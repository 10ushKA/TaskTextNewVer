package by.sri.tpi.task.text.parser;

import java.io.FileNotFoundException;

public interface Parser<T, K> {
    T parse(K obj) throws FileNotFoundException;
}
