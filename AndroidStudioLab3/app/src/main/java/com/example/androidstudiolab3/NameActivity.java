package com.example.androidstudiolab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NameActivity extends AppCompatActivity {

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    TextView textView2;
    Button button, button2;

    SharedPreferences sp;
    private static final String shared_pref_name = "mypref";
    private static final String KEY_NAME = "name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        Intent nextPage = getIntent();
        String message = nextPage.getStringExtra("name");

        textView2 = findViewById(R.id.textView2);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        sp = getSharedPreferences(shared_pref_name, MODE_PRIVATE);

        String name = sp.getString(KEY_NAME, null);

        if (name != null){
            textView2.setText("Welcome "+name+"!");

        }
        button2.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                setResult(0);
                finish();
            }
        });
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onDestroy();
            finish();
        }
    });

    }

}