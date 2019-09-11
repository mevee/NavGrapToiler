package com.vee.navgraptoiler.view.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.vee.navgraptoiler.R;

public class MainActivity extends AppCompatActivity {
NavController navController= null;
    private boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
navController = Navigation.findNavController(this,R.id.nav_host_fragment);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        for (Fragment fragment:getSupportFragmentManager().getFragments()){
            fragment.onActivityResult(requestCode,resultCode,data);
        }
    }

    @Override
    public void onBackPressed() {

//            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
//                return;
//            }
//            doubleBackToExitPressedOnce = true;
//        Toast.makeText(this, "Press BACK again to exit", Toast.LENGTH_SHORT).show();
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    doubleBackToExitPressedOnce = false;
//                }
//            }, 2000);

    }
}
