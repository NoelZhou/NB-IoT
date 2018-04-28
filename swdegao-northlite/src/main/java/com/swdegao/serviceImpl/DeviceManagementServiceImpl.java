package com.swdegao.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huawei.iotplatform.client.NorthApiClient;
import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.AuthOutDTO;
import com.huawei.iotplatform.client.dto.ClientInfo;
import com.huawei.iotplatform.client.dto.ModifyDeviceInfoInDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceStatusOutDTO;
import com.huawei.iotplatform.client.dto.RefreshVerifyCodeDTO;
import com.huawei.iotplatform.client.dto.RefreshVerifyCodeInDTO;
import com.huawei.iotplatform.client.dto.RefreshVerifyCodeOutDTO;
import com.huawei.iotplatform.client.dto.RegDirectDeviceInDTO;
import com.huawei.iotplatform.client.dto.RegDirectDeviceOutDTO;
import com.huawei.iotplatform.client.invokeapi.Authentication;
import com.huawei.iotplatform.client.invokeapi.DeviceManagement;
import com.swdegao.common.ApplicationConfig;
import com.swdegao.common.UpDateProperty;
import com.swdegao.service.DeviceManagementService;

@Component
public class DeviceManagementServiceImpl implements DeviceManagementService {

	@Autowired
	public ApplicationConfig appConfig;
	@Autowired
	public AppSecurityConnectServiceImpl appImpl;
	
	public String appId = appConfig.getAppId();
	public String accessToken = UpDateProperty.getKeyValue("app.accessToken");
	
	@Override
	public RegDirectDeviceOutDTO regDirectDevice(RegDirectDeviceInDTO rddid) throws NorthApiException {
        DeviceManagement dManagement = new DeviceManagement(appImpl.initClient());
        RegDirectDeviceOutDTO rddod = null;
        rddod = dManagement.regDirectDevice(rddid,appId,accessToken);
        return rddod;

	}

	@Override
	public void deleteDirectDevice(String deviceId) throws NorthApiException {
		DeviceManagement dManagement = new DeviceManagement(appImpl.initClient());
		QueryDeviceStatusOutDTO qdsod = dManagement.queryDeviceStatus(deviceId, appId, accessToken);
		System.out.println(qdsod.toString());
	}

	@Override
	public void modifyDeviceInfo(ModifyDeviceInfoInDTO mdiid) throws NorthApiException {
		DeviceManagement dManagement = new DeviceManagement(appImpl.initClient());
		
	      dManagement.modifyDeviceInfo(mdiid, appId, accessToken);
		
	}

	@Override
	public RefreshVerifyCodeOutDTO refreshDeviceSecret(RefreshVerifyCodeInDTO rdsid)
			throws NorthApiException {
		DeviceManagement dManagement = new DeviceManagement(appImpl.initClient());
		RefreshVerifyCodeOutDTO rdsod = dManagement.refreshDeviceSecret(rdsid, appId, accessToken); 
		System.out.println(rdsod.toString());
		return null;
	}
	
}
