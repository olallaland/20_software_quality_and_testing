package cn.cstqb.exam.testmaker.entities;

import javax.persistence.*;

@Entity
@Table(name = "exampaper_questions")
public class ExampaperQuestions extends AbstractEntity{

    private int exampaper_id;

    private int question_id;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Override
    public boolean validate() {
        return true;
    }

    public int getExampaper_id() {
        return exampaper_id;
    }

    public void setExampaper_id(int exampaper_id) {
        this.exampaper_id = exampaper_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
