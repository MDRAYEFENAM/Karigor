package com.mdrayefenam.karigorbangla.Activity.Taker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.mdrayefenam.karigorbangla.R;

import androidx.appcompat.app.AppCompatActivity;

public class TakerNumberAuthentication extends AppCompatActivity {

    EditText number;
    ImageButton next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.taker_number_authentication);

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
                    Toast.makeText( TakerNumberAuthentication.this, "invalid phone number!", Toast.LENGTH_SHORT ).show();
                }else {
                    Intent intent = new Intent( TakerNumberAuthentication.this, TakerNumberAuthenticationCode.class );
                    intent.putExtra("number",Number);
                    startActivity( intent );
                    finish();
                }
            }
        } );



    }
}
