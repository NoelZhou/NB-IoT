package com.swdegao.quartz.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.swdegao.quartz.entity.JobAndTrigger;


@Component
@Mapper
@Repository
public interface JobAndTriggerMapper {
	public List<JobAndTrigger> getJobAndTriggerDetails();
}
