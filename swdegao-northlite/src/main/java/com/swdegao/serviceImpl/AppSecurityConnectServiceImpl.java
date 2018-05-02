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
import com.swdegao.common.ResponseMessage;
import com.swdegao.common.ResponseUtils;
import com.swdegao.common.UpDateProperty;
import com.swdegao.service.AppSecurityConnectService;

@Component
public class AppSecurityConnectServiceImpl implements AppSecurityConnectService {

	@Autowired
	public ApplicationConfig appConfig;

	@Override
	public ResponseMessage getAuthToken() {
		Authentication auth;
		AuthOutDTO aod = null;
		try {
			auth = initAuth();
			aod = auth.getAuthToken();
			UpDateProperty.updateProperties("app.accessToken", aod.getAccessToken());
			UpDateProperty.updateProperties("app.refreshToken", aod.getRefreshToken());
			return ResponseUtils.responseSuccessed(aod);
		} catch (NorthApiException e) {
			return ResponseUtils.responseFailed(e);
		}
	}

	@Override
	public ResponseMessage refreshAuthToken() {
		Authentication auth;
		AuthRefreshInDTO arid = new AuthRefreshInDTO();
		AuthRefreshOutDTO arod = null;
		try {
			auth = initAuth();
			arid.setAppId(appConfig.getAppId());
			arid.setSecret(appConfig.getSecret());
			String refreshToken = UpDateProperty.getKeyValue("app.refreshToken");
			arid.setRefreshToken(refreshToken);
			arod = auth.refreshAuthToken(arid);
			UpDateProperty.updateProperties("app.accessToken", arod.getAccessToken());
			UpDateProperty.updateProperties("app.refreshToken", arod.getRefreshToken());
			
			return ResponseUtils.responseSuccessed(arod);
		} catch (NorthApiException e) {
			return ResponseUtils.responseFailed(e);
		}
	}

	@Override
	public void logout() throws NorthApiException {
		Authentication auth = initAuth();
		String accessToken = UpDateProperty.getKeyValue("app.accessToken");
		auth.logoutAuthToken(accessToken);
	}

	/**
	 * 初始化对象
	 * 
	 * @return
	 * @throws NorthApiException
	 */
	public Authentication initAuth() throws NorthApiException {

		Authentication auth = new Authentication(initClient());
		return auth;
	}

	public NorthApiClient initClient() throws NorthApiException {
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
		return northApiClient;
	}
}
