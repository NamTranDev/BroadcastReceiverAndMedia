package com.example.namtran.countrys;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.namtran.countrys.Adapter.Adapter_ListCountry;
import com.example.namtran.countrys.Country.Country;
import com.example.namtran.countrys.Iprovider.Iprovider_Countries;
import com.example.namtran.countrys.Provider.Provider_Country;
import com.example.namtran.countrys.Read_write_File.Read_write_file;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    List<Country> countries;
    ListView listView;
    Iprovider_Countries iprovider_countries;
    String path;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CopyDB();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_country_icon);
        setSupportActionBar(toolbar)
        ;
        iprovider_countries = new Provider_Country(this,path);
        countries = iprovider_countries.get();
        listView = (ListView) findViewById(R.id.listView);
        Adapter_ListCountry adapter_listCountry = new Adapter_ListCountry(this,R.layout.layout_listview_country,countries);
        listView.setAdapter(adapter_listCountry);
        listView.setOnItemClickListener(this);
    }

    private void CopyDB() {
        String name = "Countries";
        path = getFileStreamPath(name).getAbsolutePath();
        Read_write_file read_write_file = new Read_write_file(this);
        if (read_write_file.internalFileExistance(name))
        {
            AssetManager assetManager = getAssets();
            try {
                read_write_file.copyFiletoInternal(assetManager.open(name), name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent().setClass(this,Detail_Country.class);
        intent.putExtra(Country.NAME_EN,countries.get(i).getNameEn());
        intent.putExtra(Country.NAME_VI,countries.get(i).getNameVi());
        intent.putExtra(Country.AUTHEMNAME,countries.get(i).getAnthemName());
        intent.putExtra(Country.AUTHEMSONG,countries.get(i).getAnthemSong());
        intent.putExtra(Country.LANGUAGE,countries.get(i).getLanguage());
        intent.putExtra(Country.IMAGE,countries.get(i).getImage());
        intent.putExtra(Country.FLAG,countries.get(i).getFlag());
        intent.putExtra(Country.ACREAGE,countries.get(i).getAcreage());
        intent.putExtra(Country.CAPTION,countries.get(i).getCaption());
        intent.putExtra(Country.CURRENCY,countries.get(i).getCurrency());
        intent.putExtra(Country.CODE,countries.get(i).getCode());
        intent.putExtra(Country.GOVERNMENTEN,countries.get(i).getGovernmentEn());
        intent.putExtra(Country.GOVERNMENTVI,countries.get(i).getGovernmentVi());
        intent.putExtra(Country.POPULATION,countries.get(i).getPopulation());
        intent.putExtra(Country.RELIGIONEN,countries.get(i).getReligionEn());
        intent.putExtra(Country.RELIGIONVI,countries.get(i).getReligionVi());
        Log.d("TranNam","Namtran");
        startActivity(intent);
    }
}
