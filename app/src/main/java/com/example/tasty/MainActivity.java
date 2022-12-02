package com.example.tasty;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1887;
    public static int blurred = 1;
    ImageButton ourFoodBtn;
    ImageButton cameraBtn;
    ImageButton settingsBtn;
    Button recipeBtn;
    Button ingBtn;
    ToggleButton toggleButton;
    ToggleButton toggleButton2;
    ToggleButton toggleButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.blurred_layout);
        // Code to display settings activity
        settingsBtn = (ImageButton) findViewById(R.id.settings_button);
        settingsBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });

        /*ourFoodBtn = findViewById(R.id.ourFood);
        ourFoodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, REQUEST_CODE);
            }
        });*/

        if(blurred == 1){
            cameraBtn = findViewById(R.id.camera);
            cameraBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, REQUEST_CODE);
                }
            });
        }


        recipeBtn = findViewById(R.id.recipe_button);
        recipeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RecipeActivity.class));
            }
        });

        ingBtn = findViewById(R.id.ingredients_button);
        ingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, IngredientsActivity.class));
            }
        });
        toggleButton = (ToggleButton) findViewById(R.id.myToggleButton);
        toggleButton.setChecked(false);
        toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_heart_grey));
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.img_heart_red));
                else
                    toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_heart_grey));
            }
        });
        toggleButton2 = (ToggleButton) findViewById(R.id.myToggleButton2);
        toggleButton2.setChecked(false);
        toggleButton2.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_heart_grey));
        toggleButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    toggleButton2.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_heart_red));
                else
                    toggleButton2.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_heart_grey));
            }
        });
        toggleButton3 = (ToggleButton) findViewById(R.id.myToggleButton3);
        toggleButton3.setChecked(false);
        toggleButton3.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_heart_grey));
        toggleButton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    toggleButton3.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_heart_red));
                else
                    toggleButton3.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_heart_grey));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK)
        {
            setContentView(R.layout.activity_main);
            blurred = 0;
            ourFoodBtn = findViewById(R.id.ourFood);
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            int[] images = {R.drawable.spaghetti3,R.drawable.spaghetti4,R.drawable.spaghetti5};
            Random rand = new Random();
            ourFoodBtn.setImageResource(images[rand.nextInt(images.length)]);
            //ourFoodBtn.setImageBitmap(photo);
        }
        else
        {
            Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}