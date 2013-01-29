<%@page import="com.step2dream.dc.DCList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*;"%>

<html>
<head>
<script type="text/javascript">
	function dcdel() {
		document.a.action = "dcdel.action";
		document.a.submit();
	}
	function dcentry() {
		document.a.action = "dcentrystart.action";
		document.a.submit();
	}
	function edit(val) {
		document.a.action = "dcpreupdate.action?v=" + val;
		document.a.submit();
	}
</script>

<title>Delivery Charge (List)</title>
</head>
<body>
	<s:form name="a" method="post">
		<table align="center" border="1" width="80%"
			style="background-color: #D8D8D8">
			<tr>
				<td colspan=4 align="center">
					<h3>Delivery Charge Information</h3>
				</td>
			</tr>
			<tr>
				<th align="center"></th>
				<th align="center">Township</th>
				<th align="center">Charge</th>
				<th align="center"></th>
			</tr>
			<%
				List l = (List) request.getAttribute("list");
					if (l != null) {

						Iterator it = l.iterator();

						while (it.hasNext()) {

							DCList dcl = (DCList) it.next();
							int tempNum = dcl.getIdDeliveryCharge();
							String tempTownship = dcl.getDeliveryTownship();
							String tempPirze = dcl.getDeliveryCharge().toString();
			%>
			<tr>
				<td align="center"><input type="checkbox" value="<%=tempNum%>"
					name="rdel"></td>
				<td><%=tempTownship%></td>
				<td><%=tempPirze%></td>
				<td><a href="javascript:edit('<%=tempNum%>')">Edit</a></td>
			</tr>

			<%
				}
					}
			%>
			<tr>
				<td colspan="4" align="center"><input type="button"
					value=" Delete " onclick="dcdel();" /> <input type="button"
					value="  New  " onclick="dcentry();" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>