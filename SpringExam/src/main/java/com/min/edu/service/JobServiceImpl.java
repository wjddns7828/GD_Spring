package com.min.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.model.mapper.IJobDao;
import com.min.edu.vo.JobsVo;

@Service
public class JobServiceImpl implements IJobService {

	@Autowired
	private IJobDao dao;
	
	@Override
	public List<JobsVo> selAll() {
		return dao.selAll();
	}

	@Override
	public int insertJob(JobsVo vo) {
		int m = dao.updateJob();
		int n = dao.insertJob(vo);
		return (m>0||n>0)?1:0;
	}
}
