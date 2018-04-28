package com.swdegao.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.ModifyDeviceInfoInDTO;
import com.huawei.iotplatform.client.dto.RefreshVerifyCodeDTO;
import com.huawei.iotplatform.client.dto.RefreshVerifyCodeInDTO;
import com.huawei.iotplatform.client.dto.RefreshVerifyCodeOutDTO;
import com.huawei.iotplatform.client.dto.RegDirectDeviceInDTO;
import com.huawei.iotplatform.client.dto.RegDirectDeviceOutDTO;
import com.huawei.iotplatform.client.invokeapi.DeviceManagement;
import com.swdegao.common.ApplicationConfig;
import com.swdegao.common.UpDateProperty;
import com.swdegao.service.AppSecurityConnectService;
import com.swdegao.service.DeviceManagementService;

@Component
public class DeviceManagementServiceImpl implements DeviceManagementService {

	@Autowired
	public ApplicationConfig appConfig;
	@Autowired
	public AppSecurityConnectService appSecurity;
	
	public String accessToken = UpDateProperty.getKeyValue("app.accessToken");
	
	@Override
	public RegDirectDeviceOutDTO regDirectDevice(String nodeId) throws NorthApiException {
		String appId = appConfig.getAppId();
        DeviceManagement dManagement = new DeviceManagement(appSecurity.initClient());
        RegDirectDeviceInDTO rddid = new RegDirectDeviceInDTO();
        String verifyCode = nodeId;
        rddid.setNodeId(nodeId);
        rddid.setVerifyCode(verifyCode);
        rddid.setTimeout(0);
        RegDirectDeviceOutDTO rddod = null;
        rddod = dManagement.regDirectDevice(rddid,appId,accessToken);
        return rddod;

	}

	@Override
	public void deleteDirectDevice(String deviceId) throws NorthApiException {
		String appId = appConfig.getAppId();
		DeviceManagement dManagement = new DeviceManagement(appSecurity.initClient());
		dManagement.deleteDirectDevice(deviceId, appId, accessToken);
	}

	@Override
	public void modifyDeviceInfo(ModifyDeviceInfoInDTO mdiid) throws NorthApiException {
		String appId = appConfig.getAppId();
		DeviceManagement dManagement = new DeviceManagement(appSecurity.initClient());
	    dManagement.modifyDeviceInfo(mdiid, appId, accessToken);
	}

	@Override
	public RefreshVerifyCodeOutDTO refreshDeviceSecret(String deviceId,String nodeId)
			throws NorthApiException {
		String appId = appConfig.getAppId();
		DeviceManagement dManagement = new DeviceManagement(appSecurity.initClient());
		RefreshVerifyCodeInDTO rdsid = new RefreshVerifyCodeInDTO();
		rdsid.setDeviceId(deviceId);
		RefreshVerifyCodeDTO request = new RefreshVerifyCodeDTO();
		request.setNodeId(nodeId);
		request.setVerifyCode(nodeId);
		rdsid.setRequest(request);
		RefreshVerifyCodeOutDTO rdsod = dManagement.refreshDeviceSecret(rdsid, appId, accessToken); 
		return rdsod;
	}
}
















