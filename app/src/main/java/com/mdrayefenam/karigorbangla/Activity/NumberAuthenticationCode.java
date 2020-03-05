package com.mdrayefenam.karigorbangla.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mdrayefenam.karigorbangla.R;
import com.mdrayefenam.karigorbangla.R;

import androidx.appcompat.app.AppCompatActivity;

public class NumberAuthenticationCode extends AppCompatActivity {

    EditText code;
    Button submit;
    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.number_authentication_code );


        code = findViewById(R.id.code);

        submit = findViewById(R.id.submit);

        number = getIntent().getStringExtra("number");

        submit.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Code = code.getText().toString();

                if (Code.equals( "" ))
                {
                    code.setError( "Enter Your 6 digit Code" );
                }else if(Code.equals( "123456" )){
                    Intent intent = new Intent( NumberAuthenticationCode.this,SingUp.class );
                    intent.putExtra("number",number);
                    startActivity( intent );
                    finish();
                }else {
                    Toast.makeText( NumberAuthenticationCode.this, "invalid Code!", Toast.LENGTH_SHORT ).show();
                }
            }
        } );
    }



}
