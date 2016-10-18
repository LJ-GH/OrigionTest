package com.origiontest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.Toast;

import com.origiontest.R;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    protected void jumpClick(View v){
        Intent intent =  new Intent(MainActivity.this, WelcomeActivity.class);
        Bundle bundle =  new Bundle();
        bundle.putString("name","dulala");
        intent.putExtras(bundle);
        startActivity(intent);
    }

    protected void jumpLogin(View v){
        Intent intent =  new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    protected void jumpNavigation(View v){
        Intent intent =  new Intent(MainActivity.this,NavigationDrawerActivity.class);
        startActivity(intent);
    }

    protected void jumpTestViewPage(View v){
        Intent intent =  new Intent(MainActivity.this,TestViewPageActivity.class);
        startActivity(intent);
    }

    protected void jumpTestFragment(View v){
        Intent intent = new Intent(getApplication(),TestFragmentActivity.class);
        startActivity(intent);
    }

    protected void jumpFragment(View v){
        Intent intent = new Intent(getApplication(),MainFragmentActivity.class);
        startActivity(intent);
    }

    protected void jumpBottomNavigator(View v){
        Intent intent = new Intent(getApplication(),BottomNavigation.class);
        startActivity(intent);
    }

}
