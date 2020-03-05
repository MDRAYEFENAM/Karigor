package com.mdrayefenam.karigorbangla.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.mdrayefenam.karigorbangla.R;
import com.mdrayefenam.karigorbangla.R;

import androidx.appcompat.app.AppCompatActivity;

public class NumberAuthentication extends AppCompatActivity {

    EditText number;
    ImageButton next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.number_authentication );

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
                    Toast.makeText( NumberAuthentication.this, "invalid phone number!", Toast.LENGTH_SHORT ).show();
                }else {
                    Intent intent = new Intent( NumberAuthentication.this,NumberAuthenticationCode.class );
                    intent.putExtra("number",Number);
                    startActivity( intent );
                    finish();
                }
            }
        } );



    }
}
