package com.origiontest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.origiontest.R;

/**
 * Created by ljie on 16-10-11.
 */
public class LoginActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    protected void loginBtnClick(View view){
        Toast.makeText(getApplicationContext(),"登录成功",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this,Main3Activity.class);
        startActivity(intent);
        finish();
    }

}
