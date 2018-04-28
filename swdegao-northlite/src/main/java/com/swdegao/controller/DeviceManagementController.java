package com.swdegao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.ModifyDeviceInfoInDTO;
import com.huawei.iotplatform.client.dto.RefreshVerifyCodeOutDTO;
import com.huawei.iotplatform.client.dto.RegDirectDeviceOutDTO;
import com.swdegao.service.DeviceManagementService;

@RestController
@RequestMapping(value = "/deviceManagement")
public class DeviceManagementController {

	@Autowired
	public DeviceManagementService dmService;
	
	@GetMapping("/regDirectDevice/{nodeId}")
	public Object regDirectDevice(@PathVariable String nodeId) {
		Object obj = null;
		if(nodeId!=null) {
			RegDirectDeviceOutDTO rddod = null;
			try {
				rddod = dmService.regDirectDevice(nodeId);
				if(rddod!=null) {
					obj = JSON.toJSON(rddod);
				}
			} catch (NorthApiException e) {
				obj = e.toString();
			}
		}else {
			obj ="redirect:/error";
		}
		return obj;
	}
	
	@GetMapping("/deleteDirectDevice/{deviceId}")
	public Object deleteDirectDevice(@PathVariable String deviceId) {
		Object obj = null;
		try {
			dmService.deleteDirectDevice(deviceId);
			obj = "No Content";
		} catch (NorthApiException e) {
			obj = e.toString();
		}
		return obj;
	}
	
	@RequestMapping(value = "/modifyDeviceInfo", method = { RequestMethod.POST, RequestMethod.GET })  
	public Object modifyDeviceInfo(@RequestBody ModifyDeviceInfoInDTO mdiid) {
		Object obj = null;
//		  mdiid.setName("newDeviceName");
//        mdiid.setDeviceId(deviceId);
//        mdiid.setManufacturerId("CompanyId");
//        mdiid.setManufacturerName("CompanyName");
//        mdiid.setDeviceType("WaterMeter");
//        mdiid.setModel("SDKDEMO");
//        mdiid.setProtocolType("CoAP");
		try {
			dmService.modifyDeviceInfo(mdiid);
			obj = "No Content";
		} catch (NorthApiException e) {
			obj = e.toString();
		}
		return obj;
	}
	
	@GetMapping("/refreshDeviceSecret/{deviceId}&{nodeId}")
	public Object refreshDeviceSecret(@PathVariable String deviceId,@PathVariable String nodeId) {
		Object obj = null;
		RefreshVerifyCodeOutDTO rdsod = null;
		try {
			rdsod = dmService.refreshDeviceSecret(deviceId, nodeId);
			obj = JSON.toJSON(rdsod);
		} catch (NorthApiException e) {
			obj = e.toString();
		}
		return obj;
	}
	
}





















