package com.green.nowon.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
import com.green.nowon.domain.dto.NoticeSaveDTO;
import com.green.nowon.domain.dto.NoticeUpdateDTO;
import com.green.nowon.domain.entity.NoticeEntity;
import com.green.nowon.domain.entity.NoticeEntityRepository;
import com.green.nowon.service.NoticeService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeServiceProcess implements NoticeService{
	
	private final NoticeEntityRepository repository;
	@Override
	public void listProcess(int _division,Model model) {
		int pageNumber=1; //1페이지
		int pageSize=10; //최대 10개까지
		
		Sort sort = Sort.by(Direction.DESC, "fixed", "no");
		Pageable pageable = PageRequest.of(pageNumber-1, pageSize, sort);
		
		String division =_division==1?"전체":"영화관";
		
		//JPA 쿼리메서드 : findAll()
		//사용자가 만들 수 있는 쿼리 메서드 문법-키워드
		Page<NoticeEntity> result=repository.findAllByDivision(division,pageable);
		
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
	
	//저장처리
	@Override
	public void saveProcess(NoticeSaveDTO dto) {
		System.out.println("---------save start");
		repository.save(dto.toEntity());
		System.out.println("---------save end");
	}

	@Override
	//@Transactional //객체를 수정하면 업데이트가 진행됨, 메서드종료될때까지 유지한다.
	public void detailProcess(long no, Model model) {
		//상세정보 조회해서 model에 담아라
		System.out.println("---------findById start");
		//Null Pointer Exception 방지:
		//map(), flatmap(), filter()
		NoticeEntity result= repository.findById(no).orElseThrow();
		model.addAttribute("detail", result.toNoticeDetailDTO());
		result.incrementReadCount();
		repository.save(result);
		//JPA를 사용시 SqlSession이 유지되는 동안 Entity가 수정되면 -> update쿼리가 처리됨.
		System.out.println("---------findById end");
				
	}
	
	//orElseThrow()); 존재하면 리턴 존재하지 않으면 예외처리
	@Override
	public void deleteProcess(long no) {
		// no(pk)해당하는 공지 db에서 삭제
		repository.delete(repository.findById(no).orElseThrow());
		
		//repository.deleteById(no);
	}
	
	
	@Override
	@Transactional
	public void updateProcess(long no, NoticeUpdateDTO dto) {
		// 1.수정 할 대상을 조회
		// 2.변경사항을 적용 -> 수정됨(@Transational 인 경우)
		// 3.저장
		//repository.save(repository.findById(no).orElseThrow().update(dto));//수정처리
		
		repository.findById(no).orElseThrow().update(dto);
		
		
	}

}
