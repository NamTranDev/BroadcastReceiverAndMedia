package com.example.namtran.namtran;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.WindowManager;

import com.example.namtran.namtran.Alarm.Alarm;
import com.example.namtran.namtran.Alarm.AlarmReceiver;
import com.example.namtran.namtran.Dialog.Dialog_Alarm;
import com.example.namtran.namtran.Iprovider.Iprovider_GhiChu;
import com.example.namtran.namtran.Lớp_cơ_bản.GhiChu;
import com.example.namtran.namtran.Provider.Provider_GhiChu;

/**
 * Created by Nam Tran on 8/21/2015.
 */
public class DialogFragment extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        Dialog_Alarm dialog_alarm = new Dialog_Alarm();
        dialog_alarm.setArguments(bundle);
        dialog_alarm.show(getSupportFragmentManager(),"Nam");
    }
}
