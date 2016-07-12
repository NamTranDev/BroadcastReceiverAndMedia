package com.example.namtran.namtran.Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;

import com.example.namtran.namtran.GhiChu.AddGhiChu;
import com.example.namtran.namtran.GhiChu.UpdateGhiChu;
import com.example.namtran.namtran.Iprovider.Dialog_Callback;
import com.example.namtran.namtran.R;

/**
 * Created by Nam Tran on 8/6/2015.
 */
public class Dialog_TimePikerUpdate extends DialogFragment implements DialogInterface.OnClickListener,TimePicker.OnTimeChangedListener{

    TimePicker timePicker;
    Dialog_Callback dialog_callback;
    int hour,minute;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.layout_dialog_timepicker,null);

        dialog_callback = (UpdateGhiChu)getActivity();

        timePicker = (TimePicker) view.findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener(this);

        AlertDialog dialog = new AlertDialog.Builder(getActivity()).setTitle("Time").setPositiveButton("Ok",this)
                .setNegativeButton("Cancel",this).setView(view).create();
        return dialog;


    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == dialogInterface.BUTTON_POSITIVE)
        {
        dialog_callback.setTimerComplete(true,hour,minute);
        dismiss();
    }else if (i == dialogInterface.BUTTON_NEGATIVE)
        {
            dialogInterface.dismiss();
        }
    }

    @Override
    public void onTimeChanged(TimePicker timePicker, int mHour, int mMinute) {
        hour = mHour;
        minute = mMinute;
    }
}
