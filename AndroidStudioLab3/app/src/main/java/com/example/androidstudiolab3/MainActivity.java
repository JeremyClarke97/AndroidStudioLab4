package com.example.androidstudiolab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    SharedPreferences sp;
    private static final String shared_pref_name = "mypref";
    private static final String KEY_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences(shared_pref_name, MODE_PRIVATE);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button_next);

        String name = sp.getString(KEY_NAME, null);

        if (name != null){
            Intent i = new Intent (MainActivity.this, NameActivity.class);
            startActivity(i);
        }

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sp.edit();
                editor.putString(KEY_NAME, editText.getText().toString());
                editor.apply();
                Intent i = new Intent(MainActivity.this, NameActivity.class);
                startActivityForResult(i, 1);
            }
        });



    }

    public void newPage(View v){
        String message = ((EditText)findViewById(R.id.editText)).getText().toString();
        Intent nextPage = new Intent(this, NameActivity.class);
        nextPage.putExtra("name", message);
        startActivity(nextPage);
    }
}