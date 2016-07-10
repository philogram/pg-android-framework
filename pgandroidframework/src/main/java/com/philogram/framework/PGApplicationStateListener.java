package com.philogram.framework;

/**
 * Created by bigmandoo on 16. 7. 9..
 * Only applicable to activities and fragments
 */
public interface PGApplicationStateListener
{
	void appDidEnterBackground();
	void appDidEnterForeground();
}
