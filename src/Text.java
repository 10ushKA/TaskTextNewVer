import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Text implements TextFile {
    private String content = new String();
    public static final String FORBIDDEN_TEXT_CHARACTERS_REGEX = "[{\\^|&~\\d<>()']";
    File textFile = new File("text_file.txt");


    @Override
    public void readNShowTextFile(File textFile) throws FileNotFoundException {
        this.textFile = textFile;
        Scanner scanner = new Scanner(textFile);
        LinkedList<String> list = new LinkedList<>();

        while(scanner.hasNextLine()){
            content = scanner.nextLine();
            list.add(content);
            System.out.println(content);
        }
    }

    @Override
    public void parseText(File textFile) {
        content = content.replace(FORBIDDEN_TEXT_CHARACTERS_REGEX,"");
        System.out.println("Text without extra symbols: ");
        System.out.println(content);
    }
}
