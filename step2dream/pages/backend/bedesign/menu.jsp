<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>
	<s:url action="home" var="homeLink"></s:url>

	<!-- ################################ Product ################################ -->
	<s:url action="viewProduct" var="viewPLink"></s:url>
	<!-- ################################ End #################################### -->

	<!-- ################################ Employee ############################### -->
	<s:url action="viewemp" var="emplistLink"></s:url>
	<!-- ################################ End #################################### -->

	<!-- ################################ Delivery Charge ######################## -->
	<s:url action="dclist" var="dclistlink"></s:url>
	<!-- ################################ End #################################### -->

	<!-- ################################ Customer ############################### -->
	<s:url action="usrlist" var="usrviewlink"></s:url>
	<!-- ################################ End #################################### -->

	<!-- ################################ Reports ################################ -->
	<s:url action="viewSoldGood" var="viewSoldGoodLink"></s:url>
	<s:url action="viewDeliveredGood" var="viewDeliveredGoodLink"></s:url>
	<s:url action="viewPurchase" var="viewPurchaseLink"></s:url>
	<s:url action="viewDeliveryStatus" var="viewDeliveryStatusLink"></s:url>
	<!-- ################################ End #################################### -->


	<table border="1" style="width:100%; text-align: center; border: thin;">
		<tr style="height: 70px">
			<th><a href="${homeLink}" style="font-variant: small-caps; font-size:xx-large; text-decoration: none;">Back End Menu</a></th>
		</tr>
		<!-- ########################### Product ################################ -->
		<tr style="background-color: #D8D8D8; height: 35px; font-variant: small-caps;">
			<td><a href="${viewPLink}" style="color: red; font-weight: bold; text-decoration: none;" >Product List</a></td>
		</tr>
		<!-- ########################### End #################################### -->

		<!-- ########################### Customer ############################### -->
		
		<tr style="background-color: #D8D8D8; height: 35px; font-variant: small-caps;">
			<td><a href="${usrviewlink}" style="color: red; font-weight: bold; text-decoration: none;">Customer List Form</a></td>
		</tr>
		<!-- ########################### End #################################### -->


		<!-- ########################### Delivery Charge ######################## -->

		<tr style="background-color: #D8D8D8; height: 35px; font-variant: small-caps;">
			<td><a href="${dclistlink}" style="color: red; font-weight: bold; text-decoration: none;">Delivery Information</a></td>
		</tr>
		<!-- ########################### End #################################### -->


		<!-- ########################### Employee ############################### -->

		<tr style="background-color: #D8D8D8; height: 35px; font-variant: small-caps;">
			<td><a href="${emplistLink}" style="color: red; font-weight: bold; text-decoration: none;">Employee Information</a></td>
		</tr>

		<!-- ########################### End #################################### -->


		<!-- ########################### Reports################################# -->
		<tr style="background-color: #D8D8D8; height: 35px; font-variant: small-caps;">
			<td><a href="${viewSoldGoodLink}" style="color: red; font-weight: bold; text-decoration: none;">Sold Good List</a></td>
		</tr>
		<tr style="background-color: #D8D8D8; height: 35px; font-variant: small-caps;">
			<td><a href="${viewDeliveredGoodLink}" style="color: red; font-weight: bold; text-decoration: none;">Delivered List Report</a></td>
		</tr>
		<tr style="background-color: #D8D8D8; height: 35px; font-variant: small-caps;">
			<td><a href="${viewPurchaseLink}" style="color: red; font-weight: bold; text-decoration: none;">Purchase List Report</a></td>
		</tr>
		<tr style="background-color: #D8D8D8; height: 35px; font-variant: small-caps;">
			<td><a href="${viewDeliveryStatusLink}" style="color: red; font-weight: bold; text-decoration: none;">Delivery Status</a></td>
		</tr>
		<!-- ########################### End #################################### -->
	</table>
</body>
</html>
