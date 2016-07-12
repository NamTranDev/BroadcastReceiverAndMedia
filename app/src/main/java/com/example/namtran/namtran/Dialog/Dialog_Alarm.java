package com.example.namtran.namtran.Dialog;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.example.namtran.namtran.Alarm.AlarmReceiver;
import com.example.namtran.namtran.Iprovider.Iprovider_GhiChu;
import com.example.namtran.namtran.Lớp_cơ_bản.GhiChu;
import com.example.namtran.namtran.Provider.Provider_GhiChu;
import com.example.namtran.namtran.R;

/**
 * Created by Nam Tran on 8/22/2015.
 */
public class Dialog_Alarm extends DialogFragment {
    MediaPlayer mediaPlayer;
    long id ;
    String Ghichu="" ;
    Iprovider_GhiChu iprovider_ghiChu;
    AlarmManager alarmManager;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);

        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.hug);
        mediaPlayer.start();
        Bundle bundle = getArguments();
        id = bundle.getLong(GhiChu._ID_);
        Ghichu = bundle.getString(GhiChu._GHICHU);
        final PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), (int) id, new Intent(getActivity(), AlarmReceiver.class), PendingIntent.FLAG_CANCEL_CURRENT);
        alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        iprovider_ghiChu = new Provider_GhiChu(getActivity());

        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle(Ghichu);
        dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == dialogInterface.BUTTON_POSITIVE) {
                    mediaPlayer.stop();
                    alarmManager.cancel(pendingIntent);
                    iprovider_ghiChu.delete(id);
                    getActivity().finish();
                    Log.d("Tran","Tran");
                }
            }
        });
        return dialog.create();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getActivity().finish();
    }
}
