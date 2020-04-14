package cn.cstqb.exam.testmaker.dao;

import cn.cstqb.exam.testmaker.entities.ExamPaper;

import java.util.List;

public interface ExamPaperDao {
    public List<ExamPaper> findByFacilitator(int facilitator_id);
}
