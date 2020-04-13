/*
* 没用的，别看了
 */


package cn.cstqb.exam.testmaker.actions.examPaper;


import cn.cstqb.exam.testmaker.actions.AbstractPaginationAction;
import cn.cstqb.exam.testmaker.entities.ExamPaper;
import cn.cstqb.exam.testmaker.entities.User;
import cn.cstqb.exam.testmaker.mailing.MailMessenger;
import cn.cstqb.exam.testmaker.mailing.MailNotificationFactory;
import cn.cstqb.exam.testmaker.mailing.SendMailTask;
import cn.cstqb.exam.testmaker.services.IExamPaperService;
import cn.cstqb.exam.testmaker.services.IExamPaperStatusService;
import cn.cstqb.exam.testmaker.services.ISyllabusService;
import cn.cstqb.exam.testmaker.services.IUserService;
import cn.cstqb.exam.testmaker.util.ServletUtils;
import com.google.common.collect.Lists;
import freemarker.template.TemplateException;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import javax.inject.Inject;
import javax.mail.internet.AddressException;
import java.io.IOException;
import java.util.List;

public abstract class BaseExamPaperAction extends AbstractPaginationAction{
    @Inject protected IExamPaperService examPaperService;
    @Inject protected IExamPaperStatusService examPaperStatusService;
    @Inject protected IUserService userService;
    @Inject protected ISyllabusService syllabusService;
    @Inject protected MailNotificationFactory mailFactory;
    @Inject protected MailMessenger messenger;

    public BaseExamPaperAction() {
        super();
        injector.injectMembers(this);
    }
    protected User findFacilitator(String userName) {
        return userService.findUser(userName);
    }

    protected boolean validateExamPaper(ExamPaper examPaper) {
        if (examPaper==null) {
            addActionError(getText("error.entity.invalid", Lists.newArrayList(getText("label.entity.project"))));
            return false;
        }

        if (!examPaper.validate()) {
            addActionError(getText("error.entity.validation.incomplete", Lists.newArrayList(getText("message.project.requiredFields"))));
            return false;
        }

        if (examPaper.getStartDate() == null || examPaper.getFinishDate() == null) {
            addActionError(getText("error.project.missing.date.info"));
            return false;
        }
        if (examPaper.getFinishDate().before(examPaper.getStartDate())) {
            addActionError(getText("error.project.finishDate.earlierThanStart", Lists.newArrayList(dateFormat.format(examPaper.getStartDate()), dateFormat.format(examPaper.getFinishDate()))));
            return false;
        }

        /*
         * If the status is not null, check if the status is valid or not
         */
        if (examPaper.getStatus()!=null) {
            if (!examPaper.getStatus().validate() || !examPaper.getStatus().isValidID()) {
                addActionError(getText("error.project.status.invalid", Lists.newArrayList(examPaper.getStatus())));
                return false;
            }
        }

        return true;
    }


//    protected void sendMailToFacilitator(Project project, User facilitator) throws AddressException, TemplateException, EmailException, IOException {
//        mailFactory.setContextPath(ServletUtils.getBaseUrl(request));
//        List<User> users = projectService.findProjectUsers(project,false);
//        HtmlEmail email = mailFactory.buildNotificationForFacilitator(project, facilitator,users);
//        messenger.send(new SendMailTask(email));
//    }

    /**
     * method to load entity count from service layer
     */
    @Override
    protected void initEntityCount() {}

    /**
     * subclasses should implement this method to put business logic
     *
     * @return
     */
    @Override
    protected String doExecuteImpl() {
        return null;
    }

}
