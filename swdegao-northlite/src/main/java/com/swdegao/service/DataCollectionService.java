package com.swdegao.service;

import org.springframework.stereotype.Component;

import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.QueryDataHistoryOutDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCapabilitiesOutDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceDataOutDTO;
@Component
public interface DataCollectionService {
	/**
	 * 查询单个设备信息
	 * @return
	 * @throws NorthApiException
	 */
	public QueryDeviceDataOutDTO queryDeviceData(String deviceId) throws NorthApiException;
	/**
	 * Application订阅平台数据
	 * @param sid
	 * @throws NorthApiException
	 */
	public void subscribeNotify()throws NorthApiException;
	/**
	 * 查询设备历史数据
	 * @param qdhid
	 * @return
	 * @throws NorthApiException
	 */
	public QueryDataHistoryOutDTO queryDataHistory(String deviceId,String gatewayId) throws NorthApiException;
	/**
	 * 查询设备能力
	 * @param qdcid
	 * @return
	 * @throws NorthApiException
	 */
	public QueryDeviceCapabilitiesOutDTO queryDeviceCapabilities(String deviceId) throws NorthApiException;
}
