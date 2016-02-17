package com.example.fragmentexample;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button B1,B2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        B1 = (Button) findViewById(R.id.b1);
        B2 = (Button) findViewById(R.id.b2);
        
        B1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentManager FM = getFragmentManager();
				FragmentTransaction FT = FM.beginTransaction();
				
				FragmentOne F1 = new FragmentOne();
				
				FT.add(R.id.fr1_id, F1);
				FT.addToBackStack("f1");
				FT.commit();
			}
		});
        
        B2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				FragmentManager FM = getFragmentManager();
				FragmentTransaction FT = FM.beginTransaction();
				
				FragmentTwo F2 = new FragmentTwo();
				
				FT.add(R.id.fr2_id, F2);
				FT.addToBackStack("f2");
				FT.commit();
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
