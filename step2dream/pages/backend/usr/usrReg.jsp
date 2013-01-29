<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>

	<br>
	<br>
	<center>
		<font color="red"> <s:actionerror />
		</font>
	</center>
	
	<%
		String prePage = (String) request.getParameter("prePage");
		session.removeAttribute("previousPage");
		System.out.println("user register page" + prePage);
		if(prePage != null) {
			if(prePage.equals("viewShoppingCart")){
				session.setAttribute("previousPage", "viewShoppingCart");
			}
		}
	%>
	<s:form action="usrRegSave">
		<table align="center">
			<tr>
				<th colspan=2 align="center"><b>Customer Registration Form</b></th>
			</tr>
			<tr>
				<td colspan=2>
					<hr size=3 color="gray" />
				</td>
			</tr>

			<tr>
				<td colspan=2><s:textfield name="regUsrFName"
						key="label.regUsrFName" size="30" /></td>
			</tr>

			<tr>
				<td colspan=2><s:textfield name="regUsrLName"
						key="label.regUsrLName" size="30" /></td>
			</tr>

			<tr>
				<td colspan=2><s:password name="regUsrPassword"
						key="label.regUsrPassword" size="30" /></td>
			</tr>

			<tr>
				<td colspan=2><s:textarea name="regUsrAddress"
						key="label.regUsrAddress" rows="2" /></td>
			</tr>

			<tr>
				<td colspan=2><s:textfield name="regUsrPhone"
						key="label.regUsrPhone" size="30" /></td>
			</tr>

			<tr>
				<td colspan=2><s:textfield name="regUsrEmail"
						key="label.regUsrEmail" size="30" /></td>
			</tr>

			<tr>
				<td colspan=2>
					<hr size=3 color="gray" />
				</td>
			</tr>

			<tr>
				<td colspan="2" style="text-align: center">
					<input type="submit" value="  Save  " />
					<input type="reset" value=" Reset " />
				</td>
			</tr>

		</table>
	</s:form>



</body>
</html>
