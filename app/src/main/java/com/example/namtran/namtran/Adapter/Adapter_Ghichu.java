package com.example.namtran.namtran.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.namtran.namtran.Lớp_cơ_bản.GhiChu;
import com.example.namtran.namtran.R;

import java.util.List;

/**
 * Created by Nam Tran on 8/6/2015.
 */
public class Adapter_Ghichu extends ArrayAdapter<GhiChu> {
    Context mContext;
    int layoutid;
    List<GhiChu> data;
    public Adapter_Ghichu(Context context, int resource, List<GhiChu> objects) {
        super(context, resource, objects);
        mContext = context;
        layoutid = resource;
        data = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Getview getview;
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutid,null);

            getview = new Getview(convertView);
            convertView.setTag(getview);
            convertView.getTag();
        }
        else
            getview = (Getview) convertView.getTag();
            getview.txtngaythangitem.setText(data.get(position).get_day() + " / " + (data.get(position).get_month()+1)+ " / " + data.get(position).get_year());
            getview.txtgiophutitem.setText(data.get(position).get_hour() + " : " + data.get(position).get_minute());
            getview.txtghichu.setText(data.get(position).get_ghichu());
        return convertView;
    }
    class Getview
    {
        TextView txtngaythangitem;
        TextView txtgiophutitem;
        TextView txtghichu;
        Getview(View view)
        {
            txtngaythangitem = (TextView) view.findViewById(R.id.txtngaythangitem);
            txtgiophutitem = (TextView) view.findViewById(R.id.txtgiophutitem);
            txtghichu = (TextView) view.findViewById(R.id.txtghichu);
        }
    }
}
