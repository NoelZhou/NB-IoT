package com.swdegao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.huawei.iotplatform.client.dto.BatchTaskCreateInDTO;
import com.swdegao.common.ResponseMessage;
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
	public ResponseMessage createBatchTask(@RequestBody BatchTaskCreateInDTO btcid) {
		return bService.createBatchTask(btcid);
	}

	@GetMapping("/queryOneTask/{taskId}")
	public ResponseMessage queryOneTask(@PathVariable String taskId) {
		return bService.queryOneTask(taskId);
	}

	@GetMapping("/queryTaskDetails/{taskId}")
	public ResponseMessage queryTaskDetails(@PathVariable String taskId) {
		return bService.queryTaskDetails(taskId);
	}

}
