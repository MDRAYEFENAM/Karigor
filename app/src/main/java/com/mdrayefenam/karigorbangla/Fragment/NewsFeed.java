package com.mdrayefenam.karigorbangla.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mdrayefenam.karigorbangla.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeed extends Fragment {


    public NewsFeed() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate( R.layout.fragment_news_feed, container, false );
    }

}