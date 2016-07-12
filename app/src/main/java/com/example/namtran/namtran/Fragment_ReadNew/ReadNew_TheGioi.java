package com.example.namtran.namtran.Fragment_ReadNew;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.namtran.namtran.Adapter.Adapter_ReadNew;
import com.example.namtran.namtran.Asystask.Asystank_ReadNew;
import com.example.namtran.namtran.Lớp_cơ_bản.News;
import com.example.namtran.namtran.R;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by Nam Tran on 8/19/2015.
 */
public class ReadNew_TheGioi extends android.support.v4.app.Fragment implements Asystank_ReadNew.GetResult,AdapterView.OnItemClickListener
{

    ListView listViewitiem;
    Adapter_ReadNew adapterReadNew;
    List<News> newsList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_readnew,null);
        listViewitiem = (ListView) view.findViewById(R.id.listViewitiem);
        listViewitiem.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Asystank_ReadNew asystank_readNew = new Asystank_ReadNew(this);
        try {
            asystank_readNew.execute(new URL("http://vnexpress.net/rss/the-gioi.rss"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void GetResult( List<News> result) {
        newsList = result;
        if (newsList != null && getActivity() != null) {
            adapterReadNew = new Adapter_ReadNew(getActivity(), R.layout.layout_item_new, newsList);
            listViewitiem.setAdapter(adapterReadNew);
        }
        else {
            Toast.makeText(this.getActivity(), "Không thể kết nối đến trang web", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(newsList.get(position).getLink()));
        startActivity(intent);
    }
}
