package com.green.nowon.domain.entity;

import org.hibernate.annotations.DynamicUpdate;

import com.green.nowon.domain.dto.NoticeDetailDTO;
import com.green.nowon.domain.dto.NoticeListDTO;
import com.green.nowon.domain.dto.NoticeUpdateDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@DynamicUpdate
@SequenceGenerator(name = "gen_notice",
sequenceName = "seq_notice", initialValue = 1, allocationSize = 1)
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Table(name = "notice")
@Entity
public class NoticeEntity extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_notice")
	private long no;
	@Column(nullable = false)
	private String title;
	@Column(columnDefinition = "text",  nullable = false)
	private String content;
	private int readCount;
	
	private String division; //구분 -"전체","영화관"
	private boolean fixed;
	
	//조회수 증가시키는 편의메서드
	public NoticeEntity incrementReadCount() {
			readCount++;
			return this;
	}
	
	//제목 또는 내용 수정
	public NoticeEntity update(NoticeUpdateDTO dto) {
		this.title=dto.getTitle();
		this.content=dto.getContent();
		return this;
		
	}
	
	//편의메서드 NoticeEntity -> NoticeListDTO 매핑하기 위한 메서드
	public NoticeListDTO toNoticeListDTO() {
		return NoticeListDTO.builder()
				.no(no)
				.title(title)
				.division(division)
				.fixed(fixed)
				.updatedAt(updatedAt)
				.build();
	}
	
	public NoticeDetailDTO toNoticeDetailDTO() {
		return NoticeDetailDTO.builder()
				.no(no)
				.title(title)
				.content(content)
				.division(division)
				.createdAt(createdAt)
				.updatedAt(updatedAt)
				.readCount(readCount)
				.build();
	}


	
}
