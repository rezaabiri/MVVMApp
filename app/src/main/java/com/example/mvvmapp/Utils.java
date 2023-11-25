package com.example.mvvmapp;

import android.app.Activity;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import me.ibrahimsn.lib.SmoothBottomBar;

public class Utils {
    public static void goneNav(Activity activity) {
        SmoothBottomBar navBottom = activity.findViewById(R.id.bottomBar);
        if (navBottom != null) {
            navBottom.setVisibility(View.GONE);
        }
    }

    public static void visibleNav(Activity activity) {
        SmoothBottomBar navBottom = activity.findViewById(R.id.bottomBar);
        if (navBottom != null) {
            navBottom.setVisibility(View.VISIBLE);
        }
    }
}
