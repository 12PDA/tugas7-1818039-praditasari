package com.example.grooming_kucing;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_grooming";
    private static final String tb_grooming = "tb_grooming";
    private static final String tb_grooming_id = "id";
    private static final String tb_grooming_nama = "nama";
    private static final String tb_grooming_umur = "umur";
    private static final String tb_grooming_jenis = "jenis";
    private static final String CREATE_TABLE_GROOMING = "CREATE TABLE " +
            tb_grooming +"("
            + tb_grooming_id + " INTEGER PRIMARY KEY ,"
            + tb_grooming_nama + " TEXT ,"
            + tb_grooming_umur + " TEXT ,"
            + tb_grooming_jenis + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_GROOMING);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void CreateGrooming(Grooming data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_grooming_id, data.get_id());
        values.put(tb_grooming_nama, data.get_nama());
        values.put(tb_grooming_umur, data.get_umur());
        values.put(tb_grooming_jenis, data.get_groom());
        db.insert(tb_grooming, null, values);
        db.close();
    }
    public List<Grooming> ReadGrooming() {
        List<Grooming> listGrm = new ArrayList<Grooming>();
        String selectQuery = "SELECT * FROM " + tb_grooming;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Grooming data = new Grooming();
                data.set_id(cursor.getString(0));
                data.set_nama(cursor.getString(1));
                data.set_umur(cursor.getString(2));
                data.set_groom(cursor.getString(3));
                listGrm.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listGrm;
    }
    public int UpdateGrooming (Grooming data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_grooming_nama, data.get_nama());
        values.put(tb_grooming_umur, data.get_umur());
        values.put(tb_grooming_jenis, data.get_groom());
        return db.update(tb_grooming, values, tb_grooming_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteGrooming(Grooming data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_grooming,tb_grooming_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
