package cn.cstqb.exam.testmaker.actions.question;

import cn.cstqb.exam.testmaker.configuration.Constants;
import cn.cstqb.exam.testmaker.entities.Question;
import cn.cstqb.exam.testmaker.entities.QuestionStatus;
import com.google.common.collect.Lists;

/**
 * Created with IntelliJ IDEA.
 * User: Jian-Min Gao
 * Date: 2015/3/27
 * Time: 22:53
 */
public class ChangeQuestionStatusAction extends BaseQuestionAction {

    private int questionId;
    private int statusId;
    private String username;


    private Question question;
    private QuestionStatus nextStatus;

    @Override
    public void validateInput() {
        if (questionId<1 || statusId<1) {
            addActionError(getText("error.entity.id.invalid", Lists.newArrayList(questionId)));
        }

        question = questionService.findQuestion(questionId);
        if (question == null) {
            addActionError(getText("error.entity.id.notFound", Lists.newArrayList(questionId, getText("label.entity.question"))));
            return;
        }

        nextStatus = statusService.findStatus(statusId);
        if (nextStatus == null) {
            addActionError(getText("error.entity.id.notFound", Lists.newArrayList(questionId, getText("label.entity.question.status"))));
        }
    }

    /**
     * The real action should be defined in this method. Do not use execute. otherwise you get nothing
     *
     * @return <b>null</b> or empty string if action is successful; otherwise return your error result
     * @throws Exception
     */
    @Override
    protected String executeImpl() throws Exception {
        logger.debug("ChangeQuestionStatusAction.executeImpl: Attempting to change question #0 to status #1", questionId, nextStatus.getName() );

        if (question.getStatus().equals(nextStatus)) {
            addActionError(getText("message.question.status.notChanged", Lists.newArrayList(question.getStatus().getName())));
            addFieldError("current status id", "same as next status");
            return Constants.RESULT_NOT_MODIFIED;
        }

        QuestionStatus tempStatus = question.getStatus();
        question.setStatus(nextStatus);
        //发布: 判断如果此时是质管员发布，则判断是否全部质管员同意发布
        if(statusId==Constants.PUNLISH&&tempStatus.isAccessibleByQualityAdmin()){
            //是否发布(质管员全部同意)
            int currentQaPublishs = question.getQaPulishs() == null ? 0:question.getQaPulishs();
            if((currentQaPublishs+1) == question.getQaNums()){
                question.setStatus(nextStatus);
                if(question.getQaUser1() == null || question.getQaUser1().length() == 0){
                    question.setQaUser1(username);
                }
                else if(question.getQaUser2() == null || question.getQaUser2().length() == 0){
                    question.setQaUser2(username);
                }
                else{
                    question.setQaUser3(username);
                }
            }
            else{
                question.setStatus(tempStatus);
                if(question.getQaUser1() == null || question.getQaUser1().length() == 0){
                    question.setQaUser1(username);
                }
                else{
                    question.setQaUser2(username);
                }
            }
            question.setQaPulishs(currentQaPublishs+1);
        }
        //修改:
        if(statusId==Constants.MODIFY&&tempStatus.isAccessibleByQualityAdmin()) {
            question.setQaPulishs(0);
            question.setQaUser1(null);
            question.setQaUser2(null);
            question.setQaUser3(null);
        }
        questionService.saveOrUpdate(question);
        return null;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public QuestionStatus getStatus() {
        return nextStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
