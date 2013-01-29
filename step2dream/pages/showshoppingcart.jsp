<%@page import="com.step2dream.product.Product"%>
<%@page import="java.util.Vector"%>
<%@page import="com.step2dream.shoppingcart.ShoppingCart"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<script type="text/javascript">
	function checkout() {
		document.a.action = "confirmAddress.action";
		document.a.submit();
	}
	function continueshopping() {
		document.a.action = "showProductCatalog.action";
		document.a.submit();
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<%
		ShoppingCart cart = (ShoppingCart) session
				.getAttribute("ShoppingCart");
		if (cart == null) {
			System.out.println("shoppingcart");
			cart = new ShoppingCart();
			session.setAttribute("ShoppingCart", cart);

		}
		Vector item = cart.getItems();
		if (item.size() == 0) {
	%>
	<table>
		<tr>
			<td>Nothing Data.</td>
		</tr>
	</table>
	<%
		} else {
		
	%>
	Shopping Cart
	</br>
	<table width="100%">
<tr>
			<td>
				<s:form action="removeItem" method="post">
					<table border="1">
						<tr>
							<th align="center">Image</th>
							<th align="center">Code</th>
							<th align="center">Brand</th>
							<th align="center">Prize</th>
							<th align="center">Color</th>
							<th align="center">Size</th>
							<th align="center">Remove</th>
						</tr>
						<%
						if (item.size() != 0) {
							int numitems = item.size();
							for (int i = 0; i < numitems; i++) {
								Product producrt = (Product) item.elementAt(i);
						%>
						<tr>
							<td><img height="50" width="50" alt="image" src="<%=request.getContextPath()%>/images/<%=producrt.getImage1()%>" /></td>
							<td><%=producrt.getProductCode()%></td>
							<td><%=producrt.getProductBrand()%></td>
							<td><%=producrt.getProductPrize()%></td>
							<td><%=producrt.getProductColor()%></td>
							<td><%=producrt.getProductSize()%></td>
							<td><input type="hidden" name="item" value="<%=i%>" /> <input type="submit" value="Remove" /></td>
						</tr>
						<%
							}
			
						}
						%>
					</table>
				</s:form> 
			</td>
		</tr>
		<tr>
			<td><s:form name="a" method="post">
				<input type="button" value="Check out" onclick="checkout();" />
				<input type="button" value="Continue Shopping"	onclick="continueshopping();" />
				
				</s:form></td>
		</tr>
	</table>
	<%} %>
</body>
</html>