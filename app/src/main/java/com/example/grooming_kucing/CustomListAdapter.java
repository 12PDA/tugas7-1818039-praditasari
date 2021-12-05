package com.example.grooming_kucing;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Grooming> Grooming;
    public CustomListAdapter(Activity activity, List<Grooming>
            Grooming) {
        this.activity = activity;
        this.Grooming = Grooming;
    }
    @Override
    public int getCount() {
        return Grooming.size();
    }
    @Override
    public Object getItem(int location) {
        return Grooming.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView nama_anabul = (TextView)
                convertView.findViewById(R.id.text_nm_anabul);
        TextView umur = (TextView)
                convertView.findViewById(R.id.text_umur_anabul);
        TextView groom = (TextView)
                convertView.findViewById(R.id.text_jenis_groom);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Grooming g = Grooming.get(position);
        nama_anabul.setText("Nama Anabul : "+ g.get_nama());
        umur.setText("Umur : "+ g.get_umur());
        groom.setText("Jenis Grooming : "+ g.get_groom());
        return convertView;
    }
}
