package com.example.asharashfaq.crypto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] cipher = {"Ceasar's Cipher","Vegenere's Cipher","PolyAlphabethic Cipher","PlayFair Cipher","Rail Fence","Columnar Transposition Cipher"};
        ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,cipher);
        ListView Cipherlist = findViewById(R.id.cipherslist);
        Cipherlist.setAdapter(listAdapter);

        Cipherlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Cipher = String.valueOf(parent.getItemAtPosition(position));
                Intent intent = new Intent(MainActivity.this,Encrypted_Activity.class);
                intent.putExtra("Cipher",Cipher);
                startActivity(intent);
                finish();
            }
        });
    }
}
