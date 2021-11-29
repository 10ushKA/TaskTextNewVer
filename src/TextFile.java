import java.io.File;
import java.io.FileNotFoundException;

public interface TextFile {
    void readNShowTextFile(File textFile) throws FileNotFoundException;
    void parseText(File textFile);
}
