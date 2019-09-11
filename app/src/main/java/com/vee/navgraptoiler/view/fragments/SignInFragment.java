package com.vee.navgraptoiler.view.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vee.navgraptoiler.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment implements View.OnClickListener {
    private String TAG = SignInFragment.class.getName();
NavController navController =null;
    ProgressBar progressBar;
    public SignInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signin, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        Log.d(TAG,"backstack_entry:"+getActivity().getSupportFragmentManager().getBackStackEntryCount());
       view.findViewById(R.id.et_user_id).setOnClickListener(this);
        view.findViewById(R.id.et_user_pass).setOnClickListener(this);
        view.findViewById(R.id.rl_signIn).setOnClickListener(this);
        view.findViewById(R.id.create_Account).setOnClickListener(this);
        view.findViewById(R.id.forgot_doc).setOnClickListener(this);
        progressBar =  view.findViewById(R.id.progress_bar);

//        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
//            @Override
//            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
//
//            }
//        });

//        @BindView(R.id.et_user_pass)
//        EditText etUserPass;
//
//        @BindView(R.id.rl_signIn)
//        RelativeLayout tv_btn_LoginButton;
//
//        @BindView(R.id.create_Account)
//        TextView create_Account;
//
//        @BindView(R.id.forgot_doc)
//        TextView forgot_doc;
//
//        @BindView(R.id.progress_bar)



    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v!=null){
            switch (v.getId()){
                case R.id.rl_signIn:
                    navController.navigate(R.id.action_signInFragment_to_homeFragment);
                break;
                case R.id.create_Account:navController.navigate(R.id.action_signInFragment_to_createAccountFragment);
                    break;
                case R.id.forgot_doc:navController.navigate(R.id.action_signInFragment_to_forgetPasswordFragment);
                    break;
            }



        }

    }
}
