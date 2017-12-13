package assignment8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class LyricAnalyzer { // score 4
    private HashMap<String,ArrayList<Integer>> map;

    public LyricAnalyzer(){
        map = new HashMap<String, ArrayList<Integer>>();
    }

    public void read(File file) throws IOException{
        FileInputStream fis = new FileInputStream(file);
        int count = 1;
        StringBuilder lyric = new StringBuilder();
        while(true){
            int temp = fis.read();
            if(temp == -1){
                add(lyric.toString(), -count);
                break;
            }
            if(temp == 32){
                add(lyric.toString(),count);
                count++;
                lyric.delete(0,lyric.length());
            }else if(temp == 10 || temp == 13){
                fis.read();
                add(lyric.toString(), -count);
                count++;
                lyric.delete(0,lyric.length());
            }else{
                lyric.append((char)temp);
            }
        }
        fis.close();
    }

    private void add(String lyricWord, int wordPosition){
        if(map.containsKey(lyricWord)){
            map.get(lyricWord).add(wordPosition);
        }else{
            map.put(lyricWord, new ArrayList<Integer>());
            map.get(lyricWord).add(wordPosition);
        }
    }

    public void displayWords(){
        List<String> words = new ArrayList<String>(map.keySet());
        Collections.sort(words);
        for(String word : words){
            System.out.print(word);
            int space = 14 - word.length();
            for(int i = 0; i < space; i++){
                System.out.print(" ");
            }
            System.out.println(map.get(word).toString());
        }
    }

    public void writeLyrics(File file) throws IOException{
        int total = 0;
        List<String> words = new ArrayList<String>(map.keySet());
        for(String word : words){
            total = total + map.get(word).size();
        }
        String[] lyric = new String[total + 1];
        Set<String> wordSet = map.keySet();
        for(String word : wordSet){
            ArrayList<Integer> currentWordPosition = map.get(word);
            for(int i = 0; i < currentWordPosition.size(); i++){
                if(currentWordPosition.get(i) > 0){
                    lyric[currentWordPosition.get(i)] = word + " ";
                }else{
                    lyric[-currentWordPosition.get(i)] = word + "\n";
                }
            }
        }
        FileOutputStream fos = new FileOutputStream(file,true);
        for(int i = 1; i < lyric.length; i++){
            byte[] b = lyric[i].getBytes();
            fos.write(b);
        }
        fos.close();
    }

    public int count(){
        int total = 0;
        List<String> words = new ArrayList<String>(map.keySet());
        for(String word : words){
            total = total + map.get(word).size();
        }
        System.out.println("Total words count:" + total);
        for(int i = 0; i < words.size(); i++){
            words.set(i,words.get(i).toUpperCase());
        }
        LinkedHashSet<String> set = new LinkedHashSet<String>(words);
        words = new ArrayList<String>(set);
        return words.size();
    }

    public String mostFrequentWord(){
        Set<String> words = map.keySet();
        int max = 0;
        String index = new String();
        for(String word : words){
            if(map.get(word).size() > max){
                max = map.get(word).size();
                index = word;
            }
        }
        return index;
    }

    public static void main(String[] args)throws IOException{
        LyricAnalyzer la = new LyricAnalyzer();
        String path = "C:\\Question2_test2.txt";
        File testFile = new File(path);
        la.read(testFile);
        la.displayWords();
        System.out.println("Unique words count" + la.count());
        System.out.println("Most frequently word: " + la.mostFrequentWord());
        path = "C:\\Question2_output.txt";
        testFile = new File(path);
        testFile.createNewFile();
        la.writeLyrics(testFile);
    }
}
