package by.sri.tpi.task.text.writer.impl;

import by.sri.tpi.task.text.entity.Word;
import by.sri.tpi.task.text.writer.Writer;

import java.io.PrintWriter;

public class WordWriter implements Writer<Word> {

    public static final Writer<Word> INSTANCE = new WordWriter();

    private WordWriter(){

    }

    @Override
    public void write(PrintWriter writer, Word word) {
        writer.write(word.getWord());
    }
}
