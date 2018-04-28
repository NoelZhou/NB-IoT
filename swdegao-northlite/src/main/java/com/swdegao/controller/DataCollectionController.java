package com.swdegao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.QueryDataHistoryOutDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCapabilitiesOutDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceDataOutDTO;
import com.swdegao.service.DataCollectionService;


@RestController
@RequestMapping(value = "/dataCollection")
public class DataCollectionController {
	
	@Autowired
	public DataCollectionService dcService;
	
	@GetMapping("/queryDeviceData/{deviceId}")
	public Object queryDeviceData(@PathVariable String deviceId) {
		Object obj = null;
		QueryDeviceDataOutDTO qddod = null;
		try {
			qddod = dcService.queryDeviceData(deviceId);
			if(qddod!=null) {
				obj = JSON.toJSON(qddod);
			}
		} catch (NorthApiException e) {
			obj = e.toString();
		}
		return obj;
	}
	@GetMapping("/subscribeNotify/deviceDataChanged")
	public void subscribeNotify() throws NorthApiException {
		dcService.subscribeNotify();
	}
	
	@GetMapping("/queryDataHistory/{deviceId}&{gatewayId}")
	public Object queryDataHistory(@PathVariable String deviceId,@PathVariable String gatewayId) {
		Object obj = null;
		QueryDataHistoryOutDTO qdhod = null;
		try {
			qdhod = dcService.queryDataHistory(deviceId, gatewayId);
			if(qdhod!=null) {
				obj = JSON.toJSON(qdhod);
			}
		} catch (NorthApiException e) {
			obj = e.toString();
		}
		return obj;
	}
	
	@GetMapping("/queryDeviceCapabilities/{deviceId}")
	public Object queryDeviceCapabilities(@PathVariable String deviceId) {
		Object obj = null;
		QueryDeviceCapabilitiesOutDTO qdcod = null;
		try {
			qdcod = dcService.queryDeviceCapabilities(deviceId);
			if(qdcod!=null) {
				obj = JSON.toJSON(qdcod);
			}
		} catch (NorthApiException e) {
			obj = e.toString();
		}
		return obj;
	}
}












