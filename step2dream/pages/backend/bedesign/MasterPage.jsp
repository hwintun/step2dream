<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head>
<title></title>
</head>

<body style="background-color: #FAFAFA">
	<table style="width: 100%;">
		<tr style="height: 80px">
			<td><tiles:insertAttribute name="header" /></td>
		</tr>
		<tr>
			<td>
				<table style="width:80%; margin-left: auto; margin-right: auto; height: 500px " border="1">
					<tr style="vertical-align: top;">
						<td style="width: 20%;"><tiles:insertAttribute
								name="menu" /></td>
						<td><tiles:insertAttribute
								name="body" /></td>
					</tr>
				</table>
		<tr>
			<td height="10%"><tiles:insertAttribute name="footer" /></td>
		</tr>
	</table>
</body>
</html>
