package com.example.hp.digitalquran.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.example.hp.digitalquran.Adapter.TranslationAdapter;
import com.example.hp.digitalquran.Database.DbBackend;
import com.example.hp.digitalquran.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TranslationFragment extends Fragment {

    ListView itemList;
    TranslationAdapter listAdapter;

    public TranslationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView=inflater.inflate(R.layout.fragment_translation, container, false);
        itemList = (ListView)myView.findViewById(R.id.listView_translation);
        DbBackend db=new DbBackend(getContext());

        String[] arabic_text = db.Ayat_Text();
        String[] ayat_number = db.Ayat_No();

        listAdapter = new TranslationAdapter(getContext(),ayat_number,arabic_text);

        itemList.setAdapter(listAdapter);


        return myView;
    }

}
