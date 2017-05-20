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
    public String[] ayat_translation_array;
    public String[] ayat_arabic_array;
    Typeface tf;

    public TranslationAdapter(Context context, String[] ayat_translation, String[] ayat_arabic) {
        super(context, R.layout.translation_single_row,R.id.translationArabicText,ayat_arabic);
        this.context=context;
        this.ayat_translation_array=ayat_translation;
        this.ayat_arabic_array=ayat_arabic;
        tf = Typeface.createFromAsset(context.getAssets(), "fonts/pdms.ttf");

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.translation_single_row,parent,false);
        TextView translation= (TextView) row.findViewById(R.id.translationUrduText);
        TextView arabic= (TextView) row.findViewById(R.id.translationArabicText);
        arabic.setText(ayat_arabic_array[position]);
        translation.setText(ayat_translation_array[position]);
        arabic.setTypeface(tf);
        return row;
    }
}