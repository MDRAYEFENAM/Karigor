package com.mdrayefenam.karigorbangla.Activity.Provider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.mdrayefenam.karigorbangla.R;

public class ProviderAccountVerified extends AppCompatActivity {

    Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_account_verified);

        done = findViewById( R.id.doneProvider);

        done.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( ProviderAccountVerified.this, ProviderProfile.class );
                startActivity( intent );
            }
        } );
    }
}

