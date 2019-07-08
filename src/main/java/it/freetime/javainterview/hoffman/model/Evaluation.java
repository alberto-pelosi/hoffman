package it.freetime.javainterview.hoffman.model;

import java.math.BigDecimal;
import java.util.Date;

public class Evaluation {

    private String id;

    public Evaluation() {
    }

    private Student student;

    private String exercixe;

    private BigDecimal evaluation;

    private Date evaluationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getExercixe() {
        return exercixe;
    }

    public void setExercixe(String exercixe) {
        this.exercixe = exercixe;
    }

    public BigDecimal getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(BigDecimal evaluation) {
        this.evaluation = evaluation;
    }

    public Date getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

}
