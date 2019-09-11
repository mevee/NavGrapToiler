package com.vee.navgraptoiler.view.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vee.navgraptoiler.R;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener  {
    NavController navController = null;
//    @BindView(R.id.tv_address)
//    TextView tv_Address;
//
//    @BindView(R.id.ll_top_address)
//    LinearLayout ll_top_address;
//
//    @BindView(R.id.navigation_doc)
//    BottomNavigationView navigation_doc;

    //    @BindView(R.id.ll_top_address)
    LinearLayout ll_top_address;

    //    @BindView(R.id.navigation_doc)
    BottomNavigationView navigation_doc;


    private boolean doubleBackToExitPressedOnce = false;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        navigation_doc = view.findViewById(R.id.navigation_doc);
        navigation_doc.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(new PropertyOptionsFragment(), "PropertyOptionsFragment");

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        Log.d("HomeFragment","backstack_entry:"+getActivity().getSupportFragmentManager().getBackStackEntryCount());
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_top_address:
//                navController.navigate(R.id.action_signInFragment_to_homeFragment);
                break;
            case R.id.frameLayout_home_doc:
//                navController.navigate(R.id.action_signInFragment_to_createAccountFragment);
                break;
            case R.id.navigation_doc:
//                navController.navigate(R.id.action_signInFragment_to_forgetPasswordFragment);
                break;

        }
    }

    @Override
    public void onStart() {
        super.onStart();
//        String address = AppPref.instance(context).getAddress();

        if (getArguments() != null) {
            String s = getArguments().getString("fh");
            switch (s) {
                case "loc":
                    navigation_doc.setSelectedItemId(R.id.action_home);
                    break;
                case "h":
                    navigation_doc.setSelectedItemId(R.id.action_home);
                    break;
                case "p":
                    navigation_doc.setSelectedItemId(R.id.action_profile);
                    break;
                case "d":
                    navigation_doc.setSelectedItemId(R.id.action_dashboard);
                    break;
                case "v":
                    navigation_doc.setSelectedItemId(R.id.action_home);
                    break;
            }
        } else {
            navigation_doc.setSelectedItemId(R.id.action_home);
        }
    }

    public void setListFragment(String title) {
//    Bundle bundle = new Bundle();
//    bundle.putString("header", title);
//    setArguments(bundle);
        Bundle bundle = new Bundle();
        bundle.putString("fh", "h");
        setArguments(bundle);
        navController.navigate(R.id.action_homeFragment_to_productListFragment);

    }

    public void goToChangePassword() {
//    Bundle bundle = new Bundle();
//    bundle.putString("header", title);
//    setArguments(bundle);
        Bundle bundle = new Bundle();
        bundle.putString("fh", "p");
        setArguments(bundle);
        navController.navigate(R.id.action_homeFragment_to_changPasswordeFragment2);
    }

    public void logOutFromApp() {
//    Bundle bundle = new Bundle();
//    bundle.putString("header", title);
//    setArguments(bundle);

//        cleare all the prefrence and log out

        navController.navigate(R.id.action_homeFragment_to_signInFragment);
    }


    public void goToMyRoomList() {
//    Bundle bundle = new Bundle();
//    bundle.putString("header", title);
//    setArguments(bundle);
        Bundle bundle = new Bundle();
        bundle.putString("fh", "p");
        setArguments(bundle);
        navController.navigate(R.id.action_homeFragment_to_myListingFragment2);
    }

    public void gotoEditProfile() {
//    Bundle bundle = new Bundle();
//    bundle.putString("header", title);
//    setArguments(bundle);
        Bundle bundle = new Bundle();
        bundle.putString("fh", "p");
        setArguments(bundle);
        navController.navigate(R.id.action_homeFragment_to_editProfileFragment2);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.action_profile:
//                    home_title.setText("Profile");
                    if (getChildFragmentManager().findFragmentByTag("ProfileFragment") instanceof ProfileFragment) {
                        Bundle bundle = new Bundle();
                        bundle.putString("fh", "p");
                        setArguments(bundle);
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putString("fh", "p");
                        setArguments(bundle);
                        loadFragment(new ProfileFragment(), "ProfileFragment");
                    }
                    Bundle bundlepr = new Bundle();
                    bundlepr.putString("fh", "p");
                    setArguments(bundlepr);
                    return true;
                case R.id.action_home:
//                    home_title.setText("Home");

                    if (getChildFragmentManager().findFragmentByTag("PropertyOptionsFragment") instanceof PropertyOptionsFragment) {
                        Bundle bundle = new Bundle();
                        bundle.putString("fh", "h");
                        setArguments(bundle);
                    } else {
                        loadFragment(new PropertyOptionsFragment(), "PropertyOptionsFragment");
                        Bundle bundle = new Bundle();
                        bundle.putString("fh", "h");
                        setArguments(bundle);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("fh", "h");
                    setArguments(bundle);
                    return true;
                case R.id.action_dashboard:
//                    home_title.setText("Favourites");
                    if (getChildFragmentManager().findFragmentByTag("FavouritesFragment") instanceof FavouriteFragment) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("fh", "d");
                        setArguments(bundle2);
                    } else {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("fh", "d");
                        setArguments(bundle2);
                        loadFragment(new FavouriteFragment(), "FavouritesFragment");
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("fh", "d");
                    setArguments(bundle2);
                    return true;
                case R.id.action_item4:
                    Bundle bundleH = new Bundle();
                    bundleH.putString("fh", "h");
                    setArguments(bundleH);

                    Bundle dataBUndle = new Bundle();
                    dataBUndle.putString("title", "Register your property");
                    navController.navigate(R.id.action_homeFragment_to_addPropertyFormFragment, dataBUndle);
//                    Intent intent =new Intent(HomeActivity.this, SellMyPropertyActivity.class);
//                    intent.putExtra("header","Register your property");
//                    startActivity(intent);

                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment, String tag) {

        Fragment inBackStack = getChildFragmentManager().findFragmentByTag(tag);

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

        if (inBackStack != null) {
            if (inBackStack instanceof HomeFragment) {

            } else {
                transaction.replace(R.id.frameLayout_home_doc, fragment, tag);
                transaction.commit();
                return;
            }

            if (inBackStack instanceof FavouriteFragment) {

            } else {
                transaction.replace(R.id.frameLayout_home_doc, fragment, tag);
                transaction.commit();
                return;
            }

            if (inBackStack instanceof ProfileFragment) {

            } else {
                transaction.replace(R.id.frameLayout_home_doc, fragment, tag);
                transaction.commit();
                return;
            }
        } else {
            transaction.replace(R.id.frameLayout_home_doc, fragment, tag);
            transaction.commit();
        }
    }


}
