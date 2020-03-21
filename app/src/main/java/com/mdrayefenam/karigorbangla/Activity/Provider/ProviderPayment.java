package com.mdrayefenam.karigorbangla.Activity.Provider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mdrayefenam.karigorbangla.R;

public class ProviderPayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_payment);


        Button buttonOne = findViewById(R.id.paid);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Payment Successfully Paid");

                Toast.makeText(ProviderPayment.this, "Payment Successfully Paid", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(getApplicationContext(), ProviderProfile.class);
                startActivity(intent);
            }

        });

    }
}