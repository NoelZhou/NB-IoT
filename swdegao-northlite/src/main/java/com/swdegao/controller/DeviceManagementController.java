package com.swdegao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.ModifyDeviceInfoInDTO;
import com.swdegao.common.ResponseMessage;
import com.swdegao.service.DeviceManagementService;

@RestController
@RequestMapping(value = "/deviceManagement")
public class DeviceManagementController {

	@Autowired
	public DeviceManagementService dmService;

	@GetMapping("/regDirectDevice/{nodeId}")
	public ResponseMessage regDirectDevice(@PathVariable String nodeId) {
		return dmService.regDirectDevice(nodeId);
	}

	@GetMapping("/deleteDirectDevice/{deviceId}")
	public void deleteDirectDevice(@PathVariable String deviceId) throws NorthApiException{
		dmService.deleteDirectDevice(deviceId);
	}

	/**
	 * Body: { 
	 * "name":"****", 
	 * "deviceId":"",
	 * "manufacturerName":"",
	 * "manufacturerId":"",
	 * "endUser":"****" 
	 * }
	 * @param mdiid
	 * @return
	 */
	@RequestMapping(value = "/modifyDeviceInfo", method = { RequestMethod.POST, RequestMethod.GET })
	public void modifyDeviceInfo(@RequestBody ModifyDeviceInfoInDTO mdiid) throws NorthApiException {
		dmService.modifyDeviceInfo(mdiid);
	}

	@GetMapping("/refreshDeviceSecret/{deviceId}&{nodeId}")
	public ResponseMessage refreshDeviceSecret(@PathVariable String deviceId, @PathVariable String nodeId) {
		return dmService.refreshDeviceSecret(deviceId, nodeId);
	}

}
