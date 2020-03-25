package com.mdrayefenam.karigorbangla.Fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.mdrayefenam.karigorbangla.Activity.Taker.TakerOwnLocationActivity;
import com.mdrayefenam.karigorbangla.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TakerHome extends Fragment {

    RelativeLayout aa,ab,ac,ad,ae,af;


    public TakerHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_home, container, false );

        aa =(RelativeLayout)view.findViewById(R.id.aa);
        ab =(RelativeLayout)view.findViewById(R.id.ab);
        ac =(RelativeLayout)view.findViewById(R.id.ac);
        ad =(RelativeLayout)view.findViewById(R.id.ad);
        ae =(RelativeLayout)view.findViewById(R.id.ae);
        af =(RelativeLayout)view.findViewById(R.id.af);


        aa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TakerOwnLocationActivity.class);
                startActivity(intent);
            }
        });


        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TakerOwnLocationActivity.class);
                startActivity(intent);
            }
        });

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TakerOwnLocationActivity.class);
                startActivity(intent);
            }
        });

        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TakerOwnLocationActivity.class);
                startActivity(intent);
            }
        });

        ae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TakerOwnLocationActivity.class);
                startActivity(intent);
            }
        });

        af.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), TakerOwnLocationActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
