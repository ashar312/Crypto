package com.example.asharashfaq.crypto.Ciphers;

public class RailFence {

    private String Message;
    private int key;

    public RailFence(String Message, int key){
        this.Message = Message;
        this.key = key;
    }


    public String Encryption(){
        Message.toUpperCase();
        String[] rows = new String[key];
        if(Message.length() % 2 == 1){
            Message += "X";
        }
        int num = 0;
        for(int i = 0; i < Message.length(); i++){
            rows[num] += Message.charAt(i);
            if(num < key){
                num++;
            }else {
                num = 0;
            }
        }

        String str = "";
        for(int i = 0; i < key; i++){
            str += rows[i];
        }

        return str;
    }

    public String Decryption(){
        String str = "";

        return str;
    }

    public String getMessage() {
        return Message;
    }

    public int getKey() {
        return key;
    }
}
