package com.example.namtran.namtran;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.namtran.namtran.Adapter.Adapter_Ghichu;
import com.example.namtran.namtran.Alarm.Alarm;
import com.example.namtran.namtran.GhiChu.AddGhiChu;
import com.example.namtran.namtran.GhiChu.UpdateGhiChu;
import com.example.namtran.namtran.Iprovider.Iprovider_GhiChu;
import com.example.namtran.namtran.Lớp_cơ_bản.GhiChu;
import com.example.namtran.namtran.Provider.Provider_GhiChu;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    ListView listView;
    ImageButton imgghichu;
    Iprovider_GhiChu iprovider_ghiChu;
    List<GhiChu> ghiChuList;
    Adapter_Ghichu adapter_ghichu;
    protected Alarm alarm ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.icon_ghichu);
        setSupportActionBar(toolbar);



        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer,R.string.closeDrawer);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        listView = (ListView) findViewById(R.id.listView);
        imgghichu = (ImageButton) findViewById(R.id.imgghichu);
        imgghichu.setOnClickListener(this);
        registerForContextMenu(listView);
        alarm = new Alarm(this);

    }
    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        if (menuItem.isChecked())
        {
            menuItem.setChecked(false);
        }
        else
        {
            menuItem.setChecked(true);
        }
        drawerLayout.closeDrawers();

        int id = menuItem.getItemId();
        if (id == R.id.readnew)
        {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null)
            {
                Intent intent = new Intent(this,Activity_ReadNew.class);
                startActivity(intent);
                return true;
            }
            else
            {
                Toast.makeText(this,"Hiện tại chưa có mạng . Vui lòng kết nối mạng",Toast.LENGTH_LONG).show();
            }

        }
        return false;
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.imgghichu)
        {
            Intent intent = new Intent(this, AddGhiChu.class);
            startActivity(intent);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        Data();
        adapter_ghichu = new Adapter_Ghichu(this,R.layout.layout_item_listview_ghichu,ghiChuList);
        listView.setAdapter(adapter_ghichu);
        alarm.SetAlarm();
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_ghichu_item, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if (id == R.id.mnUpdate)
        {
            Intent intent = new Intent(this, UpdateGhiChu.class);
            intent.putExtra(GhiChu._ID_,ghiChuList.get(info.position).get_id_());
            intent.putExtra(GhiChu._MINUTE, ghiChuList.get(info.position).get_minute());
            intent.putExtra(GhiChu._HOUR, ghiChuList.get(info.position).get_hour());
            intent.putExtra(GhiChu._DAY, ghiChuList.get(info.position).get_day());
            intent.putExtra(GhiChu._MONTH, ghiChuList.get(info.position).get_month());
            intent.putExtra(GhiChu._YEAR, ghiChuList.get(info.position).get_year());
            intent.putExtra(GhiChu._GHICHU, ghiChuList.get(info.position).get_ghichu());
            startActivity(intent);
        }
        else if (id == R.id.mnDelete)
        {
            long delete = iprovider_ghiChu.delete(ghiChuList.get(info.position).get_id_());
            if (delete != 0)
            {
                Toast.makeText(this, "Success", Toast.LENGTH_LONG).show();
                onResume();
            }
            else
                Toast.makeText(this,"Fail",Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onContextItemSelected(item);
    }
    private void Data()
    {
        iprovider_ghiChu = new Provider_GhiChu(this);
        ghiChuList = iprovider_ghiChu.get();
    }





}
