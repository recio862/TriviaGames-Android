package com.example.trivia;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

	SharedPreferences mPrefs;
	boolean mSoundOn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mPrefs = getSharedPreferences("ttt_prefs", MODE_PRIVATE);
	
		if (mPrefs.getBoolean("loggedOut", true)){
			Intent intent = new Intent(getApplicationContext(), LoginMenu.class);
			startActivity(intent);
			finish();
			return;
		}

		setContentView(R.layout.activity_main);
	
		mSoundOn = mPrefs.getBoolean("sound", true);


	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	int id = item.getItemId();
        
    	if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
