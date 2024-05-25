package com.min.edu.bean1;

public class MessageBeanImpl implements IMessageBean {
/**
 * 은닉화 되어있는 맴버필드를 가지고 있다
 * 기능을 구현한 Override된 메소드를 가지고 있다
 * 
 * 
 */
	private String coffe;
	private String price;
	
	
	public MessageBeanImpl(String coffe, String price) {
		super();
		this.coffe = coffe;
		this.price = price;
	}

	public MessageBeanImpl() {
		this.coffe = "케냐AA";
		this.price ="1000";
	}



	@Override
	public void call() {
		System.out.printf("%s의 커피 가격은? %s 입니다 \n",coffe,price);
	}
}
