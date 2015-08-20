package com.lewa.app.lock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import lewa.support.v7.app.ActionBarActivity;

public class LewaAppLockGeneric extends ActionBarActivity {
    private LockPatternUtils mLockPatternUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        mLockPatternUtils = new LockPatternUtils(this);
        Intent newIntent = new Intent();
        if (mLockPatternUtils.savedLewaPatternExists()) {
            newIntent.setClassName("com.lewa.app.lock", "com.lewa.app.lock.LewaAppLockConfirmControl");
        } else {
            newIntent.setClassName("com.lewa.app.lock", "com.lewa.app.lock.LewaChooseLockPattern");
        }
        startActivity(newIntent);
        finish();
    }
    
}