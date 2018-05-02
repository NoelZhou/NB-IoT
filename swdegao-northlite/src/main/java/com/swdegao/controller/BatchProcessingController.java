package com.swdegao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.BatchTaskCreateInDTO;
import com.huawei.iotplatform.client.dto.BatchTaskCreateOutDTO;
import com.huawei.iotplatform.client.dto.QueryOneTaskOutDTO;
import com.huawei.iotplatform.client.dto.QueryTaskDetailsOutDTO;
import com.swdegao.service.BatchProcessingService;

@RestController
@RequestMapping(value = "/batch")
public class BatchProcessingController {

	@Autowired
	public BatchProcessingService bService;

	/**
	 * Body: 
	 * { 
	 * "appId" : "******", 
	 * "timeout" : 1000, 
	 * "taskName" : "******",
	 * "taskType" : "DeviceReg", 
	 * "param" : { "fileId" : "******" } 
	 * }
	 * @param btcid
	 * @return
	 */
	@PostMapping("/createBatchTask")
	public Object createBatchTask(@RequestBody BatchTaskCreateInDTO btcid) {
		Object obj = null;
		BatchTaskCreateOutDTO bOutDTO = null;
		try {
			bOutDTO = bService.createBatchTask(btcid);
			obj = JSON.toJSON(bOutDTO);
		} catch (NorthApiException e) {
			obj = e.toString();
		}
		return obj;
	}

	@GetMapping("/queryOneTask/{taskId}")
	public Object queryOneTask(@PathVariable String taskId) {
		Object obj = null;
		QueryOneTaskOutDTO qOutDTO = null;
		try {
			qOutDTO = bService.queryOneTask(taskId);
			obj = JSON.toJSON(qOutDTO);
		} catch (NorthApiException e) {
			obj = e.toString();
		}
		return obj;
	}

	@GetMapping("/queryTaskDetails/{taskId}")
	public Object queryTaskDetails(@PathVariable String taskId) {
		Object obj = null;
		QueryTaskDetailsOutDTO qOutDTOs = null;
		try {
			qOutDTOs = bService.queryTaskDetails(taskId);
			obj = JSON.toJSON(qOutDTOs);
		} catch (NorthApiException e) {
			obj = e.toString();
		}
		return obj;
	}

}
