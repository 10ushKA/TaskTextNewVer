package by.sri.tpi.task.text.writer.impl;

import by.sri.tpi.task.text.entity.Sentence;
import by.sri.tpi.task.text.entity.Word;
import by.sri.tpi.task.text.writer.Writer;

import java.io.PrintWriter;
import java.util.List;

public class SentenceWriter implements Writer<Sentence> {

    public static final Writer<Sentence> INSTANCE  = new SentenceWriter();
    private Writer<Word> wordWriter = WordWriter.INSTANCE;

    private SentenceWriter(){

    }

    @Override
    public void write(PrintWriter writer, Sentence sentence) {
        List<Word> words = sentence.getWords();
        for(int i = 0; i < words.size(); i++){
            Word word = words.get(i);
            wordWriter.write(writer, word);
            if(i+1 < words.size()) {
                writer.write(word.getDelimeter()!=null ? word.getDelimeter()+" ": " ");
            }
        }
    }
}
