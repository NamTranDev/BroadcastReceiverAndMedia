package com.example.namtran.namtran.base;


import com.example.namtran.namtran.Lớp_cơ_bản.GhiChu;

public class Migration_0001 extends Migration {
    public Migration_0001() {
        steps.add("CREATE TABLE " + GhiChu._TABLE
                + " (" + GhiChu._ID_ + " INTEGER PRIMARY KEY, "
                + GhiChu._YEAR + " INTEGER, "
                + GhiChu._MONTH + " INTEGER, "
                + GhiChu._DAY + " INTEGER, "
                + GhiChu._HOUR + " INTEGER, "
                + GhiChu._MINUTE + " INTEGER, "
                + GhiChu._GHICHU + " TEXT)");

    }
}