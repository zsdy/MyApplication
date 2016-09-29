package com.test.myapplication.utils;

import android.app.ActivityManager;
import android.content.Context;

/**
 * @author yanxu
 * @date 2016/8/17.
 */
public class MyUtils {

    public static String  getCurProcessName(Context context,int pid) {
        String name="";
        ActivityManager mActivityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager
                .getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                name= appProcess.processName;
            }
        }
    return name;
    }
}
