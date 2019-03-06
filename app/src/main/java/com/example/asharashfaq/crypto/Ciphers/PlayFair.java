package com.example.asharashfaq.crypto.Ciphers;

public class PlayFair {
    private final String Message;
    private final String Keystr;
    private final char[][] Keyarray;
    private final int range;
    private char[] pair;
    int tempi, tempj,tempi2,tempj2;

    public PlayFair(String Message, String Keystr){
        this.Message = Message;
        this.Keystr = Keystr;
        range = 5;
        Keyarray = new char[range][range];
        setKeyarray(Keystr);
        //   print();
    }

    private String Pairs(String Message){
        Message = Message.toUpperCase();
        String Str = "";
        for (int i = 0; i < Message.length(); i++) {
            if(Message.charAt(i) != ' '){
                Str += Message.charAt(i);
            }
        }
        return Str;
    }



    public String Encryption(){
        String Str = Arrangment(Pairs(Message));
        System.out.println("Str "+Str);
        String Encrypted = "";
        Str = Str.replace('J', 'I');


        for (int k = 0; k < Str.length(); k += 2) {
            if(search_in_array(Str,k)){
                if(tempj == tempj2){
                    if(tempi == range - 1){
                        tempi = - 1;
                    }
                    if(tempi2 == range - 1){
                        tempi2 = - 1;
                    }
                    Encrypted += ""+Keyarray[tempi+1][tempj] + ""+Keyarray[tempi2+1][tempj];
                }
                else{
                    Encrypted += ""+Keyarray[tempi][tempj2] + ""+Keyarray[tempi2][tempj];
                }

            }
        }
        return Encrypted;
    }


    private boolean search_in_array(String str,int k){
        for (int l = 0; l < 2; l++) {
            if(l == 1){
                k++;
            }
            for (int i = 0; i < range; i++) {
                for (int j = 0; j < range; j++) {
                    if(str.charAt(k) == Keyarray[i][j]){
                        if(k % 2 == 0){
                            tempi = i;
                            tempj = j;
                            i = range - 1;
                            break;
                        }else{
                            tempi2 = i;
                            tempj2 = j;
                            return true;
                        }

                    }
                }
            }
        }
        return false;
    }


    private String Arrangment(String Str){

        String TempStr = "";
        for (int i = 0; i < Str.length(); i+=2) {
            if(i < Str.length() - 1){
                //i + 1.
                if(Str.charAt(i) == Str.charAt(i + 1)){
                    TempStr += Str.charAt(i);
                    TempStr += "X";
                    TempStr += Str.charAt(i + 1);
                }
                else{
                    TempStr += Str.charAt(i);
                    TempStr += Str.charAt(i + 1);
                }
            }
        }
        if(TempStr.length() % 2 != 0){
            TempStr += "X";
        }
        return TempStr;
    }

    public String getMessage() {
        return Message;
    }

    public String getKeystr() {
        return Keystr;
    }

    private void print(){
        for (int i = 0; i < range; i++) {
            for (int j = 0; j < range; j++) {
                System.out.print(Keyarray[i][j]+" ");
            }
            System.out.println();
        }
    }

    private void setKeyarray(String key){
        int index = 0;
        boolean flag = false;
        int alphabet = 65;
        for(int i = 0; i < range; i++){
            for(int j = 0; j < range; j++){
                if(index < key.length()) {
                    if (key.charAt(index) != 'J') {
                        if (search(i, j, key.charAt(index))) {
                            Keyarray[i][j] = key.charAt(index);

                        }
                        else{
                            if(j == range - 1){
                                i--;
                                j = 4;
                            } else{
                                j--;
                            }
                        }
                    }
                    index++;
                }
                else{if(flag){
                    j = 4;
                    flag = false;
                }
                    if(alphabet <= 90){
                        if(search(i,j,(char)alphabet) && alphabet != 'J'){
                            Keyarray[i][j] = (char)alphabet;
                        }
                        else{
                            if(j == range - 1){
                                i--;
                                flag = true;
                            } else{
                                j--;
                            }
                        }
                    }
                    alphabet++;
                }
            }
        }
    }

    private boolean search(int i, int j, char c){
        for(int x = 0; x < range; x++){
            for(int y = 0; y < range; y++){
                if(x == i && y == j){
                    return true;
                }
                else if(c == Keyarray[x][y]){
                    return false;
                }
            }
        }
        return true;
    }
}