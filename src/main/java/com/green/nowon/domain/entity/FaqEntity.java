package com.green.nowon.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

@SequenceGenerator(name = "gen_faq",
		sequenceName = "seq_faq", initialValue = 1, allocationSize = 1)
@Builder
@AllArgsConstructor(access=AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Table(name="faq")
@Entity

public class FaqEntity extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_faq")
	private long no;
	
	@Column(nullable = false) //not null
	@Enumerated(EnumType.STRING)//enum타입을 컬럼타입을 문자열로 지정 - @Enumerated 기본은 ordinal적용
	private Division division;
	
	@Column(columnDefinition = "text", nullable = false) 
	private String answer;
	
	@Column(nullable = false)
	private String question;
	
}
