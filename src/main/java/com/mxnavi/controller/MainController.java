package com.mxnavi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mxnavi.dto.FormDto;
import com.mxnavi.dto.ListDto;
import com.mxnavi.model.FormModel;
import com.mxnavi.model.ListModel;
import com.mxnavi.service.MainService;

@Controller
public class MainController {

	@Autowired
	MainService service = null;

	@RequestMapping("/add")
	@ResponseBody
	public void addArticle() {
		NewsCrawler nc = new NewsCrawler(null, false);
		try {
			nc.spider();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/list")
	@ResponseBody
	public Map<String, Object> list() {
		List<ListDto> listDto = service.getList();
		List<ListModel> listModel = listDto.stream().map(this::dtoToModel).collect(Collectors.toList());
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("list", listModel);
		return resultMap;
	}

	public FormDto modelToDto(FormModel formModel) {
		FormDto formDto = new FormDto();
		formDto.setId(formModel.getId());
		return formDto;
	}

	public ListModel dtoToModel(ListDto listDto) {
		ListModel listModel = new ListModel();
		listModel.setId(listDto.getId());
		listModel.setUrl(listDto.getUrl());
		listModel.setTitle(listDto.getTitle());
		listModel.setContent(listDto.getContent());
		return listModel;
	}

}
