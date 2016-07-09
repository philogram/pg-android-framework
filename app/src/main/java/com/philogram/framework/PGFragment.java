package com.philogram.framework;

import android.support.v4.app.Fragment;

/**
 * Created by bigmandoo on 16. 7. 9..
 */
public class PGFragment extends Fragment implements PGApplicationStateListener, PGConstant
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
