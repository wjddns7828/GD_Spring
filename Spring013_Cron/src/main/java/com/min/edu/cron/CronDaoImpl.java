package com.min.edu.cron;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CronDaoImpl implements ICronDao{
	
	private final String NS="com.min.edu.cron.CronDaoImpl.";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void test() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date times = new Date();
		String timeStr = date.format(times);
		System.out.println("-----스케줄러 동작 시간 ->" +timeStr);
	}

	@Override
	public void new_item() {
		String str = sqlSession.selectOne(NS+"autoDatePrint");
		System.out.println("--------------데이터베이스 호출 시간 -> "+str);
	}

}
