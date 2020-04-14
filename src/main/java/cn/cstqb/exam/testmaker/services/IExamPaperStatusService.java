package cn.cstqb.exam.testmaker.services;

import java.util.List;

import cn.cstqb.exam.testmaker.entities.ExamPaperStatus;

public interface IExamPaperStatusService {
    /**
     * Create or update a project status
     * @param examPaperStatus
     */
    void saveOrUpdate(ExamPaperStatus examPaperStatus);

    /**
     * Delete the specific project status
     * @param examPaperStatus
     */
    void delete(ExamPaperStatus examPaperStatus);

    /**
     * Find all project status
     * @return all project status objects
     */
    List<ExamPaperStatus> findAll();

    /**
     * get the project status object according to the project status name
     * @return the project status matching the given name
     */
    ExamPaperStatus findByName(String name);

    /**
     *
     * @param id
     * @return
     */
    ExamPaperStatus findById(Integer id);

    ExamPaperStatus findStartState();

    /**
     * Test if it's OK to add a status as start status because there should be only one start status in the system.
     * @return <b>True</b> if there's no start status yet.
     */
    boolean canAddStartStatus();
}
