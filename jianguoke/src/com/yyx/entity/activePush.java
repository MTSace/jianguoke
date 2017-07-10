package com.yyx.entity;

public class activePush {
	private int act_infoid;
	private String act_content;
	private String act_image;
	private String act_starttime;
	private String act_endtime;
	private String act_createtime;
	private String act_updatetime;
	private int act_state;
	private String act_title;

	public String getAct_title() {
		return act_title;
	}

	public void setAct_title(String act_title) {
		this.act_title = act_title;
	}

	public int getAct_infoid() {
		return act_infoid;
	}

	public void setAct_infoid(int act_infoid) {
		this.act_infoid = act_infoid;
	}

	public String getAct_content() {
		return act_content;
	}

	public void setAct_content(String act_content) {
		this.act_content = act_content;
	}

	public String getAct_starttime() {
		return act_starttime;
	}

	public void setAct_starttime(String act_starttime) {
		this.act_starttime = act_starttime;
	}

	public String getAct_endtime() {
		return act_endtime;
	}

	public void setAct_endtime(String act_endtime) {
		this.act_endtime = act_endtime;
	}

	public String getAct_createtime() {
		return act_createtime;
	}

	public void setAct_createtime(String act_createtime) {
		this.act_createtime = act_createtime;
	}

	public String getAct_updatetime() {
		return act_updatetime;
	}

	public void setAct_updatetime(String act_updatetime) {
		this.act_updatetime = act_updatetime;
	}

	public int getAct_state() {
		return act_state;
	}

	public void setAct_state(int act_state) {
		this.act_state = act_state;
	}

	public activePush() {
		super();
	}

	public activePush(String act_content) {
		super();
		this.act_content = act_content;
	}

	public activePush(String act_content, String act_starttime) {
		super();
		this.act_content = act_content;
		this.act_starttime = act_starttime;
	}

	public activePush(String act_content, String act_starttime,
			String act_endtime) {
		super();
		this.act_content = act_content;
		this.act_starttime = act_starttime;
		this.act_endtime = act_endtime;
	}

	public String getAct_image() {
		return act_image;
	}

	public void setAct_image(String act_image) {
		this.act_image = act_image;
	}

}
