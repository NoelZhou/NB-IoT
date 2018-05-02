package com.swdegao.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.DeviceCmdCancelTaskInDTO;
import com.huawei.iotplatform.client.dto.DeviceCmdCancelTaskOutDTO;
import com.huawei.iotplatform.client.dto.PostDeviceCommandInDTO;
import com.huawei.iotplatform.client.dto.PostDeviceCommandOutDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCmdCancelTaskInDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCmdCancelTaskOutDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCommandInDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCommandOutDTO;
import com.huawei.iotplatform.client.dto.UpdateDeviceCmdInDTO;
import com.huawei.iotplatform.client.dto.UpdateDeviceCmdOutDTO;
import com.huawei.iotplatform.client.invokeapi.SignalDelivery;
import com.swdegao.common.ApplicationConfig;
import com.swdegao.common.ResponseMessage;
import com.swdegao.common.ResponseUtils;
import com.swdegao.common.UpDateProperty;
import com.swdegao.service.AppSecurityConnectService;
import com.swdegao.service.SigtranService;

@Component
public class SigtranServiceImpl implements SigtranService {

	@Autowired
	public ApplicationConfig appConfig;

	@Autowired
	public AppSecurityConnectService appService;

	public String accessToken = UpDateProperty.getKeyValue("app.accessToken");

	@Override
	public ResponseMessage postDeviceCommand(PostDeviceCommandInDTO pdcid) {
		String appId = appConfig.getAppId();
		try {
			SignalDelivery sd = new SignalDelivery();
			sd.setNorthApiClient(appService.initClient());
			// PostDeviceCommandInDTO pdcid = new PostDeviceCommandInDTO();
			// pdcid.setDeviceId(deviceId);
			//
			// AsynCommandDTO acdo = new AsynCommandDTO();
			// String serviceId = "Brightness";
			// String method = "SET_DEVICE_LEVEL";
			// ObjectNode paras = JsonUtil.convertObject2ObjectNode("{\"value\":\"100\"}");
			// acdo.setServiceId(serviceId);
			// acdo.setMethod(method);
			// acdo.setParas(paras);
			// pdcid.setCommand(acdo);
			PostDeviceCommandOutDTO pdcod = sd.postDeviceCommand(pdcid, appId, accessToken);
			return ResponseUtils.responseSuccessed(pdcod);
		} catch (NorthApiException e) {
			return ResponseUtils.responseFailed(e);
		}
	}

	@Override
	public ResponseMessage queryDeviceCommand(String deviceId) {
		String appId = appConfig.getAppId();
		try {
			SignalDelivery sd = new SignalDelivery();
			sd.setNorthApiClient(appService.initClient());
			QueryDeviceCommandInDTO qdcid = new QueryDeviceCommandInDTO();
			qdcid.setDeviceId(deviceId);
			QueryDeviceCommandOutDTO qdcod = sd.queryDeviceCommand(qdcid, appId, accessToken);
			return ResponseUtils.responseSuccessed(qdcod);
		} catch (NorthApiException e) {
			return ResponseUtils.responseFailed(e);
		}
	}

	@Override
	public ResponseMessage updateDeviceCommand(UpdateDeviceCmdInDTO udcid) {
		String appId = appConfig.getAppId();
		try {
			SignalDelivery sd = new SignalDelivery();
			sd.setNorthApiClient(appService.initClient());
			UpdateDeviceCmdOutDTO udcod = sd.updateDeviceCommand(udcid, appId, accessToken);
			return ResponseUtils.responseSuccessed(udcod);
		} catch (NorthApiException e) {
			return ResponseUtils.responseFailed(e);
		}
	}

	@Override
	public ResponseMessage createDeviceCmdCancelTaskV4(String deviceId) {
		String appId = appConfig.getAppId();
		try {
			SignalDelivery sd = new SignalDelivery();
			sd.setNorthApiClient(appService.initClient());
			DeviceCmdCancelTaskInDTO dcctod = new DeviceCmdCancelTaskInDTO();
			dcctod.setDeviceId(deviceId);
			DeviceCmdCancelTaskOutDTO dcctoud = sd.createDeviceCmdCancelTaskV4(dcctod, appId, accessToken);
			return ResponseUtils.responseSuccessed(dcctoud);
		} catch (NorthApiException e) {
			return ResponseUtils.responseFailed(e);
		}
	}

	@Override
	public ResponseMessage queryDeviceCmdCancelTask(String deviceId) {
		String appId = appConfig.getAppId();
		try {
			SignalDelivery sd = new SignalDelivery();
			sd.setNorthApiClient(appService.initClient());
			QueryDeviceCmdCancelTaskInDTO qdcctid = new QueryDeviceCmdCancelTaskInDTO();
			qdcctid.setDeviceId(deviceId);
			QueryDeviceCmdCancelTaskOutDTO qdcctod = sd.queryDeviceCmdCancelTask(qdcctid, appId, accessToken);
			return ResponseUtils.responseSuccessed(qdcctod);
		} catch (NorthApiException e) {
			return ResponseUtils.responseFailed(e);
		}
	}

}
