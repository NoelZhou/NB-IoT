package com.swdegao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.huawei.iotplatform.client.NorthApiException;
import com.swdegao.service.AppSecurityConnectService;

@RestController
public class AppSecurityConnectController {
	
	@Autowired
	public AppSecurityConnectService appConnectService;
	
	@GetMapping("/login")
	public void login() throws NorthApiException {
//		appConnectService.getAuthToken();
		System.out.println(appConnectService.getAuthToken());
	}
	@GetMapping("/refeshToken/{refeshToken}")
	public void substributeNotfiy(@PathVariable String refeshToken) throws NorthApiException {
//		appConnectService.refreshAuthToken();
		System.out.println(appConnectService.refreshAuthToken(refeshToken));
	}
	
	@PostMapping("/logout")
	public void logout() throws NorthApiException {
		appConnectService.logout();
	}
}















