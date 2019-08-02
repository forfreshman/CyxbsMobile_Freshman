package com.mredrock.cyxbs.freshman;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.mredrock.cyxbs.common.ui.BaseActivity;
import com.mredrock.cyxbs.freshman.ui.adapter.FragmentAdapter;
import com.mredrock.cyxbs.freshman.ui.fragment.AcademyFragment;
import com.mredrock.cyxbs.freshman.ui.fragment.ActivitiesFragment;
import com.mredrock.cyxbs.freshman.ui.fragment.FellowFragment;
import com.mredrock.cyxbs.freshman.ui.view.CursorView;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CommunicateActivity extends BaseActivity implements View.OnClickListener {
    private TextView academy;
    private TextView fellow;
    private TextView activities;
    private List<Fragment> fragments = new ArrayList<>();
    private ViewPager viewPager;
    private FragmentAdapter fragmentAdapter;
    private CursorView cursorView;

    @Override
    public boolean isFragmentActivity() {
        return false;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.freshman_activity_communicate);
        initview();
        academy.setOnClickListener(this);
        fellow.setOnClickListener(this);
        activities.setOnClickListener(this);
        viewPager.setOnPageChangeListener(new MyPagerChangeListener());

        fragments.add(new AcademyFragment());
        fragments.add(new FellowFragment());
        fragments.add(new ActivitiesFragment());
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(fragmentAdapter);
        viewPager.setCurrentItem(0);
        cursorView.setCounts(fragments.size());
        cursorView.setColor(R.color.common_default_text_color);
    }

    private void initview() {
        academy = (TextView) findViewById(R.id.tv_academy);
        fellow = (TextView) findViewById(R.id.tv_fellow);
        activities = (TextView) findViewById(R.id.tv_activities);
        viewPager = (ViewPager) findViewById(R.id.vp_communicate);
        cursorView=(CursorView)findViewById(R.id.curson_view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_academy:
                viewPager.setCurrentItem(0);
                break;
            case R.id.tv_fellow:
                viewPager.setCurrentItem(1);
                break;
            case R.id.tv_activities:
                viewPager.setCurrentItem(2);
                break;
            default:
                break;
        }
    }

    /**
     * 设置一个ViewPager的侦听事件，当左右滑动ViewPager时菜单栏被选中状态跟着改变
     */
    public class MyPagerChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            cursorView.setXY(position,positionOffset);
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
