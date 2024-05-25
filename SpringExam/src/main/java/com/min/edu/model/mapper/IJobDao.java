package com.min.edu.model.mapper;

import java.util.List;

import com.min.edu.vo.JobsVo;

public interface IJobDao {
	public List<JobsVo> selAll();
	public int insertJob(JobsVo vo);
	public int updateJob();
}
