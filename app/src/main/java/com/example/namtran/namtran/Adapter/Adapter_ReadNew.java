package com.example.namtran.namtran.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.namtran.namtran.Lớp_cơ_bản.News;
import com.example.namtran.namtran.R;

import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by Nam Tran on 8/6/2015.
 */
public class Adapter_ReadNew extends ArrayAdapter<News> {
    Context mContext;
    int layoutid;
    List<News> data;
    public Adapter_ReadNew(Context context, int resource, List<News> objects) {
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

            getview.txttitle.setText(data.get(position).getTitle());
            getview.txtdate.setText(data.get(position).getPubdate());
            getview.txtdecription.setText(data.get(position).getDecription());
        Picasso.with(mContext).load(data.get(position).getImage()).resize(250,250).centerCrop().into(getview.image);
        return convertView;
    }
    class Getview
    {
        ImageView image;
        TextView txttitle;
        TextView txtdate;
        TextView txtdecription;
        Getview(View view)
        {
            image = (ImageView) view.findViewById(R.id.image);
            txttitle = (TextView) view.findViewById(R.id.txttitle);
            txtdate = (TextView) view.findViewById(R.id.txtdate);
            txtdecription = (TextView) view.findViewById(R.id.txtdecription);
        }
    }
}
