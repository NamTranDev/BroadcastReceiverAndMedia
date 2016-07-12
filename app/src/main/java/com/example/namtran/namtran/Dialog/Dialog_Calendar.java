package com.example.namtran.namtran.Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CalendarView;

import com.example.namtran.namtran.Iprovider.Dialog_Callback;
import com.example.namtran.namtran.GhiChu.AddGhiChu;
import com.example.namtran.namtran.R;

/**
 * Created by Nam Tran on 8/17/2015.
 */
public class Dialog_Calendar extends DialogFragment implements CalendarView.OnDateChangeListener{

    CalendarView calendarView;
    Dialog_Callback dialog_callback;;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.layout_calendar,null);
        calendarView = (CalendarView) view.findViewById(R.id.calendarView);
        calendarView.setShowWeekNumber(false);

        dialog_callback = (AddGhiChu)getActivity();


        calendarView.setOnDateChangeListener(this);


        AlertDialog dialog = new AlertDialog.Builder(getActivity()).setTitle("Date").setView(view).create();
        return dialog;
    }

    @Override
    public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day) {
        dialog_callback.setDateComplete(true,year,month,day);
        dismiss();
    }

}
