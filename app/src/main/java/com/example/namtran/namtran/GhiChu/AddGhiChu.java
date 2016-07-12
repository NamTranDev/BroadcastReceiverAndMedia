package com.example.namtran.namtran.GhiChu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.namtran.namtran.Dialog.Dialog_Calendar;
import com.example.namtran.namtran.Dialog.Dialog_TimePikerAdd;
import com.example.namtran.namtran.Iprovider.Dialog_Callback;
import com.example.namtran.namtran.Iprovider.Iprovider_GhiChu;
import com.example.namtran.namtran.Provider.Provider_GhiChu;
import com.example.namtran.namtran.R;

import java.util.Calendar;

/**
 * Created by Nam Tran on 8/17/2015.
 */
public class AddGhiChu extends AppCompatActivity implements View.OnClickListener, Dialog_Callback {

    private Toolbar toolbar;
    public Iprovider_GhiChu iprovider_ghiChu;
    Button btngiophut,btnngaythangnam;
    TextView txtngaythang,txtgiophut;
    EditText edtghichu;


    int day;
    int month;
    int year;
    int hour;
    int minute;

    private Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ghichu);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.icon_ghichu);
        toolbar.setTitle(R.string.ghichu1);
        toolbar.setTitleTextColor(R.color.red);
        setSupportActionBar(toolbar);
        nhamchan();
        setCalendar();
        txtngaythang.setText(day + " / " + (month+1) + " / " + year);
        txtgiophut.setText(hour + " : " + minute);

        btnngaythangnam.setOnClickListener(this);
        btngiophut.setOnClickListener(this);
    }

    void setCalendar()
    {
        minute = calendar.get(Calendar.MINUTE);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);
    }

    private void nhamchan()
    {
        txtgiophut = (TextView) findViewById(R.id.txtgiophut);
        txtngaythang = (TextView) findViewById(R.id.txtngaythangnam);
        edtghichu = (EditText) findViewById(R.id.edtghichu);
        btngiophut = (Button) findViewById(R.id.btngiophut);
        btnngaythangnam = (Button) findViewById(R.id.btnngaythangnam);
    }

    @Override
    public void setTimerComplete(boolean complete, int mHour, int mMinute) {
        if (complete)
        {
            hour = mHour;
            minute = mMinute;
            txtgiophut.setText(hour + " : " + minute);
        }
        else
        {
            Toast.makeText(this, "Fail", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void setDateComplete(boolean complete, int mYear, int mMonth, int mDay) {
        if (complete)
        {
            day = mDay;
            month = mMonth;
            year = mYear;
            txtngaythang.setText(day + " / " + (month+1) + " / " + year);
        }
        else
        {
            Toast.makeText(this, "Fail", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnngaythangnam)
        {
            Dialog_Calendar dialog_calendar = new Dialog_Calendar();
            dialog_calendar.show(getFragmentManager(), "Dialog");
            setDateComplete(true, year, month, day);
        }
        else if (id == R.id.btngiophut)
        {
            Dialog_TimePikerAdd dialogTimePiker = new Dialog_TimePikerAdd();
            dialogTimePiker.show(getFragmentManager(), "Dialog");
            setTimerComplete(true, hour, minute);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_luu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.mnOK)
        {
            iprovider_ghiChu = new Provider_GhiChu(this);
            long kt = iprovider_ghiChu.insert(day,month,year,hour,minute,edtghichu.getText().toString());
            if (kt != 0)
            {
                this.finish();
            }

            else
            {
                Toast.makeText(this,"Fail",Toast.LENGTH_LONG).show();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
