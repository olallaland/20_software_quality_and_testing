package cn.cstqb.exam.testmaker.dao.impl;

import cn.cstqb.exam.testmaker.dao.ExamPaperQuestionsDao;
import cn.cstqb.exam.testmaker.entities.ExamPaperQuestions;

import java.util.List;

public class ExamPaperQuestionsDaoImpl extends GenericJpaDaoImpl<ExamPaperQuestions,Integer> implements ExamPaperQuestionsDao {

    @Override
    public List<ExamPaperQuestions> findByExampaper(int exampaper_id) {
        return queryList(buildQuery("exampaper_id",exampaper_id));
    }
}
