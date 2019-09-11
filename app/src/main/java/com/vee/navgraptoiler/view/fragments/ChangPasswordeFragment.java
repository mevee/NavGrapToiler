package com.vee.navgraptoiler.view.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vee.navgraptoiler.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChangPasswordeFragment extends Fragment {
NavController controller= null;

    public ChangPasswordeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chang_passworde, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller = Navigation.findNavController(view);
        view.findViewById(R.id.iv_back).setOnClickListener(v->{
            controller.navigateUp();
        });

    }
}
