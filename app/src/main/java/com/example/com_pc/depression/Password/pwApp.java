package com.example.com_pc.depression.Password;

import android.app.Application;

public class pwApp extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		pwLockManager.getInstance().enableAppLock(this);
	}
}
