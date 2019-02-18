package com.example.asharashfaq.crypto.Ciphers;

public class Ceasar {

    private String Message;
    private int key;

    public Ceasar(String message, int key){
        this.Message = message;
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public String getMessage() {
        return Message;
    }

    public String Encryption(){
        String tempstr = "";
        for (int i = 0; i < Message.length(); i++) {
            if(Message.charAt(i) == ' '){
                tempstr += " ";
            }
            else{
                if(Message.charAt(i) >= 'A' && Message.charAt(i) <= 'Z'){
                    tempstr += (char)((Message.charAt(i) + key - 65) % 26 + 65);
                }
                else{
                    tempstr += (char)((Message.charAt(i) + key - 97) % 26 + 97);
                }
            }
        }
        return tempstr;
    }
    public String Decryption(){
        String tempstr = "";
        for (int i = 0; i < Message.length(); i++) {
            if(Message.charAt(i) == ' '){
                tempstr += " ";
            }
            else{
                if(Message.charAt(i) >= 'A' && Message.charAt(i) <= 'Z'){
                    tempstr += (char)(((Message.charAt(i) - key) - 65) % 26 + 65);
                }
                else{
                    tempstr += (char)(((Message.charAt(i) - key) - 97) % 26 + 97);
                }
            }
        }
        return tempstr;
    }
}
