package com.swdegao.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.huawei.iotplatform.client.NorthApiClient;
import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.AuthOutDTO;
import com.huawei.iotplatform.client.dto.AuthRefreshInDTO;
import com.huawei.iotplatform.client.dto.AuthRefreshOutDTO;
import com.huawei.iotplatform.client.dto.ClientInfo;
import com.huawei.iotplatform.client.invokeapi.Authentication;
import com.swdegao.common.ApplicationConfig;
import com.swdegao.service.AppSecurityConnectService;
@Component
public class AppSecurityConnectServiceImpl implements AppSecurityConnectService{

	@Autowired
	public ApplicationConfig appConfig;
	
	@Override
	public AuthOutDTO getAuthToken() throws NorthApiException {
		Authentication auth = initAPIClient();
	    AuthOutDTO aod = auth.getAuthToken();
		return aod;
	}

	@Override
	public AuthRefreshOutDTO refreshAuthToken(String refeshToken) throws NorthApiException {
		Authentication auth = initAPIClient();
		AuthRefreshInDTO arid = new AuthRefreshInDTO(); 
	    AuthRefreshOutDTO arod = null;
        arid.setAppId(appConfig.getAppId());
        arid.setSecret(appConfig.getSecret());
//        String refreshToken = getAuthToken().getRefreshToken();
        arid.setRefreshToken(refeshToken);
        
        arod = auth.refreshAuthToken(arid);
        
		return arod;
	}

	@Override
	public void logout() throws NorthApiException {
		Authentication auth = initAPIClient();
		auth.logoutAuthToken(refreshAuthToken(null).getAccessToken());
	}
	
	/**
	 * 初始化对象
	 * @return
	 * @throws NorthApiException
	 */
	private Authentication initAPIClient() throws NorthApiException {
		/**
		 * 北向API入口
		 */
		NorthApiClient northApiClient = new NorthApiClient();
		/**
		 * 平台信息
		 */
		ClientInfo cInfo = new ClientInfo();
		cInfo.setAppId(appConfig.getAppId());
		cInfo.setSecret(appConfig.getSecret());
		cInfo.setPlatformIp(appConfig.getBase_url());
		cInfo.setPlatformPort(appConfig.getPort());
		/**
		 * 设置信息到北向API客户端中
		 */
		northApiClient.setClientInfo(cInfo);
		/**
		 * 初始化SSL
		 */
		northApiClient.initSSLConfig();
		Authentication auth = new Authentication(northApiClient);
		return auth;
	}

}
