package com.mdrayefenam.karigorbangla.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mdrayefenam.karigorbangla.Model.SessionData;
import com.mdrayefenam.karigorbangla.Network.RetrofitClient;
import com.mdrayefenam.karigorbangla.R;
import com.mdrayefenam.karigorbangla.Responce.LoginModel.LoginResponce;
import com.mdrayefenam.karigorbangla.SessionClass.SessionClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText login_email, login_password;
    TextView sign_in;
    Button bottomSinUp;
    private String TAG = "LoginActivity ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_email = findViewById(R.id.login_email);
        login_password = findViewById(R.id.login_password);

        bottomSinUp = findViewById(R.id.bottomSinUp);

        sign_in = findViewById(R.id.sign_in);


        bottomSinUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = login_email.getText().toString().trim();
                String password = login_password.getText().toString().trim();

                if (email.equals("")) {
                    login_email.setError("Enter Your Email");
                } else if (password.equals("")) {
                    login_password.setError("Enter Your password");
                } else {

                    doLogin(email, password);
//                    if (email.equals( "habib") && password.equals( "1234" ) ){
//                        Intent intent = new Intent( Login.this, MainActivity.class );
//                        startActivity( intent );
//                        finish();
//                    }else {
//                        Toast.makeText( Login.this, "your email or password is incorrect. please try again", Toast.LENGTH_SHORT ).show();
//                    }


                }
            }
        });

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, NumberAuthentication.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void doLogin(String email, String password) {
        Call<LoginResponce> call = RetrofitClient.getInstance().getApiInterface().userLogin(email, password);
        call.enqueue(new Callback<LoginResponce>() {
            @Override
            public void onResponse(Call<LoginResponce> call, Response<LoginResponce> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.code());
                    LoginResponce loginResponse = response.body();
                    if (loginResponse != null && loginResponse.getStatus() == 1) {
                        Log.e(TAG, "onResponse: " + loginResponse.getToken().getOriginal().getAccessToken());
                        Log.e(TAG, "onResponse: " + loginResponse.getToken().getOriginal().getAccessToken().length());
                        Toast.makeText(LoginActivity.this, loginResponse.getUserId().toString(), Toast.LENGTH_SHORT).show();

                        int userID = loginResponse.getUserId();
                        String UserToken = loginResponse.getToken().getOriginal().getAccessToken();

                        SessionData sessionData = new SessionData();

                        sessionData.setId( userID );
                        sessionData.setToken( UserToken );
                        SessionClass.getInstance(getApplicationContext()).userLogin(sessionData);


                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    } else {
//                        Toast.makeText(LoginActivity.this, loginResponse.getStatus(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.d(TAG, "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<LoginResponce> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
