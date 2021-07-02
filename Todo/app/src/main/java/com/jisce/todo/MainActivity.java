package com.jisce.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList items;
    private ArrayAdapter<String> itemAdaptor;
    private ListView listview;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.lv);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = findViewById(R.id.et);
                String itemText = input.getText().toString();
                if(!(itemText.equals(""))){
                    itemAdaptor.add(itemText);
                    input.setText("");
                }
            }
        });

        items = new ArrayList<>();
        itemAdaptor = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listview.setAdapter(itemAdaptor);
    }
}