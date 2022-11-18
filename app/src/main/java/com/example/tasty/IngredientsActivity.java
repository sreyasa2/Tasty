package com.example.tasty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class IngredientsActivity extends AppCompatActivity {

    Button friendsBtn;
    Button recipeBtn;
    ImageButton settingsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

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