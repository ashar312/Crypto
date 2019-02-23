package com.example.asharashfaq.crypto.Ciphers;

public class polyalphabetic {

    String Message;
    char[][] keyarray;

    public polyalphabetic(String Message){
        this.Message = Message;
        keyarray = new char[4][27];
        setKeyarray();
    }

    private void setKeyarray(){
        keyarray[0][0] = ' ';
        for(int i = 1; i <= 26; i++){
            keyarray[0][i] = (char)(i+64);
        }
        keyarray[1][1] = 'A';
        keyarray[1][2] = 'S';
        keyarray[1][3] = 'D';
        keyarray[1][4] = 'F';
        keyarray[1][5] = 'G';
        keyarray[1][6] = 'H';
        keyarray[1][7] = 'J';
        keyarray[1][8] = 'K';
        keyarray[1][9] = 'L';
        keyarray[1][10] = 'P';
        keyarray[1][11] = 'O';
        keyarray[1][12] = 'I';
        keyarray[1][13] = 'U';
        keyarray[1][14] = 'Y';
        keyarray[1][15] = 'T';
        keyarray[1][16] = 'R';
        keyarray[1][17] = 'E';
        keyarray[1][18] = 'W';
        keyarray[1][19] = 'Q';
        keyarray[1][20] = 'Z';
        keyarray[1][21] = 'X';
        keyarray[1][22] = 'C';
        keyarray[1][23] = 'V';
        keyarray[1][24] = 'B';
        keyarray[1][25] = 'N';
        keyarray[1][26] = 'M';

        keyarray[2][1] = 'Q';
        keyarray[2][2] = 'A';
        keyarray[2][3] = 'Z';
        keyarray[2][4] = 'W';
        keyarray[2][5] = 'S';
        keyarray[2][6] = 'X';
        keyarray[2][7] = 'E';
        keyarray[2][8] = 'D';
        keyarray[2][9] = 'C';
        keyarray[2][10] = 'R';
        keyarray[2][11] = 'F';
        keyarray[2][12] = 'V';
        keyarray[2][13] = 'T';
        keyarray[2][14] = 'G';
        keyarray[2][15] = 'B';
        keyarray[2][16] = 'Y';
        keyarray[2][17] = 'H';
        keyarray[2][18] = 'N';
        keyarray[2][19] = 'U';
        keyarray[2][20] = 'P';
        keyarray[2][21] = 'J';
        keyarray[2][22] = 'M';
        keyarray[2][23] = 'I';
        keyarray[2][24] = 'K';
        keyarray[2][25] = 'O';
        keyarray[2][26] = 'L';

        keyarray[3][1] = 'Z';
        keyarray[3][2] = 'X';
        keyarray[3][3] = 'C';
        keyarray[3][4] = 'V';
        keyarray[3][5] = 'B';
        keyarray[3][6] = 'N';
        keyarray[3][7] = 'M';
        keyarray[3][8] = 'K';
        keyarray[3][9] = 'I';
        keyarray[3][10] = 'O';
        keyarray[3][11] = 'P';
        keyarray[3][12] = 'L';
        keyarray[3][13] = 'U';
        keyarray[3][14] = 'J';
        keyarray[3][15] = 'H';
        keyarray[3][16] = 'Y';
        keyarray[3][17] = 'T';
        keyarray[3][18] = 'G';
        keyarray[3][19] = 'F';
        keyarray[3][20] = 'R';
        keyarray[3][21] = 'E';
        keyarray[3][22] = 'D';
        keyarray[3][23] = 'S';
        keyarray[3][24] = 'W';
        keyarray[3][25] = 'Q';
        keyarray[3][26] = 'A';
    }

    public String Decryption(){
        String tempstr = "";
        int num = 1;
        for(int i = 0; i < Message.length(); i++){
            if(num == 4){
                num = 1;
            }
            tempstr += search_decrypt(Message.charAt(i),num);
            num++;
        }
        return tempstr;
    }
    private char search_decrypt(char c, int num){
        int TempNum = 0;
        for(int i = 1; i < 27; i++){
            if(c == keyarray[num][i]){
                TempNum = i;
                break;
            }
        }
        return keyarray[0][TempNum];

    }

    public String Encryption(){
        int num = 1;
        String tempStr = "";
        for(int  i = 0; i < Message.length(); i++){
            if(num == 4){
                num =  1;
            }
            tempStr += search(Message.charAt(i),num)+"";
            num++;
        }
        return tempStr;
    }

    private char search(char c,int num){
        int tempNum = 0;
        for(int i = 1; i < 27; i++){
            if(c == keyarray[0][i]){
                tempNum = i;
                break;
            }
        }
        return keyarray[num][tempNum];
    }

}
