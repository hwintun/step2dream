<%@page import="com.step2dream.login.user.User"%>
<%@page import="com.step2dream.reports.purchase.Purchase"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*;"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<s:form method="get" action="viewPurchaseByUser">
		<table align="center" border="1" width="80%"
			style="background-color: #D8D8D8">
			<tr>
				<td colspan="9" align="center">
					<h3>Purchase Report</h3>
				</td>
			</tr>
			<tr>
				<td colspan="9"><select name="soldGoodsUserId">
						<%
						List l1 = (List) request.getAttribute("userlist");
					if(l1 != null) {
						Iterator it = l1.iterator();
						while(it.hasNext()) {
							User u = (User)it.next();
							int id = u.getIdRegUsr();
							String name = u.getRegUsrFName();
					%>
						<option value="<%=id%>"><%=name %></option>
						<%
		
						}
					}
								 %>
				</select> <input type="submit" value=" View " /></td>
			</tr>
			<tr>
				<th align="center">Code</th>
				<th align="center">Brand</th>
				<th align="center">Category</th>
				<th align="center">Quantity</th>
				<th align="center">Prize</th>
				<th align="center">Color</th>
				<th align="center">Size</th>
				<th align="center">Reg. User Name</th>
				<th align="center">Customer Name</th>
			</tr>
			<%
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
			%>
			<tr>
				<td><%=tempCode%></td>
				<td><%=tempBrand%></td>
				<td><%=tempCategory%></td>
				<td><%=tempQty%></td>
				<td><%=tempPrize%></td>
				<td><%=tempColor%></td>
				<td><%=tempSize%></td>
				<td><%=tempUsrFName%></td>
				<td><%=tempName%></td>
			</tr>

			<%
				}
					}
			%>
		</table>
	</s:form>
</body>
</html>