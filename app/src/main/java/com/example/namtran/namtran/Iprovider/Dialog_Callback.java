package com.example.namtran.namtran.Iprovider;

/**
 * Created by Nam Tran on 8/6/2015.
 */
public interface Dialog_Callback {
    void setTimerComplete(boolean complete, int mHour, int mMinute);
    void setDateComplete(boolean complete, int mYear, int mMonth, int mDay);
}
