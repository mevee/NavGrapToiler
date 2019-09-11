package com.vee.navgraptoiler.view.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.vee.navgraptoiler.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplashScreenFragment extends Fragment {
    NavController navController =null;

    public SplashScreenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
        params.flags |= WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;
        return inflater.inflate(R.layout.fragment_splash_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        ProgressBar mProgressBar = view.findViewById(R.id.progress_bar);
        ImageView tvAppName = view.findViewById(R.id.progress_bar);
        mProgressBar.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mProgressBar.setVisibility(View.GONE);
//                if (AppPref.instance(SplashActivity.this).getUid().length() <= 0) {

                getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
                    navController.navigate(R.id.action_splashScreenFragment_to_signInFragment);
//                navController.navigate(R.id.action_splashScreenFragment_to_signInFragment,null,
//                                navController.popBackStack(R.id.splashScreenFragment, true));
//                } else {

                    //        navController.navigate(R.id.action_splashScreenFragment_to_homeFragment);
//                }
            }
        }, 2000);



    }
}
