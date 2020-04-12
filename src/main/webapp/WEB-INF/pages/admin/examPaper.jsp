<%--
  Created by IntelliJ IDEA.
  User: lanping
  Date: 2020/4/9
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="page-header">
    <h1>试卷管理</h1>
</div>
<div class="container-fluid">
    <div role="tabpanel" class="form-panel">

        <!-- Nav tabs -->
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a id="project-tab-title" href="#project-tab" aria-controls="syllabus-tab" role="tab" data-toggle="tab">项目信息管理</a></li>
<%--            <li role="presentation"><a id="status-tab-title" href="#project-status-tab" aria-controls="chapter-tab" role="tab" data-toggle="tab">项目状态</a></li>--%>
        </ul>

        <!-- Tab panes -->
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane fade in active" id="project-tab">
                <jsp:include page="/WEB-INF/partials/admin/examPaper/examPaper-tab.jsp"/>
            </div>
            <%-- project status tab --%>
<%--            <div role="tabpanel" class="tab-pane fade" id="project-status-tab">--%>
<%--                <jsp:include page="/WEB-INF/partials/admin/project/projectStatus-tab.jsp"/>--%>
<%--            </div>--%>

        </div>
    </div>
</div>
<script src="${ctx}/assets/js/utils/project-util.js"></script>
<script src="${ctx}/assets/js/admin/examPaper/examPaper.js"></script>
<%--<script src="${ctx}/assets/js/admin/project/project-status.js"></script>--%>
