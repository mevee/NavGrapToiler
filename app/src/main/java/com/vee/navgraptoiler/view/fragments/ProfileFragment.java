package com.vee.navgraptoiler.view.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.vee.navgraptoiler.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.Navigation;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {
NavController controller = null;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller = Navigation.findNavController(view);
        view.findViewById(R.id.rl_edit_profile).setOnClickListener(this);
        view.findViewById(R.id.rl_change_pwd).setOnClickListener(this);
        view.findViewById(R.id.rl_myListing).setOnClickListener(this);
        view.findViewById(R.id.rl_logout).setOnClickListener(this);

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_edit_profile:
                ((HomeFragment) getParentFragment()).gotoEditProfile();
                break;
            case R.id.rl_change_pwd:
                ((HomeFragment) getParentFragment()).goToChangePassword();
                break;
            case R.id.rl_myListing:
                ((HomeFragment) getParentFragment()).goToMyRoomList();
                break;
            case R.id.rl_logout:
                ((HomeFragment) getParentFragment()).logOutFromApp();
                Toast.makeText(getContext(), "Logout", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
