package com.mdrayefenam.karigorbangla.Activity.Provider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.mdrayefenam.karigorbangla.Activity.Taker.TakerAccountVerified;
import com.mdrayefenam.karigorbangla.Model.SessionData;
import com.mdrayefenam.karigorbangla.Network.RetrofitClient;
import com.mdrayefenam.karigorbangla.R;
import com.mdrayefenam.karigorbangla.RegisterModel.RegisterResponse;
import com.mdrayefenam.karigorbangla.SessionClass.SessionClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProviderSignUp extends AppCompatActivity {

    EditText userName,userEmail,Password,confirm_password;
    CheckBox check_box;
    Button sign_up;
    String mobile;
    private String TAG = "RegisterActivity ";
    ProgressBar progressBar;
    Spinner spinner1;
    String spinnerData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_signup);


        userName = findViewById( R.id.userName );
        userEmail = findViewById( R.id.userEmail );
        Password = findViewById( R.id.password );
        confirm_password = findViewById( R.id.confirm_password );

        check_box = findViewById( R.id.check_box );

        sign_up = findViewById( R.id.sign_up );

        progressBar = findViewById( R.id.progressBar );

        spinner1 = findViewById( R.id.spinner1 );


        mobile = getIntent().getStringExtra("number");




        ArrayAdapter<String> rentTypeAdapter = new ArrayAdapter<String>(ProviderSignUp.this,android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.renters_type));
        rentTypeAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(rentTypeAdapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerData = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        sign_up.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userName.getText().toString();
                String email = userEmail.getText().toString();
                String password = Password.getText().toString();
                String ConfirmPassword = confirm_password.getText().toString();

                Toast.makeText(ProviderSignUp.this, ""+spinnerData, Toast.LENGTH_LONG).show();



                sign_up.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);

                if (name.equals( "" ) ){
                    userName.setError( "Enter Your Name" );
                    sign_up.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }else if (email.equals( "" ) ){
                    userEmail.setError( "Enter Your Email" );
                    sign_up.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }else if (password.equals( "" )){
                    Password.setError( "Enter Your password" );
                    sign_up.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }else if (ConfirmPassword.equals( "" )){
                    confirm_password.setError( "Enter Your password" );
                    sign_up.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }else if (!password.equals(ConfirmPassword)){
                    Toast.makeText( ProviderSignUp.this, "Password not match!", Toast.LENGTH_SHORT ).show();
                    sign_up.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }if(!check_box.isChecked())//checked then
                {
                    check_box.setError( "Please Confirm Our terms and condition." );
                    sign_up.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }else {

                   /* Intent intent = new Intent( TakerSignUp.this, TakerHomePage.class );
                    startActivity( intent );
                    finish(); */

                    doRegister(name,email,mobile,password);
                }
            }
        } );
    }

    private void doRegister(String name,String email,String mobile, String password) {




        Call<RegisterResponse> call = RetrofitClient.getInstance().getApiInterface().userRegister(name,email,mobile, password);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.code());
                    RegisterResponse registerResponse = response.body();
                    if (registerResponse != null && registerResponse.getStatus() == 1) {
                        Log.e(TAG, "onResponse: " + registerResponse.getToken().getOriginal().getAccessToken());
                        Log.e(TAG, "onResponse: " + registerResponse.getToken().getOriginal().getAccessToken().length());

                        sign_up.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);

                        int userID = registerResponse.getUserId();
                        String UserToken = registerResponse.getToken().getOriginal().getAccessToken();

                        SessionData sessionData = new SessionData();

                        sessionData.setId( userID );
                        sessionData.setToken( UserToken );
                        //SessionData.(getApplicationContext()).userLogin(sessionData);

                        SessionClass.getInstance(getApplicationContext()).userLogin(sessionData);

                        Toast.makeText(ProviderSignUp.this, registerResponse.getUserId().toString(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(ProviderSignUp.this, ProviderAccountVerified.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(ProviderSignUp.this, registerResponse.getStatus(), Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Log.d(TAG, "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(ProviderSignUp.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
