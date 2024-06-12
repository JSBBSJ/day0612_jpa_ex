package com.green.nowon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequestMapping("/cscenter/faq")
@Controller
@RequiredArgsConstructor
public class FaqController {
	
	@GetMapping // /cscenter/faq
	public String list() {
		return "views/cs/faq/list";
	}
	
}
