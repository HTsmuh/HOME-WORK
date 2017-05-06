package com.example.hp.digitalquran.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.hp.digitalquran.R;

/**
 * Created by Syed Minhaj ul Hasan on 5/6/2017.
 */

public class TranslationAdapter extends ArrayAdapter<String> {
    public Context context;
    public String[] ayat_no_array;
    public String[] ayat_arabic_array;
    //public String[] ayat_roman_array;
    Typeface tf;

    public TranslationAdapter(Context context, String[] ayat_no, String[] ayat_arabic) {
        super(context, R.layout.ayat_single_row,R.id.text2,ayat_arabic);
        this.context=context;
        this.ayat_no_array=ayat_no;
        this.ayat_arabic_array=ayat_arabic;
        //this.ayat_roman_array=ayat_roman;
        tf = Typeface.createFromAsset(context.getAssets(), "fonts/pdms.ttf");

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.ayat_single_row,parent,false);
        TextView number= (TextView) row.findViewById(R.id.text1);
        TextView arabic= (TextView) row.findViewById(R.id.text2);
        //TextView roman= (TextView) row.findViewById(R.id.text3);
        arabic.setText(ayat_arabic_array[position]);
        number.setText(ayat_no_array[position]);
        //roman.setText(ayat_roman_array[position]);
        arabic.setTypeface(tf);
        return row;
    }
}