(function () {

    /*
     * Definition of DOM variables
     */
    var dataTable = $('#question-list-table');

    var makePaperBtn = $('#make-paper-btn');
    var showPaperbtn = $('#show-paper-btn');
    //form elements

    var question1NumberInput=$('#question-type1-number');
    var question2NumberInput=$('#question-type2-number');
    var question3NumberInput=$('#question-type3-number');


    var questionTypeOk=$('#question-type-ok');

    var questionTypeUpdateBtn=$('#question-type-update-btn');
    var questionTypeUpdateModal = $('#question-type-update-modal');
    var paperShowModal = $('#paper-show-modal');
    var paperShowDiv = $('#paper-show-div');
    /*
     * Definition of model variables
     */
    var question1number=0;
    var question2number=0;
    var question3number=0;
    // var selectedQuestion={}, questions,transitions;
    // var selectedQuestionQAs = {};
    // var selectedQualityAdminNum = 0; //主持人选择的质管人数，用于判断是否重复
    // var syllabus=CONTEXT.project.syllabus;
    // var selectedChapter={}, chapters;
    // var knowledgePoints, languages, questionTypes;
    // var projectUsers;
    // var transitions4InitialStatus;

    var questions={};

    /*
     * action urls
     */
    // var listQTypeURL = CONTEXT.ctx + '/web/question/type/list.action';
    // var listProjectUserURL=CONTEXT.ctx + '/web/project/current/list-users.action';
    var listQuestionsURL = CONTEXT.ctx + '/web/project/current/list-questions-in-paper.action';
    var makePaperURL = CONTEXT.ctx + '/web/project/current/make-paper.action';
    var getChoicesURL = CONTEXT.ctx + '/web/project/current/view-question.action';
    // var questionPagingUrl=CONTEXT.ctx + '/web/project/current/paging.action';
    // var saveQuestionURL= CONTEXT.ctx + '/web/project/current/save-question.action';
    // var listQuestionInPaper=CONTEXT.ctx+'/web/project/current/list-question-inpaper';

    // var pagingHelper = new PaginationHelper(questionPagingUrl, listQuestionsURL, function (data) {
    //     questions=data.questions;
    //     console.log('%s questions loaded.', questions.length);
    //     displayQuestions(questions);
    //     loadTransitionsForInitialStatus();
    // });
    /*
     * Default function when the page loads
     */
    //alert(45);

    initialize();
    /**
     * Page initialization
     */
    function initialize() {
        //pagingHelper.loadPagingInfo();
        loadData();
        //initNewQuestionModal();
    }

    $('#reload-question-btn').click(function (e) {
        initialize();
    });

    function loadData() {
        return $.get(listQuestionsURL, {
            pageSize: 1000,
            pageNumber: 1
        })
            .done(function (data, textStatus, jqXHR) {
                questions=data.questions;
                displayQuestions(questions);
            });
    }

    function displayQuestions(questions) {
        displayQuestionsAsPaper(questions);
        AjaxUtils.getTemplateAjax(CONTEXT.ctx +'/assets/templates/questions/question-list-table.hbs.html', function (template) {
            var templateData = {
                questions: questions,
                showActions: true,
                showDelete: false,
                showDetails: true
            };
            dataTable.empty();
            dataTable.append(template(templateData));
//            Dialogs.showAjaxLoadInfo($('.msg-area'), questions.length);
        });
    }

    function displayQuestionsAsPaper(questions){
        let content="";
        let score=100.0/questions.length;
        let scorestr=''+score;
        scorestr=scorestr.substr(0,4);
        for(let i=0;i<questions.length;i++){
            let question = questions[i];
            content+='第'+(i+1)+'题：('+scorestr+'\')';
            content+=question.scenario;
            //content+='<br />';
            content+=question.stem;
            content+='<br />';
            //alert(question);
            if(question['images'].length>0){
                for(let j=0;j<question['images'].length;j++){
                    showimage(i,j,question['images'][j].path);
                }
            }
            content+="<br />"
            let choiceDivId='choiceofquestion'+question['id'];
            content+='<div id="'+choiceDivId+'"></div>';
            getChioces(question['id'],choiceDivId);
        }
        function showimage(indexOfQuetion,indexOfImage,path){
            content+='<img width="60%" src="'+CONTEXT.ctx+path+'"'+' />';
        }
        function getChioces(quetionId,choiceDivId){
            $.get(getChoicesURL, {
                id: quetionId
            })
                .done(function (data, textStatus, jqXHR) {
                    let choiceContent="";
                    let choices=data['choices'];
                    if(choices.length>0){
                        for(let choiceindex=0;choiceindex<choices.length; choiceindex++){
                            let choice=choices[choiceindex];
                            //alert(choices);
                            //alert(choice);
                            choiceContent+=choice['choiceLabel']+'&nbsp;&nbsp;'+
                                choice['content'].substr(3,choice['content'].length-3)+'<br />';
                        }
                    }
                    $('#'+choiceDivId).html(choiceContent);
                });
        }
        paperShowDiv.html(content);
    }

    //alert(0);

    /**
     * clicking the remove sign will delete the selected item
     */

    /**
     * Popup a modal of question details
     */
    dataTable.on('click','.view-item', function (e) {
        e.preventDefault();

        //gets the data-index attribute in the table and set selected kp per this index
        var index = $(this).closest('tr').data('index');
        selectedQuestion = questions[index];
        QuestionUtils.showQuestionDetailsModal({question: selectedQuestion});
    });

    questionTypeUpdateBtn.click(function (e) {
        questionTypeUpdateModal.modal('show');
    });

    questionTypeOk.click(function (e) {
        if(question1NumberInput.val()!=""){
            question1number=parseInt(question1NumberInput.val());
        }
        if(question2NumberInput.val()!=""){
            question2number=parseInt(question2NumberInput.val());
        }
        if(question3NumberInput.val()!=""){
            question3number=parseInt(question3NumberInput.val());
        }
        //alert(question1number);
    });

    makePaperBtn.click(function (e) {
        if(question1number==0&&question2number==0&&question3number==0){
            Dialogs.info("请分配题型");
            return;
        }

        $.post(makePaperURL, {
            type1number:question1number,
            type2number:question2number,
            type3number:question3number
        },function (data) {
            Dialogs.info(data['result']);
            loadData();
        });

    });

    showPaperbtn.click(function (e) {
        paperShowModal.modal('show');
    });
})();
