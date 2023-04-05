package controller;

import controller.action.JoinAction;
import controller.action.ModifyAction;

public class ActionFactory {

	private ActionFactory() {}
	
	private static ActionFactory instance = new ActionFactory();
	// 단 하나의 인스턴스를 외부에서 사용하기 위함
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("join")) {
			action = new JoinAction();
		}
		else if(command.equals("modify")) {
			action = new ModifyAction();
		}
		
		return action;
	}
}
