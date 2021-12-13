package by.sri.tpi.task.text.parser.impl;

import by.sri.tpi.task.text.entity.Word;
import by.sri.tpi.task.text.parser.Parser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class WordParser implements Parser<List<Word>,  String> {
   public static final Parser<List<Word>, String> INSTANCE =  new WordParser();

   private WordParser(){

   }

    @Override
    public List<Word> parse(String obj){
        List<Word> wordList = new ArrayList<>();
        String [] words = obj.split(" |,|;|:");
        for(String word : words){
            if(word.isBlank()){
                continue;
            }
            Word wordObj = new Word(word);
            int sentInd = obj.indexOf(word);
            sentInd += word.length();
            if(sentInd<obj.length()) {
                char delimeter = obj.charAt(sentInd);
                if (delimeter != ' ') {
                    wordObj.setDelimeter(String.valueOf(delimeter));
                }
            }
            wordList.add(wordObj);
        }
       return wordList;
    }
}
