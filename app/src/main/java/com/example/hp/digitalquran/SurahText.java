package com.example.hp.digitalquran;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hp.digitalquran.Database.DbBackend;

import java.util.Arrays;

public class SurahText extends AppCompatActivity {
    TextView quranText;
    Typeface tf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_text);
        quranText= (TextView) findViewById(R.id.quran_text);
        tf = Typeface.createFromAsset(getAssets(), "fonts/pdms.ttf");
        quranText.setTypeface(tf);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int index = bundle.getInt("Surah_Number");
        DbBackend db=new DbBackend(SurahText.this);

        String[] text = db.Surah_Text(index);

        quranText.setText(Arrays.toString(text).replaceAll("\\[|\\]", ""));
    }
}