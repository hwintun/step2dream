<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<script type="text/javascript">
	function cancel() {
		document.a.action = "showProductCatalog.action";
		document.a.submit();
	}
	function add() {
		document.a.action = "addToShoppingCart.action";
		document.a.submit();
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<s:form name="a" method="post">
		<table border="1" style="border-color: blue; border-style: solid;">
			<tr>
				<td><img height="150" width="150" alt="image"
					src="<%=request.getContextPath() %>/images/<%=application.getAttribute("i") %>" /></td>
				<td><img height="150" width="150" alt="image"
					src="<%=request.getContextPath() %>/images/<%=application.getAttribute("j") %>" /></td>
				<td><img height="150" width="150" alt="image"
					src="<%=request.getContextPath() %>/images/<%=application.getAttribute("k") %>" /></td>
				<td><img height="150" width="150" alt="image"
					src="<%=request.getContextPath() %>/images/<%=application.getAttribute("l") %>" /></td>
			</tr>
		</table>
		</br>
		<table style="border-color: blue; border-style: solid;" width="400px">
			<thead>
				<th>
				<td colspan="2">Production Information</td>
				</th>
			</thead>
			<tr>
				<td colspan=2><s:label label="Category"
						value="%{#application.c}" /></td>
			</tr>
			<tr>
				<td colspan=2><s:label label="Brand" value="%{#application.d}" /></td>
			</tr>
			<tr>
				<td colspan=2><s:label label="Prize" value="%{#application.e}" /></td>
			</tr>
			<tr>
				<td colspan=2><s:label label="Color" value="%{#application.g}" /></td>
			</tr>
			<tr>
				<td>Size:</td>
				<td><select name="productSize">
						<option value="-1">- Select one -</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
				</select></td>
			</tr>
			<tr>
				<td colspan=2>
					<hr size=3 color="gray" />
				</td>
			</tr>
			<tr>
				<td colspan=2 align="center"><input type="button"
					value=" Buy Now " onclick="add();" /><input type="button"
					value=" Cancel " onclick="cancel();" /></td>
			</tr>
		</table>

		<s:hidden name="productID" value="%{#application.a}" />
		<s:hidden name="productCode" value="%{#application.b}" />
		<s:hidden name="productName" value="%{#application.d}" />
		<s:hidden name="productPrize" value="%{#application.e}" />
		<s:hidden name="productColor" value="%{#application.g}" />
		<s:hidden name="productImage" value="%{#application.i}" />
		<s:label value="%{#application.i}" />
	</s:form>
</body>
</html>