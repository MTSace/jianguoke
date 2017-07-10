package com.yyx.vae.dao;

import com.yyx.entity.stuInfo;

public class stuLoginResult {
	private int result;
	private stuInfo stuloginInfo;
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public stuInfo getStuloginInfo() {
		return stuloginInfo;
	}
	public void setStuloginInfo(stuInfo stuloginInfo) {
		this.stuloginInfo = stuloginInfo;
	}
}
