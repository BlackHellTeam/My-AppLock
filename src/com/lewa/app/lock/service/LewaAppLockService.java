package com.lewa.app.lock.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.lewa.app.lock.provider.LewaAppLockHelper;
import com.lewa.app.lock.service.LewaScreenListener.ScreenStateListener;

import android.app.ActivityManagerNative;

public class LewaAppLockService extends Service {

    private ExecutorService executorService;
    private Process monitorProcess;
    private Process cleanProcess;
    private ActivityManager mActivityManager = null;
    private LewaAppLockHelper mLockDB;
    List<String> mLockAppPackage = new ArrayList<String>();
    private static final String LOCK_VALUE = "locked";

    // private LewaAppLockThread mThread;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        return Service.START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mLockDB = new LewaAppLockHelper(this);
        LewaScreenListener screenListener = new LewaScreenListener(this);
        screenListener.begin(new ScreenStateListener() {

            @Override
            public void onUserPresent() {
                // TODO Auto-generated method stub

            }

            @Override
            public void onScreenOn() {
                // TODO Auto-generated method stub
            }

            @Override
            public void onScreenOff() {
                // TODO Auto-generated method stub
                mLockAppPackage = mLockDB.getAllLockedPackName(LOCK_VALUE);
                if (mLockAppPackage != null) {
                    // for (String appPackage : mLockAppPackage) {
                    //     try {
                    //         ActivityManagerNative.getDefault()
                    //                 .addAppLockControlPackage(appPackage);
                    //     } catch (RemoteException e) {
                    //         // TODO: handle exception
                    //     }
                    // }
                }
            }
        });
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

}