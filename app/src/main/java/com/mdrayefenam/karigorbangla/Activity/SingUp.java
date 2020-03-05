package com.mdrayefenam.karigorbangla.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mdrayefenam.karigorbangla.Model.SessionData;
import com.mdrayefenam.karigorbangla.R;
import com.mdrayefenam.karigorbangla.RegisterModel.RegisterResponse;
import com.mdrayefenam.karigorbangla.SessionClass.SessionClass;
import com.mdrayefenam.karigorbangla.Network.RetrofitClient;
import com.mdrayefenam.karigorbangla.Network.RetrofitClient;
import com.mdrayefenam.karigorbangla.R;
import com.mdrayefenam.karigorbangla.RegisterModel.RegisterResponse;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingUp extends AppCompatActivity {

    EditText userName,userEmail,Password,confirm_password;
    CheckBox check_box;
    Button sign_up;
    String mobile;
    private String TAG = "RegisterActivity ";
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.sign_up);

        userName = findViewById( R.id.userName );
        userEmail = findViewById( R.id.userEmail );
        Password = findViewById( R.id.password );
        confirm_password = findViewById( R.id.confirm_password );

        check_box = findViewById( R.id.check_box );

       sign_up = findViewById( R.id.sign_up );

        progressBar = findViewById( R.id.progressBar );

        mobile = getIntent().getStringExtra("number");

        sign_up.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userName.getText().toString();
                String email = userEmail.getText().toString();
                String password = Password.getText().toString();
                String ConfirmPassword = confirm_password.getText().toString();

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
                    Toast.makeText( SingUp.this, "Password not match!", Toast.LENGTH_SHORT ).show();
                    sign_up.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }if(!check_box.isChecked())//checked then
                {
                    check_box.setError( "Please Confirm Our terms and condition." );
                    sign_up.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.GONE);
                }else {

                   /* Intent intent = new Intent( SingUp.this, MainActivity.class );
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

                        Toast.makeText(SingUp.this, registerResponse.getUserId().toString(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SingUp.this, AccountVerified.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(SingUp.this, registerResponse.getStatus(), Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Log.d(TAG, "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(SingUp.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
