package com.swdegao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.SubscribeInDTO;
import com.swdegao.common.ResponseMessage;
import com.swdegao.service.DataCollectionService;

@RestController
@RequestMapping(value = "/dataCollection")
public class DataCollectionController {

	@Autowired
	public DataCollectionService dcService;

	@GetMapping("/queryDeviceData/{deviceId}")
	public ResponseMessage queryDeviceData(@PathVariable String deviceId) {
		return  dcService.queryDeviceData(deviceId);
	}

	/**
	 * Body: 
	 * { 
	 * "notifyType":"deviceInfoChanged",
	 * "callbackurl":"https://server:port/callbackUri" 
	 * }
	 * @param sid
	 * @throws NorthApiException
	 */
	@PostMapping("/subscribeNotify")
	public void subscribeNotify(@RequestBody SubscribeInDTO sid) throws NorthApiException {
		dcService.subscribeNotify(sid);
	}

	@GetMapping("/queryDataHistory/{deviceId}&{gatewayId}")
	public ResponseMessage queryDataHistory(@PathVariable String deviceId, @PathVariable String gatewayId) {
		return dcService.queryDataHistory(deviceId, gatewayId);
	}

	@GetMapping("/queryDeviceCapabilities/{deviceId}")
	public ResponseMessage queryDeviceCapabilities(@PathVariable String deviceId) {
		return dcService.queryDeviceCapabilities(deviceId);
	}
}
