package com.swdegao.service;

import org.springframework.stereotype.Component;
import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.AuthOutDTO;
import com.huawei.iotplatform.client.dto.AuthRefreshOutDTO;

@Component
public interface AppSecurityConnectService {
	
	/**
	 * 获取鉴权token
	 * @return
	 * @throws NorthApiException
	 */
	public AuthOutDTO getAuthToken() throws NorthApiException;
	/**
	 * 刷新accessToken
	 * @param refeshToken 
	 * @param arid
	 * @return
	 * @throws NorthApiException
	 */
	public AuthRefreshOutDTO refreshAuthToken() throws NorthApiException;
	/**
	 * 注销鉴权信息
	 * @param accessToken
	 * @throws NorthApiException
	 */
	public void logout() throws NorthApiException;
}
