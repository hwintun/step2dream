/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.23
 * Generated at: 2013-01-21 06:06:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages.backend.reports;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.step2dream.login.user.User;
import com.step2dream.reports.purchase.Purchase;
import java.util.*;;

public final class purchase_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fform_0026_005fmethod_005faction;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fform_0026_005fmethod_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fform_0026_005fmethod_005faction.release();
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
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      //  s:form
      org.apache.struts2.views.jsp.ui.FormTag _jspx_th_s_005fform_005f0 = (org.apache.struts2.views.jsp.ui.FormTag) _005fjspx_005ftagPool_005fs_005fform_0026_005fmethod_005faction.get(org.apache.struts2.views.jsp.ui.FormTag.class);
      _jspx_th_s_005fform_005f0.setPageContext(_jspx_page_context);
      _jspx_th_s_005fform_005f0.setParent(null);
      // /pages/backend/reports/purchase.jsp(12,1) name = method type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fform_005f0.setMethod("get");
      // /pages/backend/reports/purchase.jsp(12,1) name = action type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_s_005fform_005f0.setAction("viewPurchaseByUser");
      int _jspx_eval_s_005fform_005f0 = _jspx_th_s_005fform_005f0.doStartTag();
      if (_jspx_eval_s_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_s_005fform_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_s_005fform_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_s_005fform_005f0.doInitBody();
        }
        do {
          out.write("\r\n");
          out.write("\t\t<table align=\"center\" border=\"1\" width=\"80%\"\r\n");
          out.write("\t\t\tstyle=\"background-color: #D8D8D8\">\r\n");
          out.write("\t\t\t<tr>\r\n");
          out.write("\t\t\t\t<td colspan=\"9\" align=\"center\">\r\n");
          out.write("\t\t\t\t\t<h3>Purchase Report</h3>\r\n");
          out.write("\t\t\t\t</td>\r\n");
          out.write("\t\t\t</tr>\r\n");
          out.write("\t\t\t<tr>\r\n");
          out.write("\t\t\t\t<td colspan=\"9\"><select name=\"soldGoodsUserId\">\r\n");
          out.write("\t\t\t\t\t\t");

						List l1 = (List) request.getAttribute("userlist");
					if(l1 != null) {
						Iterator it = l1.iterator();
						while(it.hasNext()) {
							User u = (User)it.next();
							int id = u.getIdRegUsr();
							String name = u.getRegUsrFName();
					
          out.write("\r\n");
          out.write("\t\t\t\t\t\t<option value=\"");
          out.print(id);
          out.write('"');
          out.write('>');
          out.print(name );
          out.write("</option>\r\n");
          out.write("\t\t\t\t\t\t");

		
						}
					}
								 
          out.write("\r\n");
          out.write("\t\t\t\t</select> <input type=\"submit\" value=\" View \" /></td>\r\n");
          out.write("\t\t\t</tr>\r\n");
          out.write("\t\t\t<tr>\r\n");
          out.write("\t\t\t\t<th align=\"center\">Code</th>\r\n");
          out.write("\t\t\t\t<th align=\"center\">Brand</th>\r\n");
          out.write("\t\t\t\t<th align=\"center\">Category</th>\r\n");
          out.write("\t\t\t\t<th align=\"center\">Quantity</th>\r\n");
          out.write("\t\t\t\t<th align=\"center\">Prize</th>\r\n");
          out.write("\t\t\t\t<th align=\"center\">Color</th>\r\n");
          out.write("\t\t\t\t<th align=\"center\">Size</th>\r\n");
          out.write("\t\t\t\t<th align=\"center\">Reg. User Name</th>\r\n");
          out.write("\t\t\t\t<th align=\"center\">Customer Name</th>\r\n");
          out.write("\t\t\t</tr>\r\n");
          out.write("\t\t\t");

				List l = (List) request.getAttribute("list");
					if (l != null) {

						Iterator it = l.iterator();

						while (it.hasNext()) {

							Purchase p = (Purchase) it.next();
							int tempNum = p.getIdsoldGoods();
							String tempCode = p.getSoldGoodsCode();
							String tempBrand = p.getSoldGoodsBrand();
							String tempCategory = p.getSoldGoodsCategory();
							int tempQty = p.getSoldGoodsQty();
							Double tempPrize =  p.getSoldGoodsPrize();
							String tempColor = p.getSoldGoodsColor();
							int tempSize = p.getSoldGoodsSize();
							int tempUsrId = p.getSoldGoodsUserId();
							String tempUsrFName = p.getRegUsrFName();
							String tempName = p.getName();
			
          out.write("\r\n");
          out.write("\t\t\t<tr>\r\n");
          out.write("\t\t\t\t<td>");
          out.print(tempCode);
          out.write("</td>\r\n");
          out.write("\t\t\t\t<td>");
          out.print(tempBrand);
          out.write("</td>\r\n");
          out.write("\t\t\t\t<td>");
          out.print(tempCategory);
          out.write("</td>\r\n");
          out.write("\t\t\t\t<td>");
          out.print(tempQty);
          out.write("</td>\r\n");
          out.write("\t\t\t\t<td>");
          out.print(tempPrize);
          out.write("</td>\r\n");
          out.write("\t\t\t\t<td>");
          out.print(tempColor);
          out.write("</td>\r\n");
          out.write("\t\t\t\t<td>");
          out.print(tempSize);
          out.write("</td>\r\n");
          out.write("\t\t\t\t<td>");
          out.print(tempUsrFName);
          out.write("</td>\r\n");
          out.write("\t\t\t\t<td>");
          out.print(tempName);
          out.write("</td>\r\n");
          out.write("\t\t\t</tr>\r\n");
          out.write("\r\n");
          out.write("\t\t\t");

				}
					}
			
          out.write("\r\n");
          out.write("\t\t</table>\r\n");
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
        _005fjspx_005ftagPool_005fs_005fform_0026_005fmethod_005faction.reuse(_jspx_th_s_005fform_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fs_005fform_0026_005fmethod_005faction.reuse(_jspx_th_s_005fform_005f0);
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
