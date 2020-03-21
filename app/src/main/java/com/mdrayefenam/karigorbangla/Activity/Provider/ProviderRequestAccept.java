package com.mdrayefenam.karigorbangla.Activity.Provider;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mdrayefenam.karigorbangla.R;

public class ProviderRequestAccept extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_request_accept);

        Button buttonOne = findViewById(R.id.btn_accept);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");


                Intent intent = new Intent(getApplicationContext(), ProviderOwnLocationActivity.class);
                startActivity(intent);
            }

        });



/*
        findViewById(R.id.pendingwork).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSuccessDialog();

            }
        });*/




    }
  /*  private void showSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ProviderRequestAccept.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(ProviderRequestAccept.this).inflate(
                R.layout.activity_provider_request_accept,
                (LinearLayout) findViewById(R.id.layoutDialogContrainer)
        );
        builder.setView(view);
        //((TextView) view.findViewById(R.id.texTitle)).setText(getResources().getString(R.string.success_title));


        ((Button) view.findViewById(R.id.btn_accept)).setText(getResources().getString(R.string.yes));
        ((Button) view.findViewById(R.id.btn_no)).setText(getResources().getString(R.string.No));

        final AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.btn_accept).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                Intent intent = new Intent(ProviderRequestAccept.this, ProviderOwnLocationActivity.class);
                startActivity(intent);
                Toast.makeText(ProviderRequestAccept.this, "Accept", Toast.LENGTH_SHORT).show();

            }
        });

        view.findViewById(R.id.btn_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                Toast.makeText(ProviderRequestAccept.this, "Decline", Toast.LENGTH_LONG).show();
            }
        });


        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }

        alertDialog.show();


    }*/

}
