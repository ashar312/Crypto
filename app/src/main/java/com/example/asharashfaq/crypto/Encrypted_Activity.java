package com.example.asharashfaq.crypto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.asharashfaq.crypto.Ciphers.*;

public class Encrypted_Activity extends AppCompatActivity {

    private String Cipher;
    private TextView ciphertext,Todecrypt,ToDecryptActivity;
    private Button ToEncrypt;
    private EditText Message;
    private int key;
    private String keyString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypted_);
        Cipher = getIntent().getExtras().getString("Cipher");
        ciphertext = findViewById(R.id.cihperText);
        Todecrypt = findViewById(R.id.encrypt_msg);
        ToEncrypt = findViewById(R.id.encrypt_btn);
        Message = findViewById(R.id.message);
        ToDecryptActivity = findViewById(R.id.Todecrypt);
        key = 3;
        keyString = "LEMON";
        Which_Cipher(Cipher);
        ToEncrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Which_Cipher();
            }
        });
        ToDecryptActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Encrypted_Activity.this,Decrypt_Activity.class);
                intent.putExtra("Message",Message.getText().toString());
                intent.putExtra("key",key);
                intent.putExtra("DecryptMsg",Todecrypt.getText().toString());
                intent.putExtra("Cipher",Cipher);
                startActivity(intent);
            }
        });


    }

    private void Which_Cipher(String cipher){
        switch (cipher){
            case "Ceasar's Cipher":
                ciphertext.setText("Ceasar");
                Cipher = "Ceasar";
                break;
            case "Vegenere's Cipher":
                ciphertext.setText("Vegenere");
                Cipher = "Vegenere";
                break;
        }
    }

    private void Which_Cipher(){
        switch (ciphertext.getText().toString()){
            case "Ceasar":
                Ceasar ceasar = new Ceasar(Message.getText().toString(),key);
                Todecrypt.setText(ceasar.Encryption());
                break;
            case "Vegenere":
                vegenere vegenere = new vegenere(Message.getText().toString(),keyString);
                Todecrypt.setText(vegenere.Encryption());
                break;
        }
    }

}