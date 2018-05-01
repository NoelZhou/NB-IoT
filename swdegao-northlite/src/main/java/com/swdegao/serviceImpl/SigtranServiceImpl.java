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
	public PostDeviceCommandOutDTO postDeviceCommand(PostDeviceCommandInDTO pdcid) throws NorthApiException {
		String appId = appConfig.getAppId();
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
		System.out.println(pdcod.toString());

		return null;
	}

	@Override
	public QueryDeviceCommandOutDTO queryDeviceCommand(String deviceId) throws NorthApiException {
		// TODO Auto-generated method stub
		String appId = appConfig.getAppId();
		SignalDelivery sd = new SignalDelivery();
		sd.setNorthApiClient(appService.initClient());
		QueryDeviceCommandInDTO qdcid = new QueryDeviceCommandInDTO();
		qdcid.setDeviceId(deviceId);
		QueryDeviceCommandOutDTO qdcod = sd.queryDeviceCommand(qdcid, appId, accessToken);
		return qdcod;
	}

	@Override
	public UpdateDeviceCmdOutDTO updateDeviceCommand(UpdateDeviceCmdInDTO udcid) throws NorthApiException {

		String appId = appConfig.getAppId();
		SignalDelivery sd = new SignalDelivery();
		sd.setNorthApiClient(appService.initClient());
		// UpdateDeviceCmdInDTO udcid = new UpdateDeviceCmdInDTO();
		// String deviceCommandId = "bfeb4ba5c2644aae87b3188beb13539f";
		// udcid.setDeviceCommandId(deviceCommandId);
		// UpdateDeviceCmdReq udcr = new UpdateDeviceCmdReq();
		// udcr.setStatus("CANCELED");
		// udcid.setUpdateDeviceCommandReq(udcr);
		UpdateDeviceCmdOutDTO udcod = sd.updateDeviceCommand(udcid, appId, accessToken);
		return udcod;
	}

	@Override
	public DeviceCmdCancelTaskOutDTO createDeviceCmdCancelTaskV4(String deviceId) throws NorthApiException {
		String appId = appConfig.getAppId();
		SignalDelivery sd = new SignalDelivery();
		sd.setNorthApiClient(appService.initClient());
		DeviceCmdCancelTaskInDTO dcctod = new DeviceCmdCancelTaskInDTO();
		dcctod.setDeviceId(deviceId);
		DeviceCmdCancelTaskOutDTO dcctoud = sd.createDeviceCmdCancelTaskV4(dcctod, appId, accessToken);
		return dcctoud;
	}

	@Override
	public QueryDeviceCmdCancelTaskOutDTO queryDeviceCmdCancelTask(String deviceId) throws NorthApiException {
		String appId = appConfig.getAppId();
		SignalDelivery sd = new SignalDelivery();
		sd.setNorthApiClient(appService.initClient());
		QueryDeviceCmdCancelTaskInDTO qdcctid = new QueryDeviceCmdCancelTaskInDTO();
		qdcctid.setDeviceId(deviceId);
		QueryDeviceCmdCancelTaskOutDTO qdcctod = sd.queryDeviceCmdCancelTask(qdcctid, appId, accessToken);

		return qdcctod;
	}

}
