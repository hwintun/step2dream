<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*;"%>
<html>
<head>
<title>Delivery Charge (Edit)</title>
</head>
<body>
	<s:form action="dcpostupdate">
		<s:textfield label="ID" value="%{#application.a}"
			name="dcl.idDeliveryCharge" readonly="true" />
		<s:textfield label="Township" value="%{#application.b}"
			name="dcl.deliveryTownship" />
		<s:textfield label="Charge" value="%{#application.c}"
			name="dcl.deliveryCharge" />
		<s:submit value="Update" />
	</s:form>
</body>
</html>