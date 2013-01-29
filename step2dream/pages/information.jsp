<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<s:form action="showProductCatalog">
		<table>
			<tr>
				<th colspan="2">Your information have been successfully saved</th>
			</tr>
			<tr>
				<td colspan=2>
					<hr size=3 color="gray" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><s:label label="Name"
						value="%{#application.name}" /></td>
			</tr>
			<tr>
				<td colspan="2"><s:label label="Phone"
						value="%{#application.phone}" /></td>
			</tr>
			<tr>
				<td colspan="2"><s:label label="Address"
						value="%{#application.address}" /></td>
			</tr>
			<tr>
				<td colspan="2"><s:label label="Amount"
						value="%{#application.amount}" /></td>
			</tr>
			<tr>
				<td colspan="2"><s:label label="Delivery Charge"
						value="%{#application.dc}" /></td>
			</tr>
			<tr>
				<td colspan="2"><s:label label="Total Charge"
						value="%{#application.totalprice}" /></td>
			</tr>
			<tr>
				<td colspan=2>
					<hr size=3 color="gray" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value=" OK " /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>