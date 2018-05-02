package com.swdegao.service;

import org.springframework.stereotype.Component;
import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.SubscribeInDTO;
import com.swdegao.common.ResponseMessage;
@Component
public interface DataCollectionService {
	/**
	 * 查询单个设备信息
	 * @return
	 * @throws NorthApiException
	 */
	public ResponseMessage queryDeviceData(String deviceId);
	/**
	 * Application订阅平台数据
	 * @param sid
	 * @throws NorthApiException
	 */
	public void subscribeNotify(SubscribeInDTO sid) throws NorthApiException;
	/**
	 * 查询设备历史数据
	 * @param qdhid
	 * @return
	 * @throws NorthApiException
	 */
	public ResponseMessage queryDataHistory(String deviceId,String gatewayId);
	/**
	 * 查询设备能力
	 * @param qdcid
	 * @return
	 * @throws NorthApiException
	 */
	public ResponseMessage queryDeviceCapabilities(String deviceId);
}
