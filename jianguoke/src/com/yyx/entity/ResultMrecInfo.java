package com.yyx.entity;

import java.util.ArrayList;
import java.util.List;

public class ResultMrecInfo {
	private int result;
	private List<mrecInfo> merc_query_data=new ArrayList<mrecInfo>();
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public List<mrecInfo> getMerc_query_data() {
		return merc_query_data;
	}
	public void setMerc_query_data(List<mrecInfo> merc_query_data) {
		this.merc_query_data = merc_query_data;
	}

}
