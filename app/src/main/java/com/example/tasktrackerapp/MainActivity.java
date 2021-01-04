package com.example.tasktrackerapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;
    private EditText editField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItems = (ListView) findViewById(R.id.lvItems);
        items = new ArrayList<String>();
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);
        items.add("First Item");
        items.add("Second Item");
    }

    public void onAddItem(android.view.View v) {
        editField = (EditText) findViewById(R.id.etNewItem);
        Log.d("tasktrackerapp", editField.getText().toString());
        items.add(editField.getText().toString());
        for (int i = 0; i < lvItems.getCount(); i++) {
            Log.d("tasktrackerapp", String.valueOf(lvItems.getCount()));
            lvItems.getChildAt(i).setOnTouchListener(onTouchListener);
        }
    }

    View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            Log.d("tasktrackerapp", "IT WORKS");
            Log.d("tasktrackerapp", editField.getText().toString());
            return false;
        }
    };
}
