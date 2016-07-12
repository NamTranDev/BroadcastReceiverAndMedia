package com.example.namtran.namtran.Alarm;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Toast;

import com.example.namtran.namtran.Iprovider.Iprovider_GhiChu;
import com.example.namtran.namtran.Lớp_cơ_bản.GhiChu;
import com.example.namtran.namtran.MainActivity;
import com.example.namtran.namtran.Provider.Provider_GhiChu;
import com.example.namtran.namtran.R;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Nam Tran on 8/12/2015.
 */
public class AlarmReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        long a = bundle.getLong(GhiChu._ID_);
        String abc = bundle.getString(GhiChu._GHICHU);
        intent = new Intent("Wakeup.Wakeup.Wakeup");
        intent.putExtra(GhiChu._ID_,a);
        intent.putExtra(GhiChu._GHICHU,abc);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

}
