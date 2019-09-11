package com.vee.navgraptoiler.view.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vee.navgraptoiler.R;
import com.vee.navgraptoiler.view.adapters.ListingAdapter;
import com.vee.navgraptoiler.view.adapters.MyRoomsListingAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyListingFragment extends Fragment {
    private MyRoomsListingAdapter listAdapter;
    private NavController navController= null;

    public MyListingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_listing, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);


        listAdapter = new MyRoomsListingAdapter(getContext(), new MyRoomsListingAdapter.ItemClickListener() {
            @Override
            public void onItemClick(int positin, int action) {
             if (action==MyRoomsListingAdapter.EDIT_PROPERTY){

                 Bundle dataBUndle = new Bundle();
                 dataBUndle.putString("title","Edit your property");
                 navController.navigate(R.id.action_myListingFragment2_to_addPropertyFormFragment,dataBUndle);
             }
            }
        });
        RecyclerView recyclerView = view.findViewById(R.id.rv_listing);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listAdapter);
    }

}
