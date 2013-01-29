<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.step2dream.product.Product"%>
<%@ page import="java.util.*;"%>
<html>
<head>
<script type="text/javascript">
	function detail(val) {
		document.a.action = "showDetailProduct.action?item="+val;
		document.a.submit();
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<s:form name="a" method="post">
		<table style="background-color: #D8D8D8; border-color: blue">
			
			<%
				int col = 0;
				List l = (List) request.getAttribute("productlist");
					if (l != null) {

						Iterator it = l.iterator();

						while (it.hasNext()) {

							Product p = (Product) it.next();
							int tempid = p.getIdProduct();
							String tempCode = p.getProductCode();
							String tempCategory = p.getProductCategory();
							String tempBrand = p.getProductBrand();
							String tempPrize = p.getProductPrize().toString();
							int tempQty = p.getProductQty();
							String tempColor = p.getProductColor().toString();
							String tempSize = String.valueOf(p.getProductSize());
							String tempImageName = p.getImage1();
			%>
			<%if(col == 0) { %>
			<tr>
				<% col = 1;}  %>
				<td>
					<table style="text-align: center">
						<tr>
							<td><img height="150" width="150" alt="image" src="<%=request.getContextPath()%>/images/<%=tempImageName%>" /></td>
						</tr>
						<tr>
							<td>Price: <%=tempPrize %> Kyats</td>
						</tr>
						<tr>						
							<td>
								<%if(tempQty > 0) { %>
								<a href="javascript:detail('<%=tempid%>')" style="color: red; font-weight: bold; text-decoration: none;font-variant: small-caps;">Add To Cart</a>
								<%} else { %>
								<font style="color: red; font-weight: bold; text-decoration: none;font-variant: small-caps;">Out Of Stock</font> 
								<%} %>
							</td>
						</tr>
					</table>
				</td>
				<% if(col==6) { col=0; %>				
			</tr>

			<%} else {col++;}
		
				}
					}
			%>
		</table>
	</s:form>
</body>
</html>