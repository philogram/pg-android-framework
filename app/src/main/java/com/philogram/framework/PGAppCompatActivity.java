package com.philogram.framework;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bigmandoo on 16. 7. 9..
 */
public class PGAppCompatActivity extends AppCompatActivity
		implements PGApplicationStateListener, PGConstant
{
	protected PGLog pgLog = new PGLog(this);

	@Override
	public void appDidEnterBackground()
	{

	}

	@Override
	public void appDidEnterForeground()
	{

	}
}
