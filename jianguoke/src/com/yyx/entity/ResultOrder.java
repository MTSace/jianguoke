package com.yyx.entity;

import java.util.ArrayList;
import java.util.List;

public class ResultOrder {
	private String result;
	private List<orderInfo> orderInfo_data=new ArrayList<orderInfo>();
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public List<orderInfo> getOrderInfo_data() {
		return orderInfo_data;
	}
	public void setOrderInfo_data(List<orderInfo> orderInfo_data) {
		this.orderInfo_data = orderInfo_data;
	}
}
