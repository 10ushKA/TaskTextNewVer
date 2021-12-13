package by.sri.tpi.task.text.entity;

public class Word implements Cloneable {
    private String word;

    private String delimeter;

    public String getDelimeter() {
        return delimeter;
    }

    public void setDelimeter(String delimeter) {
        this.delimeter = delimeter;
    }

    public Word(String word){
        this.word = word;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                '}';
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public Word clone() {
        try {
            Word clone = (Word) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}




