<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Product(Edit)</title>
</head>
<body>
	<s:form action="productpostupdate.action">
		<table align="center">
			<tr>
				<th colspan=2 align="center"><b>Product Edit Form</b></th>
			</tr>
			<tr>
				<td colspan=2>
					<hr size=3 color="gray" />
				</td>
			</tr>
			<tr>
				<td colspan=2><s:textfield name="p.idProduct" label="ID"
						value="%{#application.a}" size="30" /></td>
			</tr>
			<tr>
				<td colspan=2><s:textfield name="p.productCode"
						key="label.productCode" value="%{#application.b}" size="30" /></td>
			</tr>
			<tr>
				<td colspan=2><s:textfield name="p.productCategory"
						key="label.productCategory" value="%{#application.c}" size="30" /></td>
			</tr>
			<tr>
				<td colspan=2><s:textfield name="p.productBrand"
						key="label.productBrand" value="%{#application.d}" size="30" /></td>
			</tr>
			<tr>
				<td colspan=2><s:textfield name="p.productPrize"
						key="label.productPrize" value="%{#application.e}" size="30" /></td>
			</tr>
			<tr>
				<td colspan=2><s:textfield name="p.productQty"
						key="label.productQty" value="%{#application.f}" size="30" /></td>
			</tr>
			<tr>
				<td colspan=2><s:textfield name="p.productColor"
						key="label.color" value="%{#application.g}" size="30" /></td>
			</tr>
			<tr>
				<td colspan=2><s:textfield name="p.productSize"
						key="label.productSize" value="%{#application.h}" size="30" /></td>
			</tr>
			<tr>
				<td colspan=2>
					<hr size=3 color="gray" />
				</td>
			</tr>
			<tr>
				<td colspan=2 align="center"><input type="submit"
					value=" Update " /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>