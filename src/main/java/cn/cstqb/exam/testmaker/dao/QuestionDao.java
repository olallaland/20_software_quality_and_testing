package cn.cstqb.exam.testmaker.dao;

import cn.cstqb.exam.testmaker.entities.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jian-Min Gao
 * Date: 2014/12/31
 * Time: 15:46
 */
public interface QuestionDao extends GenericDao<Question,Integer> {

    /**
     *
     * @param project
     * @param author
     * @return
     */
    List<Question> findByAuthor(Project project, User author);

    /**
     *
     * @param project
     * @param username
     * @return
     */
    List<Question> findByAuthor(Project project, String username);

    /**
     *
     * @param project
     * @param username
     * @return
     */
    List<Question> findByReviewer(Project project, String username);

    /**
     *
     * @param project
     * @param username
     * @return
     */
    List<Question> findByQA(Project project, String username);

    /**
     * Finds all questions in the project
     * @param project
     * @return
     */
    List<Question> findAll(Project project);

    List<Question> findByStatus(Project project, QuestionStatus status);

    List<Question> findRandomReleasedQuestion(Syllabus syllabus,QuestionType questionType, QuestionStatus questionStatus, int number);
}
