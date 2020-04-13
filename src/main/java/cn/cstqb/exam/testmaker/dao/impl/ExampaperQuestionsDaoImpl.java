package cn.cstqb.exam.testmaker.dao.impl;

import cn.cstqb.exam.testmaker.dao.ExampaperQuestionsDao;
import cn.cstqb.exam.testmaker.entities.ExampaperQuestions;

import java.util.List;

public class ExampaperQuestionsDaoImpl extends GenericJpaDaoImpl<ExampaperQuestions,Integer> implements ExampaperQuestionsDao {

    @Override
    public List<ExampaperQuestions> findByExampaper(int exampaper_id) {
        return queryList(buildQuery("exampaper_id",exampaper_id));
    }
}
