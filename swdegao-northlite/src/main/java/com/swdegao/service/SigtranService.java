package com.swdegao.service;

import org.springframework.stereotype.Component;
import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.PostDeviceCommandInDTO;
import com.huawei.iotplatform.client.dto.UpdateDeviceCmdInDTO;
import com.swdegao.common.ResponseMessage;

@Component
public interface SigtranService {
	
	/**
	 * //创建设备命令V4
	 * @param pdcid
	 * @return
	 * @throws NorthApiException
	 */
	public ResponseMessage postDeviceCommand(PostDeviceCommandInDTO pdcid);
	
	/**
	 * //查询设备命令V4
	 * @param qdcid
	 * @param appId
	 * @param accessToken
	 * @return
	 * @throws NorthApiException
	 */
	public ResponseMessage queryDeviceCommand(String deviceId);
	
	/**
	 * //修改该设备命令V4
	 * @param udcid
	 * @return
	 * @throws NorthApiException
	 */
	public ResponseMessage updateDeviceCommand(UpdateDeviceCmdInDTO udcid);
	
	/**
	 * //创建设备命令撤销任务V4
	 * @param dcctod
	 * @return
	 * @throws NorthApiException
	 */
	public ResponseMessage createDeviceCmdCancelTaskV4(String deviceId);
	
	/**
	 * //查询设备命令撤销任务V4
	 * @param qdcctid
	 * @return
	 * @throws NorthApiException
	 */
	public ResponseMessage queryDeviceCmdCancelTask(String deviceId);
}



















