package it.freetime.javainterview.hoffman.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Question {

    private String id;

    @NotEmpty
    private String tag;

    private String question;

    private String answer;

    private Integer level;

    public Question() {
    }

    public Question(String question, Integer level) {
        this.question = question;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public String getQuestion() {return question; }

    public String getAnswer() { return answer; }

    public Integer getLevel() {
        return level;
    }

    public String getTag() { return tag; }

    public void setId(String id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) { this.answer = answer;}

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setTag(String tag) { this.tag = tag; }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", tag='" + tag + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", level=" + level +
                '}';
    }
}
