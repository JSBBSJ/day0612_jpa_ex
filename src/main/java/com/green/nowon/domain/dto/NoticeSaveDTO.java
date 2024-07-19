package com.green.nowon.domain.dto;

import java.time.LocalDateTime;

import com.green.nowon.domain.entity.NoticeEntity;

import lombok.Setter;
import lombok.ToString;
@ToString
@Setter//controller에서 메서드바인딩(파라미터 매핑)시 setter메서드가 있어야함.
public class NoticeSaveDTO{
	
	private String title;
	private String division; //구분 -"전체","영화관"
	private boolean fixed;//고정여부
	private String content;
	
	//formdata->dto->entity
	public NoticeEntity toEntity() {
		return NoticeEntity.builder()
				.division(division).fixed(fixed).title(title).content(content)			
				.build();
	}
}
