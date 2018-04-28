package com.swdegao.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.AsynCommandDTO;
import com.huawei.iotplatform.client.dto.DeviceCmdCancelTaskInDTO;
import com.huawei.iotplatform.client.dto.DeviceCmdCancelTaskOutDTO;
import com.huawei.iotplatform.client.dto.DeviceCommand;
import com.huawei.iotplatform.client.dto.PostDeviceCommandInDTO;
import com.huawei.iotplatform.client.dto.PostDeviceCommandOutDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCmdCancelTaskInDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCmdCancelTaskOutDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCommandInDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCommandOutDTO;
import com.huawei.iotplatform.client.dto.UpdateDeviceCmdInDTO;
import com.huawei.iotplatform.client.dto.UpdateDeviceCmdOutDTO;
import com.huawei.iotplatform.client.invokeapi.SignalDelivery;
import com.huawei.iotplatform.utils.JsonUtil;
import com.swdegao.common.ApplicationConfig;
import com.swdegao.common.UpDateProperty;
import com.swdegao.service.AppSecurityConnectService;
import com.swdegao.service.SigtranService;

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
	      PostDeviceCommandInDTO pdcid = new PostDeviceCommandInDTO(); 
	      pdcid.setDeviceId(deviceId); 
	      AsynCommandDTO acdo = new AsynCommandDTO(); 
	      String serviceId = "Brightness";
	      String method = "SET_DEVICE_LEVEL"; 
	      ObjectNode paras = JsonUtil.convertObject2ObjectNode("{\"value\":\"100\"}"); 
	      acdo.setServiceId(serviceId); 
	      acdo.setMethod(method);
	      acdo.setParas(paras);
	      pdcid.setCommand(acdo); 
	      PostDeviceCommandOutDTO pdcod = sd.postDeviceCommand(pdcid, appId, accessToken); 
	      System.out.println(pdcod.toString());
	        
	      
		return null;
	}

	@Override
	public QueryDeviceCommandOutDTO queryDeviceCommand(QueryDeviceCommandInDTO qdcid) throws NorthApiException {
		// TODO Auto-generated method stub
		  // 4.4.2 查询设备命令V4
        
        QueryDeviceCommandInDTO qdcid = new QueryDeviceCommandInDTO();
        qdcid.setDeviceId(deviceId);
        QueryDeviceCommandOutDTO qdcod = sd.queryDeviceCommand(qdcid, appId, accessToken);
        System.out.println(qdcod.toString());
        
       
	
		return null;
	}

	@Override
	public UpdateDeviceCmdOutDTO updateDeviceCommand(UpdateDeviceCmdInDTO udcid) throws NorthApiException {
		 // 4.4.3 修改设备命令V4
        /*
         * UpdateDeviceCmdInDTO udcid = new UpdateDeviceCmdInDTO(); String deviceCommandId = "bfeb4ba5c2644aae87b3188beb13539f"; udcid.setDeviceCommandId(deviceCommandId);
         * UpdateDeviceCmdReq udcr = new UpdateDeviceCmdReq(); udcr.setStatus("CANCELED"); udcid.setUpdateDeviceCommandReq(udcr); UpdateDeviceCmdOutDTO udcod =
         * sd.updateDeviceCommand(udcid, appId, accessToken); System.out.println(udcod.toString());
         */
        
       
		return null;
	}

	@Override
	public DeviceCmdCancelTaskOutDTO createDeviceCmdCancelTaskV4(DeviceCmdCancelTaskInDTO dcctod)
			throws NorthApiException {
 // 4.4.4 创建设备命令撤销任务V4
        
        /*
         * DeviceCmdCancelTaskInDTO dcctod = new DeviceCmdCancelTaskInDTO(); dcctod.setDeviceId(deviceId); DeviceCmdCancelTaskOutDTO dcctoud =
         * sd.createDeviceCmdCancelTaskV4(dcctod, appId, accessToken); System.out.println(dcctoud.toString());
         */
        
      
		return null;
	}

	@Override
	public QueryDeviceCmdCancelTaskOutDTO queryDeviceCmdCancelTask(QueryDeviceCmdCancelTaskInDTO qdcctid)
			throws NorthApiException {
  // 4.4.5 查询设备命令撤销任务V4
        
        /*
         * QueryDeviceCmdCancelTaskInDTO qdcctid = new QueryDeviceCmdCancelTaskInDTO(); qdcctid.setDeviceId(deviceId); QueryDeviceCmdCancelTaskOutDTO qdcctod =
         * sd.queryDeviceCmdCancelTask(qdcctid, appId, accessToken); System.out.println(qdcctod.toString());
         */
		return null;
	}

}
