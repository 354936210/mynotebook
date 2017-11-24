package com.owangwang.mynotebook;


import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private View view1, view2, view3,view4;
    private List<View> viewList;//view数组
    RadioGroup radioGroup;
    List<RadioButton> radioButtonList=new ArrayList<>();
    ViewPager viewPager;
    RadioButton radioButton_1;
    RadioButton radioButton_2;
    RadioButton radioButton_3;
    RadioButton radioButton_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            //让应用主题内容占用系统状态栏的空间,注意:下面两个参数必须一起使用 stable 牢固的
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            //设置状态栏颜色为透明
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        WindowManager windowManager=getWindowManager();
        DisplayMetrics displayMetrics=new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int x=displayMetrics.widthPixels;
        int y=displayMetrics.heightPixels;
        Log.d("分辨率",x+":"+y);
        init();
    }

    private void init() {
        radioGroup=findViewById(R.id.radiogroup);
        LayoutInflater inflater=getLayoutInflater();
        view1 = inflater.inflate(R.layout.fragment_1, null);
        view2 = inflater.inflate(R.layout.fragment_2,null);
        view3 = inflater.inflate(R.layout.fragment_3, null);
        view4 = inflater.inflate(R.layout.fragment_4, null);
        viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(viewList);

        viewPager=findViewById(R.id.mainViewPager);
        radioButton_1=findViewById(R.id.radio_1);
        radioButton_2=findViewById(R.id.radio_2);
        radioButton_3=findViewById(R.id.radio_3);
        radioButton_4=findViewById(R.id.radio_4);
        radioButtonList.add(radioButton_1);
        radioButtonList.add(radioButton_2);
        radioButtonList.add(radioButton_3);
        radioButtonList.add(radioButton_4);
        radioButton_1.setOnClickListener(this);
        radioButton_2.setOnClickListener(this);
        radioButton_3.setOnClickListener(this);
        radioButton_4.setOnClickListener(this);

        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(0);//初始设置ViewPager选中第一帧
        radioButton_1.setChecked(true);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                radioButtonList.get(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.radio_1:
                viewPager.setCurrentItem(0, true);
                break;
            case R.id.radio_2:
                viewPager.setCurrentItem(1, true);
                break;
            case R.id.radio_3:
                viewPager.setCurrentItem(2, true);
                break;
            case R.id.radio_4:
                viewPager.setCurrentItem(3, true);
                break;

        }
    }


}
