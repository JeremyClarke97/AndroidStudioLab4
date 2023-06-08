package com.example.androidstudiolab4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Switch urgent;
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listView;
    private Button button;

    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextText);
        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);
        urgent = findViewById(R.id.switch1);


        //ADD button click listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                items.add(editText.getText().toString());

                itemsAdapter.notifyDataSetChanged();
            }
        });

        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>
                (this, R.layout.activity_list_view, R.id.listTextView, items);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id) {

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Do you want to remove " + items.get(i) + " from list?")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                items.remove(items.get(i));
                                itemsAdapter.notifyDataSetChanged();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.dismiss();
                            }
                        }).create().show();

                return false;
            }
        });

    };

    /* I couldnt figure out the highlighting, is it possible to send a solution to the assignment?
    public Object todoitem(){
        boolean urgent;


    }
    private class MyListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View newView = convertView;
            Todo todo = (Todo)getItem(position);
            LayoutInflater inflater = getLayoutInflater();

            if(newView == null){
                newView = inflater.inflate(R.layout.activity_list_view, parent, false);
            }


            return newView;
        }
        }*/
    }