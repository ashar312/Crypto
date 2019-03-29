package com.example.asharashfaq.crypto.Ciphers;

public class Columnar {

    private String key;
    private String Message;
    private int[] num;

    public Columnar(String Message, String key){
        this.Message = Message;
        this.key = key;
        num = new int[key.length()];
    }

    public String Encryption(){
        String str = "";

        return str;
    }

    private void key_Nums(){
        int temp = 91;
        int j = 1;
        for(int i = 0; i < key.length(); i++){
            if(isContain(key.charAt(i)) < temp){
                num[i] = j;
                temp = isContain(key.charAt(i));
            }
            else{
                j++;
                num[i] = j;
            }
        }
    }

    private int isContain(char c){
        return c;
    }



    public String getMessage() {
        return Message;
    }

    public String getKey() {
        return key;
    }
}
