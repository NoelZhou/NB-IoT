package com.swdegao.quartz.service;

import org.springframework.stereotype.Component;

import com.github.pagehelper.PageInfo;
import com.swdegao.quartz.entity.JobAndTrigger;

@Component
public interface IJobAndTriggerService {
		public PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize);
}
