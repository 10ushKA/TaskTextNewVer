package by.sri.tpi.task.text.parser.impl;

import by.sri.tpi.task.text.entity.Text;
import by.sri.tpi.task.text.entity.Paragraph;
import by.sri.tpi.task.text.parser.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class TextParser implements Parser<Text, File> {

    public static final TextParser INSTANCE = new TextParser();

    public static final String FORBIDDEN_TEXT_CHARACTERS_REGEX = "[{\\^|&~\\d<>()']";
    private Parser<List<Paragraph>, String> paragraphParser = ParagraphParser.INSTANCE;
    private TextParser(){

    }

    @Override
    public Text parse(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        StringBuilder buffer = new StringBuilder();
        while (scanner.hasNextLine()){
            buffer.append(scanner.nextLine());
        }
        scanner.close();
        String string = buffer.toString().replaceAll(FORBIDDEN_TEXT_CHARACTERS_REGEX, "");
        List<Paragraph> paragraphs = paragraphParser.parse(string);
        return new Text(paragraphs);
    }
}
