package com.example.namtran.namtran.Lớp_cơ_bản;

/**
 * Created by Nam Tran on 8/5/2015.
 */
public class GhiChu {
    public static final String _TABLE = "GhiChu";
    public static final String _ID_ = "_id_";
    public static final String _DAY = "_day";
    public static final String _MONTH = "_month";
    public static final String _YEAR = "_year";
    public static final String _HOUR = "_hour";
    public static final String _MINUTE = "_minute";
    public static final String _GHICHU = "_ghichu";
    public static final String _XAPXEP = _YEAR + " ASC," +_MONTH  + " ASC," + _DAY +
                                            " ASC," + _HOUR +" ASC," + _MINUTE +" ASC," + _ID_ +" ASC";

    long _id_;
    int _day;
    int _month;
    int _year;
    int _hour;
    int _minute;
    String _ghichu;

    public long get_id_() {
        return _id_;
    }

    public void set_id_(long _id_) {
        this._id_ = _id_;
    }

    public int get_day() {
        return _day;
    }

    public void set_day(int _day) {
        this._day = _day;
    }

    public int get_month() {
        return _month;
    }

    public void set_month(int _month) {
        this._month = _month;
    }

    public int get_year() {
        return _year;
    }

    public void set_year(int _year) {
        this._year = _year;
    }

    public int get_hour() {
        return _hour;
    }

    public void set_hour(int _hour) {
        this._hour = _hour;
    }

    public int get_minute() {
        return _minute;
    }

    public void set_minute(int _minute) {
        this._minute = _minute;
    }

    public String get_ghichu() {
        return _ghichu;
    }

    public void set_ghichu(String _ghichu) {
        this._ghichu = _ghichu;
    }

    public GhiChu() {

        this._id_ = _id_;
        this._day = _day;
        this._year = _year;
        this._month = _month;
        this._hour = _hour;
        this._minute = _minute;
        this._ghichu = _ghichu;
    }

}
