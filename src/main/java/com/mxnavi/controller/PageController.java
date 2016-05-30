package com.mxnavi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping("/main")
	@ResponseBody
	public ModelAndView initPage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("articleList");
		return view;
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public ModelAndView testPage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("article");
		return view;
	}

}
