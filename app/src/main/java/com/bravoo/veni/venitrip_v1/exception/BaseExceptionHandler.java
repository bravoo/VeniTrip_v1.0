package com.bravoo.veni.venitrip_v1.exception;

import android.os.*;
import android.os.Process;

import java.text.DateFormat;

/**
 * Created by msi on 2015/12/1.
 */
public abstract class BaseExceptionHandler implements Thread.UncaughtExceptionHandler{
    public static final String TAG="CrashHandler";
    protected static final DateFormat dateFormat=DateFormat.getDateInstance().getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        if(handleException(ex)){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        android.os.Process.killProcess(Process.myPid());
        System.exit(1);
    }

    public abstract boolean handleException(Throwable ex);
}
