package com.swdegao.common;

/**
 * 返回JSON数据
 * @author zhoutao
 */
public class ResponseMessage {
	/**
	 * 代码
	 */
	private int code;
	/**
	 * 描述，数据存储的KEY
	 */
	private Object desc;
	/**
	 * HTTP状态码
	 */
	private int statusCode;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object getDesc() {
		return desc;
	}
	public void setDesc(Object desc) {
		this.desc = desc;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
}
