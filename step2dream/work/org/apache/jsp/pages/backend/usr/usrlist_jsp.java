/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.23
 * Generated at: 2013-01-21 06:06:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages.backend.usr;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.step2dream.usr.UsrList;
import java.util.*;;

public final class usrlist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fform_0026_005fname_005fmethod;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fform_0026_005fname_005fmethod = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fform_0026_005fname_005fmethod.release();
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction deleteRecord() {\r\n");
      out.write("\t\tdocument.a.action = \"usrdel.action\";\r\n");
      out.write("\t\tdocument.a.submit();\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction newRecord() {\r\n");
      out.write("\t\tdocument.a.action = \"usrcreate.action\";\r\n");
      out.write("\t\tdocument.a.submit();\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction edit(val) {\r\n");
      out.write("\t\tdocument.a.action = \"usrpreup.action?v=\" + val;\r\n");
      out.write("\t\tdocument.a.submit();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<title>Customer (List)</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      //  s:form
      org.apache.struts2.views.jsp.ui.FormTag _jspx_th_s_005fform_005f0 = (org.apache.struts2.views.jsp.ui.FormTag) _005fjspx_005ftagPool_005fs_005fform_0026_005fname_005fmethod.get(org.apache.struts2.views.jsp.ui.FormTag.class);
      _jspx_th_s_005fform_005f0.setPageContext(_jspx_page_context);
      _jspx_th_s_005fform_005f0.setParent(null);
      // /pages/backend/usr/usrlist.jsp(27,1) name = name type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fform_005f0.setName("a");
      // /pages/backend/usr/usrlist.jsp(27,1) name = method type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fform_005f0.setMethod("post");
      int _jspx_eval_s_005fform_005f0 = _jspx_th_s_005fform_005f0.doStartTag();
      if (_jspx_eval_s_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_s_005fform_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_s_005fform_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_s_005fform_005f0.doInitBody();
        }
        do {
          out.write("\r\n");
          out.write("\t\t<table border=\"2\" bgcolor=#D8D8D8 align=\"center\" width=\"80%\">\r\n");
          out.write("\t\t\t<tr>\r\n");
          out.write("\t\t\t\t<td colspan=7 align=\"center\">\r\n");
          out.write("\t\t\t\t\t<h3>Customer Information Form</h3>\r\n");
          out.write("\t\t\t\t</td>\r\n");
          out.write("\t\t\t</tr>\r\n");
          out.write("\t\t\t<tr>\r\n");
          out.write("\t\t\t\t<th align=\"center\"></th>\r\n");
          out.write("\t\t\t\t<th align=\"center\">Full Name</th>\r\n");
          out.write("\t\t\t\t<th align=\"center\">Login Name</th>\r\n");
          out.write("\t\t\t\t<th align=\"center\">Address</th>\r\n");
          out.write("\t\t\t\t<th align=\"center\">Phone No:</th>\r\n");
          out.write("\t\t\t\t<th align=\"center\">E-mail</th>\r\n");
          out.write("\t\t\t\t<th align=\"center\"></th>\r\n");
          out.write("\t\t\t</tr>\r\n");
          out.write("\r\n");
          out.write("\t\t\t");

				List l = (List) request.getAttribute("list");

					if (l != null) {

						Iterator it = l.iterator();

						while (it.hasNext()) {
							UsrList ul = (UsrList) it.next();
							int tempId = ul.getIdRegUsr();
							String tempFName = ul.getRegUsrFName();
							String tempLName = ul.getRegUsrLName();
							String tempAddress = ul.getRegUsrAddress();
							String tempPhone = ul.getRegUsrPhone();
							String tempEmail = ul.getRegUsrEmail();
			
          out.write("\r\n");
          out.write("\t\t\t<tr>\r\n");
          out.write("\t\t\t\t<td><input type=\"checkbox\" value=\"");
          out.print(tempId);
          out.write("\" name=\"rdel\"></td>\r\n");
          out.write("\t\t\t\t<td>");
          out.print(tempFName);
          out.write("</td>\r\n");
          out.write("\t\t\t\t<td>");
          out.print(tempLName);
          out.write("</td>\r\n");
          out.write("\t\t\t\t<td>");
          out.print(tempAddress);
          out.write("</td>\r\n");
          out.write("\t\t\t\t<td>");
          out.print(tempPhone);
          out.write("</td>\r\n");
          out.write("\t\t\t\t<td>");
          out.print(tempEmail);
          out.write("</td>\r\n");
          out.write("\t\t\t\t<td><a href=\"javascript:edit('");
          out.print(tempId);
          out.write("')\">Edit</a></td>\r\n");
          out.write("\t\t\t</tr>\r\n");
          out.write("\r\n");
          out.write("\t\t\t");

				}
					}
			
          out.write("\r\n");
          out.write("\t\t\t<tr>\r\n");
          out.write("\t\t\t\t<td colspan=\"7\" align=\"center\"><input type=\"button\"\r\n");
          out.write("\t\t\t\t\tvalue=\"Delete\" onclick=\"deleteRecord();\" /> <input type=\"button\"\r\n");
          out.write("\t\t\t\t\tvalue=\"  New \" onclick=\"newRecord();\" /></td>\r\n");
          out.write("\t\t\t</tr>\r\n");
          out.write("\t\t</table>\r\n");
          out.write("\r\n");
          out.write("\t");
          int evalDoAfterBody = _jspx_th_s_005fform_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_s_005fform_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_s_005fform_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fs_005fform_0026_005fname_005fmethod.reuse(_jspx_th_s_005fform_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fs_005fform_0026_005fname_005fmethod.reuse(_jspx_th_s_005fform_005f0);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}