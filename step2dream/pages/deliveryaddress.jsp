<%@page import="com.step2dream.dc.DCList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*;"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<font color="red"><s:actionerror /></font>
	<s:form method="post" action="checkout">
		<table>
			<tr>
				<th colspan="2">Delivery Address</th>
			</tr>
			<tr>
				<td colspan="2"><s:textfield label="Name" value="" name="name" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><s:textfield label="Phone" value=""
						name="phone" /></td>
			</tr>
			<tr>
				<td colspan="2"><s:textfield label="Shipping Address" value=""
						name="address" /></td>
			</tr>
			<tr>
				<td>Township:</td>
				<td><select name="deliveryCharge">
						<option value="-1">- Select Township -</option>
						<%
					List l = (List) session.getAttribute("list");
					if(l != null) {
						Iterator i = l.iterator();
						while(i.hasNext()) {
							DCList dcl = (DCList) i.next();
				%>
						<option value="<%=dcl.getDeliveryTownship() %>"><%=dcl.getDeliveryTownship() %></option>
						<%			
						}
					}
				%>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value=" Check Out " /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>