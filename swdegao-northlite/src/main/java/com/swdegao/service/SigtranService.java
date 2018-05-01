package com.swdegao.service;

import org.springframework.stereotype.Component;
import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.DeviceCmdCancelTaskOutDTO;
import com.huawei.iotplatform.client.dto.PostDeviceCommandInDTO;
import com.huawei.iotplatform.client.dto.PostDeviceCommandOutDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCmdCancelTaskOutDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCommandOutDTO;
import com.huawei.iotplatform.client.dto.UpdateDeviceCmdInDTO;
import com.huawei.iotplatform.client.dto.UpdateDeviceCmdOutDTO;

@Component
public interface SigtranService {
	
	/**
	 * //创建设备命令V4
	 * @param pdcid
	 * @return
	 * @throws NorthApiException
	 */
	public PostDeviceCommandOutDTO postDeviceCommand(PostDeviceCommandInDTO pdcid)throws NorthApiException;
	
	/**
	 * //查询设备命令V4
	 * @param qdcid
	 * @param appId
	 * @param accessToken
	 * @return
	 * @throws NorthApiException
	 */
	public QueryDeviceCommandOutDTO queryDeviceCommand(String deviceId) throws NorthApiException;
	
	/**
	 * //修改该设备命令V4
	 * @param udcid
	 * @return
	 * @throws NorthApiException
	 */
	public UpdateDeviceCmdOutDTO updateDeviceCommand(UpdateDeviceCmdInDTO udcid)throws NorthApiException;
	
	/**
	 * //创建设备命令撤销任务V4
	 * @param dcctod
	 * @return
	 * @throws NorthApiException
	 */
	public DeviceCmdCancelTaskOutDTO createDeviceCmdCancelTaskV4(String deviceId)throws NorthApiException;
	
	/**
	 * //查询设备命令撤销任务V4
	 * @param qdcctid
	 * @return
	 * @throws NorthApiException
	 */
	public QueryDeviceCmdCancelTaskOutDTO queryDeviceCmdCancelTask(String deviceId)throws NorthApiException;
}



















