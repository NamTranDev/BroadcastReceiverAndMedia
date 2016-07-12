package com.example.namtran.namtran.Iprovider;

import com.example.namtran.namtran.Lớp_cơ_bản.GhiChu;

import java.util.List;

/**
 * Created by Nam Tran on 8/5/2015.
 */
public interface Iprovider_GhiChu {
    List<GhiChu> get();
    long insert(int day, int month, int year, int hour, int minute, String text);
    long uptdate(long id, int day, int month, int year, int hour, int minute, String text);
    long delete(long id);
}
