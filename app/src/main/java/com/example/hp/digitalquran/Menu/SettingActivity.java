package com.example.hp.digitalquran.Menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hp.digitalquran.Database.DbBackend;
import com.example.hp.digitalquran.R;

public class SettingActivity extends AppCompatActivity {
    Spinner textSize;
    Spinner displayMode;
    Spinner textScript;
    Button setting_button;
    DbBackend db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        db=new DbBackend(SettingActivity.this);

        textSize = (Spinner) findViewById(R.id.text_size);
        displayMode= (Spinner) findViewById(R.id.display_mode);
        textScript= (Spinner) findViewById(R.id.text_script);

        setting_button = (Button) findViewById(R.id.setting_btn);

        setting_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(textSize.getSelectedItem().toString().trim().equals("Select Text Size")
                    &&displayMode.getSelectedItem().toString().trim().equals("Select Display Mode")
                    &&textScript.getSelectedItem().toString().trim().equals("Select Script")){
                Toast.makeText(SettingActivity.this, "Previous Setting", Toast.LENGTH_SHORT).show();
            }else{

                if (textSize.getSelectedItem().toString().trim().equals("Small")){
                    db.setSize(15);
                }else if (textSize.getSelectedItem().toString().trim().equals("Normal")){
                    db.setSize(18);
                }else if (textSize.getSelectedItem().toString().trim().equals("Large")){
                    db.setSize(24);
                }else if (textSize.getSelectedItem().toString().trim().equals("Extra Large")){
                    db.setSize(28);
                }else if (displayMode.getSelectedItem().toString().trim().equals("Day Mode")){
                    db.setMode("Day");
                }else if (displayMode.getSelectedItem().toString().trim().equals("Night Mode")){
                    db.setMode("Night");
                }else if (textScript.getSelectedItem().toString().trim().equals("Me Quran")){
                    db.setScript("me_quran");
                }else if (textScript.getSelectedItem().toString().trim().equals("PDMS Saleem")){
                    db.setScript("pdms");
                }
                Toast.makeText(SettingActivity.this, "Setting Changed"+db.getSize()+" "+db.getMode()+""+db.getScript(), Toast.LENGTH_SHORT).show();
            }
            }
        });
    }
}