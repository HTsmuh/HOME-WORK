package com.example.hp.digitalquran.Database;

public class SurahObject {

    private String surah_name;
    private int surah_id;
    private String roman_name;

    public SurahObject(String name,int id, String roman) {
        this.surah_name = name;
        this.surah_id=id;
        this.roman_name = roman;
    }

    public String getSurah_name() {
        return surah_name;
    }

    public void setSurah_name(String surah_name) {
        this.surah_name = surah_name;
    }

    public int getSurah_id() {
        return surah_id;
    }

    public void setSurah_id(int surah_id) {
        this.surah_id = surah_id;
    }

    public String getRoman_name() {
        return roman_name;
    }

    public void setRoman_name(String roman_name) {
        this.roman_name = roman_name;
    }
}
