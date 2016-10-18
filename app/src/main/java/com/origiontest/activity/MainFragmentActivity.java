package com.origiontest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.origiontest.R;
import com.origiontest.fragment.Fragment1;
import com.origiontest.fragment.Fragment2;
import com.origiontest.fragment.Fragment3;
import com.origiontest.fragment.Fragment4;

public class MainFragmentActivity extends FragmentActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);
        initView();
    }

    private FragmentTabHost mTabHost;
    private LinearLayout button0, button1, button3;

    //初始化标签数组
    String tabs[] = {"Tab1", "Tab2", "Tab3", "Tab4"};

    //初始化界面数组
    Class cls[] = {Fragment1.class, Fragment2.class, Fragment3.class,
            Fragment4.class};

    private ImageView image1, image2, image3, image4;
    private TextView text1, text2, text3, text4, tvcartNum;
    private RelativeLayout button2, rlNum1; //显示数字标签布局


    private void initView() {
        //实例化控件
        this.image1 = (ImageView) findViewById(R.id.image1);
        this.image2 = (ImageView) findViewById(R.id.image2);
        this.image3 = (ImageView) findViewById(R.id.image3);
        this.image4 = (ImageView) findViewById(R.id.image4);
        this.text1 = (TextView) findViewById(R.id.text1);
        this.text2 = (TextView) findViewById(R.id.text2);
        this.text3 = (TextView) findViewById(R.id.text3);
        this.text4 = (TextView) findViewById(R.id.text4);

        //实例化 FragmentTabHost (注：id 的获取必须为固定) 与 FrameLayout 布局
        mTabHost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        mTabHost.getTabWidget().setVisibility(View.GONE);//隐藏顶部切换菜单
        for (int i = 0; i < tabs.length; i++) {
            //向 FragmentTabHost 添加标签以及 Fragment 界面
            mTabHost.addTab(mTabHost.newTabSpec(tabs[i]).setIndicator(tabs[i]),
                    cls[i], null);

        }

        //实例化布局按钮控件
        button0 = (LinearLayout) findViewById(R.id.Button0);
        button1 = (LinearLayout) findViewById(R.id.Button1);
        button3 = (LinearLayout) findViewById(R.id.Button3);
        button2 = (RelativeLayout) findViewById(R.id.Button2);
        //设置监听事件
        this.button0.setOnClickListener(this);
        this.button1.setOnClickListener(this);
        this.button2.setOnClickListener(this);
        this.button3.setOnClickListener(this);

        //这里是实例化显示的提示标签数字
        rlNum1 = (RelativeLayout) findViewById(R.id.rlNum1);
        tvcartNum = (TextView) findViewById(R.id.tvcartNum);

        //设置默认选中标签
        mTabHost.setCurrentTabByTag(tabs[0]);
    }

    public void fragment_music_click(View v){
        Toast.makeText(getApplicationContext(),"fragment_music_click",Toast.LENGTH_LONG);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Button0:
                setlayoutbutton1();
                mTabHost.setCurrentTabByTag(tabs[0]);
                break;
            case R.id.Button1:
                setlayoutbutton2();
                mTabHost.setCurrentTabByTag(tabs[1]);
                break;
            case R.id.Button2:
                setlayoutbutton3();
                mTabHost.setCurrentTabByTag(tabs[2]);
                break;

            case R.id.Button3:
                setlayoutbutton4();
                mTabHost.setCurrentTabByTag(tabs[3]);
                break;
        }
    }

    //设置点击切换标签字体颜色与背景图片的切换
    private void setlayoutbutton1() {
        image1.setBackgroundResource(R.drawable.ic_guide_1);
        image2.setBackgroundResource(R.drawable.ic_guide_1);
        image3.setBackgroundResource(R.drawable.ic_guide_1);
        image4.setBackgroundResource(R.drawable.ic_guide_1);
        text1.setTextColor(this.getResources().getColor(R.color.txt009eb8));
        text2.setTextColor(this.getResources().getColor(R.color.txt666));
        text3.setTextColor(this.getResources().getColor(R.color.txt666));
        text4.setTextColor(this.getResources().getColor(R.color.txt666));
    }

    private void setlayoutbutton2() {
        image1.setBackgroundResource(R.drawable.ic_guide_1);
        image2.setBackgroundResource(R.drawable.ic_guide_1);
        image3.setBackgroundResource(R.drawable.ic_guide_1);
        image4.setBackgroundResource(R.drawable.ic_guide_1);
        text1.setTextColor(this.getResources().getColor(R.color.txt666));
        text2.setTextColor(this.getResources().getColor(R.color.txt009eb8));
        text3.setTextColor(this.getResources().getColor(R.color.txt666));
        text4.setTextColor(this.getResources().getColor(R.color.txt666));
    }

    private void setlayoutbutton3() {
        image1.setBackgroundResource(R.drawable.ic_guide_1);
        image2.setBackgroundResource(R.drawable.ic_guide_1);
        image3.setBackgroundResource(R.drawable.ic_guide_1);
        image4.setBackgroundResource(R.drawable.ic_guide_1);
        text1.setTextColor(this.getResources().getColor(R.color.txt666));
        text2.setTextColor(this.getResources().getColor(R.color.txt666));
        text3.setTextColor(this.getResources().getColor(R.color.txt009eb8));
        text4.setTextColor(this.getResources().getColor(R.color.txt666));
    }

    private void setlayoutbutton4() {
        image1.setBackgroundResource(R.drawable.ic_guide_1);
        image2.setBackgroundResource(R.drawable.ic_guide_1);
        image3.setBackgroundResource(R.drawable.ic_guide_1);
        image4.setBackgroundResource(R.drawable.ic_guide_1);
        text1.setTextColor(this.getResources().getColor(R.color.txt666));
        text2.setTextColor(this.getResources().getColor(R.color.txt666));
        text3.setTextColor(this.getResources().getColor(R.color.txt666));
        text4.setTextColor(this.getResources().getColor(R.color.txt009eb8));
    }
}
