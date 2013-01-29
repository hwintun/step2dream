<%@page import="com.step2dream.product.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*;"%>
<html>
<head>
<script type="text/javascript">

	function deleteRecord() {
		document.a.action = "deleteProduct.action";
		document.a.submit();
	}
	function edit(val) {
		document.a.action = "productpreupdate.action?v=" + val;
		document.a.submit();
	}
	function entryP() {
		document.a.action = "entryP.action";
		document.a.submit();
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<s:form name="a" method="post">
		<table bgcolor="#D8D8D8" border="1" align="center" width="80%">
			<tr>
				<td colspan="10" align="center">
					<h3>Product Information Form.</h3>
				</td>
			</tr>
			<tr>
				<th align="center"></th>
				<th align="center">Code</th>
				<th align="center">Category</th>
				<th align="center">Brand</th>
				<th align="center">Prize</th>
				<th align="center">Qty</th>
				<th align="center">Color</th>
				<th align="center">Size</th>
				<th align="center">Image</th>
				<th align="center"></th>
			</tr>
			<%
				List l = (List) request.getAttribute("list");
					if (l != null) {

						Iterator it = l.iterator();

						while (it.hasNext()) {

							Product p = (Product) it.next();
							int tempid = p.getIdProduct();
							String tempCode = p.getProductCode();
							String tempCategory = p.getProductCategory();
							String tempBrand = p.getProductBrand();
							String tempPrize = p.getProductPrize().toString();
							String tempQty = String.valueOf(p.getProductQty());
							String tempColor = p.getProductColor().toString();
							String tempSize = String.valueOf(p.getProductSize());
							String tempImageName = p.getImage1();
			%>
			<tr>
				<td><input type="checkbox" value="<%=tempid%>" name="rdel"></td>
				<td><%=tempCode%></td>
				<td><%=tempCategory%></td>
				<td><%=tempBrand%></td>
				<td><%=tempPrize%></td>
				<td><%=tempQty%></td>
				<td><%=tempColor%></td>
				<td><%=tempSize%></td>
				<td><img height="50" width="50" alt="image"
					src="<%=request.getContextPath() %>/images/<%=tempImageName %>" /></td>
				<td><a href="javascript:edit('<%=tempid%>')">Edit</a></td>
			</tr>

			<%
				}
					}
			%>
			<tr>
				<td colspan="10" align="center"><input type="button" value=" Delete "
					onclick="deleteRecord();"> <input type="button"
					value="  New  " onclick="entryP();"></td>
			</tr>
		</table>
	</s:form>
</body>
</html>