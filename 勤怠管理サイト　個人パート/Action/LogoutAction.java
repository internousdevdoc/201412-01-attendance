package jp.co.internous.action;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

	public  String execute(){
		if(LoginAction.sessionMap!=null){
			LoginAction.sessionMap.remove("USERNAME");
			LoginAction.sessionMap.remove("USERPASSWD");

		}
		return "success";
	}

}
