package com.swdegao.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huawei.iotplatform.client.NorthApiClient;
import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.AuthOutDTO;
import com.huawei.iotplatform.client.dto.ClientInfo;
import com.huawei.iotplatform.client.dto.ModifyDeviceInfoInDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceStatusOutDTO;
import com.huawei.iotplatform.client.dto.RegDirectDeviceInDTO;
import com.huawei.iotplatform.client.dto.RegDirectDeviceOutDTO;
import com.huawei.iotplatform.client.invokeapi.Authentication;
import com.huawei.iotplatform.client.invokeapi.DeviceManagement;
import com.swdegao.common.ApplicationConfig;
import com.swdegao.service.DeviceManagementService;

@Component
public class DeviceManagementServiceImpl implements DeviceManagementService {

	@Autowired
	public ApplicationConfig appConfig;
	
	@Override
	public RegDirectDeviceOutDTO regDirectDevice(RegDirectDeviceInDTO rddid, String appId, String accessToken)
			throws NorthApiException {
		
//		NorthApiClient nac = new NorthApiClient();
//        
//        ClientInfo ci = new ClientInfo();
//        
//        String appId = "ax2MtpcLWicDfuqPTquJIEXHXJEa";
//        String secret = "u3rJWxzRWsivf830MKGlag0s35oa";
//        
//        ci.setAppId(appId);
//        ci.setPlatformIp("100.115.140.0");
//        ci.setPlatformPort("8743");
//        ci.setSecret(secret);
//        
//        nac.setClientInfo(ci);
//        nac.initSSLConfig();
//        
//        DeviceManagement dm = new DeviceManagement(nac);
//        
//        // auth
//        Authentication aaa = new Authentication(nac);
//        
//        // 4.1.1 閼惧嘲褰囬柎瀛樻綀Token
//        AuthOutDTO aod = null;
//        
//        aod = aaa.getAuthToken();
//        
//        String accessToken = aod.getAccessToken();
//        
//        // 4.2.1 濞夈劌鍞介惄纾嬬箾鐠佹儳顦�
//        
//        RegDirectDeviceInDTO rddid = new RegDirectDeviceInDTO();
//        String nodeid = "3703030485442";
//        String verifyCode = nodeid;
//        rddid.setNodeId(nodeid);
//        rddid.setVerifyCode(verifyCode);
//        rddid.setTimeout(0);
//        RegDirectDeviceOutDTO rddod = null;
//        rddod = dm.regDirectDevice(rddid, appId, accessToken);
//        System.out.println(rddod.toString());
//        String deviceId = rddod.getDeviceId();
//        
//        // String deviceId = "c057a931-cff8-4a2b-bd76-141ccde8d16f";
//        
//        // 4.2.2 閺屻儴顕楃拋鎯ь槵濠碉拷濞茶崵濮搁幀锟�
//        QueryDeviceStatusOutDTO qdsod = dm.queryDeviceStatus(deviceId, appId, accessToken);
//        System.out.println(qdsod.toString());
//        
//        // 4.2.4 娣囶喗鏁肩拋鎯ь槵娣団剝浼�
//        // String deviceId = "18a99eaa-f420-4ee1-b76c-b0f7550504a7";
//        
//        ModifyDeviceInfoInDTO mdiid = new ModifyDeviceInfoInDTO();
//        mdiid.setName("newDeviceName");
//        mdiid.setDeviceId(deviceId);
//        mdiid.setManufacturerId("CompanyId");
//        mdiid.setManufacturerName("CompanyName");
//        mdiid.setDeviceType("WaterMeter");
//        mdiid.setModel("SDKDEMO");
//        mdiid.setProtocolType("CoAP");
//        dm.modifyDeviceInfo(mdiid, appId, accessToken);
//        
//        // 4.2.5 閸掗攱鏌婄拋鎯ь槵鐎靛棝鎸�
//        
//        /*
//         * RefreshVerifyCodeInDTO rdsid = new RefreshVerifyCodeInDTO(); RefreshVerifyCodeDTO request = new RefreshVerifyCodeDTO(); rdsid.setDeviceId(deviceId); String new_nodeid =
//         * "TEST$_00387209XX"; request.setNodeId(new_nodeid); request.setVerifyCode(new_nodeid); rdsid.setRequest(request); RefreshVerifyCodeOutDTO rdsod =
//         * dm.refreshDeviceSecret(rdsid, appId, accessToken); System.out.println(rdsod.toString());
//         */
//        
//        // 4.2.6 鐠佸墽鐤嗛崝鐘茬槕
//        
//        /*
//         * EncryptSetInDTO esid = new EncryptSetInDTO(); esid.setDeviceId(deviceId); String serviceType = "carEncrypt"; esid.setServiceType(serviceType); ObjectNode data =
//         * JsonUtil.convertObject2ObjectNode("{\"period\":\"12\"}"); DmServicesRequestDTO request1 = new DmServicesRequestDTO(); request1.setData(data); esid.setRequest(request1);
//         * dm.setEncrypt(esid, accessToken);
//         */
//        
//        // 4.2.3 閸掔娀娅庨惄纾嬬箾鐠佹儳顦�
//        // dm.deleteDirectDevice(deviceId, appId, accessToken);
//        
//        aaa.logoutAuthToken(accessToken);
		
		return null;
	}
	
}
