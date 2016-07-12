package com.example.namtran.namtran.Provider;

import android.content.Context;

import com.example.namtran.namtran.Database.GetDataBase;
import com.example.namtran.namtran.Iprovider.Iprovider_GhiChu;
import com.example.namtran.namtran.Lớp_cơ_bản.GhiChu;

import java.util.List;

/**
 * Created by Nam Tran on 8/5/2015.
 */
public class Provider_GhiChu implements Iprovider_GhiChu{

    GetDataBase getDataBase;

    public Provider_GhiChu(Context context) {
        getDataBase = new GetDataBase(context);
    }

    @Override
    public List<GhiChu> get() {
        return getDataBase.get();
    }


    @Override
    public long insert(int day, int month, int year, int hour, int minute, String text) {
        return getDataBase.insert(day,month,year,hour,minute,text);
    }

    @Override
    public long uptdate(long id, int day, int month, int year, int hour, int minute, String text) {
        return getDataBase.uptdate(id,day,month,year,hour,minute,text);
    }

    @Override
    public long delete(long id) {
        return getDataBase.delete(id);
    }
}
