package by.sri.tpi.task.text.entity;

import java.util.List;

public class Sentence implements Cloneable {
    public List<Word> getWords() {
        return words;
    }

    private String delimeter;

    public String getDelimeter() {
        return delimeter;
    }

    public void setDelimeter(String delimeter) {
        this.delimeter = delimeter;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    // определить что является границами предложения и ввести переменную типо sentence*
    private List<Word> words ;

    public Sentence(List<Word> words){
        this.words = words;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "words=" + words +
                '}';
    }

    @Override
    public Sentence clone() {
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return (Sentence) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
