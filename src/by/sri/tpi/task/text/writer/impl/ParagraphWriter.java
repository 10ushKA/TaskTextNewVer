package by.sri.tpi.task.text.writer.impl;

import by.sri.tpi.task.text.entity.Sentence;
import by.sri.tpi.task.text.entity.Paragraph;
import by.sri.tpi.task.text.writer.Writer;

import java.io.PrintWriter;

public class ParagraphWriter implements Writer<Paragraph> {

    public static final Writer<Paragraph> INSTANCE  = new ParagraphWriter();

    private Writer<Sentence> sentenceWriter = SentenceWriter.INSTANCE;

    private ParagraphWriter(){

    }

    @Override
    public void write(PrintWriter writer, Paragraph paragraph) {
        for(Sentence sentence : paragraph.getSentenceList()){
            sentenceWriter.write(writer, sentence);
            writer.write(sentence.getDelimeter()==null?". ": sentence.getDelimeter()+" ");
        }
    }
}
