package com.example.skain.sunshine;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ForecastFragment())
                    .commit();
        }
        Log.d(LOG_TAG, "OnCreate");
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
        Intent intent = null;
        if (id == R.id.action_settings) {
            intent = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_view_map) {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            String location = prefs.getString(getString(R.string.pref_location_key), getString(R.string.pref_location_default));
            intent = new Intent(Intent.ACTION_VIEW);
            Uri geoLoc = Uri.parse("geo:0,0?q=" + location);
            intent.setData(geoLoc);
//            Utils.MakeToast(this, geoLoc.toString());
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Utils.MakeToast(this, "Could not find map intent target.");
            }
        }
        else {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        Log.v(LOG_TAG, "in onStart");
        super.onStart();
        // The activity is about to become visible.
    }

    @Override
    protected void onResume() {
        Log.v(LOG_TAG, "in onResume");
        super.onResume();
        // The activity has become visible (it is now "resumed").
    }

    @Override
    protected void onPause() {
        Log.v(LOG_TAG, "in onPause");
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
    }

    @Override
    protected void onStop() {
        Log.v(LOG_TAG, "in onStop");
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
    }

    @Override
    protected void onDestroy() {
        Log.v(LOG_TAG, "in onDestroy");
        super.onDestroy();
        // The activity is about to be destroyed.
    }


}
