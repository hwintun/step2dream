<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title></title>
<style type="text/css">
.mytd {
	font-style: normal;
	color: yellow;
}
h1 {
	color: green;
	text-align: center;
}
h2 {
	color: green;
	text-align: center;
}
</style>
</head>
<body>
	<s:url action="viewLogin" var="viewLoginLink"></s:url>
	<s:url action="usrReg" var="usrReg"></s:url>
	<s:url action="logout" var="LogoutLink"></s:url>
	<s:url action="empLoginStart" var="empLoginLink"></s:url>
	<s:url action="empLogout" var="empLogoutLink"></s:url>
	
	<table width="100%">
		<tr>
			<td>
				<h1>Step To Dream Online Shoe Gallery</h1>
			</td>
		</tr>
	</table>

	<table align="right" bgcolor="green" width="100%">
		<%
			String status = (String) session.getAttribute("status");
			if (status == null)
				status = "false";
			int adminstatus = 0;
			Object temp = session.getAttribute("login-status");
			if (temp != null) {
				adminstatus = Integer.parseInt(temp.toString()); 
				if (adminstatus < 0)
					adminstatus = 0;
			}
		%>
		<tr>
			<td width="85%"></td>
			<td class="mytd">
				<%
					if (adminstatus > 0) {
				%> <a href="${empLogoutLink}" style="color: yellow; font-weight: bold; text-decoration: none;font-variant: small-caps;">Logout (Admin)</a> <%
 	} else {
 %> <a href="${empLoginLink}" style="color: yellow; font-weight: bold; text-decoration: none; font-variant: small-caps;">Admin</a> <%
 	}
 %></font>
			</td>
			<td class="mytd"><a href="${usrReg}" style="color: yellow; font-weight: bold; text-decoration: none;font-variant: small-caps;">Register</a></td>
			<td class="mytd">
				<%
				Object usrtemp = session.getAttribute("usrlogin-status");
				int usrstatus = 0;
				if (usrtemp != null) {
					usrstatus = Integer.parseInt(usrtemp.toString()); 
					if (usrstatus < 0)
						usrstatus = 0;
				}					
					if (usrstatus > 0) {
				%> <a href="${LogoutLink}" style="color: yellow; font-weight: bold; text-decoration: none;font-variant: small-caps;">Logout</a> <%
 	} else {
 %> <a href="${viewLoginLink}" style="color: yellow; font-weight: bold; text-decoration: none;font-variant: small-caps;">Login</a> <%
 	}
 %>
			</td>
		</tr>

	</table>


</body>
</html>
