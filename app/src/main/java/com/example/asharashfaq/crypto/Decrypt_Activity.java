package com.example.asharashfaq.crypto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.asharashfaq.crypto.Ciphers.Ceasar;
import com.example.asharashfaq.crypto.Ciphers.PlayFair;
import com.example.asharashfaq.crypto.Ciphers.RailFence;
import com.example.asharashfaq.crypto.Ciphers.polyalphabetic;
import com.example.asharashfaq.crypto.Ciphers.vegenere;
import com.example.asharashfaq.crypto.R;

public class Decrypt_Activity extends AppCompatActivity {

    private TextView ciphertext1,Toencrypt;
    private Button Todecrypt;
    private int key;
    private String StringKey;
    private String Key_playfair;
    private String encrypted_msg = "";
    EditText msgTodecrypt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt_);
        msgTodecrypt = findViewById(R.id.msgToDecrypt);
        ciphertext1 = findViewById(R.id.ciphertext1);
        Toencrypt = findViewById(R.id.ToEncrypt);
        Todecrypt = findViewById(R.id.Decrypt_btn);
        key = getIntent().getExtras().getInt("key");
        ciphertext1.setText(getIntent().getExtras().getString("Cipher"));
        msgTodecrypt.setText(getIntent().getExtras().getString("DecryptMsg"));
        encrypted_msg = getIntent().getExtras().getString("Message");
        StringKey = getIntent().getExtras().getString("StringKey");
        Key_playfair = getIntent().getExtras().getString("Key_PlayFair");
        Todecrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Which_Cipher();
            }
        });

    }

    private void Which_Cipher(){
        switch (getIntent().getExtras().getString("Cipher")){
            case "Ceasar":
                Ceasar ceasar = new Ceasar(msgTodecrypt.getText().toString(),key);
                Toencrypt.setText(ceasar.Decryption());
                break;
            case "Vegenere":
                vegenere veg = new vegenere(msgTodecrypt.getText().toString(),StringKey);
                Toencrypt.setText(veg.decryption());
                break;
            case "Polyalphabetic":
                polyalphabetic polyalphabetic = new polyalphabetic(msgTodecrypt.getText().toString());
                Toencrypt.setText(polyalphabetic.Decryption());
                break;
            case "PlayFair":
                PlayFair playFair = new PlayFair(msgTodecrypt.getText().toString(),Key_playfair);
                Toencrypt.setText(playFair.Decryption());
                break;
            case "RailFence":
                break;
            case "Columnar":
                break;
        }
    }



}
