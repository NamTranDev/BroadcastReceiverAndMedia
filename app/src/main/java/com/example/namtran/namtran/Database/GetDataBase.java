package com.example.namtran.namtran.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.namtran.namtran.Lớp_cơ_bản.GhiChu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nam Tran on 8/17/2015.
 */
public class GetDataBase extends BaseDao {
    public GetDataBase(Context context) {
        super.setContext(context);
    }

    public List<GhiChu> get(){
        Cursor cursor = loadAll(GhiChu._TABLE, null,GhiChu._XAPXEP);
        return Takedata(cursor);
    }

    List<GhiChu> Takedata(Cursor cursor)
    {
        List<GhiChu> countries  = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do{
                countries.add(ghiChu(cursor));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return countries;
    }

    GhiChu ghiChu(Cursor cursor)
    {
        GhiChu ghiChu = new GhiChu();
        ghiChu.set_id_(cursor.getLong(cursor.getColumnIndex(GhiChu._ID_)));
        ghiChu.set_year(cursor.getInt(cursor.getColumnIndex(GhiChu._YEAR)));
        ghiChu.set_month(cursor.getInt(cursor.getColumnIndex(GhiChu._MONTH)));
        ghiChu.set_day(cursor.getInt(cursor.getColumnIndex(GhiChu._DAY)));
        ghiChu.set_hour(cursor.getInt(cursor.getColumnIndex(GhiChu._HOUR)));
        ghiChu.set_minute(cursor.getInt(cursor.getColumnIndex(GhiChu._MINUTE)));
        ghiChu.set_ghichu(cursor.getString(cursor.getColumnIndex(GhiChu._GHICHU)));
        return ghiChu;
    }
    public long insert(int day, int month, int year, int hour, int minute, String text)
    {
        ContentValues values = new ContentValues();
        values.put(GhiChu._DAY, day);
        values.put(GhiChu._MONTH, month);
        values.put(GhiChu._YEAR, year);
        values.put(GhiChu._HOUR, hour);
        values.put(GhiChu._MINUTE, minute);
        values.put(GhiChu._GHICHU, text);
        return insert(GhiChu._TABLE,values);
    }
    public long uptdate(long id, int day, int month, int year, int hour, int minute, String text)
    {
        ContentValues values = new ContentValues();
        values.put(GhiChu._ID_,id);
        values.put(GhiChu._DAY, day);
        values.put(GhiChu._MONTH, month);
        values.put(GhiChu._YEAR, year);
        values.put(GhiChu._HOUR, hour);
        values.put(GhiChu._MINUTE, minute);
        values.put(GhiChu._GHICHU, text);
        return update(GhiChu._TABLE, values, GhiChu._ID_ + "=?", new String[]{id + ""});
    }
    public long delete(long id)
    {
        return delete(GhiChu._TABLE, GhiChu._ID_ + "=?", new String[]{id + ""});
    }
}
