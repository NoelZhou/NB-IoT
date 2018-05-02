package com.swdegao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.huawei.iotplatform.client.dto.DeviceServiceInvocationInDTO;
import com.swdegao.common.ResponseMessage;
import com.swdegao.service.DeviceServiceInvocationService;

@RestController
@RequestMapping(value = "/invocation")
public class DeviceServiceInvocationController {
	@Autowired
	public DeviceServiceInvocationService deviceService;

	/**
	 * Body: 
	 * { 
	 * "header": { 
	 * 			 "mode": "ACK", 
	 *			 "from": "/users/23212121", 
	 *			 "method":"INVITE-INIT", 
	 *			 "callbackURL":"https://186.25.1.49:8043/na/iocm/message/confirm" 
	 * 			}, 
	 * "body": { 
	 * 		  	"from":"************", 
	 * 			"sessionID": "**********", 
	 * 			"sdp": "**********" 
	 * 			} 
	 * }
	 * @param dsiid
	 * @return
	 */
	@PostMapping("/invocateDeviceService")
	public ResponseMessage invocateDeviceService(@RequestBody DeviceServiceInvocationInDTO dsiid) {
		return deviceService.invocateDeviceService(dsiid);
	}
}
