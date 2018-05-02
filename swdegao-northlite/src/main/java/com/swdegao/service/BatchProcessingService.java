package com.swdegao.service;

import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.BatchTaskCreateInDTO;
import com.swdegao.common.ResponseMessage;

public interface BatchProcessingService {
	
	/**
	 * 创建批量任务
	 * @param btcid
	 * @return
	 * @throws NorthApiException
	 */
	public ResponseMessage createBatchTask(BatchTaskCreateInDTO btcid);
	/**
	 * 查询单个任务信息
	 * @param tasked
	 * @return
	 * @throws NorthApiException
	 */
	public ResponseMessage queryOneTask(String taskId);
	/**
	 * 查询任务详情信息
	 * @param qtdid
	 * @return
	 * @throws NorthApiException
	 */
	public ResponseMessage queryTaskDetails(String taskId);
}
