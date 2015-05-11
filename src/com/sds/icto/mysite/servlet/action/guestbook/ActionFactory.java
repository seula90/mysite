package com.sds.icto.mysite.servlet.action.guestbook;

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
		} else if ("insert".equals(a)){
			action = new AddAction();
		}
		
		if (action==null){
			action = new ListAction();
		}
				
		return action;
	}
}
