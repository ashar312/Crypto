package com.example.asharashfaq.crypto.Ciphers;


public class vegenere {
    private String Message;
    private String Key;

    public vegenere(String Message,String Key){
        this.Message = Message;
        this.Key = Key;
    }

    public String getMessage() {
        return Message;
    }

    public String getKey() {
        return Key;
    }

    boolean lowercase = true;

    public String Encryption(){
        String temp = "";
        CharToNumbers();
        int j = 0;
        char c;
        for (int i = 0; i < Message.length(); i++) {
            if(Message.charAt(i) != ' '){
                if(j == Key.length()){
                    j = 0;
                }
                if(Message.charAt(i) >= 'A' && Message.charAt(i) <= 'Z'){
                    lowercase = false;
                }
                int temNum = search(Message.charAt(i)) + search(Key.charAt(j));
                if(lowercase){
                    c = Character.toLowerCase(search(NumToChar(temNum)));
                }
                else{
                    c = search(NumToChar(temNum));
                }
                temp += c;
                lowercase = true;
                j++;



            }
            else{
                temp += ' ';
            }
        }

        return temp;
    }
    private int NumToChar(int num){
        if(num >= 26){
            return num - 26;
        }
        return num;
    }

    CharToNum[] charToNums;
    private void CharToNumbers(){
        charToNums = new CharToNum[26];
        for(int i = 0; i < charToNums.length; i++){
            charToNums[i] = new CharToNum((char)(i+65),(char)(i+97),i);
        }
    }
    private int search(char Char){
        for(int i = 0; i < charToNums.length; i++){
            if(Char == charToNums[i].Char || Char == charToNums[i].Char2){
                return i;
            }
        }
        return -1;
    }
    private char search(int num){
        for (CharToNum charToNum : charToNums) {
            if (num == charToNum.number) {
                return charToNum.Char;
            }
        }
        return '/';

    }
    public String decryption() {
        String res = "";
        Message = Message.toUpperCase();
        for (int i = 0, j = 0; i < Message.length(); i++) {
            char c = Message.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            res += (char)((c - Key.charAt(j) + 26) % 26 + 'A');
            j = ++j % Key.length();
        }
        return res;
    }


}
