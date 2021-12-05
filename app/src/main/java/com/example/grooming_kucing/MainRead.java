package com.example.grooming_kucing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView gListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Grooming> ListGrooming = new
            ArrayList<Grooming>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListGrooming
        );
        gListView = (ListView) findViewById(R.id.list_customer);
        gListView.setAdapter(adapter_off);
        gListView.setOnItemClickListener(this);
        gListView.setClickable(true);
        ListGrooming.clear();
        List<Grooming> grooming = db.ReadGrooming();
        for (Grooming grm : grooming) {
            Grooming daftar = new Grooming();
            daftar.set_id(grm.get_id());
            daftar.set_nama(grm.get_nama());
            daftar.set_umur(grm.get_umur());
            daftar.set_groom(grm.get_groom());
            ListGrooming.add(daftar);
            if ((ListGrooming.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = gListView.getItemAtPosition(i);
        Grooming detailGrm = (Grooming) o;
        String Sid = detailGrm.get_id();
        String Snama = detailGrm.get_nama();
        String Sumur = detailGrm.get_umur();
        String Sgroom = detailGrm.get_groom();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Iumur", Sumur);
        goUpdel.putExtra("Igroom", Sgroom);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListGrooming.clear();
        gListView.setAdapter(adapter_off);
        List<Grooming> grooming = db.ReadGrooming();
        for (Grooming mhs : grooming) {
            Grooming daftar = new Grooming();
            daftar.set_id(mhs.get_id());
            daftar.set_nama(mhs.get_nama());
            daftar.set_umur(mhs.get_umur());
            daftar.set_groom(mhs.get_groom());
            ListGrooming.add(daftar);
            if ((ListGrooming.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
