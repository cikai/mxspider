package com.mxnavi.service;

import java.util.List;

import com.mxnavi.dto.ListDto;

public interface MainService {

	public List<ListDto> getList();
	
	public List<ListDto> getListById(String pageNo);

}
