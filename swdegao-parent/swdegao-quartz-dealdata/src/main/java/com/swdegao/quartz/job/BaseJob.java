package com.swdegao.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public interface BaseJob extends Job{
	
	
	public String Name();
	public String DisplayName(); 
	public String GroupName();  
	public String Description(); 
	public String CronVersion();  
	public String Author(); 
    
	public void execute(JobExecutionContext context) throws JobExecutionException;
}

