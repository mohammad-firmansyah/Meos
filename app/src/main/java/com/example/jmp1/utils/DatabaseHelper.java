package com.example.jmp1.utils;


import static com.example.jmp1.utils.DateHelper.convertDateToString;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "mahasiswa_db";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_MAHASISWA = "mhs";
    private static final String KEY_ID = "id";
    private static final String KEY_NOMOR = "nomor";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_TGL_LAHIR = "tgl_lahir";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_ALAMAT = "alamat";

    private static final String CREATE_TABLE_MHS = "CREATE TABLE " +
            TABLE_MAHASISWA + "("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            KEY_NOMOR +" INTEGER,"+KEY_NAMA+" TEXT,"+KEY_TGL_LAHIR + " DATE," + KEY_ALAMAT + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.d("table",CREATE_TABLE_MHS);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_MHS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXISTS '"+TABLE_MAHASISWA+"'");
        onCreate(db);
    }

    public long addNewMhs(Integer nomor, String nama, DateHelper tgl_lahir, String gender, String alamat){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NOMOR,nomor);
        values.put(KEY_NAMA,nama);
        values.put(KEY_TGL_LAHIR,convertDateToString(tgl_lahir));
        values.put(KEY_ALAMAT,alamat);
        values.put(KEY_GENDER,gender);
        long insert = db.insert(TABLE_MAHASISWA,null,values);
        return insert;
    }

    public ArrayList<String> getAllMhs(){
        ArrayList<String> mhsList = new ArrayList<String>();
        String name = "";
        String selectQuery = "SELECT * FROM "+ TABLE_MAHASISWA;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery,null);
        if (c.moveToFirst()){
            do{
                name=c.getString(c.getColumnIndex(KEY_NAMA));
                mhsList.add(name);
            } while (c.moveToNext());
        }
        return mhsList;
    }




}
