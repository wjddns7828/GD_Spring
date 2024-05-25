package com.min.edu.anno06;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

/**
 * TODO anno06 06_01 Lombok을 통한 생성자 주입 처리
 * -- 생성자 주입을 사용 할 경우 많은 장점을 가지고 있다
 * 	1) 순환참조 방지
 * 	2) 테스트 코드 작성 용이
 * 	3) 악성 코드 제거
 * 	4) 객체 변이 방지(final)
 */
@Component(value="userServiceImpl2")
@RequiredArgsConstructor
public class UserServiceImpl2 implements IUserService {

	private final UserDto userDto;
	
	@Override
	public void addUser() {
		System.out.println("추가된 맴버 : "+userDto.getName());
	}
}
