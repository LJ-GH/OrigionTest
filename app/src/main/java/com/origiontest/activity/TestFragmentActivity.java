package com.origiontest.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fragment.BlankFragment1;
import com.fragment.BlankFragment2;
import com.origiontest.R;

public class TestFragmentActivity extends Activity {

    private Button btn_add_frag1;
    private Button btn_add_frag2;
    private Button btn_remove_frag2;
    private Button btn_repalce_frag1;
    private Button btn_pop_back;
    private Button btn_show;
    private Button btn_hide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);
        initView();
    }

    private void initView(){
        btn_add_frag1 = (Button) findViewById(R.id.btn_add_frag1);
        btn_add_frag2 = (Button) findViewById(R.id.btn_add_frag2);
        btn_remove_frag2 = (Button) findViewById(R.id.btn_remove_frag2);
        btn_repalce_frag1 = (Button) findViewById(R.id.btn_repalce_frag1);
        btn_pop_back =  (Button) findViewById(R.id.btn_pop_back);
        btn_show =  (Button) findViewById(R.id.btn_show);
        btn_hide =  (Button) findViewById(R.id.btn_hide);

        btn_add_frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment blankFragment1 = new BlankFragment1();
                addFragment(blankFragment1,"blankFragment1");
            }
        });

        btn_add_frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment blankFragment2 = new BlankFragment2();
                addFragment(blankFragment2,"blankFragment2");
            }
        });

        btn_remove_frag2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                removeFragment2();
            }
        });

        btn_repalce_frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment1();
            }
        });

        btn_pop_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });

        btn_hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideFragment("blankFragment2");
            }
        });

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment("blankFragment2");
            }
        });
    }

    private void addFragment(Fragment fragment, String tag){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_container,fragment,tag);
        transaction.addToBackStack(tag);
        transaction.commit();
    }

    private void removeFragment2(){
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag("blankFragment2");
        if(fragment==null){return;}
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
    }

    private void replaceFragment1() {
        FragmentManager manager = getFragmentManager();
        BlankFragment2 fragment2 = new BlankFragment2();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment2);
        transaction.commit();
    }

    private void popBackStack(){
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.popBackStack();
    }

    private void hideFragment(String tag){
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (null == fragment){return;}
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.hide(fragment);
        fragmentTransaction.commit();
    }

    private void showFragment(String tag){
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if(null==fragment){return;}
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.show(fragment);
        fragmentTransaction.commit();
    }
}
