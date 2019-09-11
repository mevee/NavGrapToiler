package com.vee.navgraptoiler.view.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.vee.navgraptoiler.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PropertyOptionsFragment extends Fragment implements View.OnClickListener {
    public static final String TAG = PropertyOptionsFragment.class.getName();
    Context context;

    public PropertyOptionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_property_options, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.rl_room1).setOnClickListener(this);
        view.findViewById(R.id.rl_flat1).setOnClickListener(this);
        view.findViewById(R.id.rl_shops1).setOnClickListener(this);
        view.findViewById(R.id.rl_office1).setOnClickListener(this);
        view.findViewById(R.id.rl_plot1).setOnClickListener(this);
        view.findViewById(R.id.rl_bungalow1).setOnClickListener(this);
        view.findViewById(R.id.rl_farmhouse1).setOnClickListener(this);
        view.findViewById(R.id.rl_agriculture_land1).setOnClickListener(this);
        view.findViewById(R.id.rl_auditoriam1).setOnClickListener(this);
        view.findViewById(R.id.rl_room2).setOnClickListener(this);
        view.findViewById(R.id.rl_flat2).setOnClickListener(this);
        view.findViewById(R.id.rl_shops2).setOnClickListener(this);
        view.findViewById(R.id.rl_office2).setOnClickListener(this);
        view.findViewById(R.id.rl_plot2).setOnClickListener(this);
        view.findViewById(R.id.rl_bungalow2).setOnClickListener(this);
        view.findViewById(R.id.rl_farmhouse2).setOnClickListener(this);
        view.findViewById(R.id.rl_agriculture_land2).setOnClickListener(this);
        view.findViewById(R.id.rl_auditoriam2).setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_room1:
                ((HomeFragment) getParentFragment()).setListFragment("Room");
                break;
            case R.id.  rl_flat1:
                ((HomeFragment) getParentFragment()).setListFragment("Flat");
                break;
            case R.id.rl_shops1:
                ((HomeFragment) getParentFragment()).setListFragment("Shop");
                break;
            case R.id.rl_office1:
                ((HomeFragment) getParentFragment()).setListFragment("Office");
                break;
            case R.id.rl_plot1:
                ((HomeFragment) getParentFragment()).setListFragment("Plot");
                break;
            case R.id.rl_bungalow1:
                ((HomeFragment) getParentFragment()).setListFragment("Bungalow");
                break;
            case R.id.rl_farmhouse1:
                ((HomeFragment) getParentFragment()).setListFragment("Farm House");
                break;
            case R.id.rl_agriculture_land1:
                ((HomeFragment) getParentFragment()).setListFragment("Agriculture Land");
                break;
            case R.id.rl_auditoriam1:
                ((HomeFragment) getParentFragment()).setListFragment("Auditorium");
                break;

            case R.id.rl_room2:
                ((HomeFragment) getParentFragment()).setListFragment("Room");
                break;
            case R.id.  rl_flat2:
                ((HomeFragment) getParentFragment()).setListFragment("Flat");
                break;
            case R.id.rl_shops2:
                ((HomeFragment) getParentFragment()).setListFragment("Shop");
                break;
            case R.id.rl_office2:
                ((HomeFragment) getParentFragment()).setListFragment("Office");
                break;
            case R.id.rl_plot2:
                ((HomeFragment) getParentFragment()).setListFragment("Plot");
                break;
            case R.id.rl_bungalow2:
                ((HomeFragment) getParentFragment()).setListFragment("Bungalow");
                break;
            case R.id.rl_farmhouse2:
                ((HomeFragment) getParentFragment()).setListFragment("Farm House");
                break;
            case R.id.rl_agriculture_land2:
                ((HomeFragment) getParentFragment()).setListFragment("Agriculture Land");
                break;
            case R.id.rl_auditoriam2:
                ((HomeFragment) getParentFragment()).setListFragment("Auditorium");
                break;

        }
    }
}
