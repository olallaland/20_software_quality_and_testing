package cn.cstqb.exam.testmaker.dao;

import cn.cstqb.exam.testmaker.entities.Exampaper;
import cn.cstqb.exam.testmaker.entities.ExampaperQuestions;

import java.util.List;

public interface ExampaperQuestionsDao extends GenericDao<ExampaperQuestions,Integer>{
    List<ExampaperQuestions> findByExampaper(int exampaper_id);
}
