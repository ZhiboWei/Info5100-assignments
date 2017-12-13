package assignment8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileCounter { // score 3
    private int characterCount = 0;
    private int wordCount = 0;
    private int lineCount = 0;

    public FileCounter(){}
    public int getCharacterCount(){
        return characterCount;
    }

    public int getWordCount(){
        return wordCount;
    }

    public int getLineCount(){
        return lineCount;
    }

    public void read(Scanner in) throws IOException{
        StringBuilder sb = new StringBuilder();
        while(in.hasNextLine()){
            sb.append(in.nextLine());
            sb.append(" ");
            lineCount++;
        }

        String s = sb.toString().trim();
        if(s.length() == 0){
            return;
        }else{
            wordCount++;
        }

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                characterCount++;
            }else{
                if(s.charAt(i + 1) != ' '){
                    wordCount++;
                }
            }

        }

    }
}
