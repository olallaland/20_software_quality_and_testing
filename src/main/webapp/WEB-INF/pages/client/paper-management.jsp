<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="page-header">
    <h1> 考卷生成
        <small></small>
    </h1>
</div>

<div class="container-fluid">
    <div class="row">
        <nav class="toolbar navbar navbar-default">
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li>
                        <a id="reload-question-btn" href="#" class="btn btn-primary navbar-btn-tm" role="button"><i
                                class="glyphicon glyphicon-refresh"></i>刷新</a>
                    </li>
                    <li>
                        <a id="question-type-update-btn" href="#" class="btn btn-primary navbar-btn-tm"
                           role="button"><i class="glyphicon glyphicon-pencil"></i>修改题目类型</a>
                    </li>
                    <li>
                        <a id="make-paper-btn" class="btn btn-primary navbar-btn-tm" data-toggle="modal"
                           role="button"><i class="glyphicon glyphicon-plus-sign"></i>生成考卷</a>
                    </li>
                    <li>
                        <a id="show-paper-btn" class="btn btn-primary navbar-btn-tm" data-toggle="modal"
                           role="button"><i class="glyphicon glyphicon-plus-sign"></i>考卷预览</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    <div class="row">
        <table id="question-list-table" class="table table-striped table-bordered table-responsive table-condensed">
        </table>
    </div>
</div>

<div id="question-type-update-modal" class="modal fade" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header modal-header-warning">
                <div>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <span class="modal-title">填写相应题型数量</span>
                </div>
            </div>
            <div class="modal-body">
                <h4>如不做修改，请直接关闭对话框。</h4>

                <div class="form-group">
                    <label class="col-md-2 control-label">选择题</label>
                    <div class="col-md-2">
                        <input id='question-type1-number' name="quetion1Number" type='number' min="0" class="datepicker form-control" required>
                    </div>
                    <label class="col-md-2 control-label">情景题</label>
                    <div class="col-md-2">
                        <input id='question-type2-number' name="quetion2Number" type='number' min="0" class="datepicker form-control" required>
                    </div>
                    <label class="col-md-2 control-label">视频题</label>
                    <div class="col-md-2">
                        <input id='question-type3-number' name="quetion3Number" type='number' min="0" class="datepicker form-control" required>
                    </div>
                </div>
                <div id="init-transition-actions-container"></div>
            </div>
            <div class="modal-footer">
                <button id="question-type-ok" type="button" class="btn btn-default" data-dismiss="modal">确认</button>
            </div>

        </div>
    </div>
</div>

<div id="paper-show-modal" class="modal fade" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header modal-header-warning">
                <div>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <span class="modal-title">试卷预览</span>
                </div>
            </div>
            <div id="paper-show-div" class="modal-body">
                1.(10') 识别测试的任务、定义测试的目标以及为实现测试目标和任务的测试活动定义规格说明。上述活动主要发生在___阶段。<br/>
                A. 测试计划和控制<br/>
                B. 测试分析和设计<br/>
                C. 测试实现和执行<br/>
                D. 测试结束活动<br/>
                <br/>
                2.(10')  瀑布模型表达了一种系统的、顺序的逻辑开发方法。以下正确的是___<br/>
                A. 瀑布模型能够快速地开发大规模软件项目<br/>
                B. 只有很大的开发团队才使用瀑布模型<br/>
                C. 瀑布模型已经不再适合于现今的软件开发环境<br/>
                D. 瀑布模型适用于软件需求确定，开发过程能够采用线性方式完成的项目<br/>
                <br/>
                3.(10')  V 模型指出___对详细设计进行确认，___对系统设计进行确认<br/>
                A. 组件测试; 集成测试<br/>
                B. 组件测试; 系统测试<br/>
                C. 系统测试; 组件测试<br/>
                D. 组件测试; 验收测试<br/>
                <br/>
                4.(10')  在下列选项中，叙述错误的是___<br/>
                A. 每个开发活动都有相对的测试行为<br/>
                B. 每个测试级别都有特有的测试目标<br/>
                C. 软件测试的工作重点应该集中在系统测试上<br/>
                D. 对每个测试级别，都应在相应的开发活动过程中就进行相应的测试分析和设计<br/>
                <br/>
                5.(10')  测试的基本过程包括___<br/>
                A. 计划与控制、分析&设计、实现与执行、测试评估&测试报告、结束工作<br/>
                B. 计划与控制、分析&设计、测试执行、测试评估&测试报告、结束工作<br/>
                C. 计划与监督、分析&设计、实现与执行、测试评估出口准则、结束工作<br/>
                D. 计划与监督、分析&设计、测试执行、测试评估出口准则、结束工作<br/>
                <br/>
                6. (10') 测试执行阶段，错误的活动是___<br/>
                A. 提交所有的事件<br/>
                B. 仅提交发现的错误<br/>
                C. 执行确认测试<br/>
                D. 记录特殊情况<br/>
                <br/>
                7. (10') 在设计逻辑或概念类型的测试用例时，不在测试分析和设计阶段的活动是___<br/>
                A. 评审测试的依据<br/>
                B. 识别测试的条件<br/>
                C. 设计测试用例<br/>
                D. 准备测试数据<br/>
                <br/>
                8. (10') 下列不属于测试计划与控制阶段工作产品的内容是___<br/>
                A. 测试的进度表<br/>
                B. 测试的策略<br/>
                C. 测试的交付物<br/>
                D. 测试的条件<br/>
                <br/>
                9.(10')  下列不属于测试结束工作___<br/>
                A. 事件报告是否关闭<br/>
                B. 记录和归档测试套件（Testware）<br/>
                C. 对未关闭的事件报告提交变更需求<br/>
                D. 评价是否需要继续执行进一步的更多的测试或者提交测试报告<br/>
                <br/>
                10.(10')  下列针对测试人员的描述哪项是正确的___<br/>
                A. 开发人员需要较高的专业知识而测试人员不需要特别专业的知识技能<br/>
                B. 优秀的测试人员不仅需要掌握系统化的测试知识，拥有测试的实践经验，还需要具备适当的软技能及对系统的使用领域的知识的了解<br/>
                C. 测试等同于使用工具来检验代码<br/>
                D. 测试人员等同于测试执行人员<br/>
                <br/>
            </div>
            <div class="modal-footer">
                <button id="paper-show-close" type="button" class="btn btn-default" data-dismiss="modal">确认</button>
            </div>

        </div>
    </div>
</div>

<script src="${ctx}/assets/js/client/paper-management/paper-management.js"></script>