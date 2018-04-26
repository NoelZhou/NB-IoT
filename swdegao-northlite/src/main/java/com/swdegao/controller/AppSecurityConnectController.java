package com.swdegao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.huawei.iotplatform.client.NorthApiException;
import com.swdegao.service.AppSecurityConnectService;

@RestController
public class AppSecurityConnectController {
	
	@Autowired
	public AppSecurityConnectService appConnectService;
	
	@GetMapping("/getAuthToken")
	public Object login(){
		Object obj=null;
		try {
			obj = JSON.toJSON(appConnectService.getAuthToken());
		} catch (NorthApiException e) {
			obj = e.toString();
		}
		return obj;
	}
	@GetMapping("/refreshToken")
	public Object substributeNotfiy(){
		Object obj=null;
		try {
			obj = JSON.toJSON(appConnectService.refreshAuthToken());
		} catch (NorthApiException e) {
			obj = e.toString();
		}
		return obj;
	}
	
	@GetMapping("/logout")
	public void logout() throws NorthApiException {
		appConnectService.logout();
	}
}

  













