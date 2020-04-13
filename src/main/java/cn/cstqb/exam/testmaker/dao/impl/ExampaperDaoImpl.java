package cn.cstqb.exam.testmaker.dao.impl;

import cn.cstqb.exam.testmaker.dao.ExampaperDao;
import cn.cstqb.exam.testmaker.entities.Exampaper;

import java.util.List;

public class ExampaperDaoImpl extends GenericJpaDaoImpl<Exampaper,Integer> implements ExampaperDao {

    @Override
    public List<Exampaper> findByFacilitator(int facilitator_id) {
        return queryList(buildQuery("facilitator_id",facilitator_id));
    }
}
