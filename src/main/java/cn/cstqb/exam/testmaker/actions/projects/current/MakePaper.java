package cn.cstqb.exam.testmaker.actions.projects.current;

import cn.cstqb.exam.testmaker.configuration.Constants;
import cn.cstqb.exam.testmaker.entities.ExamPaper;
import cn.cstqb.exam.testmaker.services.IExamPaperService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class MakePaper extends BaseCurrentProjectAction {

    private int type1number;
    private int type2number;
    private int type3number;

    private String result;

    @JsonIgnore
    @Inject
    protected IExamPaperService paperService;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getType1number() {
        return type1number;
    }

    public void setType1number(int type1number) {
        this.type1number = type1number;
    }

    public int getType2number() {
        return type2number;
    }

    public void setType2number(int type2number) {
        this.type2number = type2number;
    }

    public int getType3number() {
        return type3number;
    }

    public void setType3number(int type3number) {
        this.type3number = type3number;
    }
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
        if(type1number<0||type2number<0||type3number<0||(type1number+type2number+type3number==0)){
            addActionError(getText("error.papermaking.required.typeNumber",
                    Lists.newArrayList(type1number,type2number,type3number)));
        }
    }

    /**
     * method to load entity count from service layer
     */
    @Override
    protected void initEntityCount() {
        this.count = questionService.findAll(sessionProject).size();
    }


    /**
     * subclasses should implement this method to put business logic
     *
     * @return
     */
    @Override
    protected String doExecuteImpl() {
        logger.debug("MakePaper.doExecuteImpl: Make Paper: #0", "debug" );
        System.out.println(type1number);
        result=paperService.makePaper((ExamPaper) session.get(Constants.ATTR_EXAMPAPER),type1number,type2number,type3number);
        return null;
    }

}
