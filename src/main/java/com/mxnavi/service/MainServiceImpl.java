package com.mxnavi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mxnavi.dao.MainDao;
import com.mxnavi.dto.ListDto;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	MainDao dao = null;

	@Override
	public List<ListDto> getList() {
		List<ListDto> list = dao.select();
		return list;
	}

	@Override
	public List<ListDto> getListById(String pageNo) {
		List<ListDto> list = dao.selectById(pageNo);
		return list;
	}

}
