package com.origiontest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.origiontest.R;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.BGABannerUtil;

public class Main3Activity extends Activity implements BGABanner.OnItemClickListener, BGABanner.Adapter {
    private BGABanner mDefaultBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mDefaultBanner = (BGABanner) findViewById(R.id.banner_main_cube);
        mDefaultBanner.setOnItemClickListener(this);
        loadData();

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                Log.i("main3Activity=> tabId:", tabId+"" );
                if (tabId == R.id.tab_favorites) {
                    // The tab with id R.id.tab_favorites was selected,
                    // change your content accordingly.
                }
            }
        });

        BottomBarTab nearby = bottomBar.getTabWithId(R.id.tab_nearby);
        nearby.setBadgeCount(5);

    }

    private void loadData(){
        mDefaultBanner.setAdapter(new BGABanner.Adapter() {
            @Override
            public void fillBannerItem(BGABanner banner, View view, Object model, int position) {
                ((ImageView)view).setImageResource((int)model);
            }
        });
        mDefaultBanner.setData(Arrays.asList(R.mipmap.scrollow01, R.mipmap.scrollow02, R.mipmap.scrollow03,R.mipmap.scrollow01,R.mipmap.scrollow01), null);
    }
    @Override
    public void fillBannerItem(BGABanner banner, View view, Object model, int position) {
        ((ImageView)view).setImageResource((int)model);
    }

    @Override
    public void onBannerItemClick(BGABanner banner, View view, Object model, int position) {
        Log.i("Main3Activity","banner:"+banner.toString()+"; view"+view.toString()+"; position"+position);
    }
}
