<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Login</title>
</head>

<body>

	<table align="center">
		<tr>
			<th colspan=2 align="center"><b>Customer Login Page</b></th>
		</tr>

		<tr>
			<td colspan=2>
				<hr size=3 color="gray" />
			</td>
		</tr>

		<tr>
			<td colspan=2><s:textfield name="LoginName"
					key="label.LoginName" size="30" /></td>
		</tr>

		<tr>
			<td colspan=2><s:password name="Password" key="label.Password"
					size="30" /></td>
		</tr>

		<tr>
			<td colspan=2>
				<hr size=3 color="gray" />
			</td>
		</tr>

		<tr>
			<td colspan=2><s:submit key="label.submit" align="center" /></td>
			<td colspan=2><s:reset key="label.reset" align="center" /></td>
		</tr>

	</table>

</body>
</html>



