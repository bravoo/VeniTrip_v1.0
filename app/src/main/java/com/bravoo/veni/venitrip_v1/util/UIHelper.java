package com.bravoo.veni.venitrip_v1.util;

import android.widget.Toast;

import com.bravoo.veni.venitrip_v1.application.LocalApplication;

/**
 * Created by msi on 2015/12/1.
 */
public class UIHelper {
    public static void showToast(String msg){
        Toast.makeText(LocalApplication.getInstance(), msg, Toast.LENGTH_SHORT).show();
    }
}
