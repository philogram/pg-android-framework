package com.philogram.framework;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public abstract class PGApplication extends Application implements Application.ActivityLifecycleCallbacks
{
	private static PGApplication INSTANCE;
	private boolean inBackground;
	private List<Activity> activityStack;
	protected PGLog pgLog = new PGLog(this);

	public static PGApplication getInstance()
	{
		return INSTANCE;
	}

	@Override
	public void onCreate()
	{
		super.onCreate();

		INSTANCE = this;

		activityStack = new ArrayList<>();
		registerActivityLifecycleCallbacks(this);
	}

	public boolean isInBackground()
	{
		return inBackground;
	}

	abstract public Class<?> mainActivityClass();

	public Activity currentActivity()
	{
		if( !activityStack.isEmpty())
			return activityStack.get(activityStack.size() - 1);
		else
			return null;
	}

	public Activity mainActivity()
	{
		for (Activity activity : activityStack)
		{
			if (mainActivityClass().isInstance(activity))
			{
				return activity;
			}
		}

		return null;
	}

	public void exitApplication()
	{
		for (int i = activityStack.size() - 1; i > -1; i--)
		{
			activityStack.get(i).finish();
		}
	}

	protected void appDidEnterBackground(){}
	protected void appDidEnterForeground(){}

	public SharedPreferences defaultPreference()
	{
		return this.getBaseContext().getSharedPreferences(getPackageName(), 0);
	}

	public SharedPreferences preferenceForName(String name)
	{
		return this.getBaseContext().getSharedPreferences(getPackageName() + "." + name, 0);
	}

	@Override
	public void onActivityCreated(Activity activity, Bundle savedInstanceState)
	{
		activityStack.add(activity);
	}

	@Override
	public void onActivityStarted(Activity activity)
	{

	}

	@Override
	public void onActivityResumed(Activity activity)
	{
		activityStack.remove(activity);
		activityStack.add(activity);

		if (inBackground)
		{
			if (activity.getApplication() instanceof PGApplication)
				appDidEnterForeground();

			for (Activity a : activityStack)
			{
				if (a instanceof PGApplicationStateListener)
					((PGApplicationStateListener) activity).appDidEnterForeground();

				if (a instanceof FragmentActivity)
				{
					for (Fragment fragment : ((FragmentActivity) a).getSupportFragmentManager().getFragments())
					{
						if (fragment instanceof PGApplicationStateListener)
						{
							((PGApplicationStateListener) fragment).appDidEnterForeground();
						}
					}
				}
			}

			inBackground = false;
		}
	}

	@Override
	public void onActivityPaused(Activity activity)
	{

	}

	@Override
	public void onActivityStopped(Activity activity)
	{
		pgLog.error("onActivityStopped:" + activity.getClass().getSimpleName());

		if (activity == currentActivity())
		{
			inBackground = true;

			appDidEnterBackground();

			for (Activity a : activityStack)
			{
				if (a instanceof PGApplicationStateListener)
					((PGApplicationStateListener) activity).appDidEnterBackground();

				if (a instanceof FragmentActivity)
				{
					for (Fragment fragment : ((FragmentActivity) a).getSupportFragmentManager().getFragments())
					{
						if (fragment instanceof PGApplicationStateListener)
						{
							((PGApplicationStateListener) fragment).appDidEnterBackground();
						}
					}
				}
			}
		}
	}

	@Override
	public void onActivitySaveInstanceState(Activity activity, Bundle outState)
	{

	}

	@Override
	public void onActivityDestroyed(Activity activity)
	{
		activityStack.remove(activity);

		pgLog.error("onActivityDestroyed:" + activity.getClass().getSimpleName());

		//메인 액티비티가 종료되면 혹시 남아있을지 모르는 다른 액티비티도 함께 종료
		if (mainActivityClass().isInstance(activity))
		{
			exitApplication();
		}
	}
}
