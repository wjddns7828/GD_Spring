package com.min.edu.anno02;
/**
 * TODO anno02 02_02 NickName클래스를 맴버필드로 가지고 있는 POJO 클래스
 * @author GDJ67
 */
public class NickNameProp {
	private NickName nickName;

	public NickName getNickName() {
		return nickName;
	}

	public void setNickName(NickName nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "NickNameProp [nickName=" + nickName + "]";
	}
	
}
