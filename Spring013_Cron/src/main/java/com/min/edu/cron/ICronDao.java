package com.min.edu.cron;

public interface ICronDao {
	//CRON을 통해서 6초에 한번씩 자동으로 실행되는 DAO
	public void test();
	
	//service -> dao -> Mybatis 결과를 출력하는 CRON
	public void new_item();
}
