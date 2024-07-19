package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.nowon.domain.dto.NoticeSaveDTO;
import com.green.nowon.domain.dto.NoticeUpdateDTO;
import com.green.nowon.domain.entity.Division;
import com.green.nowon.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/cscenter/notices")
@Controller
@RequiredArgsConstructor
public class NoticeController {
	
	
	private final NoticeService service;
	
	//Division에 있는 데이터만 허용
	Division div = Division.LPOINT;
	
	//공지사항 글쓰기
	@PostMapping
	public String save(/*@ModelAttribute*/ NoticeSaveDTO dto) {
		//System.out.println("NoticeSaveDTO" + dto);
		service.saveProcess(dto);
		
		return "redirect:/cscenter/notices";
	}
	
	// /cscenter/notices -> 전체 공지사항 페이지
	@GetMapping
	public String list() {
		return "redirect:/cscenter/notices/cinemas/1";
	}
	
	//상세페이지 조회
	@GetMapping("/{no}")
	public String detail(@PathVariable("no") long no, Model model) {
		service.detailProcess(no,model);
		return "views/cs/notice/detail";
	}
	
	//삭제
	@DeleteMapping("/{no}")
	public String delete(@PathVariable("no") long no) {
		service.deleteProcess(no);
		return "redirect:/cscenter/notices";
	}
	
	//업데이트
	@PutMapping("/{no}")
	public String update(@PathVariable("no") long no, NoticeUpdateDTO dto) {
		//수정할 no  수정할DATA-dto
		service.updateProcess(no,dto);
		
		return "redirect:/cscenter/notices/{no}";
	}
	
	// 1->전체 공지 2->영화관공지
	@GetMapping("/cinemas/{division}")
	public String list(@PathVariable("division") int division ,Model model) {
		System.out.println("division:" + division);
		service.listProcess(division,model);
		return "views/cs/notice/list";
	}
	
	@GetMapping("/new")
	public String wirte() {
		return "views/cs/notice/write";
	}
	
}
