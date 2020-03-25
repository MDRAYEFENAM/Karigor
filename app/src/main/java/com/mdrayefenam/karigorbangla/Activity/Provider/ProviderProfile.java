package com.mdrayefenam.karigorbangla.Activity.Provider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.mdrayefenam.karigorbangla.R;
import com.mdrayefenam.karigorbangla.SessionClass.SessionClass;

public class ProviderProfile extends AppCompatActivity {

    private Menu action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_profile);


        Button buttonOne = findViewById(R.id.pendingwork);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");


                Intent intent = new Intent(getApplicationContext(), ProviderRequestAccept.class);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        action = menu;

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.menu_logout:

                /*new LoginRegisterClass(TakerProfileFragment.this).removeEmail();
                Intent intent = new Intent( TakerProfileFragment.this,loginactivity.class );
                startActivity( intent );
                finish();*/

                SessionClass.getInstance(getApplicationContext()).logout();

                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }




}
