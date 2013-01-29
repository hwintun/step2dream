package com.step2dream.login.user;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserLogoutAction extends ActionSupport {
	
	@Override
	public String execute() throws Exception {
		Map m = ActionContext.getContext().getSession();
		m.remove("usrlogin-status");
		m.remove("previousPage");
		return SUCCESS;
	}

}
