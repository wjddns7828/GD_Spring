package com.min.edu.anno03.sub;

import org.springframework.stereotype.Component;

/**
 *  TODO anno03 03_01 NickName3의 POJO클래스를 Bean으로 등록하기 위해서 @Component를 사용
 * 		 Componet-scnan에 의해서 com.min.edu.anno03. 하위에 있는 모든 Spring Annotation을 자동으로 등록됨
 */

@Component
public class NickName3 {
	public NickName3() {
	}

	@Override
	public String toString() {
		return "NickName3 = 카시오페아 ";
	}
}
