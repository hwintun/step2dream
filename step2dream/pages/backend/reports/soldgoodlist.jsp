<%@page import="com.step2dream.reports.soldgoods.SoldGood"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*;"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<s:form method="post">
		<table align="center" border="1" width="80%"
			style="background-color: #D8D8D8">
			<tr>
				<td colspan="7" align="center">
					<h3>Sold Good List</h3>
				</td>
			</tr>
			<tr>
				<th align="center">Code</th>
				<th align="center">Brand</th>
				<th align="center">Category</th>
				<th align="center">Quantity</th>
				<th align="center">Prize</th>
				<th align="center">Color</th>
				<th align="center">Size</th>
			</tr>
			<%
				List l = (List) request.getAttribute("list");
					if (l != null) {

						Iterator it = l.iterator();

						while (it.hasNext()) {

							SoldGood sg = (SoldGood) it.next();
							int tempNum = sg.getIdsoldGoods();
							String tempCode = sg.getSoldGoodsCode();
							String tempBrand = sg.getSoldGoodsBrand();
							String tempCategory = sg.getSoldGoodsCategory();
							int tempQty = sg.getSoldGoodsQty();
							Double tempPrize =  sg.getSoldGoodsPrize();
							String tempColor = sg.getSoldGoodsColor();
							int tempSize = sg.getSoldGoodsSize();
			%>
			<tr>
				<td><%=tempCode%></td>
				<td><%=tempBrand%></td>
				<td><%=tempCategory%></td>
				<td><%=tempQty%></td>
				<td><%=tempPrize%></td>
				<td><%=tempColor%></td>
				<td><%=tempSize%></td>
			</tr>

			<%
				}
					}
			%>
		</table>
	</s:form>
</body>
</html>