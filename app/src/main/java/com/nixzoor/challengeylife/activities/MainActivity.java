package com.nixzoor.challengeylife.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.Bind;
import butterknife.ButterKnife;

import android.view.View;
import android.widget.*;

import com.nixzoor.challengeylife.R;
import com.nixzoor.challengeylife.constants.AppConstants;

public class MainActivity extends Activity {

    @Bind(R.id.twLogout) TextView twLogout;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ButterKnife.bind(this);

            twLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AppConstants.editor.putBoolean("login",false);
                    AppConstants.editor.commit();
                    Intent myintent = new Intent(MainActivity.this, StartActivity.class);
                    startActivity(myintent);
                    finish();
                }
            });

        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflat the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
