package com.origiontest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.origiontest.R;

import java.util.Arrays;

import cn.bingoogolapple.bgabanner.BGABanner;

public class WelcomeActivity extends Activity implements BGABanner.Adapter {
    private BGABanner mDefaultBanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Bundle bundle = this.getIntent().getExtras();
        String name = bundle.getString("name");
        Log.i("WelcomeActivity---->",name);

        mDefaultBanner = (BGABanner) findViewById(R.id.banner_welcome);
        loadData();
        Log.i("WelcomeActivity","222222222222");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(getApplicationContext(),this.getLocalClassName(),Toast.LENGTH_SHORT).show();
    }

    private void loadData(){
        mDefaultBanner.setAdapter(new BGABanner.Adapter() {
            @Override
            public void fillBannerItem(BGABanner banner, View view, Object model, int position) {
                ((ImageView)view).setImageResource((int)model);
            }
        });
        mDefaultBanner.setData(Arrays.asList(R.mipmap.scrollow01, R.mipmap.scrollow02, R.mipmap.scrollow03,R.mipmap.scrollow01,R.mipmap.scrollow03), null);
    }

    @Override
    public void fillBannerItem(BGABanner banner, View view, Object model, int position) {
        ((ImageView)view).setImageResource((int)model);
    }
}
