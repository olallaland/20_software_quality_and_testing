package cn.cstqb.exam.testmaker.dao.impl;

import cn.cstqb.exam.testmaker.dao.ExampaperQuestionsDao;
import cn.cstqb.exam.testmaker.entities.ExamPaperQuestions;

import java.util.List;

public class ExampaperQuestionsDaoImpl extends GenericJpaDaoImpl<ExamPaperQuestions,Integer> implements ExampaperQuestionsDao {

    @Override
    public List<ExamPaperQuestions> findByExampaper(int exampaper_id) {
        return queryList(buildQuery("exampaper_id",exampaper_id));
    }
}
