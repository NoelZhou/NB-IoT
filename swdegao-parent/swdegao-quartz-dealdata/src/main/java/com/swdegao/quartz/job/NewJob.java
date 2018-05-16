package com.swdegao.quartz.job;

import java.util.Date;  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import org.quartz.JobExecutionContext;  
import org.quartz.JobExecutionException;  
  
public class NewJob implements BaseJob {  
  
    private static Logger _log = LoggerFactory.getLogger(NewJob.class);  
    private String jobName= "RealTimeDataForDevices";
	private String jobGroup= "RealTimeDataForDevicesGroup";
	private String description= "处理指定终端设备的数据解析";
	private String cronExpression;
	private String triggerName;
	private String triggerState;
	
	
//    this._name = "RealTimeDataForDevices";
//    this._displayName = "指定终端设备数据解析任务";
//    this._groupName = "RealTimeDataForDevicesGroup";
//    this._description = "处理指定终端设备的数据解析";
//    this._cronVersion = "1.0";
//    this._author = "DeGao Team";
     
    public void execute(JobExecutionContext context)  
        throws JobExecutionException {  
        _log.error("New Job执行时间: " + new Date());  
          
    }

	@Override
	public String Name() {
		return this.jobName;
	}

	@Override
	public String DisplayName() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String GroupName() {
		return this.jobGroup;
	}


	@Override
	public String Description() {
		return description;
	}


	@Override
	public String CronVersion() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String Author() {
		// TODO Auto-generated method stub
		return null;
	}  
}  
