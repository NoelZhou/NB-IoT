//package com.swdegao.serviceImpl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.huawei.iotplatform.client.NorthApiClient;
//import com.huawei.iotplatform.client.NorthApiException;
//import com.huawei.iotplatform.client.dto.AuthOutDTO;
//import com.huawei.iotplatform.client.dto.ClientInfo;
//import com.huawei.iotplatform.client.dto.ModifyDeviceInfoInDTO;
//import com.huawei.iotplatform.client.dto.QueryDeviceStatusOutDTO;
//import com.huawei.iotplatform.client.dto.RefreshVerifyCodeInDTO;
//import com.huawei.iotplatform.client.dto.RefreshVerifyCodeOutDTO;
//import com.huawei.iotplatform.client.dto.RegDirectDeviceInDTO;
//import com.huawei.iotplatform.client.dto.RegDirectDeviceOutDTO;
//import com.huawei.iotplatform.client.invokeapi.Authentication;
//import com.huawei.iotplatform.client.invokeapi.DeviceManagement;
//import com.swdegao.common.ApplicationConfig;
//import com.swdegao.service.DeviceManagementService;
//
//@Component
//public class DeviceManagementServiceImpl implements DeviceManagementService {
//
//	@Autowired
//	public ApplicationConfig appConfig;
//	@Autowired
//	public AppSecurityConnectServiceImpl appImpl;
//	
//	@Override
//	public RegDirectDeviceOutDTO regDirectDevice(RegDirectDeviceInDTO rddid, String appId, String accessToken)
//			throws NorthApiException {
//        DeviceManagement dManagement = new DeviceManagement(appImpl.initClient());
//        RegDirectDeviceOutDTO rddod = null;
//        rddod = dManagement.regDirectDevice(rddid, appId, accessToken);
//        return rddod;
//
//	}
//
//	@Override
//	public void deleteDirectDevice(String deviceId, String appId, String accessToken) throws NorthApiException {
//		QueryDeviceStatusOutDTO qdsod = dm.queryDeviceStatus(deviceId, appId, accessToken);
//		System.out.println(qdsod.toString());
//	}
//
//	@Override
//	public void modifyDeviceInfo(ModifyDeviceInfoInDTO mdiid, String appId, String accessToken) {
//      
//      ModifyDeviceInfoInDTO mdiid = new ModifyDeviceInfoInDTO();
//      mdiid.setName("newDeviceName");
//      mdiid.setDeviceId(deviceId);
//      mdiid.setManufacturerId("CompanyId");
//      mdiid.setManufacturerName("CompanyName");
//      mdiid.setDeviceType("WaterMeter");
//      mdiid.setModel("SDKDEMO");
//      mdiid.setProtocolType("CoAP");
//      dm.modifyDeviceInfo(mdiid, appId, accessToken);
//		
//	}
//
//	@Override
//	public RefreshVerifyCodeOutDTO refreshDeviceSecret(RefreshVerifyCodeInDTO rdsid, String appId, String accessToken)
//			throws NorthApiException {
////      /*
////       * RefreshVerifyCodeInDTO rdsid = new RefreshVerifyCodeInDTO(); RefreshVerifyCodeDTO request = new RefreshVerifyCodeDTO(); rdsid.setDeviceId(deviceId); String new_nodeid =
////       * "TEST$_00387209XX"; request.setNodeId(new_nodeid); request.setVerifyCode(new_nodeid); rdsid.setRequest(request); RefreshVerifyCodeOutDTO rdsod =
////       * dm.refreshDeviceSecret(rdsid, appId, accessToken); System.out.println(rdsod.toString());
////       */
//		return null;
//	}
//	
//}
