<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>
<head>

<script type="text/javascript">
	function saveEntry() {
		document.a.action = "dcentry.action";
		document.a.submit();
	}
	function cancelEntry() {
		document.a.action = "dclist.action";
		document.a.submit();
	}
</script>

<title>Delivery Charge (Entry)</title>

</head>

<center>
	<font color="red"><s:actionerror /></font>
</center>

<s:form name="a" action="post">

	<table bgcolor=#909090 border=1 align="center" width="30%">
		<tr>
			<td colspan=2 align="center"><h3>Delivery Charge List Form</h3></td>
		</tr>

		<tr>
			<td><s:textfield name="township" key="label.township" size="50" /></td>
		</tr>

		<tr>
			<td><s:textfield name="prize" key="label.prize" size="50" /></td>
		</tr>

		<tr>
			<td colspan="2" align="center"><input type="button"
				value=" Save " onclick="saveEntry();"><input type="button"
				value="Cancel" onclick="cancelEntry();"></td>
		</tr>
	</table>
</s:form>
</body>
</html>
