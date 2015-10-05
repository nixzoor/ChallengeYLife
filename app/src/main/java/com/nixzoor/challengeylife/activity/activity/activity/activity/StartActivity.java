package com.nixzoor.challengeylife.activity.activity.activity.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nixzoor.challengeylife.R;
import com.nixzoor.challengeylife.activity.activity.activity.activity.constants.AppConstants;

import android.view.View;
import android.widget.*;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by dejan on 5.10.2015.
 */
public class StartActivity extends Activity implements View.OnClickListener {

    @Bind(R.id.twLogin) TextView twLogin;
    @Bind(R.id.twSubmitLogin) TextView twSubmitLogin;
    @Bind(R.id.login) RelativeLayout login;
    @Bind(R.id.meni) RelativeLayout meni;
    @Bind(R.id.edUssername) EditText edUssername;
    @Bind(R.id.edPassword) EditText edPassword;
    @Bind(R.id.twWrongLogin) TextView twWrongLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);



        AppConstants.preferences = this.getPreferences(Context.MODE_PRIVATE);
        AppConstants.editor = AppConstants.preferences.edit();

        if ( AppConstants.preferences.getBoolean("login",false))
            Login();

        YoYo.with(Techniques.SlideOutRight).delay(10).playOn(login);
        twLogin.setOnClickListener(this);
        twSubmitLogin.setOnClickListener(this);

        edUssername.setText("admin");
        edPassword.setText("admin");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.twLogin:
                YoYo.with(Techniques.SlideOutLeft).delay(10).playOn(meni);
                YoYo.with(Techniques.SlideInRight).delay(10).playOn(login);
                break;
            case R.id.twSubmitLogin:
                if(edUssername.getText().toString().equals("admin") && edPassword.getText().toString().equals("admin")){
                    AppConstants.editor.putBoolean("login",true);
                    AppConstants.editor.commit();
                    Login();
                }
                else{
                    twWrongLogin.setVisibility(View.VISIBLE);
                }
                break;

        }
    }
    public void Login(){
        Intent myIntent = new Intent(StartActivity.this, MainActivity.class);
        startActivity(myIntent);
        finish();
    }
}
