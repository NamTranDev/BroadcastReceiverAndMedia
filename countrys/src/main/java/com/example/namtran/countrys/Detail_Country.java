package com.example.namtran.countrys;

import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.namtran.countrys.Country.Country;

import android.os.Handler;
import android.support.v7.widget.Toolbar;

/**
 * Created by Nam Tran on 8/27/2015.
 */
public class Detail_Country extends AppCompatActivity implements RatingBar.OnRatingBarChangeListener,View.OnClickListener
                        ,MediaPlayer.OnPreparedListener,SeekBar.OnSeekBarChangeListener {

    TextView namevi,nameen,Language,Caption,Religionvi,Religionen,governmentVi,governmentEn,currentcy,Population,code,Acreage,authemname;
    ImageView img;
    private Toolbar toolbar;
    RatingBar ratingBar;
    SeekBar seekbar;
    TextView timeplay;
    TextView timetotal;
    int total;
    int current;
    Button btnplay;
    String nameVi;
    String nameEn;
    String image;
    String Flag;
    String religionVi;
    String religionEn;
    String GovernmentVi;
    String GovernmentEn;
    String language;
    String caption;
    String Currency;
    int population;
    String population1;
    int Code;
    String Code1;
    double acreage;
    String acreage1;
    String AnthemSong;
    String AnthemName;
    MediaPlayer mediaPlayer;
    String PACKET_NAME;
    Handler handler;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //thiet lap thoi gian hien tai
            current = mediaPlayer.getCurrentPosition();
            timeplay.setText(stringForTime(current));
            seekbar.setProgress(current);
            if (mediaPlayer.isPlaying())
            {
                handler.postDelayed(runnable,1);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detail_country);
        getDATA();
        set();
        int authemsong = getResources().getIdentifier(PACKET_NAME+":raw/"+AnthemSong,null,null);
        mediaPlayer = MediaPlayer.create(this,authemsong);
        handler = new Handler();
        btnplay.setBackgroundResource(android.R.drawable.ic_media_play);
        btnplay.setOnClickListener(this);
        mediaPlayer.setOnPreparedListener(this);
        seekbar.setOnSeekBarChangeListener(this);
    }
    void set()
    {
        namevi = (TextView) findViewById(R.id.namevi);
        nameen = (TextView) findViewById(R.id.nameen);
        authemname = (TextView) findViewById(R.id.authemname);
        Language = (TextView) findViewById(R.id.Language);
        Caption = (TextView) findViewById(R.id.Caption);
        Religionvi = (TextView) findViewById(R.id.Religionvi);
        Religionen = (TextView) findViewById(R.id.Religionen);
        governmentVi = (TextView) findViewById(R.id.governmentVi);
        governmentEn = (TextView) findViewById(R.id.governmentEn);
        currentcy = (TextView) findViewById(R.id.currency);
        Population = (TextView) findViewById(R.id.Population);
        code = (TextView) findViewById(R.id.code);
        Acreage = (TextView) findViewById(R.id.Acreage);
        img = (ImageView) findViewById(R.id.img);
        btnplay = (Button) findViewById(R.id.btnplay);
        seekbar = (SeekBar) findViewById(R.id.seekbar);
        timeplay = (TextView) findViewById(R.id.timeplay);
        timetotal = (TextView) findViewById(R.id.timetotal);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        /*ratingBar = (RatingBar) findViewById(R.id.ratingBar);*/
        PACKET_NAME = getApplicationContext().getPackageName();
        int R = getResources().getIdentifier(PACKET_NAME + ":drawable/" + image, null, null);
        int R1 = getResources().getIdentifier(PACKET_NAME + ":drawable/" + Flag, null, null);

        toolbar.setTitle(nameEn);
        toolbar.setLogo(R1);
        setSupportActionBar(toolbar);

        namevi.setText(nameVi);
        nameen.setText(nameEn);
        authemname.setText(AnthemName);
        Language.setText(language);
        Caption.setText(caption);
        Religionvi.setText(religionVi);
        Religionen.setText(religionEn);
        governmentVi.setText(GovernmentVi);
        governmentEn.setText(GovernmentEn);
        currentcy.setText(Currency);
        Population.setText(population1 + " million");
        Acreage.setText(acreage1);
        code.setText(Code1);


        img.setImageBitmap(BitmapFactory.decodeResource(getResources(),R));
    }
    private void getDATA()
    {
        Bundle bundle = getIntent().getExtras();
        nameVi = bundle.getString(Country.NAME_VI);
        nameEn = bundle.getString(Country.NAME_EN);
        AnthemName = bundle.getString(Country.AUTHEMNAME);
        AnthemSong = bundle.getString(Country.AUTHEMSONG);
        image= bundle.getString(Country.IMAGE);
        Flag= bundle.getString(Country.FLAG);
        religionVi= bundle.getString(Country.RELIGIONVI);
        religionEn= bundle.getString(Country.RELIGIONEN);
        GovernmentVi= bundle.getString(Country.GOVERNMENTVI);
        GovernmentEn= bundle.getString(Country.GOVERNMENTEN);
        language= bundle.getString(Country.LANGUAGE);
        caption= bundle.getString(Country.CAPTION);
        Currency= bundle.getString(Country.CURRENCY);
        population= bundle.getInt(Country.POPULATION);
        population1 = String.valueOf(population);
        Code= bundle.getInt(Country.CODE);
        Code1 = String.valueOf(Code);
        acreage= bundle.getDouble(Country.ACREAGE);
        acreage1 = String.valueOf(acreage);
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnplay)
        {
            if (mediaPlayer.isPlaying())
            {
                mediaPlayer.pause();
                btnplay.setBackgroundResource(android.R.drawable.ic_media_play);
            }
            else {
                mediaPlayer.start();
                btnplay.setBackgroundResource(android.R.drawable.ic_media_pause);
                handler.postDelayed(runnable,1000);
            }
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        total = mp.getDuration();// thời gian tổng của bài hát
        timetotal.setText(stringForTime(total));
        seekbar.setMax(total);//thiet lap gia tri hien tai cua bai hat
        current = mediaPlayer.getCurrentPosition();
        timeplay.setText(stringForTime(current));
        seekbar.setProgress(current);
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        int id = seekBar.getId();
        if (id == R.id.seekbar)
        {

        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        int id = seekBar.getId();
        if (id == R.id.seekbar)
        {
            mediaPlayer.seekTo(seekBar.getProgress());
        }
    }
    private String stringForTime( int time)//set thoi gian duoi dinh dang: %1$d m, %2$d s
    {
        int totalseconds = time/1000;

        int second = totalseconds %60;
        int minute = (totalseconds/60)%60;
        return String.format("%02d:%02d",minute,second).toString();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        this.finish();
    }
}
