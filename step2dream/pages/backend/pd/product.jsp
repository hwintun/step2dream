<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Product(Entry)</title>
<script type="text/javascript">
	function cancelEntry() {
		document.a.action = "viewProduct.action";
		document.a.submit();
	}
	function saveEntry() {
		document.a.action = "entryProduct.action";
		document.a.submit();
	}
</script>
</head>
<body>
	<center>
		<font color="red"> <s:actionerror /></font>
	</center>
	<s:form name="a" method="post" enctype="multipart/form-data">
	<table bgcolor="#909090" border="1" align="center" width="45%">
			<tr>
				<td colspan="10" align="center">
					<h3>Product Entry Form.</h3>
				</td>
			</tr>
			<tr>
				<td colspan=2><s:textfield name="p.productCode"
						key="label.productCode" size="35" /></td>
			</tr>
			<tr>
				<td colspan=2><s:textfield name="p.productCategory"
						key="label.productCategory" size="35" /></td>
			</tr>
			<tr>
				<td colspan=2><s:textfield name="p.productBrand"
						key="label.productBrand" size="35" /></td>
			</tr>
			<tr>
				<td colspan=2><s:textfield name="p.productPrize"
						key="label.productPrize" size="35" /></td>
			</tr>
			<tr>
				<td colspan=2><s:textfield name="p.productQty"
						key="label.productQty" size="35" /></td>
			</tr>
			<tr>
				<td colspan=2><s:select label="Product Color" headerKey="-1"
						headerValue="Select Color" list="colorList" name="p.productColor" /></td>
			</tr>
			<tr>
				<td colspan=2><s:textfield name="p.productSize"
						key="label.productSize" size="35" /></td>
			</tr>
			<tr>
				<td colspan=2><s:file label="Front Image" name="fileUpload"
						size="40" /></td>
			</tr>
			<tr>
				<td colspan=2><s:file label="Back Image" name="fileUpload"
						size="40" /></td>
			</tr>
			<tr>
				<td colspan=2><s:file label="Right Image" name="fileUpload"
						size="40" /></td>
			</tr>
			<tr>
				<td colspan=2><s:file label="Left Image" name="fileUpload"
						size="40" /></td>
			</tr>

			<tr>
				<td colspan=2 align="center"><input type="button"
					value=" Save " onclick="saveEntry();" /><input type="button"
					value="Cancel" onclick="cancelEntry();" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>