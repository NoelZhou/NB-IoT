package com.swdegao.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.BatchTaskCreateInDTO;
import com.huawei.iotplatform.client.dto.BatchTaskCreateOutDTO;
import com.huawei.iotplatform.client.dto.QueryOneTaskOutDTO;
import com.huawei.iotplatform.client.dto.QueryTaskDetailsInDTO;
import com.huawei.iotplatform.client.dto.QueryTaskDetailsOutDTO;
import com.huawei.iotplatform.client.invokeapi.BatchProcess;
import com.swdegao.common.ApplicationConfig;
import com.swdegao.common.UpDateProperty;
import com.swdegao.service.AppSecurityConnectService;
import com.swdegao.service.BatchProcessingService;

@Component
public class BatchProcessingServiceImpl implements BatchProcessingService {

	@Autowired
	public ApplicationConfig appConfig;

	@Autowired
	public AppSecurityConnectService appService;

	public String accessToken = UpDateProperty.getKeyValue("app.accessToken");

	@Override
	public BatchTaskCreateOutDTO createBatchTask(BatchTaskCreateInDTO btcid) throws NorthApiException {
		BatchProcess bp = new BatchProcess(appService.initClient());
		BatchTaskCreateOutDTO btcod = bp.createBatchTask(btcid, accessToken);
		return btcod;
	}

	@Override
	public QueryOneTaskOutDTO queryOneTask(String taskId) throws NorthApiException {
		String appId = appConfig.getAppId();
		BatchProcess bp = new BatchProcess(appService.initClient());
		QueryOneTaskOutDTO qotod = bp.queryOneTask(taskId, appId, accessToken);
		return qotod;
	}

	@Override
	public QueryTaskDetailsOutDTO queryTaskDetails(String taskId) throws NorthApiException {
		String appId = appConfig.getAppId();
		BatchProcess bp = new BatchProcess(appService.initClient());
		QueryTaskDetailsInDTO qtdido = new QueryTaskDetailsInDTO();
		qtdido.setTaskId(taskId);
		QueryTaskDetailsOutDTO qtdodo = bp.queryTaskDetails(qtdido, appId, accessToken);
		return qtdodo;
	}

}
