package com.step2dream.login.admin;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EmpLogoutAction extends ActionSupport {
	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		session.remove("login-status");
		return SUCCESS;
	}
}
