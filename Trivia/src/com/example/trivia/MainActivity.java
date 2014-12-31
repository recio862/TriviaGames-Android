package com.example.trivia;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

	SharedPreferences mPrefs;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Parse Code
	/*	Parse.initialize(this, "ybMbNsW5K7M3tWC0hq5d2JJyiDDJfDW65eGRcYRc", "ny76yoFFCO2ACumEzDDzOqHs40udxmyaJkjHG5eo");
		ParseObject.registerSubclass(Game.class);
*/
		
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
