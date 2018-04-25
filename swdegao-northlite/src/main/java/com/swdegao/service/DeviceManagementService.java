package com.swdegao.service;

import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.RegDirectDeviceInDTO;
import com.huawei.iotplatform.client.dto.RegDirectDeviceOutDTO;

public interface DeviceManagementService {
	
	public RegDirectDeviceOutDTO regDirectDevice(RegDirectDeviceInDTO rddid, String appId, String accessToken) throws NorthApiException;
}
