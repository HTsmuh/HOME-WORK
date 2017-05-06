package com.example.hp.digitalquran.Database;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class DbBackend extends DbObject {
    public DbBackend(Context context) {
        super(context);
    }

    public String[] surah_arabic() {
        String query = "Select * from Surah_Names";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        ArrayList<String> surah_names_array = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String surah_name = cursor.getString(cursor.getColumnIndexOrThrow("names"));
                surah_names_array.add(surah_name);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] surah_arabic_names = new String[surah_names_array.size()];
        surah_arabic_names = surah_names_array.toArray(surah_arabic_names);
        return surah_arabic_names;
    }
    public String[] surah_roman() {
        String query = "Select * from Surah_Names";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        ArrayList<String> surah_roman_array = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String roman = cursor.getString(cursor.getColumnIndexOrThrow("roman"));
                surah_roman_array.add(roman);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] surah_roman = new String[surah_roman_array.size()];
        surah_roman = surah_roman_array.toArray(surah_roman);
        return surah_roman;
    }
    public String[] surah_No() {
        String query = "Select * from Surah_Names";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        ArrayList<String> surah_number_array = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String no = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
                surah_number_array.add(no);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] surah_number = new String[surah_number_array.size()];
        surah_number = surah_number_array.toArray(surah_number);
        return surah_number;
    }
    public String[] para_arabic() {
        String query = "Select * from Parah_Names";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        ArrayList<String> para_names_array = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String para_name = cursor.getString(cursor.getColumnIndexOrThrow("arabic_name"));
                para_names_array.add(para_name);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] para_arabic_names = new String[para_names_array.size()];
        para_arabic_names = para_names_array.toArray(para_arabic_names);
        return para_arabic_names;
    }
    public String[] para_roman() {
        String query = "Select * from Parah_Names";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        ArrayList<String> para_roman_array = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String roman = cursor.getString(cursor.getColumnIndexOrThrow("roman_name"));
                para_roman_array.add(roman);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] para_roman = new String[para_roman_array.size()];
        para_roman = para_roman_array.toArray(para_roman);
        return para_roman;
    }
    public String[] para_No() {
        String query = "Select * from Parah_Names";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        ArrayList<String> para_number_array = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String no = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
                para_number_array.add(no);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] para_number = new String[para_number_array.size()];
        para_number = para_number_array.toArray(para_number);
        return para_number;
    }
    public String[] Ayat_No() {
        String query = "Select * from quran_text";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        ArrayList<String> ayat_number_array = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String no = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
                ayat_number_array.add(no);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] ayat_number = new String[ayat_number_array.size()];
        ayat_number = ayat_number_array.toArray(ayat_number);
        return ayat_number;
    }
    public String[] Ayat_Text() {
        String query = "Select * from quran_text";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        ArrayList<String> ayat_text_array = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String ayat_text = cursor.getString(cursor.getColumnIndexOrThrow("text"));
                ayat_text_array.add(ayat_text);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] ayat_array = new String[ayat_text_array.size()];
        ayat_array = ayat_text_array.toArray(ayat_array);
        return ayat_array;
    }
    public String[] Surah_Text(int index) {
        String query = "Select * from quran_text where sura="+index;
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        ArrayList<String> quran_text_array = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String text = cursor.getString(cursor.getColumnIndexOrThrow("text"));
                quran_text_array.add(text);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] quran_text = new String[quran_text_array.size()];
        quran_text = quran_text_array.toArray(quran_text);
        return quran_text;
    }
    public String[] Para_Text(int index) {
        String query = "Select * from quran_text where para="+index;
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        ArrayList<String> quran_text_array = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String text = cursor.getString(cursor.getColumnIndexOrThrow("text"));
                quran_text_array.add(text);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] quran_text = new String[quran_text_array.size()];
        quran_text = quran_text_array.toArray(quran_text);
        return quran_text;
    }
    public SurahObject getSurahById(int surahId){

        SurahObject surahObject = null;
        String query = "select * from Surah_Names where _id = " + surahId;
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                String surah_name = cursor.getString(cursor.getColumnIndexOrThrow("names"));
                int type = cursor.getInt(cursor.getColumnIndexOrThrow("boltype"));
                String roman = cursor.getString(cursor.getColumnIndexOrThrow("roman"));
                surahObject = new SurahObject(surah_name, type,roman);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return surahObject;
    }
}
