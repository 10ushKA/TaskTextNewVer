import java.io.File;
import java.util.LinkedList;
import java.util.function.UnaryOperator;

public class Paragraph extends Text{

    private static final String PARAGRAPH_SPLIT_REGEX = "(\\s{4})";//\s	Символ пробела
   
    public void makeParagraph(File textFile){
        LinkedList<String> paragraphs;
        paragraphs = textFile.split(PARAGRAPH_SPLIT_REGEX);
        paragraphs.replaceAll((UnaryOperator<String>) textFile);
        //Изменить, что-то тут явно не то..Надо переписать файл(Linkedlist, созданный в Text), с уже сформированными абзацами
    }

    public void sortPrgrphByAmntOfSntncs(){// a тут принять файл/Linkedlist с уже сформироваными абзацами, или путем вызова метода makeParagraph, или..
        String[] textWithParagraphs =

    }
}
