package by.sri.tpi.task.text.util;

import by.sri.tpi.task.text.entity.Text;
import by.sri.tpi.task.text.entity.Word;
import by.sri.tpi.task.text.entity.Paragraph;
import by.sri.tpi.task.text.entity.Sentence;

import java.util.*;

public class TextUtil {

    private static TextUtil textUtil;

    private TextUtil(){

    }

    public static TextUtil getInstance(){
        synchronized (TextUtil.class) {
            if (textUtil == null) {
                textUtil = new TextUtil();
            }
        }
        return textUtil;
    }

    public List<Paragraph> sortBySentenceNum(Text text){
        List<Paragraph> paragraphs = new ArrayList<>();
        Collections.copy(text.getParagraphList(), paragraphs);
        paragraphs.sort(Comparator.comparingInt(o -> o.getSentenceList().size()));
        return paragraphs;
    }

    public Sentence findSentenceWithLongestWord(Text text){
        Sentence sentenceWithMax = null;
        int maxLen = 0;
        for(Paragraph paragraph : text.getParagraphList()){
            for(Sentence sentence:paragraph.getSentenceList()){
                for(Word word: sentence.getWords()){
                    if(word.getWord().length()>maxLen){
                        sentenceWithMax = sentence;
                        maxLen = word.getWord().length();
                    }
                }
            }
        }
        return sentenceWithMax;
    }

    public Text deleteSntncsWthLessWrds(Text text, int n){
        Text textNew = text.clone();
        for (Paragraph paragraph : textNew.getParagraphList()){
            paragraph.getSentenceList().removeIf(sentence -> sentence.getWords().size() < n);
        }
        return textNew;
    }

    public int getCountEqualsIgnoreCaseWords(Text text){
        int count = 0;
        Set<String> usedStrings = new HashSet<>();
        List<String> allStrings = new ArrayList<>();
        for (Paragraph paragraph : text.getParagraphList()){
            for (Sentence sentence: paragraph.getSentenceList()){
                for (Word word : sentence.getWords()){
                    allStrings.add(word.getWord());
                }
            }
        }
        for(String word : allStrings){
            if(usedStrings.contains(word)){
                continue;
            }
            int wordCount = 1;
            for (String wordToCompare : allStrings){
                if(word.equalsIgnoreCase(wordToCompare)){
                    wordCount++;
                }

            }
            if(wordCount>1){
                count++;
                usedStrings.add(word);
            }
        }
        return count;
    }

}
