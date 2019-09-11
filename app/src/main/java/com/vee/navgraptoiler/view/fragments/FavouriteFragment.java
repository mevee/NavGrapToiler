package com.vee.navgraptoiler.view.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vee.navgraptoiler.R;
import com.vee.navgraptoiler.view.adapters.ListingAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavouriteFragment extends Fragment {
    private ListingAdapter listAdapter;


    public FavouriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listAdapter = new ListingAdapter(getContext(), false, new ListingAdapter.ItemClickListener() {
            @Override
            public void onItemClick(int positin, int action) {
                if (action==ListingAdapter.VIEW_PROPERTY_DETAIL){


                }
            }
        });
        RecyclerView recyclerView = view.findViewById(R.id.rv_listing);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listAdapter);
    }
}
