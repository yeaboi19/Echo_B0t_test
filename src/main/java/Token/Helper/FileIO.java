package Token.Helper;


import Token.MainThings.FilePath;

import java.io.*;
import java.util.HashMap;

public class FileIO {

    FilePath filePath = new FilePath();

    public boolean isInList(String word){
        FileIO fileIO = new FileIO();
        HashMap<String ,Integer> wordList = fileIO.getWordList();
        for ( String key : wordList.keySet() ) {
            if(key.equalsIgnoreCase(word)){
                return true;
            }
        }
        return false;
    }

    public HashMap<String, Integer> getWordList() {
        HashMap<String, Integer> WordList = new HashMap<>();
        if(new File(filePath.wordListPath).exists()){
            try {
                FileInputStream fileInputStream = new FileInputStream(filePath.wordListPath);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                WordList = (HashMap<String ,Integer>) objectInputStream.readObject();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
        }
        return WordList;
    }

    public void addWords(String word) {
        FileIO fileIO = new FileIO();
        HashMap<String ,Integer> wordList = fileIO.getWordList();
        if(isInList(word)){
            word=word.toLowerCase();
            int a =wordList.get(word);
            a++;
            wordList.replace(word,a);
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath.wordListPath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(wordList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int setWords(String word) {
        FileIO fileIO = new FileIO();
        HashMap<String ,Integer> wordList = new HashMap<>();
        if(new File(filePath.wordListPath).exists()){
            wordList = fileIO.getWordList();
        }
        if(!isInList(word)){
            word=word.toLowerCase();
            wordList.put(word,0);
        }else{
            return 0;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath.wordListPath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(wordList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public int removeFullWord(String word) {
        FileIO fileIO = new FileIO();
        HashMap<String ,Integer> wordList = fileIO.getWordList();
        boolean isInList = false;
        word=word.toLowerCase();
        for ( String key : wordList.keySet() ) {
            if(key.equalsIgnoreCase(word)){
                wordList.remove(key);
                isInList=true;
            }
        }
        if (!isInList) {
            return 0;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath.wordListPath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(wordList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1;
    }
//---------------------------------------------------------------------------------------------------------------


}

