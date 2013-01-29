<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>
<head>
<title>Customer (Create)</title>
<script type="text/javascript">
	function cancelEntry() {
		document.a.action = "usrlist.action";
		document.a.submit();
	}
	function saveEntry() {
		document.a.action = "usrsave.action";
		document.a.submit();
	}
</script>
</head>
<body>
	<center>
		<font color="red"> <s:actionerror /></font>
	</center>

	<s:form name="a" method="post">

		<table border="1" bgcolor=#909090 align="center" width="40%">

			<tr>
				<td colspan=2 align="center"><h3>Customer Registration
						Form</h3></td>
			</tr>

			<tr>
				<td><s:textfield name="regUsrFName" key="label.regUsrFName"
						size="30" /></td>
			</tr>

			<tr>
				<td><s:textfield name="regUsrLName" key="label.regUsrLName"
						size="30" /></td>
			</tr>

			<tr>
				<td><s:password name="regUsrPassword"
						key="label.regUsrPassword" size="30" /></td>
			</tr>

			<tr>
				<td><s:textarea name="regUsrAddress" key="label.regUsrAddress"
						rows="2" /></td>
			</tr>

			<tr>
				<td><s:textfield name="regUsrPhone" key="label.regUsrPhone"
						size="30" /></td>
			</tr>

			<tr>
				<td><s:textfield name="regUsrEmail" key="label.regUsrEmail"
						size="30" /></td>
			</tr>


			<tr>
				<td colspan="2" align="center"><input type="submit"
					value=" Save " onclick="saveEntry();" /> <input type="button"
					value="Cancel" onclick="cancelEntry();" /></td>

			</tr>

		</table>
	</s:form>

</body>
</html>
