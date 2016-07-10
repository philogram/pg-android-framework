package com.philogram.framework;

import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.HashMap;
import java.util.Map;

public class PGAppCompatActivity extends AppCompatActivity
		implements PGApplicationStateListener, PGConstant
{
	protected PGLog pgLog = new PGLog(this);
	protected Handler handler;

	@Override
	public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState)
	{
		super.onCreate(savedInstanceState, persistentState);

		handler = new Handler();
	}

	@Override
	public void appDidEnterBackground()
	{

	}

	@Override
	public void appDidEnterForeground()
	{

	}
}
