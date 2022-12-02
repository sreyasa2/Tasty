package com.example.tasty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.CheckBox;


import androidx.appcompat.app.AppCompatActivity;

public class IngredientsActivity extends AppCompatActivity {

    Button friendsBtn;
    Button recipeBtn;
    ImageButton settingsBtn;
//    boolean checked = ((CheckBox)findViewById(R.id.vegetarian)).isChecked();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);
        CheckBox chickenBox = (CheckBox)findViewById(R.id.Chicken);
        CheckBox porkBox = (CheckBox)findViewById(R.id.Pork);
         boolean checked2;
//        boolean checked2 = getIntent().getExtras().getBoolean("key", false);
        if (getIntent().getExtras() != null) {
//            System.out.println("reached if get intent null");
            checked2 = getIntent().getExtras().getBoolean("key");
        }
        else
        {
//            System.out.println("reached if get intent else");
            checked2 = false;
        }
//
        if (checked2)
        {
            chickenBox.setText("Chicken Alternative");
            porkBox.setText("Pork Alternative");
        }

        friendsBtn = findViewById(R.id.friends_button);
        friendsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IngredientsActivity.this, MainActivity.class));
            }
        });

        recipeBtn = findViewById(R.id.recipe_button);
        recipeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IngredientsActivity.this, RecipeActivity.class));
            }
        });

        settingsBtn = findViewById(R.id.settings_button);
        settingsBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IngredientsActivity.this, SettingsActivity.class));
            }
        });
    }


}