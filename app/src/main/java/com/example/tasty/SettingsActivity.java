package com.example.tasty;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;

public class SettingsActivity extends AppCompatActivity {

    ImageButton backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Code to go back
        backBtn = (ImageButton) findViewById(R.id.back_button);
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsActivity.this, MainActivity.class));
            }
        });

    }
    public void onCheckboxClicked(View view) {
        Intent i = new Intent(SettingsActivity.this, IngredientsActivity.class);
        boolean checked = ((CheckBox)findViewById(R.id.vegetarian)).isChecked();
        i.putExtra("key", checked);
        startActivity(i);
    }

}