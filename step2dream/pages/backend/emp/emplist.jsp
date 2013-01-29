<%@page import="com.step2dream.emp.EmpList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*;"%>
<%@ taglib prefix="s" uri="/struts-tags"%>



<html>
<head>
<script type="text/javascript">
			function deleteRecord() {
				document.a.action = "delemp.action";
				document.a.submit();
			}
			function edit(val) {
				document.a.action = "preupdateemp.action?v=" + val;
				document.a.submit();
			}
			function entry() {
				document.a.action = "empCreate.action";
				document.a.submit();
			}
		</script>
<title>Employee (List)</title>
</head>

<body>
	<s:form name="a" method="post">
		<table bgcolor=#D8D8D8 border=1 align="center" width="80%">
			<tr>
				<td colspan=4 align="center">
					<h3>Employee Information Form</h3>
				</td>
			</tr>
			<tr>
				<th align="center"></th>
				<th align="center">Employee ID</th>
				<th align="center">Employee Login Name</th>
				<th align="center"></th>
			</tr>

			<%
				List l = (List) request.getAttribute("list");
					if (l != null) {

						Iterator it = l.iterator();

						while (it.hasNext()) {

							EmpList el = (EmpList) it.next();
							int tempId = el.getIdEmp();
							String tempLName = el.getEmpLoginName();
							String tempPassword = el.getEmpPassword();
			%>
			<tr>
				<td><input type="checkbox" value="<%=tempId%>" name="rdel"></td>
				<td><%=tempId%></td>
				<td><%=tempLName%></td>
				<td><a href="javascript:edit('<%=tempId%>')">Edit</a></td>
			</tr>

			<%
				}
					}
			%>
			<tr>
				<td colspan="4" align="center"><input type="button"
					value=" Delete " onclick="deleteRecord();"> <input
					type="button" value="  New  " onclick="entry();"></td>
			</tr>
		</table>
	</s:form>
</body>
</html>