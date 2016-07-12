package com.example.namtran.countrys.DataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.namtran.countrys.Country.Country;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nam Tran on 7/27/2015.
 */
public class Get_Database_Country {
    SQLiteDatabase database;
    public Get_Database_Country(Context context, String path)
    {
        database = context.openOrCreateDatabase(path, Context.MODE_PRIVATE,null);
    }

    public List<Country> get()
    {
        /*database.execSQL("ALTER TABLE " + Country.TABLE + "ADD COLUMN " + Country.RATING + "REAL");*/
        Cursor cursor = database.query(Country.TABLE,null,null,null,null,null,null);
        return takeall_data(cursor);
    }

    List<Country> takeall_data(Cursor cursor)
    {
        List<Country> countries = new ArrayList<>();
        if (cursor.moveToFirst())
        {
            do {
                countries.add(take_data(cursor));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return countries;
    }
    Country take_data(Cursor cursor)
    {
        Country country = new Country();
        country.setId(cursor.getInt(cursor.getColumnIndex(Country.ID)));
        country.setNameVi(cursor.getString(cursor.getColumnIndex(Country.NAME_VI)));
        country.setNameEn(cursor.getString(cursor.getColumnIndex(Country.NAME_EN)));
        country.setAnthemName(cursor.getString(cursor.getColumnIndex(Country.AUTHEMNAME)));
        String AnthemSong = cursor.getString(cursor.getColumnIndex(Country.AUTHEMSONG));
        String[] AnthemSong1 = AnthemSong.split("\\.");
        String AnthemSong2 = AnthemSong1[0];
        country.setFlag(AnthemSong2);
        country.setAnthemSong(AnthemSong2);
        String image = cursor.getString(cursor.getColumnIndex(Country.IMAGE));
        String[] image1 = image.split("\\.");
        String image2 = image1[0];
        country.setImage(image2);
        country.setLanguage(cursor.getString(cursor.getColumnIndex(Country.LANGUAGE)));
        country.setCaption(cursor.getString(cursor.getColumnIndex(Country.CAPTION)));
        country.setPopulation(cursor.getInt(cursor.getColumnIndex(Country.POPULATION)));
        country.setAcreage(cursor.getDouble(cursor.getColumnIndex(Country.ACREAGE)));
        /*country.setRating(cursor.getDouble(cursor.getColumnIndex(Country.RATING)));*/
        country.setCode(cursor.getInt(cursor.getColumnIndex(Country.CODE)));
        String flag = cursor.getString(cursor.getColumnIndex(Country.FLAG));
        String[] flag1 = flag.split("\\.");
        String flag2 = flag1[0];
        country.setFlag(flag2);
        country.setCurrency(cursor.getString(cursor.getColumnIndex(Country.CURRENCY)));
        country.setGovernmentVi(cursor.getString(cursor.getColumnIndex(Country.GOVERNMENTVI)));
        country.setGovernmentEn(cursor.getString(cursor.getColumnIndex(Country.GOVERNMENTEN)));
        country.setReligionEn(cursor.getString(cursor.getColumnIndex(Country.RELIGIONEN)));
        country.setReligionVi(cursor.getString(cursor.getColumnIndex(Country.RELIGIONVI)));
        return country;
    }
}
