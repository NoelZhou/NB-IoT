package com.swdegao.dao;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import com.swdegao.qentity.QuartzEntity;

@Mapper
@Repository
public interface QuartzTask {
	
	public QuartzEntity getJobAndTriggerDetails();
}
