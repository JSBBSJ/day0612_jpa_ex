package com.green.nowon.domain.dto;

import com.green.nowon.domain.entity.Division;
import com.green.nowon.domain.entity.FaqEntity;

import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
public class FaqSaveDTO {
	
	//필드이름은 form태그 내부의 입력요소(input,select,textarea...)들의 name과 일치해야함
	Division division;
	String question;
	String answer;
	
	public FaqEntity toEntity() {
		return FaqEntity.builder()
				.division(division)
				.question(question)
				.answer(answer)				
				.build();
				
	}
}
