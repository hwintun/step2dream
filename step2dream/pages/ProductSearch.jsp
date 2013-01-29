<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title></title>
</head>
<body>	
    <br/><br/>
    <center>
    <font color="red">
			<s:actionerror/>
    </font>
    </center>
    	<h2 align="center">Search Product</h2>
     <s:form action="productSearch">
      <table align="center"> 
     		<tr>
     			<td colspan="2"> <s:select label="Category" headerKey="-1" headerValue="Select Category" list="catList" name="p.productCategory" />
     			 </td>
     		</tr>
     		<tr>
     			<td colspan="2"> 
     				<s:submit label="View" align="center"/> 					
				</td>
			</tr>
			</table>
	</s:form>
</body>
</html>