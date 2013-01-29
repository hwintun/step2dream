<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>
	<s:url action="home" var="homeLink"></s:url>
	<s:url action="viewShoppingCart" var="viewShoppingCartLink"></s:url>
	<s:url action="productSearchStart" var="viewProductSearchLink"></s:url>

	<table border="1" style="width:100%; text-align: center; border: thin;">
		<tr style="background-color: #D8D8D8; height: 35px; font-variant: small-caps;">
			<td><a href="${homeLink}" style="color: red; font-weight: bold; text-decoration: none;" >Home</a></td>
		</tr>
		<tr style="background-color: #D8D8D8; height: 35px; font-variant: small-caps;">
			<td><a href="${viewProductSearchLink}" style="color: red; font-weight: bold; text-decoration: none;" >Product Search</a></td>
		</tr>
		<tr style="background-color: #D8D8D8; height: 35px; font-variant: small-caps;">
			<td><a href="${viewShoppingCartLink}" style="color: red; font-weight: bold; text-decoration: none;" >Shopping Cart</a></td>
		</tr>
	</table>
</body>
</html>
