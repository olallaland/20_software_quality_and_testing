package cn.cstqb.exam.testmaker.dao;

import cn.cstqb.exam.testmaker.entities.Exampaper;

import java.util.List;

public interface ExampaperDao extends GenericDao<Exampaper,Integer>{
    List<Exampaper> findByFacilitator(int facilitator_id);
}
