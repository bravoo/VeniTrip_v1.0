package com.bravoo.veni.venitrip_v1.util;

import android.content.Context;
import android.os.Environment;

/**
 * Created by msi on 2015/12/1.
 */
public class JFileKit {
    public static String getDiskCacheDir(Context context){
        String cachePath;
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())||!Environment.isExternalStorageEmulated()){
            cachePath=context.getExternalCacheDir().getAbsolutePath();
        }else {
            cachePath=context.getCacheDir().getAbsolutePath();
        }
        return cachePath;
    }
}
