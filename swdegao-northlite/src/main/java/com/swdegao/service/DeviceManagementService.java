package com.swdegao.service;

import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.ModifyDeviceInfoInDTO;
import com.huawei.iotplatform.client.dto.RefreshVerifyCodeInDTO;
import com.huawei.iotplatform.client.dto.RefreshVerifyCodeOutDTO;
import com.huawei.iotplatform.client.dto.RegDirectDeviceInDTO;
import com.huawei.iotplatform.client.dto.RegDirectDeviceOutDTO;

public interface DeviceManagementService {
	public RegDirectDeviceOutDTO regDirectDevice(RegDirectDeviceInDTO rddid, String appId, String accessToken) throws NorthApiException;
	public void deleteDirectDevice(String deviceId, String appId, String accessToken) throws NorthApiException;
	public void modifyDeviceInfo(ModifyDeviceInfoInDTO mdiid, String appId, String accessToken);
	public RefreshVerifyCodeOutDTO refreshDeviceSecret(RefreshVerifyCodeInDTO rdsid, String appId, String accessToken) throws NorthApiException;
}
