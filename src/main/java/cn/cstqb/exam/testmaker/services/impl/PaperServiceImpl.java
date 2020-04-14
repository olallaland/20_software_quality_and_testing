package cn.cstqb.exam.testmaker.services.impl;

import cn.cstqb.exam.testmaker.dao.*;
import cn.cstqb.exam.testmaker.entities.*;
import cn.cstqb.exam.testmaker.services.IPaperService;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

public class PaperServiceImpl implements IPaperService {
    @Inject
    protected QuestionDao questionDao;
    @Inject
    protected QuestionStatusDao questionStatusDao;
    @Inject
    protected QuestionTypeDao questionTypeDao;
    @Inject
    protected ExamPaperDao exampaperDao;
    @Inject
    protected ExamPaperQuestionsDao exampaperQuestionsDao;
    @Inject
    protected SyllabusDao syllabusDao;


    public  String makePaper(ExamPaper exampaper,int type1num,int type2num,int type3num){

        if(getPaperQuestions(exampaper).size()>0){
            return "试卷已经生成过了";
        }
        Syllabus syllabus=syllabusDao.findById(exampaper.getSyllabus_id());
        QuestionStatus qt_release=questionStatusDao.findByName("发布");
        List<Question> availableQuestions1=questionDao.findRandomReleasedQuestion(syllabus,questionTypeDao.findById(1),qt_release,type1num);
        List<Question> availableQuestions2=questionDao.findRandomReleasedQuestion(syllabus,questionTypeDao.findById(2),qt_release,type2num);
        List<Question> availableQuestions3=questionDao.findRandomReleasedQuestion(syllabus,questionTypeDao.findById(3),qt_release,type3num);
        if(availableQuestions1.size()<type1num){
            return  "选择题不够";
        }
        if(availableQuestions2.size()<type2num){
            return  "情景题不够";
        }
        if(availableQuestions3.size()<type3num){
            return  "分析题不够";
        }

        addQuestions(exampaper,availableQuestions1.subList(0,type1num));
        addQuestions(exampaper,availableQuestions2.subList(0,type2num));
        addQuestions(exampaper,availableQuestions3.subList(0,type3num));

        return "成功生成考卷";
    }

    private void addQuestions(ExamPaper exampaper,List<Question> questions){
        for(Question question:questions){
            ExamPaperQuestions exampaperQuestions=new ExamPaperQuestions();
            exampaperQuestions.setExampaper_id(exampaper.getId());
            exampaperQuestions.setQuestion_id(question.getId());
            exampaperQuestionsDao.create(exampaperQuestions);
        }
    }

    public List<Question> getPaperQuestions(ExamPaper exampaper){
        List<Question> questions=new ArrayList<>();
        List<ExamPaperQuestions> exampaperQuestions= exampaperQuestionsDao.findByExampaper(exampaper.getId());
        for(ExamPaperQuestions exampaperQuestion:exampaperQuestions){
            Question question=questionDao.findById(exampaperQuestion.getQuestion_id());
            questions.add(question);
        }
        return questions;
    }

    @Override
    public List<ExamPaper> findByFacilitator(int facilitator_id) {
        return exampaperDao.findByFacilitator(facilitator_id);
    }
}
