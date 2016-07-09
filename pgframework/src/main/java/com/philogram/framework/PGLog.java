package com.philogram.framework;

import android.util.Log;

import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * Created by bigmandoo on 16. 7. 9..
 */
public class PGLog implements PGConstant
{
	String tag;

	public PGLog(Object object)
	{
		tag = object.getClass().getSimpleName();
	}

	public PGLog(String tag)
	{
		this.tag = tag;
	}

	protected void error(String log)
	{
		Log.e(tag, log);
	}

	protected void info(String log)
	{
		Log.i(tag, log);
	}

	protected void debug(String log)
	{
		Log.d(tag, log);
	}

	protected void exception(Exception e)
	{
		error(e.getMessage());
		error(ExceptionUtils.getStackTrace(e));
	}
}
