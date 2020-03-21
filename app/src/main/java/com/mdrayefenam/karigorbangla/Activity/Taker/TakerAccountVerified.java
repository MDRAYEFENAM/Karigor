package com.mdrayefenam.karigorbangla.Activity.Taker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mdrayefenam.karigorbangla.R;

public class TakerAccountVerified extends AppCompatActivity {

    Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.taker_account_verified);

        done = findViewById( R.id.done );

        done.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( TakerAccountVerified.this, TakerHomePage.class );
                startActivity( intent );
            }
        } );
    }
}
