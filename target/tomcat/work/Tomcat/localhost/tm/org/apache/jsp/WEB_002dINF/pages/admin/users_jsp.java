/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-04-06 07:21:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class users_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"page-header\">\r\n");
      out.write("        <h1><i class=\"glyphicon glyphicon-user\"></i>用户管理\r\n");
      out.write("            <small>系统用户管理</small>\r\n");
      out.write("        </h1>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <div class=\"container-fluid\">\r\n");
      out.write("        <nav class=\"toolbar navbar navbar-default\">\r\n");
      out.write("            <div class=\"collapse navbar-collapse\">\r\n");
      out.write("                <ul class=\"nav navbar-nav\">\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a id=\"create-user-btn\" class=\"btn btn-primary navbar-btn-tm\" href=\"#create-user-form\"\r\n");
      out.write("                           data-toggle=\"collapse\" role=\"button\"><i class=\"glyphicon glyphicon-plus-sign\"></i>新增用户</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a id=\"switch-state-btn\" class=\"disabled btn btn-primary navbar-btn-tm\" role=\"button\"><i\r\n");
      out.write("                                class=\"glyphicon glyphicon-off\"></i>启用/禁用用户</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <a id=\"switch-admin-btn\" class=\"disabled btn btn-primary navbar-btn-tm\" role=\"button\"><i\r\n");
      out.write("                                class=\"glyphicon glyphicon-user\"></i>设定/取消管理员权限</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li><a id=\"reset-password-btn\" class=\"disabled btn btn-primary navbar-btn-tm\" role=\"button\">重设密码</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li>\r\n");
      out.write("                        <form class=\"navbar-form\" role=\"search\">\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <input id=\"user-filter\" type=\"text\" class=\"form-control\" placeholder=\"用户关键字\">\r\n");
      out.write("                                <a id=\"search-user-btn\" class=\"btn btn-danger navbar-btn-tm\"><i\r\n");
      out.write("                                        class=\"glyphicon glyphicon-search\"></i></a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/partials/admin/user/create-user-form.jsp", out, false);
      out.write("\r\n");
      out.write("        <table id=\"user-data-table\" class=\"table table-bordered table-striped table-hover\">\r\n");
      out.write("            <thead>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th><input class=\"item-select-all\" type=\"checkbox\"></th>\r\n");
      out.write("                <th>ID</th>\r\n");
      out.write("                <th>");
      if (_jspx_meth_s_005ftext_005f0(_jspx_page_context))
        return;
      out.write("</th>\r\n");
      out.write("                <th>");
      if (_jspx_meth_s_005ftext_005f1(_jspx_page_context))
        return;
      out.write("</th>\r\n");
      out.write("                <th>");
      if (_jspx_meth_s_005ftext_005f2(_jspx_page_context))
        return;
      out.write("</th>\r\n");
      out.write("                <th>");
      if (_jspx_meth_s_005ftext_005f3(_jspx_page_context))
        return;
      out.write("</th>\r\n");
      out.write("                <th>");
      if (_jspx_meth_s_005ftext_005f4(_jspx_page_context))
        return;
      out.write("</th>\r\n");
      out.write("                <th align=\"center\">");
      if (_jspx_meth_s_005ftext_005f5(_jspx_page_context))
        return;
      out.write("</th>\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("                <th>");
      if (_jspx_meth_s_005ftext_005f6(_jspx_page_context))
        return;
      out.write("</th>\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("            </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("        </table>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <script id=\"user-table-tmpl\" type=\"text/x-handlebars-template\">\r\n");
      out.write("        <tbody>\r\n");
      out.write("        {{#each users}}\r\n");
      out.write("        <tr class=\"item-row\" data-index=\"{{@index}}\">\r\n");
      out.write("            <td>\r\n");
      out.write("\r\n");
      out.write("                <input type=\"checkbox\" class=\"item-selection\">\r\n");
      out.write("\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("            </td>\r\n");
      out.write("            <td data-attr=\"id\">{{id}}</td>\r\n");
      out.write("            <td data-attr=\"username\">{{username}}</td>\r\n");
      out.write("            <td>{{fullName}}</td>\r\n");
      out.write("            <td>{{email}}</td>\r\n");
      out.write("            <td>{{phone}}</td>\r\n");
      out.write("            <td>\r\n");
      out.write("                {{#if enabled}}\r\n");
      out.write("                <span class=\"label-lg label-success\">活动</span>\r\n");
      out.write("                {{else}}\r\n");
      out.write("                <span class=\"label-lg label-warning\">已禁用</span>\r\n");
      out.write("                {{/if}}\r\n");
      out.write("            </td>\r\n");
      out.write("            <td>\r\n");
      out.write("                {{#if admin}}\r\n");
      out.write("                <span class=\"label-lg label-danger\">管理员</span>\r\n");
      out.write("                {{else}}\r\n");
      out.write("                <span class=\"label-lg label-success\">普通用户</span>\r\n");
      out.write("                {{/if}}\r\n");
      out.write("            </td>\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            <td>\r\n");
      out.write("                {{#if lastLogin}}\r\n");
      out.write("                {{date lastLogin}}\r\n");
      out.write("                {{else}}\r\n");
      out.write("\r\n");
      out.write("                {{/if}}\r\n");
      out.write("            </td>\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("        </tr>\r\n");
      out.write("        {{/each}}\r\n");
      out.write("        </tbody>\r\n");
      out.write("    </script>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/assets/js/admin/users.js\"></script>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_s_005ftext_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_005ftext_005f0 = (org.apache.struts2.views.jsp.TextTag) _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_005ftext_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005ftext_005f0.setParent(null);
    // /WEB-INF/pages/admin/users.jsp(48,20) name = name type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005ftext_005f0.setName("label.username");
    int _jspx_eval_s_005ftext_005f0 = _jspx_th_s_005ftext_005f0.doStartTag();
    if (_jspx_th_s_005ftext_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_s_005ftext_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_s_005ftext_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005ftext_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_005ftext_005f1 = (org.apache.struts2.views.jsp.TextTag) _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_005ftext_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005ftext_005f1.setParent(null);
    // /WEB-INF/pages/admin/users.jsp(49,20) name = name type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005ftext_005f1.setName("label.fullName");
    int _jspx_eval_s_005ftext_005f1 = _jspx_th_s_005ftext_005f1.doStartTag();
    if (_jspx_th_s_005ftext_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_s_005ftext_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_s_005ftext_005f1);
    return false;
  }

  private boolean _jspx_meth_s_005ftext_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_005ftext_005f2 = (org.apache.struts2.views.jsp.TextTag) _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_005ftext_005f2.setPageContext(_jspx_page_context);
    _jspx_th_s_005ftext_005f2.setParent(null);
    // /WEB-INF/pages/admin/users.jsp(50,20) name = name type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005ftext_005f2.setName("label.entity.user.email");
    int _jspx_eval_s_005ftext_005f2 = _jspx_th_s_005ftext_005f2.doStartTag();
    if (_jspx_th_s_005ftext_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_s_005ftext_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_s_005ftext_005f2);
    return false;
  }

  private boolean _jspx_meth_s_005ftext_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_005ftext_005f3 = (org.apache.struts2.views.jsp.TextTag) _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_005ftext_005f3.setPageContext(_jspx_page_context);
    _jspx_th_s_005ftext_005f3.setParent(null);
    // /WEB-INF/pages/admin/users.jsp(51,20) name = name type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005ftext_005f3.setName("label.phone");
    int _jspx_eval_s_005ftext_005f3 = _jspx_th_s_005ftext_005f3.doStartTag();
    if (_jspx_th_s_005ftext_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_s_005ftext_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_s_005ftext_005f3);
    return false;
  }

  private boolean _jspx_meth_s_005ftext_005f4(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_005ftext_005f4 = (org.apache.struts2.views.jsp.TextTag) _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_005ftext_005f4.setPageContext(_jspx_page_context);
    _jspx_th_s_005ftext_005f4.setParent(null);
    // /WEB-INF/pages/admin/users.jsp(52,20) name = name type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005ftext_005f4.setName("label.entity.user.isEnabled");
    int _jspx_eval_s_005ftext_005f4 = _jspx_th_s_005ftext_005f4.doStartTag();
    if (_jspx_th_s_005ftext_005f4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_s_005ftext_005f4);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_s_005ftext_005f4);
    return false;
  }

  private boolean _jspx_meth_s_005ftext_005f5(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_005ftext_005f5 = (org.apache.struts2.views.jsp.TextTag) _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_005ftext_005f5.setPageContext(_jspx_page_context);
    _jspx_th_s_005ftext_005f5.setParent(null);
    // /WEB-INF/pages/admin/users.jsp(53,35) name = name type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005ftext_005f5.setName("label.entity.user.isAdmin");
    int _jspx_eval_s_005ftext_005f5 = _jspx_th_s_005ftext_005f5.doStartTag();
    if (_jspx_th_s_005ftext_005f5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_s_005ftext_005f5);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_s_005ftext_005f5);
    return false;
  }

  private boolean _jspx_meth_s_005ftext_005f6(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  s:text
    org.apache.struts2.views.jsp.TextTag _jspx_th_s_005ftext_005f6 = (org.apache.struts2.views.jsp.TextTag) _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.get(org.apache.struts2.views.jsp.TextTag.class);
    _jspx_th_s_005ftext_005f6.setPageContext(_jspx_page_context);
    _jspx_th_s_005ftext_005f6.setParent(null);
    // /WEB-INF/pages/admin/users.jsp(55,20) name = name type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005ftext_005f6.setName("label.entity.user.lastLogin");
    int _jspx_eval_s_005ftext_005f6 = _jspx_th_s_005ftext_005f6.doStartTag();
    if (_jspx_th_s_005ftext_005f6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_s_005ftext_005f6);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005ftext_0026_005fname_005fnobody.reuse(_jspx_th_s_005ftext_005f6);
    return false;
  }
}