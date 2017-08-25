package com.bigdata2017.mysite.action.main;

import com.bigdata2017.web.Action;
import com.bigdata2017.web.ActionFactory;

public class MainActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		return new MainAction();
	}

}
