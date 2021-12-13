package by.sri.tpi.task.text.parser.impl;

import by.sri.tpi.task.text.entity.Sentence;
import by.sri.tpi.task.text.entity.Word;
import by.sri.tpi.task.text.parser.Parser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class SentenceParser implements Parser<List<Sentence>, String> {


    public static final Parser<List<Sentence>, String> INSTANCE = new SentenceParser();
    private static final String SENTENCE_SPLIT_REGEX = "[.?!]";
    private Parser<List<Word>, String> wordParser = WordParser.INSTANCE;

    private SentenceParser(){

    }

    @Override
    public List<Sentence> parse(String obj) throws FileNotFoundException {
       String [] sentences = obj.split(SENTENCE_SPLIT_REGEX);
       List<Sentence> sentenceList = new ArrayList<>();
       for(String sentence : sentences){
           Sentence sentenceObj = new Sentence(wordParser.parse(sentence));
           int sentInd = obj.indexOf(sentence);
           sentInd += sentence.length();
           if(sentInd<obj.length()) {
               char delimeter = obj.charAt(sentInd);
               if (delimeter != ' ') {
                   sentenceObj.setDelimeter(String.valueOf(delimeter));
               }
           }
           sentenceList.add(sentenceObj);
       }
        return sentenceList;
    }
}
