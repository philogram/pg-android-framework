package com.philogram.framework;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;

public class PGDialogFragment extends DialogFragment
		implements PGApplicationStateListener, PGConstant
{
	protected PGLog pgLog = new PGLog(this);
	protected Handler handler;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

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
