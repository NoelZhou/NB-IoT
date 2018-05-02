package com.swdegao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.DeviceCmdCancelTaskOutDTO;
import com.huawei.iotplatform.client.dto.PostDeviceCommandInDTO;
import com.huawei.iotplatform.client.dto.PostDeviceCommandOutDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCmdCancelTaskOutDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCommandOutDTO;
import com.huawei.iotplatform.client.dto.UpdateDeviceCmdInDTO;
import com.huawei.iotplatform.client.dto.UpdateDeviceCmdOutDTO;
import com.swdegao.service.SigtranService;

@RestController
@RequestMapping(value = "/sigtran")
public class SigtranController {

	@Autowired
	public SigtranService sigtranService;
	/**
	 * Body:  
		{ 
		       "deviceId": "********", 
		       "command": { 
		               "serviceId": "********", 
		               "method": "********", 
		               "paras": { 
		                       "paraName1": "paraValue1", 
		                       "paraName2": "paraValue2"        
		        }    
		    }, 
		       "callbackUrl": "https://server:port/callbackUri" 
		} 
	 * @param pdcid
	 * @return
	 */
	@PostMapping("/postDeviceCommand")
	public Object postDeviceCommand(@RequestBody PostDeviceCommandInDTO pdcid) {
		Object obj = null;
		PostDeviceCommandOutDTO pdcod = null;
		try {
			pdcod = sigtranService.postDeviceCommand(pdcid);
			obj = JSON.toJSON(pdcod);
		} catch (NorthApiException e) {
			obj = e.toString();
		}
		return obj;
	}
	@GetMapping("/queryDeviceCommand/{deviceId}")
	public Object queryDeviceCommand(@PathVariable String deviceId) {
		Object obj = null;
		QueryDeviceCommandOutDTO qDeviceCommandOutDTO = null;
		try {
			qDeviceCommandOutDTO = sigtranService.queryDeviceCommand(deviceId);
			obj = JSON.toJSON(qDeviceCommandOutDTO);
		} catch (NorthApiException e) {
			obj = e.toString();
		}
		return obj;
	}
	/**
	 * 
	    // UpdateDeviceCmdInDTO udcid = new UpdateDeviceCmdInDTO();
		// String deviceCommandId = "bfeb4ba5c2644aae87b3188beb13539f";
		// udcid.setDeviceCommandId(deviceCommandId);
		// UpdateDeviceCmdReq udcr = new UpdateDeviceCmdReq();
		// udcr.setStatus("CANCELED");
		// udcid.setUpdateDeviceCommandReq(udcr);
	 * @param udcid
	 * @return
	 */
	@PostMapping("/updateDeviceCommand")
	public Object updateDeviceCommand(@RequestBody UpdateDeviceCmdInDTO udcid) {
		Object obj = null;
		UpdateDeviceCmdOutDTO uDto = null;
		try {
			uDto = sigtranService.updateDeviceCommand(udcid);
			obj = JSON.toJSON(uDto);
		} catch (NorthApiException e) {
			obj = e.toString();
		}
		return obj;
	}
	@GetMapping("/createDeviceCmdCancelTaskV4/{deviceId}")
	public Object createDeviceCmdCancelTaskV4(@PathVariable String deviceId) {
		Object obj = null;
		DeviceCmdCancelTaskOutDTO dOutDTO = null;
		try {
			dOutDTO = sigtranService.createDeviceCmdCancelTaskV4(deviceId);
			obj = JSON.toJSON(dOutDTO);
		} catch (NorthApiException e) {
			obj = e.toString();
		}
		return obj;
	}
	@GetMapping("/queryDeviceCmdCancelTask/{deviceId}")
	public Object queryDeviceCmdCancelTask(@PathVariable String deviceId) {
		Object obj = null;
		QueryDeviceCmdCancelTaskOutDTO qOutDTO = null;
		try {
			qOutDTO = sigtranService.queryDeviceCmdCancelTask(deviceId);
			obj = JSON.toJSON(qOutDTO);
		} catch (NorthApiException e) {
			obj = e.toString();
		}
		return obj;
	}
}
