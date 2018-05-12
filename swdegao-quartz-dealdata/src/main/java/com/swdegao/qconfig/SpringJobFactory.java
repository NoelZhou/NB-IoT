package com.swdegao.qconfig;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

@Component
public class SpringJobFactory extends AdaptableJobFactory {
	
	@Autowired
	public  AutowireCapableBeanFactory capableBeanFactory;

	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
		// TODO Auto-generated method stub
		Object jobInstance = super.createJobInstance(bundle);		
		//注入job到spring中
		capableBeanFactory.autowireBean(jobInstance);		
		return jobInstance;
	}
	
	
	
}
