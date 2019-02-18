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

    public String Encryption(){
        String temp = "";
        CharToNumbers();
        int j = 0;
        for (int i = 0; i < Message.length(); i++) {
            if(Message.charAt(i) != ' '){
                if(j == Key.length()){
                    j = 0;
                }
                int a = search(Message.charAt(i));
                int b = search(Key.charAt(j));
                int temNum = search(Message.charAt(i)) + search(Key.charAt(j));
                temp += search(NumToChar(temNum));
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
}
