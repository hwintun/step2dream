<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Employee (Entry)</title>
<script type="text/javascript">
	function cancelEntry() {
		document.a.action = "viewemp.action";
		document.a.submit();
	}
	function saveEntry() {
		document.a.action = "empSave.action";
		document.a.submit();
	}
</script>
</head>

<body>
	<center>
		<font color="red"> <s:actionerror />
		</font>
	</center>

	<s:form name="a" action="post">
		<table border="1" bgcolor=#909090 align="center" width="45%">

			<tr>
				<td colspan="2" align="center"><h3>Employee Registration Form.</h3></td>
			</tr>
			<tr>
				<td colspan=2><s:textfield name="empLoginName"
						key="label.empLoginName" size="40" /></td>
			</tr>
			<tr>
				<td colspan=2><s:password name="empPassword"
						key="label.empPassword" size="40" /></td>
			</tr>
			<tr>
				
				<td colspan="2" align="center"><input type="submit" value=" Save " onclick="saveEntry();" />
					<input type="button" value="Cancel" onclick="cancelEntry();" /></td>

			</tr>

		</table>
	</s:form>



</body>
</html>
