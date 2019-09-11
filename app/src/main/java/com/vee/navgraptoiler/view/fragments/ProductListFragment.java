package com.vee.navgraptoiler.view.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vee.navgraptoiler.R;
import com.vee.navgraptoiler.view.adapters.ListingAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductListFragment extends Fragment {
    private ListingAdapter listAdapter;
    private NavController navController = null;

    public ProductListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        listAdapter = new ListingAdapter(getContext(), false, new ListingAdapter.ItemClickListener() {
            @Override
            public void onItemClick(int positin, int action) {
                if (action == ListingAdapter.VIEW_PROPERTY_DETAIL) {
                    navController.navigate(R.id.action_productListFragment_to_productDetailFragment);
                }
            }
        });
        RecyclerView recyclerView = view.findViewById(R.id.rv_listing);
        TextView textView = view.findViewById(R.id.tv_header);
        if (getArguments() != null) {
            textView.setText(getArguments().getString("header"));

        } else {
            textView.setText("Arguments are null");
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listAdapter);


    }
}
