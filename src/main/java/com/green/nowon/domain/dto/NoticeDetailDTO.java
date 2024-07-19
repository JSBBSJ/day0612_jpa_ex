package com.green.nowon.domain.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NoticeDetailDTO{
	
	
	private long no;
	private String title;
	private String content;
	private String division; //구분 -"전체","영화관"
	private int readCount;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
