package com.mdrayefenam.karigorbangla.Activity.Taker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mdrayefenam.karigorbangla.R;

public class TakerPayment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taker_payment);


        Button buttonOne = findViewById(R.id.pay);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Payment Successfully");

                Toast.makeText(TakerPayment.this, "Payment Successfully", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(getApplicationContext(), TakerHomePage.class);
                startActivity(intent);
            }

        });

    }
}
