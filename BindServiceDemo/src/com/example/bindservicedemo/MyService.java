package com.example.bindservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {

	private final IBinder mBinder = new LocalBinder();
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return mBinder;
	}
	
	public class LocalBinder extends Binder
	{
		public MyService getService()
		{
			return MyService.this;
		}
	}
	
	public int findFactorial(int x)
	{
		int fact = 1;
		for(int i=1; i<=x; i++)
		{
			fact = fact*i;
		}
		return fact;
	}

}
