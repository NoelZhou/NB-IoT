package com.swdegao.common;

import com.alibaba.fastjson.JSON;
import com.huawei.iotplatform.client.NorthApiException;

public class ResponseUtils{

	/**
	 * 请求成功-返回数据
	 * @param obj
	 * @return
	 */
	public static ResponseMessage responseSuccessed(Object obj) {
		ResponseMessage resMessage = new ResponseMessage();
		resMessage.setCode(100000);
		resMessage.setDesc(JSON.toJSON(obj));
		resMessage.setStatusCode(200);
		return resMessage;
	}
	
	/**
	 * 请求失败-返回错误内容
	 * @param e
	 * @return
	 */
	public static ResponseMessage responseFailed(NorthApiException e) {
		ResponseMessage resMessage = new ResponseMessage();
		resMessage.setCode(Integer.parseInt(e.getError_code()));
		resMessage.setDesc(e.getError_desc());
		resMessage.setStatusCode(e.getHttpStatusCode());
		return resMessage;
	}
	
}
