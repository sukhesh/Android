package com.example.bindservicedemo;

import com.example.bindservicedemo.MyService.LocalBinder;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	MyService mservice;
	boolean status;
	EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txt = (EditText) findViewById(R.id.editText1);
    }
    
    public void bindMethod(View view)
    {
    	Intent i = new Intent(this, MyService.class);
    	bindService(i, sc, Context.BIND_AUTO_CREATE);
    	status = true;
    	Toast.makeText(getBaseContext(), "Service Binded...." , Toast.LENGTH_LONG).show();
    }
    
    public void unBindMethod(View view)
    {
    	if(status)
    	{
    		unbindService(sc);
    		Toast.makeText(getBaseContext(), "Service UnBinded...." , Toast.LENGTH_LONG).show();
    		status = false;
    	}
    	else
    	{
    		Toast.makeText(getBaseContext(), "Service is already UnBinded...." , Toast.LENGTH_LONG).show();
    	}
    }
    
    public void factorialMethod(View view)
    {
    	if(status)
    	{
    		int num = Integer.parseInt(txt.getText().toString());
    		int result = mservice.findFactorial(num);
    		Toast.makeText(getBaseContext(), "Factorial ="+ result , Toast.LENGTH_LONG).show();
    	}
    	else
    	{
    		Toast.makeText(getBaseContext(), "First Bind the service.." , Toast.LENGTH_LONG).show();
    	}
    	
    }
    
    private ServiceConnection sc = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			LocalBinder binder = (LocalBinder) service;
			mservice = binder.getService();
			status = true;
		}
	};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
