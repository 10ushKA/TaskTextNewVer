package by.sri.tpi.task.text.writer;

import java.io.PrintWriter;

public interface Writer<T> {
    void write(PrintWriter writer, T t);
}
