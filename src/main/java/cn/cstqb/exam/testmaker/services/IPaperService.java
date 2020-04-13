package cn.cstqb.exam.testmaker.services;

import cn.cstqb.exam.testmaker.entities.Exampaper;
import cn.cstqb.exam.testmaker.entities.Question;

import java.util.List;

public interface IPaperService {
    String makePaper(Exampaper exampaper,int type1num,int type2num,int type3num);
    List<Question> getPaperQuestions(Exampaper exampaper);
    List<Exampaper> findByFacilitator(int facilitator_id);
}
