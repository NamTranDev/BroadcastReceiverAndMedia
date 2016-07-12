package com.example.namtran.countrys.Provider;

import android.content.Context;


import com.example.namtran.countrys.Country.Country;
import com.example.namtran.countrys.DataBase.Get_Database_Country;
import com.example.namtran.countrys.Iprovider.Iprovider_Countries;

import java.util.List;

/**
 * Created by Nam Tran on 8/5/2015.
 */
public class Provider_Country implements Iprovider_Countries {

    Get_Database_Country getDataBase;

    public Provider_Country(Context context,String path) {
        getDataBase = new Get_Database_Country(context,path);
    }

    @Override
    public List<Country> get() {
        return getDataBase.get();
    }

}
