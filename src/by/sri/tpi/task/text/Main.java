package by.sri.tpi.task.text;

import by.sri.tpi.task.text.entity.Sentence;
import by.sri.tpi.task.text.entity.Text;
import by.sri.tpi.task.text.util.TextUtil;
import by.sri.tpi.task.text.entity.Paragraph;
import by.sri.tpi.task.text.parser.Parser;
import by.sri.tpi.task.text.parser.impl.TextParser;
import by.sri.tpi.task.text.writer.Writer;
import by.sri.tpi.task.text.writer.impl.TextWriter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("text_file.txt");
        Parser<Text, File> textParser = TextParser.INSTANCE;
        Text text = textParser.parse(file);
        File output = new File("output.txt");
        if(!output.exists()) {
            output.createNewFile();
        }
        PrintWriter writer = new PrintWriter(output);

        Writer<Text> textWriter = TextWriter.INSTANCE;
        textWriter.write(writer, text);
        writer.flush();
        writer.close();

        TextUtil util = TextUtil.getInstance();

        List<Paragraph> paragraphList = util.sortBySentenceNum(text);
        System.out.println("Sorted : ");
        for(Paragraph paragraph : paragraphList){
            System.out.println(paragraph);
        }


        Sentence sentence = util.findSentenceWithLongestWord(text);
        System.out.println("Sentence with longest word : "+sentence);

        int count =util.getCountEqualsIgnoreCaseWords(text);
        System.out.println("Count equals ignore case : "+count);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N : ");
        int n = scanner.nextInt();
        scanner.close();

        Text textNew = util.deleteSntncsWthLessWrds(text, n);

        File outputNew = new File("outputNew.txt");
        if(!outputNew.exists()) {
            outputNew.createNewFile();
        }
        PrintWriter writerNew = new PrintWriter(outputNew);

        textWriter.write(writerNew, textNew);
        writerNew.flush();
        writerNew.close();
    }
}
