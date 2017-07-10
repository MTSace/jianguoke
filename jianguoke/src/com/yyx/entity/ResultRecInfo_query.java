package com.yyx.entity;

import java.util.ArrayList;
import java.util.List;

public class ResultRecInfo_query {
	private String result;
	private List<recruitInfo> rec_query_data=new ArrayList<recruitInfo>();
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public List<recruitInfo> getRec_query_data() {
		return rec_query_data;
	}
	public void setRec_query_data(List<recruitInfo> rec_query_data) {
		this.rec_query_data = rec_query_data;
	}

}
