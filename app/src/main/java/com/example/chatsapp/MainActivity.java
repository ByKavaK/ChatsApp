package com.example.chatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public EditText mesajEditText;
    public Button gonderButton;
    public ListView mesajList;
    public List<String> mesajlar;
    public ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mesajEditText = findViewById(R.id.mesajEditText);
        gonderButton = findViewById(R.id.gonderButton);
        mesajList = findViewById(R.id.mesajList);

        mesajlar = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mesajlar);
        mesajList.setAdapter(adapter);

        gonderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mesaj = mesajEditText.getText().toString().trim();
                if(!mesaj.isEmpty()){
                    mesajlar.add("Yasin: " + mesaj);
                    mesajlar.add("Hamza: " + mesaj);
                    adapter.notifyDataSetChanged();
                    mesajEditText.setText("");
                }
            }
        });
    }
}