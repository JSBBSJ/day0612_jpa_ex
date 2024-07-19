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

import com.green.nowon.domain.dto.FaqSaveDTO;
import com.green.nowon.domain.dto.NoticeListDTO;
import com.green.nowon.domain.dto.NoticeSaveDTO;
import com.green.nowon.domain.dto.NoticeUpdateDTO;
import com.green.nowon.domain.entity.FaqEntityRepository;
import com.green.nowon.domain.entity.NoticeEntity;
import com.green.nowon.domain.entity.NoticeEntityRepository;
import com.green.nowon.service.FaqService;
import com.green.nowon.service.NoticeService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FaqServiceProcess implements FaqService{
	
	private final FaqEntityRepository repository;
	
	@Override
	public void saveProcess(FaqSaveDTO dto) {
		repository.save(dto.toEntity());
		
	}
	
}
