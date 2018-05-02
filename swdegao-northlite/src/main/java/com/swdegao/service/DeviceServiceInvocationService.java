package com.swdegao.service;

import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.DeviceServiceInvocationInDTO;
import com.swdegao.common.ResponseMessage;

public interface DeviceServiceInvocationService {
	
	/**
	 * 设备服务调用
	 * @param dsiid
	 * @return
	 * @throws NorthApiException
	 */
	public ResponseMessage invocateDeviceService(DeviceServiceInvocationInDTO dsiid);
}
