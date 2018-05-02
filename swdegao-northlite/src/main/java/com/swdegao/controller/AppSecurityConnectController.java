package com.swdegao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.huawei.iotplatform.client.NorthApiException;
import com.swdegao.common.ResponseMessage;
import com.swdegao.service.AppSecurityConnectService;

@RestController
@RequestMapping(value="/auth")
public class AppSecurityConnectController {
	
	@Autowired
	public AppSecurityConnectService appConnectService;
	
	@GetMapping("/getAuthToken")
	public ResponseMessage login(){
		return appConnectService.getAuthToken();
	}
	
	@GetMapping("/refreshToken")
	public ResponseMessage substributeNotfiy(){
		return appConnectService.refreshAuthToken();
	}
	
	@GetMapping("/logout")
	public void logout() throws NorthApiException {
		appConnectService.logout();
	}
}

  













