package com.green.nowon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.green.nowon.domain.entity.NoticeEntity;
import com.green.nowon.domain.entity.NoticeEntityRepository;

@SpringBootTest
class Web240612JpaMybatis01ApplicationTests {
	
	@Autowired
	NoticeEntityRepository noRep;
	
	@Test
	void contextLoads() {
	
		noRep.save(NoticeEntity.builder()
				.title("전체 테스트4")
				.content("전체 내용테스트4")
				.division("전체")
				.fixed(false)
				.build());
	}

}
