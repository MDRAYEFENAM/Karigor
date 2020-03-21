package com.mdrayefenam.karigorbangla.Activity.Provider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mdrayefenam.karigorbangla.R;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ProviderNumberAuthentication extends AppCompatActivity {

    EditText number;
    ImageButton next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_number_authentication);

        number = findViewById(R.id.number);

        next = findViewById(R.id.next);

        next.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Number = number.getText().toString();

                if (Number.equals( "" ))
                {
                    number.setError( "Enter Your Phone Number" );
                }else if(Number.length()>12 || number.length() <11){
                    Toast.makeText( ProviderNumberAuthentication.this, "invalid phone number!", Toast.LENGTH_SHORT ).show();
                }else {
                    Intent intent = new Intent( ProviderNumberAuthentication.this, ProviderNumberAuthenticationCode.class );
                    intent.putExtra("number",Number);
                    startActivity( intent );
                    finish();
                }
            }
        } );

    }
}
