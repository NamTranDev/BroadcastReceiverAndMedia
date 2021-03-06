package com.example.namtran.namtran.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;



/**
 * Created by NamTran on 07/20/2015.
 */
public class DBContext extends SQLiteOpenHelper {

    public final static String DB_NAME = "GhiChu";
    public final static int VERSION = 1;

    public DBContext(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Migration_0001 migration = new Migration_0001();
        List<String> strQueries = migration.getSQLQuery();
        for (int i = 0; i < strQueries.size(); i++) {
            db.execSQL(strQueries.get(i));
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (newVersion) {

            case 3: {
//
                if (oldVersion == 2)
                    break;
            }
            case 2: //version 2
            {
                Migration_0002 migration2 = new Migration_0002();
                List<String> strQueries2 = migration2.getSQLQuery();
                for (int i = 0; i < strQueries2.size(); i++) {
                    db.execSQL(strQueries2.get(i));
                }
            }
            default:
                break;
        }
    }
}
