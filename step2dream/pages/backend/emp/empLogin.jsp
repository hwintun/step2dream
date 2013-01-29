<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Login</title>
</head>

<body>
<s:form action="loginemp" method="post">
		<table bgcolor="#909090" border="1" align="center" width="40%">
			<tr>
				<td colspan="2" align="center"><h3>Employee Login Form.</h3></td>
			</tr>

			<tr>
				<td colspan=2><s:textfield name="emp.empLoginName"
						label="Login Name" size="30" /></td>
			</tr>

			<tr>
				<td colspan=2><s:password name="emp.empPassword" label="Password"
						size="30" /></td>
			</tr>
			<tr>
				<td colspan=2 align="center"><input type="submit"  value="Sign in" align="center" /></td>
			</tr>

		</table>
	</s:form>
</body>
</html>



