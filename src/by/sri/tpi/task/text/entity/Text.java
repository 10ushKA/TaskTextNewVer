package by.sri.tpi.task.text.entity;

import java.util.List;

public class Text implements Cloneable {
    private List<Paragraph> paragraphList;

    public Text(List<Paragraph> paragraphs){
        this.paragraphList = paragraphs;
    }

    public List<Paragraph> getParagraphList() {
        return paragraphList;
    }

    public void setParagraphList(List<Paragraph> paragraphList) {
        this.paragraphList = paragraphList;
    }

    @Override
    public String toString() {
        return "Text{" +
                "paragraphList=" + paragraphList +
                '}';
    }

    @Override
    public Text clone() {
        try {
            Text clone = (Text) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
