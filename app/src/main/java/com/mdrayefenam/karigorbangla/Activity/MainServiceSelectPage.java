package com.mdrayefenam.karigorbangla.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mdrayefenam.karigorbangla.R;

public class MainServiceSelectPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_service_select_page);


        Button buttonOne = findViewById(R.id.buttonTaker);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");


                Intent intent = new Intent(getApplicationContext(), SingUp.class);
                startActivity(intent);
            }

        });

        Button buttonTwo = findViewById(R.id.buttonGiver);
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");


                Intent intent = new Intent(getApplicationContext(), ProviderSignUp.class);
                startActivity(intent);
            }

        });




    }

}
