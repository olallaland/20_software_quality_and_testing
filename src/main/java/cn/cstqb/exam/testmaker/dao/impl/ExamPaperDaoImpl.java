package cn.cstqb.exam.testmaker.dao.impl;

import cn.cstqb.exam.testmaker.dao.ExamPaperDao;
import cn.cstqb.exam.testmaker.entities.ExamPaper;

import java.util.List;

public class ExamPaperDaoImpl extends GenericJpaDaoImpl<ExamPaper,Integer> implements ExamPaperDao {

    @Override
    public List<ExamPaper> findByFacilitator(int facilitator_id) {
        return queryList(buildQuery("facilitator_id",facilitator_id));
    }
}
