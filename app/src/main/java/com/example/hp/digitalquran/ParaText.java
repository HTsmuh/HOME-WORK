package com.example.hp.digitalquran;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.hp.digitalquran.Database.DbBackend;

import java.util.Arrays;

public class ParaText extends AppCompatActivity {

    TextView quranText;
    Typeface tf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_para_text);

        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.activity_surah_text);
        Resources res = getResources();
        Drawable portrait = res.getDrawable(R.drawable.portrait);
        Drawable landscape = res.getDrawable(R.drawable.landscape);

        WindowManager window = (WindowManager)getSystemService(WINDOW_SERVICE);
        Display display = window.getDefaultDisplay();
        int num = display.getRotation();
        if (num == 0){
            relativeLayout.setBackgroundDrawable(portrait);
        }else if (num == 1 || num == 3){
            relativeLayout.setBackgroundDrawable(landscape);
        }else{
            relativeLayout.setBackgroundDrawable(portrait);
        }
        quranText= (TextView) findViewById(R.id.quran_text);
        tf = Typeface.createFromAsset(getAssets(), "fonts/me_quran.ttf");
        quranText.setTypeface(tf);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int index = bundle.getInt("Para_Number");
        DbBackend db=new DbBackend(ParaText.this);

        String[] text = db.Para_Text(index);

        quranText.setText(Arrays.toString(text).replaceAll("\\[|\\]", ""));
    }
}