package com.bigdata2017.mysite.action.board;

import com.bigdata2017.web.Action;
import com.bigdata2017.web.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if( "writeform".equals( actionName ) ) {
			action = new WriteFormAction();
		} else if( "write".equals( actionName ) ) {
			action = new WriteAction();
//		} else if( "view".equals( actionName ) ) {
//		} else if( "delete".equals( actionName ) ) {
//		} else if( "replyform".equals( actionName ) ) {
//		} else if( "modifyform".equals( actionName ) ) {
//		} else if( "modify".equals( actionName ) ) {
		} else {
			action = new ListAction();
		}
		
		return action;
	}

}
