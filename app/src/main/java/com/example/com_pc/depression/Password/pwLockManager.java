package com.example.com_pc.depression.Password;

import android.app.Application;

public class pwLockManager {

	private volatile static pwLockManager instance;
	private pwAppLock curPwAppLocker;

	public static pwLockManager getInstance() {
		synchronized (pwLockManager.class) {
			if (instance == null) {
				instance = new pwLockManager();
			}
		}
		return instance;
	}

	public void enableAppLock(Application app) {
		if (curPwAppLocker == null) {
			curPwAppLocker = new pwAppLockImpl(app);
		}
		curPwAppLocker.enable();
	}

	public boolean isAppLockEnabled() {
		if (curPwAppLocker == null) {
			return false;
		} else {
			return true;
		}
	}

	public void setAppLock(pwAppLock pwAppLocker) {
		if (curPwAppLocker != null) {
			curPwAppLocker.disable();
		}
		curPwAppLocker = pwAppLocker;
	}

	public pwAppLock getAppLock() {
		return curPwAppLocker;
	}
}
