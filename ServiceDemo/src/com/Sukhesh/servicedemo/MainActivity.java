package com.Sukhesh.servicedemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	Button b1, b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        
    }
    
    public void startService(View view)
    {
    	Intent intent = new Intent(getApplicationContext(), MyService.class);
    	startService(intent);
    }
    
    public void stopService(View view)
    {
    	Intent intent = new Intent(getApplicationContext(), MyService.class);
    	stopService(intent);
    }
}
