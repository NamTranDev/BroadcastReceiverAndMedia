package com.example.namtran.namtran.Asystask;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;


import com.example.namtran.namtran.Lớp_cơ_bản.News;
import com.example.namtran.namtran.RSSUtil.RSSUtil;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Nam Tran on 7/20/2015.
 */
public class Asystank_ReadNew extends AsyncTask<URL, Void, List<News>>  {

    GetResult mgetResult;

    public Asystank_ReadNew(GetResult getResult) {
        mgetResult = getResult;
    }

    @Override
protected List<News> doInBackground(URL... urls) {
        List<News> newses = new ArrayList<>();
        for (URL url : urls) {
                 try {
                         URLConnection urlConnection = url.openConnection();
                            if (url.getPath().contains("HTTPS")) {
                                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) urlConnection;
                            if (httpsURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                                newses= RSSUtil.readRSSDanTri(httpsURLConnection.getInputStream());
                            }
                            } else {
                                HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
                            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                                newses = RSSUtil.readRSSDanTri(httpURLConnection.getInputStream());
                            }
                            }
                    } catch (IOException e) {
                 e.printStackTrace();
                    }
        }
        return newses;
   }


@Override
protected void onPostExecute(List<News> newses)
    {
        super.onPostExecute(newses);
        if (mgetResult!= null)
        {
            mgetResult.GetResult(newses);
        }
    }

    public interface GetResult{
        void GetResult( List<News> result);
    }
}
