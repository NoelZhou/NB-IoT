package com.swdegao.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.QueryDataHistoryInDTO;
import com.huawei.iotplatform.client.dto.QueryDataHistoryOutDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCapabilitiesInDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCapabilitiesOutDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceDataOutDTO;
import com.huawei.iotplatform.client.dto.SubscribeInDTO;
import com.huawei.iotplatform.client.invokeapi.DataCollection;
import com.swdegao.common.ApplicationConfig;
import com.swdegao.common.UpDateProperty;
import com.swdegao.service.AppSecurityConnectService;
import com.swdegao.service.DataCollectionService;
@Component
public class DataCollectionServiceImpl implements DataCollectionService {

	@Autowired
	public ApplicationConfig appConfig;
	@Autowired
	public AppSecurityConnectService appService;
	
	public String accessToken = UpDateProperty.getKeyValue("app.accessToken");
	
	@Override
	public QueryDeviceDataOutDTO queryDeviceData(String deviceId) throws NorthApiException {
		String appId = appConfig.getAppId();
		DataCollection dc = new DataCollection(appService.initClient());
        QueryDeviceDataOutDTO qddodto = dc.queryDeviceData(deviceId, appId, accessToken);
		return qddodto;
	}

	@Override
	public void subscribeNotify(SubscribeInDTO sid) throws NorthApiException {
		DataCollection dc = new DataCollection(appService.initClient());
//        SubscribeInDTO sid = new SubscribeInDTO();
//        String notifyType = "deviceDataChanged";
//        sid.setNotifyType(notifyType);
//        String callbackurl = "http://localhost:8080/RESTfulWS/rest/UserInfoService/subscriber1";
//        sid.setCallbackurl(callbackurl);
        dc.subscribeNotify(sid, accessToken);
	}

	@Override
	public QueryDataHistoryOutDTO queryDataHistory(String deviceId,String gatewayId) throws NorthApiException {
		String appId = appConfig.getAppId();
		DataCollection dc = new DataCollection(appService.initClient());
        QueryDataHistoryInDTO qdhid = new QueryDataHistoryInDTO();
        qdhid.setDeviceId(deviceId);
        //当设备是直连设备时，gatewayId为设备本身的deviceId。当设备是非直连设备时，gatewayId为设备所关联的直连设备（即网关）的deviceId。
        qdhid.setGatewayId(gatewayId);
        QueryDataHistoryOutDTO qdhod = dc.queryDataHistory(qdhid, appId, accessToken);
		return qdhod;
	}

	@Override
	public QueryDeviceCapabilitiesOutDTO queryDeviceCapabilities(String deviceId)
			throws NorthApiException {
		String appId = appConfig.getAppId();
		DataCollection dc = new DataCollection(appService.initClient());
		QueryDeviceCapabilitiesInDTO qdcid = new QueryDeviceCapabilitiesInDTO();
        qdcid.setDeviceId(deviceId);
        QueryDeviceCapabilitiesOutDTO qdcod = dc.queryDeviceCapabilities(qdcid, appId, accessToken);
		return qdcod;
	}

}
