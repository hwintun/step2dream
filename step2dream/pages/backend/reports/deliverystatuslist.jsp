<%@page import="com.opensymphony.xwork2.ActionContext"%>
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
	<s:form method="post" action="updateDeliveryStatus">
		<table align="center" border="1" width="100%"
			style="background-color: #D8D8D8">
			<tr>
				<td colspan="12" align="center">
					<h3>Sold Good List</h3>
				</td>
			</tr>
			<tr>
				<th align="center"></th>
				<th align="center">Code</th>
				<th align="center">Brand</th>
				<th align="center">Category</th>
				<th align="center">Quantity</th>
				<th align="center">Color</th>
				<th align="center">Size</th>
				<th align="center">Customer Name</th>
				<th align="center">Phone no.</th>
				<th align="center">Shipping Address</th>
				<th align="center">Shipping Township</th>
				<th align="center">Status</th>
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
							String status = sg.getSoldGoodsStatus();
							String tempName = sg.getName();
							String tempPhone = sg.getPhone();
							String tempAddress = sg.getDeliveryaddress();
							String tempTownship = sg.getTownship();
			%>
			<tr>
				<td><input type="checkbox" value="<%=tempNum%>" name="rdel" 
				<%
					if(status.equals("delivered")) {
				%>
					disabled="disabled"
				<%		
					}
				%>
				 /></td>
				<td><%=tempCode%></td>
				<td><%=tempBrand%></td>
				<td><%=tempCategory%></td>
				<td><%=tempQty%></td>
				<td><%=tempColor%></td>
				<td><%=tempSize%></td>
				<td><%=tempName%></td>
				<td><%=tempPhone%></td>
				<td><%=tempAddress%></td>
				<td><%=tempTownship%></td>
				<td><%=status%></td>
			</tr>

			<%
				}
					}
			%>
			<tr>
				<td colspan="12">
					<input type="submit" value=" Update " />
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>