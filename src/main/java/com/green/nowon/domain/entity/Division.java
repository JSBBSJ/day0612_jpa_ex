package com.green.nowon.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//Enum
//정한 이름을 가지는 상수들의 집합을 정의
//enum -> 문자로 표현 가독성 향상,타입의 안정성
@Getter
@RequiredArgsConstructor
public enum Division {
	
	//상수필드
	USE(1, "영화관 이용"), 			//String name="USE", int ordinal = 0
	SPECIAL(2, "스페셜관"),		//String name="SPECIAL", int ordinal = 1
	LPOINT(3,"L.POINT"),			//String name="LPOINT", int ordinal = 2
	MEMBER(4,"회원"),			//String name="MEMBER", int ordinal = 3
	MEMBER_SHIP(5,"멤버쉽"),	//String name="MEMBER_SHIP", int ordinal = 4	
	ONLINE(6,"온라인"),			//String name="ONLINE", int ordinal = 5
	BENEFIT(7,"할인혜택"),		//String name="BENEFIT", int ordinal = 6
	TICKET(8,"관람권"),			//String name="TICKET", int ordinal = 7
	STORE(9,"스토어"),			//String name="STORE", int ordinal = 8
	LOTTHY(10,"롯시클럽");			

	//String name="LOTTHY", int ordinal = 9
	
	private final int no;
	private final String KoName;
	
	/*
	Division(int rnum) {
		this.rnum=rnum;
	}
	//*/
}
