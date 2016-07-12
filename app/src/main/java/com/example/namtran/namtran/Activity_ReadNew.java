package com.example.namtran.namtran;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.namtran.namtran.Adapter.Adapter_ReadNew;
import com.example.namtran.namtran.Adapter.ViewPagerAdapter_ReadNew;
import com.example.namtran.namtran.Asystask.Asystank_ReadNew;
import com.example.namtran.namtran.Lớp_cơ_bản.News;
import com.example.namtran.namtran.SlidingTabLayout.SlidingTabLayout;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nam Tran on 8/16/2015.
 */
public class Activity_ReadNew extends AppCompatActivity implements View.OnClickListener

{
    private Toolbar toolbar;
    ViewPager viewPager;
    SlidingTabLayout tab;
    ViewPagerAdapter_ReadNew viewPagerAdapterReadNew;
    CharSequence Title[] = {" Xã Hội " ,
                            " Thể Thao " ,
                            " Thế Giới " ,
                            " Giáo Dục " ,
                            " Giải Trí " ,
                            " Khoa Học " ,
                            " Xe " ,
                            " Du Lịch " ,
                            " Cười "};
    int NumberTab = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_readnew);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setSubtitleTextColor(R.color.light_green);
        toolbar.setLogo(R.drawable.item_icon_navigation);
        toolbar.setNavigationIcon(R.drawable.icon_back);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(this);


        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tab = (SlidingTabLayout) findViewById(R.id.tab);

        viewPagerAdapterReadNew = new ViewPagerAdapter_ReadNew(getSupportFragmentManager(),Title,NumberTab);
        viewPager.setAdapter(viewPagerAdapterReadNew);

        tab.setDistributeEvenly(true);
        tab.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.amber);
            }
        });
        tab.setViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_back_exit,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mnexit)
        {
            Intent main = new Intent(Intent.ACTION_MAIN);
            main.addCategory(Intent.CATEGORY_HOME);
            startActivity(main);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
            this.finish();
    }
}
