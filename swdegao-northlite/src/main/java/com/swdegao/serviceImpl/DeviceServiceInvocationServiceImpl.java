package com.swdegao.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.DeviceServiceInvocationInDTO;
import com.huawei.iotplatform.client.dto.DeviceServiceInvocationOutDTO;
import com.huawei.iotplatform.client.invokeapi.DeviceServiceInvocation;
import com.swdegao.common.ApplicationConfig;
import com.swdegao.common.ResponseMessage;
import com.swdegao.common.ResponseUtils;
import com.swdegao.common.UpDateProperty;
import com.swdegao.service.AppSecurityConnectService;
import com.swdegao.service.DeviceServiceInvocationService;
@Component
public class DeviceServiceInvocationServiceImpl implements DeviceServiceInvocationService {

	@Autowired
	public ApplicationConfig appConfig;

	@Autowired
	public AppSecurityConnectService appService;

	public String accessToken = UpDateProperty.getKeyValue("app.accessToken");

	@Override
	public ResponseMessage invocateDeviceService(DeviceServiceInvocationInDTO dsiid) {
		String appId = appConfig.getAppId();
		try {
			DeviceServiceInvocation dsi = new DeviceServiceInvocation(appService.initClient());
			DeviceServiceInvocationOutDTO dsiod = dsi.invocateDeviceService(dsiid, appId, accessToken);
			return ResponseUtils.responseSuccessed(dsiod);
		} catch (NorthApiException e) {
			return ResponseUtils.responseFailed(e);
		}
	}

}
