package com.swdegao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.DeviceServiceInvocationInDTO;
import com.huawei.iotplatform.client.dto.DeviceServiceInvocationOutDTO;
import com.swdegao.service.DeviceServiceInvocationService;

@RestController
@RequestMapping(value = "/invocation")
public class DeviceServiceInvocationController {
	@Autowired
	public DeviceServiceInvocationService deviceService;
	
	@PostMapping("/invocateDeviceService")
	public Object invocateDeviceService(DeviceServiceInvocationInDTO dsiid) {
		Object obj = null;
		DeviceServiceInvocationOutDTO dOutDTO = null;
		try {
			
			dOutDTO = deviceService.invocateDeviceService(dsiid);
			obj = JSON.toJSON(dOutDTO);
		} catch (NorthApiException e) {
			obj = e.toString();
		}
		return obj;
	}
}
