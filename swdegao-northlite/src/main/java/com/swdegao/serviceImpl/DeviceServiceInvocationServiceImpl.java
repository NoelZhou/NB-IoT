package com.swdegao.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.DeviceServiceInvocationInDTO;
import com.huawei.iotplatform.client.dto.DeviceServiceInvocationOutDTO;
import com.huawei.iotplatform.client.invokeapi.DeviceServiceInvocation;
import com.swdegao.common.ApplicationConfig;
import com.swdegao.common.UpDateProperty;
import com.swdegao.service.AppSecurityConnectService;
import com.swdegao.service.DeviceServiceInvocationService;
@Component
public class DeviceServiceInvocationServiceImpl implements DeviceServiceInvocationService {

	@Autowired
	public ApplicationConfig appConfig;

	@Autowired
	public AppSecurityConnectService appService;

	public String accessToken = UpDateProperty.getKeyValue("app.accessToken");

	@Override
	public DeviceServiceInvocationOutDTO invocateDeviceService(DeviceServiceInvocationInDTO dsiid)
			throws NorthApiException {
		String appId = appConfig.getAppId();
		DeviceServiceInvocation dsi = new DeviceServiceInvocation(appService.initClient());
		// DeviceServiceInvocationInDTO dsiid = new DeviceServiceInvocationInDTO();
		// dsiid.setDeviceId(gate_deviceId);
		// dsiid.setServiceId(serviceId);
		// CommandDTO message = new CommandDTO();
		// CommandNA2CloudHeader header = new CommandNA2CloudHeader();
		// header.setMode("ACK");
		// header.setMethod("SET_REPORT_PERIOD_BATTERY");
		// header.setToType("GATEWAY");
		// header.setCallbackURL("http://172.31.126.82:8443/RESTfulWS/rest/UserInfoService/subscriber1");
		// Map<String, Integer> commandNA2CloudBody = new HashMap<>();
		// commandNA2CloudBody.put("Period", 100);
		// ObjectNode body = JsonUtil.convertObject2ObjectNode(commandNA2CloudBody);
		// message.setBody(body);
		// message.setHeader(header);
		// dsiid.setMessage(message);
		DeviceServiceInvocationOutDTO dsiod = dsi.invocateDeviceService(dsiid, appId, accessToken);
		return dsiod;
	}

}
