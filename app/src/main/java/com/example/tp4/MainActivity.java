package com.example.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.list = this.findViewById(R.id.view);
        this.autoComplete = findViewById(R.id.autoCompleteTextView);
        ArrayAdapter tab= new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, arr);
        autoComplete.setAdapter(tab);
        autoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), ((TextView) view).getText(),
                        Toast.LENGTH_SHORT).show();
                student= (String) ((TextView) view).getText();
                if (student.equals("sara")) {
                    ArrayAdapter note= new ArrayAdapter<String>
                            (MainActivity.this, android.R.layout.simple_list_item_1, sara);
                            //(this,android.R.layout.simple_list_item_1, sara);
                    list.setAdapter(note);
                } else if (student.equals("sami")) {
                    ArrayAdapter note= new ArrayAdapter<String>
                            (MainActivity.this, android.R.layout.simple_list_item_1, sami);
                    list.setAdapter(note);
                } else {
                    ArrayAdapter note= new ArrayAdapter<String>
                            (MainActivity.this,android.R.layout.simple_list_item_1, samira);
                    list.setAdapter(note);
                }
            }
        });
    }
    AutoCompleteTextView autoComplete;
    ListView list;
    String[] arr = {"sara", "sami", "samira"};
    String[] matiere = {"Android",  "jee","Angular", "web"};
    String[] sara = {"12", "7", "10", "10"};
    String[] sami = {"15", "7", "12", "10"};
    String[]samira = {"12", "7", "10", "10"};
    String student;

}