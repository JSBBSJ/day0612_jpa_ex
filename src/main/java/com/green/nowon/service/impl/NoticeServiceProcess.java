package com.green.nowon.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.green.nowon.domain.dto.NoticeListDTO;
import com.green.nowon.domain.entity.NoticeEntity;
import com.green.nowon.domain.entity.NoticeEntityRepository;
import com.green.nowon.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeServiceProcess implements NoticeService{
	
	private final NoticeEntityRepository repository;
	@Override
	public void listProcess(Model model) {
		int pageNumber=1; //1페이지
		int pageSize=10; //최대 10개까지
		
		Sort sort = Sort.by(Direction.DESC, "fixed", "no");
		Pageable pageable = PageRequest.of(pageNumber-1, pageSize, sort);
		
		Page<NoticeEntity> result=repository.findAll(pageable);
		
		model.addAttribute("list", result.getContent().stream()
										
										//매개변수가 1개인경우에 () 생략가능 , {return null;} {} 내용이 1줄인데 return 생략가능
										.map(NoticeEntity::toNoticeListDTO)//메서드 참조를 사용할 수 있다.
										.collect(Collectors.toList()));

		/*
		List<NoticeEntity> list=result.getContent();
		
		List<NoticeListDTO> dtoList=new ArrayList<>();
		for(NoticeEntity ent:list) {
			NoticeListDTO dto = new NoticeListDTO(ent.getNo(),ent.getTitle(),ent.getDivision(),ent.isFixed(),ent.getUpdatedAt());
			dtoList.add(null);
		}
		
		model.addAttribute("list", dtoList);
		*/
	}

}
