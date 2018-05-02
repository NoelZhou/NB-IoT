package com.swdegao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.huawei.iotplatform.client.dto.PostDeviceCommandInDTO;
import com.huawei.iotplatform.client.dto.UpdateDeviceCmdInDTO;
import com.swdegao.common.ResponseMessage;
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
	public ResponseMessage postDeviceCommand(@RequestBody PostDeviceCommandInDTO pdcid) {
		return sigtranService.postDeviceCommand(pdcid);
	}
	
	@GetMapping("/queryDeviceCommand/{deviceId}")
	public ResponseMessage queryDeviceCommand(@PathVariable String deviceId) {
		return sigtranService.queryDeviceCommand(deviceId);
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
	public ResponseMessage updateDeviceCommand(@RequestBody UpdateDeviceCmdInDTO udcid) {
		return sigtranService.updateDeviceCommand(udcid);
	}
	
	@GetMapping("/createDeviceCmdCancelTaskV4/{deviceId}")
	public ResponseMessage createDeviceCmdCancelTaskV4(@PathVariable String deviceId) {
		return sigtranService.createDeviceCmdCancelTaskV4(deviceId);
	}
	
	@GetMapping("/queryDeviceCmdCancelTask/{deviceId}")
	public ResponseMessage queryDeviceCmdCancelTask(@PathVariable String deviceId) {
		return sigtranService.queryDeviceCmdCancelTask(deviceId);
	}
}
