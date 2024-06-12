package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.nowon.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/cscenter/notices")
@Controller
@RequiredArgsConstructor
public class NoticeController {
	
	
	private final NoticeService service;
	
	@GetMapping // /cscenter/faq
	public String list(Model model) {
		service.listProcess(model);
		return "views/cs/notice/list";
	}
	
}
