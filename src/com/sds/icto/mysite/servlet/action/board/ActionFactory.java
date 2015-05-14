package com.sds.icto.mysite.servlet.action.board;

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
		
		if ("insert".equals(a)){
			action = new InsertAction();
		} else if ("delete".equals(a)){
			action = new DeleteAction();
		} else if ("edit".equals(a)){
			action = new EditAction();
		} else if ("view".equals(a)){
			action = new ViewAction();
		}
		
		if (action==null){
			action = new IndexAction();
		}
				
		return action;
	}
}
