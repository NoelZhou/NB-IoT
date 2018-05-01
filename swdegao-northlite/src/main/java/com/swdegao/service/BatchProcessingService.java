package com.swdegao.service;

import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.BatchTaskCreateInDTO;
import com.huawei.iotplatform.client.dto.BatchTaskCreateOutDTO;
import com.huawei.iotplatform.client.dto.QueryOneTaskOutDTO;
import com.huawei.iotplatform.client.dto.QueryTaskDetailsOutDTO;

public interface BatchProcessingService {
	
	/**
	 * 创建批量任务
	 * @param btcid
	 * @return
	 * @throws NorthApiException
	 */
	public BatchTaskCreateOutDTO createBatchTask(BatchTaskCreateInDTO btcid)throws NorthApiException;
	/**
	 * 查询单个任务信息
	 * @param tasked
	 * @return
	 * @throws NorthApiException
	 */
	public QueryOneTaskOutDTO queryOneTask(String taskId) throws NorthApiException;
	/**
	 * 查询任务详情信息
	 * @param qtdid
	 * @return
	 * @throws NorthApiException
	 */
	public QueryTaskDetailsOutDTO queryTaskDetails(String taskId)throws NorthApiException;
}
