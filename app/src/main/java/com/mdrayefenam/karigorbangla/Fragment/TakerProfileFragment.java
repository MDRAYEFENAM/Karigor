package com.mdrayefenam.karigorbangla.Fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mdrayefenam.karigorbangla.Model.SessionData;
import com.mdrayefenam.karigorbangla.Network.RetrofitClient;
import com.mdrayefenam.karigorbangla.ProfileModel.ProfileResponse;
import com.mdrayefenam.karigorbangla.R;


import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TakerProfileFragment extends Fragment {


/*    public TakerProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate( R.layout.fragment_taker_profile, container, false );
    }

}*/

    String TAG="TakerProfileFragment ";
    String name,email,mobile;

    private Context context;
    private static final String SHARED_PREF_NAME = "simplifiedcodingsharedpref";
    private static final String KEY_TOKEN = "keytoken";
    String token;


    TextView userName,userEmail,userAddress;



    public TakerProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        this.context=context;
        super.onAttach(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        token = sharedPreferences.getString(KEY_TOKEN, "");
        Log.e(TAG, "onAttach: "+token );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_taker_profile, container, false);



/*

        Button btnTakerEditProfile = (Button) view.findViewById(R.id.btnTakerEditProfile);

        btnTakerEditProfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                // Launching new Activity on selecting single List Item
                Intent i = new Intent(getActivity(), TakerEditProfile.class);
                startActivity(i);
            }
        });
*/

        userName =(TextView)view.findViewById(R.id.userName);
        userEmail =(TextView)view.findViewById(R.id.userEmail);
        userAddress =(TextView)view.findViewById(R.id.userAddress);

        SessionData sessionData = new SessionData();
//        String Token = sessionData.getToken();

//        Log.e("TakerProfileFragment Token",""+Token);

        //userName.setText( token );

        Call <ProfileResponse> call = RetrofitClient.getInstance(token).getApiInterface().profileData();
        call.enqueue(new Callback <ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response <ProfileResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: " + response.code());
                    ProfileResponse profileResponse = response.body();
                    if (profileResponse != null && profileResponse.getStatus() == 1) {

                        Toast.makeText(getActivity(), profileResponse.getId().toString(), Toast.LENGTH_SHORT).show();

                        name = profileResponse.getName();
                        email = profileResponse.getEmail();
                        mobile = profileResponse.getMobile();

                        userName.setText( name );
                        userEmail.setText( email );
                        userAddress.setText( mobile );



                    } else {
                        Toast.makeText(getActivity(),profileResponse.getStatus(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.d(TAG, "onResponse: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                Toast.makeText(getActivity(),"Data Featching Faild", Toast.LENGTH_SHORT).show();
            }
        });


        GetProfileData();

        return view;


    }



    private void GetProfileData() {}



}