<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
	String prePage = (String) request.getAttribute("previousPage");
	session.removeAttribute("previousPage");
	System.out.println(prePage);
	if(prePage != null) {
		if(prePage.equals("confirmAddress")){
			session.setAttribute("previousPage", "confirmAddress");
		}
	}
%>
<font color="red"><s:actionerror/></font>
	<s:form action="login.action" method="post">
		<table>
			<tr>
				<td><s:textfield name="u.regUsrLName" label="Login ID" /></td>
			</tr>
			<tr>
				<td><s:password name="u.regUsrPassword" label="Password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value=" Login " align="center" />
				<%if(prePage == null) {
					%>
					<input type="button" value="Register" onclick='window.open("http://localhost:8080/step2dream/usrReg.action", "_self");' />
					<%
				} else {
					%>
					<input type="button" value="Register" onclick='window.open("http://localhost:8080/step2dream/usrReg.action?prePage=<%=prePage %>", "_self");' />
					<%
				}
					%>
				
				</td>
			</tr>
		</table>		
	</s:form>
</body>
</html>