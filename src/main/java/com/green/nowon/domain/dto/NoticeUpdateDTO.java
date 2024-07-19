package com.green.nowon.domain.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeUpdateDTO{
	
	
	private String title;
	private String content;

}
