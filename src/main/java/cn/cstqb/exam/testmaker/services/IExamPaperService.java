package cn.cstqb.exam.testmaker.services;

import cn.cstqb.exam.testmaker.entities.ExamPaper;
import cn.cstqb.exam.testmaker.entities.Question;

import java.util.List;

public interface IExamPaperService {
    String makePaper(ExamPaper exampaper, int type1num, int type2num, int type3num);
    List<Question> getPaperQuestions(ExamPaper exampaper);
    List<ExamPaper> findByFacilitator(int facilitator_id);
}
