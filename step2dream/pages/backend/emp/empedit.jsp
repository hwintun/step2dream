<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*;"%>
<html>
<head>
<script type="text/javascript">
	function cancel() {
		document.a.action = "viewemp.action";
		document.a.submit();
	}
	function saveRecord() {
		document.a.action = "postupemp.action";
		document.a.submit();
	}
</script>

<title>Employee (Edit)</title>

</head>
<body>
	<s:form name="a" action="post">
		<table bgcolor="#909090" border="1" align="center" width="40%">
			<tr>
				<td colspan="2" align="center"><h3>Edit Employee
						Information.</h3></td>
			</tr>
			<tr>
				<td><s:textfield label="ID" value="%{#application.a}"
						name="e.idEmp" readonly="true" size="40" /></td>
			</tr>
			<tr>
				<td><s:textfield label="Login Name" value="%{#application.b}"
						name="e.empLoginName" size="40" /></td>
			</tr>
			<tr>
				<td><s:password label="Password" name="e.empPassword" size="40" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button"
					value=" Save " onclick="saveRecord();" /> <input type="button"
					value="Cancel" onclick="cancel();" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>