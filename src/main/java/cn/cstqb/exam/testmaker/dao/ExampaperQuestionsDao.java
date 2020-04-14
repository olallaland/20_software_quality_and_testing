package cn.cstqb.exam.testmaker.dao;

import cn.cstqb.exam.testmaker.entities.ExamPaperQuestions;

import java.util.List;

public interface ExampaperQuestionsDao extends GenericDao<ExamPaperQuestions,Integer>{
    List<ExamPaperQuestions> findByExampaper(int exampaper_id);
}
