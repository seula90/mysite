package com.sds.icto.mysite.servlet.action.guestbook;

import com.sds.icto.mysite.servlet.action.main.IndexAction;
import com.sds.icto.mysite.servlet.action.member.JoinAction;
import com.sds.icto.mysite.servlet.action.member.JoinFormAction;
import com.sds.icto.mysite.servlet.action.member.JoinSuccessAction;
import com.sds.icto.mysite.servlet.action.member.LoginAction;
import com.sds.icto.mysite.servlet.action.member.LoginFormAction;
import com.sds.icto.mysite.servlet.action.member.LogoutAction;
import com.sds.icto.mysite.servlet.action.member.UinfoAction;
import com.sds.icto.web.Action;

public class ActionFactory {
	private static ActionFactory instance;
	static {
		instance = new ActionFactory();
	}
	
	private ActionFactory(){
		
	}
	
	public static ActionFactory getInstance(){
//		if (instance == null){
//			instance = new ActionFactory();
//		}
		return instance;
	}
	
	public Action getAction(String a) {
		Action action = null;
		if ("list".equals(a)){
			action = new ListAction();
		} else if ("deleteform".equals(a)){
			action = new DeleteFormAction();
		} else if ("delete".equals(a)){
			action = new DeleteAction();
		}
		
		if (action==null){
			action = new IndexAction();
		}
				
		return action;
	}
}
