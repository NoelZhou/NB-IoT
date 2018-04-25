package com.swdegao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.huawei.iotplatform.client.NorthApiException;
import com.swdegao.service.AppSecurityConnectService;

@RestController
public class AppSecurityConnectController {
	
	@Autowired
	public AppSecurityConnectService appConnectService;
	
	@PostMapping("/login")
	public void login() throws NorthApiException {
		appConnectService.getAuthToken();
//		System.out.println(appConnectService.getAuthToken());
	}
	@GetMapping("/refeshToken/{}")
	public void substributeNotfiy() throws NorthApiException {
		appConnectService.refreshAuthToken();
//		System.out.println(appConnectService.refreshAuthToken());
	}
	
	@PostMapping("/logout")
	public void logout() throws NorthApiException {
		appConnectService.logout();
	}
}















