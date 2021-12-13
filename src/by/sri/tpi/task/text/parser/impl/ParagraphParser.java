package by.sri.tpi.task.text.parser.impl;

import by.sri.tpi.task.text.entity.Sentence;
import by.sri.tpi.task.text.entity.Paragraph;
import by.sri.tpi.task.text.parser.Parser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ParagraphParser implements Parser<List<Paragraph>, String> {

    public static final ParagraphParser INSTANCE = new ParagraphParser();
    private static final String PARAGRAPH_SPLIT_REGEX = "(\\s{4})";//\s	Символ пробела
    private Parser<List<Sentence>, String> sentenceParser = SentenceParser.INSTANCE;

    private ParagraphParser(){
    }
    @Override
    public List<Paragraph> parse(String string) throws FileNotFoundException {
        String[] paragraphs = string.split(PARAGRAPH_SPLIT_REGEX);
        List<Paragraph> paragraphList = new ArrayList<>();

        for(String paragraph : paragraphs){
            paragraphList.add(new Paragraph(sentenceParser.parse(paragraph)));
        }
        return paragraphList;
    }
}
