<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*;"%>
<html>
<head>
<title>Customer (Edit)</title>
<script type="text/javascript">
	function cancelEntry() {
		document.a.action = "usrlist.action";
		document.a.submit();
	}
	function saveEntry() {
		document.a.action = "usrpostup.action";
		document.a.submit();
	}
</script>
</head>
<body>
	<s:form name="a" action="post">

		<table bgcolor=#909090 border=1 align="center" width="40%">

			<tr>
				<td colspan="2" align="center">
					<h3>Customer Information Detail Form</h3>
				</td>
			</tr>
			<tr>
				<td><s:textfield size="32" label="Customer ID"
						value="%{#application.a}" name="ul.idRegUsr" readonly="true" /></td>
			</tr>
			<tr>
				<td><s:textfield size="32" label="Full Name"
						value="%{#application.b}" name="ul.regUsrFName" /></td>
			</tr>
			<tr>
				<td><s:textfield size="32" label="Login Name"
						value="%{#application.c}" name="ul.regUsrLName" /></td>
			</tr>
			<tr>
				<td><s:textfield size="32" label="Password"
						value="%{#application.d}" name="ul.regUsrPassword" /></td>
			</tr>
			<tr>
				<td><s:textarea label="Address" value="%{#application.e}"
						name="ul.regUsrAddress" /></td>
			</tr>
			<tr>
				<td><s:textfield size="32" label="Phone"
						value="%{#application.f}" name="ul.regUsrPhone" /></td>
			</tr>
			<tr>
				<td><s:textfield size="32" label="E-Mail"
						value="%{#application.g}" name="ul.regUsrEmail" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value=" Save " onclick="saveEntry();" /> <input type="button"
					value="Cancel" onclick="cancelEntry();" /></td>
			</tr>
			</s:form>
</body>
</html>