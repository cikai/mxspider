package com.mxnavi.dao;

import java.util.List;

import com.mxnavi.dto.ListDto;

public interface MainDao {

	public List<ListDto> select();
	
	public List<ListDto> selectById(String pageNo);

}
