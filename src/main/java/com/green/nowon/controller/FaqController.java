package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.nowon.domain.dto.FaqSaveDTO;
import com.green.nowon.service.FaqService;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Division;
import org.springframework.web.bind.annotation.RequestBody;


@RequestMapping("/cscenter/faq")
@Controller
@RequiredArgsConstructor
public class FaqController {
	
	private final FaqService service;
	
//	//조회
//	@GetMapping("/{division}")
//	public String detail(@PathVariable("division") String division, Model model) {
//		service.detailProcess(division,model);
//		return "views/cs/notice/detail";
//	}
	
	
	
	@GetMapping // /cscenter/faq
	public String list() {
		//Division[] divs= Division.values();
		return "views/cs/faq/list";
	}
	
	//faq 쓰기 페이지 이동
	@GetMapping("/new")
	public String write() {
		return "views/cs/faq/write";
	}
	
	
	@PostMapping
	public String save(FaqSaveDTO dto) {
		service.saveProcess(dto);
		return "redirect:/cscenter/faq";
	}
	
	
}
