package cn.cstqb.exam.testmaker.dao.impl;

import cn.cstqb.exam.testmaker.dao.QuestionDao;
import cn.cstqb.exam.testmaker.entities.*;
import com.google.inject.persist.Transactional;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jian-Min Gao
 * Date: 2014/12/31
 * Time: 15:46
 */
public class QuestionDaoImpl extends GenericJpaDaoImpl<Question, Integer> implements QuestionDao {
    /**
     * @param project
     * @param author
     * @return
     */
    @Override
    @Transactional
    public List<Question> findByAuthor(Project project, User author) {
        return findByAuthor(project, author.getUsername());
    }

    /**
     * @param project
     * @param username
     * @return
     */
    @Override
    public List<Question> findByAuthor(Project project, String username) {
        EntityManager em = provider.get();
        return em.createQuery("SELECT q FROM Question q WHERE q.author.username =:author AND q.project =:project AND q.status.accessibleByAuthor = TRUE ", Question.class)
                .setParameter("author", username)
                .setParameter("project", project)
                .getResultList();
    }

    @Override
	public List<Question> findByReviewer(Project project, String username) {
		EntityManager em = provider.get();
		return em.createQuery("SELECT q FROM Question q JOIN q.reviewers r WHERE r.username =:username AND q.project =:project AND q.status.accessibleByReviewer = TRUE ", Question.class)
				.setParameter("username", username)
				.setParameter("project", project)
				.getResultList();
	}

	@Override
	public List<Question> findByQA(Project project, String username) {
        EntityManager em = provider.get();
        return em.createQuery("SELECT q FROM Question q JOIN q.qualityadmins qa WHERE qa.username =:username AND q.project =:project AND q.status.accessibleByQualityAdmin = TRUE",Question.class)
                .setParameter("username", username)
                .setParameter("project", project)
                .getResultList();
//		return em.createQuery("SELECT q from Question q WHERE q.qualityAdmin.username =:username AND q.project =:project AND q.status.accessibleByQualityAdmin = TRUE ", Question.class)
//			.setParameter("username", username)
//			.setParameter("project", project)
//			.getResultList();
	}

    @Override
    public List<Question> findByStatus(Project project, QuestionStatus status) {
        EntityManager em = provider.get();
        return em.createQuery("SELECT q from Question q WHERE q.project =:project AND q.status =:status ", Question.class)
                .setParameter("project", project)
                .setParameter("status", status)
                .getResultList();
    }

    /**
     * Finds all questions in the project
     *
     * @param project
     * @return
     */
    @Override
    public List<Question> findAll(Project project) {
        return findResultList("project", project);
    }

    @Override
    public List<Question> findRandomReleasedQuestion(Syllabus syllabus,QuestionType questionType,QuestionStatus questionStatus,int number){
        //System.out.println(provider);
        EntityManager em = provider.get();
        List<Question> questions= em.createQuery("SELECT q from Question q WHERE q.project.syllabus=:syllabus AND q.type =:type AND q.status = :status ", Question.class)
                .setParameter("syllabus",syllabus)
                .setParameter("type", questionType)
                .setParameter("status", questionStatus)
                .getResultList();
        Collections.shuffle(questions);
        return questions;
    }
}
