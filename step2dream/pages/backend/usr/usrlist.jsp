<%@page import="com.step2dream.usr.UsrList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*;"%>

<html>
<head>
<script type="text/javascript">
	function deleteRecord() {
		document.a.action = "usrdel.action";
		document.a.submit();
	}
	function newRecord() {
		document.a.action = "usrcreate.action";
		document.a.submit();
	}
	function edit(val) {
		document.a.action = "usrpreup.action?v=" + val;
		document.a.submit();
	}
</script>
<title>Customer (List)</title>
</head>

<body>
	<s:form name="a" method="post">
		<table border="2" bgcolor=#D8D8D8 align="center" width="80%">
			<tr>
				<td colspan=7 align="center">
					<h3>Customer Information Form</h3>
				</td>
			</tr>
			<tr>
				<th align="center"></th>
				<th align="center">Full Name</th>
				<th align="center">Login Name</th>
				<th align="center">Address</th>
				<th align="center">Phone No:</th>
				<th align="center">E-mail</th>
				<th align="center"></th>
			</tr>

			<%
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
			%>
			<tr>
				<td><input type="checkbox" value="<%=tempId%>" name="rdel"></td>
				<td><%=tempFName%></td>
				<td><%=tempLName%></td>
				<td><%=tempAddress%></td>
				<td><%=tempPhone%></td>
				<td><%=tempEmail%></td>
				<td><a href="javascript:edit('<%=tempId%>')">Edit</a></td>
			</tr>

			<%
				}
					}
			%>
			<tr>
				<td colspan="7" align="center"><input type="button"
					value="Delete" onclick="deleteRecord();" /> <input type="button"
					value="  New " onclick="newRecord();" /></td>
			</tr>
		</table>

	</s:form>
</body>
</html>