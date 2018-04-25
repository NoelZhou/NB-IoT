package com.swdegao.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.RegDirectDeviceInDTO;
import com.huawei.iotplatform.client.dto.RegDirectDeviceOutDTO;
import com.swdegao.common.ApplicationConfig;
import com.swdegao.service.DeviceManagementService;

@Component
public class DeviceManagementServiceImpl implements DeviceManagementService {

	@Autowired
	public ApplicationConfig appConfig;
	
	@Override
	public RegDirectDeviceOutDTO regDirectDevice(RegDirectDeviceInDTO rddid, String appId, String accessToken)
			throws NorthApiException {
		
		
		
		return null;
	}
	
}
