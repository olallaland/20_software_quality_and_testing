package cn.cstqb.exam.testmaker.services;

import cn.cstqb.exam.testmaker.entities.ExamPaper;
import cn.cstqb.exam.testmaker.entities.ExamPaperStatus;
import cn.cstqb.exam.testmaker.entities.User;

import java.util.List;
public interface IExamPaperService {
    /**
     * Finds project by name
     * @param examPaperName
     * @return
     */
    ExamPaper find(String examPaperName);

    /**
     *
     * @param id
     * @return
     */
    ExamPaper find(int id);

    ExamPaper saveOrUpdate(ExamPaper examPaper);

    /**
     * Creates or updates a project status
     * @param status
     */
    void saveOrUpdate(ExamPaperStatus status);

    /**
     * Find projects with the given facilitator
     * @param user
     * @return
     */
    List<ExamPaper> findByFacilitator(User user);

    List<User> findProjectUsers(ExamPaper examPaper, boolean activeOnly);

    List<User> findProjectUsers(String examPaperName, boolean activeOnly);

    /**
     * Finds all projects the user is associated with. The user can be in the role of a facilitator, reviewer, author or quality admin.
     * @param user
     * @return
     */
    List<ExamPaper> findProjects(User user);

    /**
     * Finds all projects in the database with optional flag to retrieve active project only
     * @param activeProjectsOnly flag to load active projects only
     * @return all projects
     */
    List<ExamPaper> findProjects(boolean activeProjectsOnly);

    /**
     * Finds all projects for this use.
     * @param user
     * @param activeProjectsOnly <b>True</b> to retrieve active projects only
     * @return
     */
    List<ExamPaper> findProjects(User user, boolean activeProjectsOnly);


    /**
     * Find projects with the given status
     * @param status
     * @return
     */
    List<ExamPaper> findByStatus(ExamPaperStatus status);

    ExamPaper findFirst();

    boolean exists(ExamPaper examPaper);
}
