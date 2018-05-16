package com.swdegao.quartz.service;

import org.springframework.stereotype.Component;
import com.github.pagehelper.PageInfo;
import com.swdegao.quartz.entity.JobAndTrigger;

@Component
public interface IJobAndTriggerService {
		/**
		 * 获取所有的定时任务列表
		 * @param jobAndTri 
		 * @param pageNum
		 * @param pageSize
		 * @return
		 */
		public PageInfo<JobAndTrigger> getJobAndTriggerDetails(JobAndTrigger jobAndTri, int pageNum, int pageSize);
}
