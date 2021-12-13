package by.sri.tpi.task.text.writer.impl;

import by.sri.tpi.task.text.entity.Text;
import by.sri.tpi.task.text.entity.Paragraph;
import by.sri.tpi.task.text.writer.Writer;

import java.io.PrintWriter;

public class TextWriter implements Writer<Text> {

    public static final Writer<Text> INSTANCE  = new TextWriter();

    private Writer<Paragraph> paragraphWriter = ParagraphWriter.INSTANCE;

    private TextWriter(){
    }

    @Override
    public void write(PrintWriter writer, Text text) {
        for(Paragraph paragraph : text.getParagraphList()){
            paragraphWriter.write(writer, paragraph);
            writer.write("\n");
        }
    }
}
