package by.sri.tpi.task.text.entity;

import java.util.List;

public class Paragraph implements Cloneable {
    private List<Sentence> sentenceList;

    public Paragraph(List<Sentence> sentences){
        this.sentenceList = sentences;
    }

    public List<Sentence> getSentenceList() {
        return sentenceList;
    }

    public void setSentenceList(List<Sentence> sentenceList) {
        this.sentenceList = sentenceList;
    }


    @Override
    public String toString() {
        return "Paragraph{" +
                "sentenceList=" + sentenceList +
                '}';
    }

    @Override
    public Paragraph clone() {
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return (Paragraph) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
