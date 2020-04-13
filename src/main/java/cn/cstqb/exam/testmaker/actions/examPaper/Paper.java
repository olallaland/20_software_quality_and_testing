package cn.cstqb.exam.testmaker.actions.examPaper;

public class Paper {

    public int id;
    public int status;
    public String syllabus;
    public String facilitator;
    public String name;

    public Paper(){

    }
    public Paper(int id, int status, String name, String syllabus, String facilitator){
        this.id = id;
        this.status = status;
        this.name = name;
        this.syllabus = syllabus;
        this.facilitator = facilitator;
    }
}
