package com.mdrayefenam.karigorbangla.Activity.Provider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mdrayefenam.karigorbangla.Activity.Taker.TakerLoginActivity;
import com.mdrayefenam.karigorbangla.R;

public class ProviderEditProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_edit_profile);

        Button bottonUpdate = findViewById(R.id.bottonUpdate);
        bottonUpdate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");


                Intent intent = new Intent(getApplicationContext(), ProviderProfile.class);
                startActivity(intent);
            }

        });
    }
}
