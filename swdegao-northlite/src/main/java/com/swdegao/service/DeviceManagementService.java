package com.swdegao.service;

import org.springframework.stereotype.Component;

import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.ModifyDeviceInfoInDTO;
import com.huawei.iotplatform.client.dto.RefreshVerifyCodeOutDTO;
import com.huawei.iotplatform.client.dto.RegDirectDeviceOutDTO;
@Component
public interface DeviceManagementService {
	/**
	 * 注册直连设备
	 * @param rddid
	 * @return
	 * @throws NorthApiException
	 */
	public RegDirectDeviceOutDTO regDirectDevice(String nodeId) throws NorthApiException;
	/**
	 * 删除直连设备
	 * @param deviceId
	 * @throws NorthApiException
	 */
	public void deleteDirectDevice(String deviceId) throws NorthApiException;
	/**
	 * 修改设备信息
	 * @param mdiid
	 */
	public void modifyDeviceInfo(ModifyDeviceInfoInDTO mdiid)throws NorthApiException;
	/**
	 * 刷新设备密钥
	 * @param rdsid
	 * @return
	 * @throws NorthApiException
	 */
	public RefreshVerifyCodeOutDTO refreshDeviceSecret(String deviceId,String nodeId) throws NorthApiException;
}
