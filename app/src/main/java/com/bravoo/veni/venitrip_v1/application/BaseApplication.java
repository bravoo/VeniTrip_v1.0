package com.bravoo.veni.venitrip_v1.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.bravoo.veni.venitrip_v1.exception.BaseExceptionHandler;
import com.bravoo.veni.venitrip_v1.exception.LocalFieldHandler;

import java.io.File;

/**
 * Created by msi on 2015/12/1.
 */
public abstract class BaseApplication extends Application {
    public static final String TAG="Application";
    public static Context applicationContext;
    public SharedPreferences sharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext=getApplicationContext();
        if(getDefaultUncaughtExceptionHandler()==null){
            Thread.setDefaultUncaughtExceptionHandler(new LocalFieldHandler(applicationContext));
        }else {
            Thread.setDefaultUncaughtExceptionHandler(getDefaultUncaughtExceptionHandler());
        }
        sharedPreferences=getSharedPreferences("local_kv",MODE_PRIVATE);
    }

    public abstract BaseExceptionHandler getDefaultUncaughtExceptionHandler();

    /**
     * 判断缓存是否存在
     *
     * @param cachefile
     * @return
     */
    private boolean isExistDataCache(String cachefile) {
        boolean exist = false;
        File data = getFileStreamPath(cachefile);
        if (data.exists())
            exist = true;
        return exist;
    }
}
