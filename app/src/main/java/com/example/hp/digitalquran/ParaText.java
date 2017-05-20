package com.example.hp.digitalquran;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.example.hp.digitalquran.Adapter.TranslationAdapter;
import com.example.hp.digitalquran.Database.DbBackend;

import java.util.Arrays;

public class ParaText extends AppCompatActivity {

    TextView quranText;
    Typeface tf;
    ImageView bismillah;
    ViewGroup header;
    int num;
    int index;
    Button translation;
    ListView ParaTextList;
    boolean isTranslate=false;
    TranslationAdapter listAdapter;
    ScrollView ParaTextScroll;
    LayoutInflater inflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_para_text);
        setTheme(R.style.DayMoodFullScreen);
        translation= (Button) findViewById(R.id.translate);
        ParaTextList= (ListView) findViewById(R.id.paratextlist);
        inflater = getLayoutInflater();
        header = (ViewGroup)inflater.inflate(R.layout.translation_header, ParaTextList , false);
        ParaTextList .addHeaderView(header, null, false);
        ParaTextScroll= (ScrollView) findViewById(R.id.paratextscroll);
        bismillah= (ImageView) findViewById(R.id.bismillahimage);
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.activity_para_text);
        Resources res = getResources();
        Drawable portrait = res.getDrawable(R.drawable.portrait);
        Drawable landscape = res.getDrawable(R.drawable.landscape);

        WindowManager window = (WindowManager)getSystemService(WINDOW_SERVICE);
        Display display = window.getDefaultDisplay();
        num = display.getRotation();
        if (num == 0){
            relativeLayout.setBackgroundDrawable(portrait);
        }else if (num == 1 || num == 3){
            relativeLayout.setBackgroundDrawable(landscape);
        }else{
            relativeLayout.setBackgroundDrawable(portrait);
        }
        quranText= (TextView) findViewById(R.id.para_text);
        tf = Typeface.createFromAsset(getAssets(), "fonts/pdms.ttf");
        quranText.setTypeface(tf);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        index = bundle.getInt("Para_Number");
        DbBackend db=new DbBackend(ParaText.this);

        String[] text = db.Para_Text(index);
        String finalize = Arrays.toString(text).replaceAll(",","");
        String finalize1 = finalize.replaceAll("\\[","");
        String finalize2 = finalize1.replaceAll("\\]","");

        String[] arabic_text = db.Para_Ayat_Text(index);
        String[] translation_text = db.Para_Translation_Text(index);
        listAdapter = new TranslationAdapter(this,translation_text,arabic_text);
        quranText.setText(finalize2);
        translation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isTranslate){
                    translation.setText("HIDE TRANSLATION");
                    isTranslate=true;
                    quranText.setVisibility(View.INVISIBLE);
                    ParaTextScroll.setVisibility(View.INVISIBLE);
                    ParaTextList.setVisibility(View.VISIBLE);
                    ParaTextList.setAdapter(listAdapter);
                    if (index==9){
                        header.findViewById(R.id.bismillah2).setVisibility(View.INVISIBLE);
                    }
                }else{
                    translation.setText("SHOW TRANSLATION");
                    isTranslate=false;
                    quranText.setVisibility(View.VISIBLE);
                    ParaTextScroll.setVisibility(View.VISIBLE);
                    ParaTextList.setVisibility(View.INVISIBLE);
                }
            }


        });
    }
}