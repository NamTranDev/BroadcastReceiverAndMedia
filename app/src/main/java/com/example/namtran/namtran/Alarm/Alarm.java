package com.example.namtran.namtran.Alarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.example.namtran.namtran.Iprovider.Iprovider_GhiChu;
import com.example.namtran.namtran.Lớp_cơ_bản.GhiChu;
import com.example.namtran.namtran.Provider.Provider_GhiChu;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by Nam Tran on 8/12/2015.
 */
public class Alarm {

    Context mcontext;
    List<GhiChu> ghiChuList;
    Iprovider_GhiChu iproviderGhiChu;
    AlarmManager alarmManager ;
    PendingIntent pendingIntent;
    /*List<Long> id = new ArrayList<Long>();*/

    public Alarm(Context mcontext) {

        this.mcontext = mcontext;
    }
    public void SetAlarm()
    {
        iproviderGhiChu = new Provider_GhiChu(mcontext);
        ghiChuList = iproviderGhiChu.get();
        if (ghiChuList != null) {
            for (GhiChu ghiChu : ghiChuList)
            {
                    /*id.add(ghiChu.get_id_());
                    long[] ID = toArray(id);
                    long minId = MinId(ID, ghiChu.get_id_());
                    if (ghiChu.get_id_() == minId) {*/
                        GregorianCalendar calendar = new GregorianCalendar(ghiChu.get_year(), ghiChu.get_month(), ghiChu.get_day(), ghiChu.get_hour(), ghiChu.get_minute());
                        long timer = calendar.getTimeInMillis();
                        alarmManager = (AlarmManager) mcontext.getSystemService(Context.ALARM_SERVICE);
                        Intent intent = new Intent(mcontext, AlarmReceiver.class);
                        intent.putExtra(GhiChu._ID_, ghiChu.get_id_());
                        intent.putExtra(GhiChu._GHICHU, ghiChu.get_ghichu());
                        if (timer != 0) {
                            pendingIntent = PendingIntent.getBroadcast(mcontext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                            alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, timer, 0, pendingIntent);
                            Log.d("Trannam", "TranNam");
                        } else {
                            Toast.makeText(mcontext, "Fail", Toast.LENGTH_LONG).show();
                        }
                    }
                }
           /* }*/

            else
            {
                Toast.makeText(mcontext, "Fail", Toast.LENGTH_LONG).show();
            }

    }
    /*long MinId(long[] listId,long id)
    {
        long minId = listId[0] ;
        for (int i = 0; i<id; i++ )
        {
            if (minId>listId[i])

                minId = listId[i+1];

        }
        return minId;
    }

    private long[] toArray (List<Long> a)
    {
        long[] b = new long[a.size()];
        int index = 0 ;
        for (Long c : a )
        {
           b[index] = c;
        }
        return b;
    }*/
}
