package com.java.sagitt.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.java.sagitt.service.UserMgr;

import java.util.List;

public class AbstractController {

	@Autowired
	protected UserMgr userMgr;

	protected List<String> errMsgs;
		



	// GET-SET=========================================================================================================


	public UserMgr getUserMgr() {
		return userMgr;
	}

	public void setUserMgr(UserMgr userMgr) {
		this.userMgr = userMgr;
	}

	public List<String> getErrMsgs() {
		return errMsgs;
	}

	public void setErrMsgs(List<String> errMsgs) {
		this.errMsgs = errMsgs;
	}
}
