package com.swdegao.service;

import org.springframework.stereotype.Component;
import com.huawei.iotplatform.client.NorthApiClient;
import com.huawei.iotplatform.client.NorthApiException;
import com.swdegao.common.ResponseMessage;

@Component
public interface AppSecurityConnectService {
	
	/**
	 * 获取鉴权token
	 * @return
	 * @throws NorthApiException
	 */
	public ResponseMessage getAuthToken();
	/**
	 * 刷新accessToken
	 * @param refeshToken 
	 * @param arid
	 * @return
	 * @throws NorthApiException
	 */
	public ResponseMessage refreshAuthToken() ;
	/**
	 * 注销鉴权信息
	 * @param accessToken
	 * @throws NorthApiException
	 */
	public void logout() throws NorthApiException;
	
	public NorthApiClient initClient() throws NorthApiException;
}
