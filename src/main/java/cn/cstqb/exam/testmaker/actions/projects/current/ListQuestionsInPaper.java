package cn.cstqb.exam.testmaker.actions.projects.current;

import cn.cstqb.exam.testmaker.configuration.Constants;
import cn.cstqb.exam.testmaker.entities.ExamPaper;
import cn.cstqb.exam.testmaker.entities.Question;
import cn.cstqb.exam.testmaker.services.IPaperService;
import cn.cstqb.exam.testmaker.services.impl.PaperServiceImpl;
import com.google.inject.Inject;
import com.sun.org.apache.bcel.internal.classfile.Constant;

import java.util.List;

public class ListQuestionsInPaper extends BaseCurrentProjectAction {
    @Inject
    protected IPaperService paperService;
    private List<Question> questions;

//    public ListQuestionsInPaper(){
//        super();
//        injector.injectMembers(this);
//    }

    /**
     * This is a replacement for validate() method in ActionSupport in that the posted json
     * data is not serialized yet in ActionSupport validate() method.
     *
     * @return The result string of the first error.
     * @see cn.cstqb.exam.testmaker.configuration.Constants
     */
    @Override
    public void validateInput() {
        super.validateInput();
    }

    /**
     * method to load entity count from service layer
     */
    @Override
    protected void initEntityCount() {
        this.count = 2;//questionService.findAll(sessionProject).size();
    }


    /**
     * subclasses should implement this method to put business logic
     *
     * @return
     */
    @Override
    protected String doExecuteImpl() {
        logger.debug("ListPaperQuestions.doExecuteImpl: Loading questions for Paper: #0", "debug" );

        questions = paperService.getPaperQuestions((ExamPaper) session.get(Constants.ATTR_EXAMPAPER));
        //questions=questionService.findAll(sessionProject, pageSize, pageNumber);
        return null;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
