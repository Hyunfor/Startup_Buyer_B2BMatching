package com.b2b.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.b2b.domain.PageMaker;
import com.b2b.domain.SearchCriteria;
import com.b2b.service.StartupService;

@Controller
@RequestMapping("/startupCommon/*")
public class StartupCommonController {
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(StartupCommonController.class);
	
	@Inject
	private StartupService service;

	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		model.addAttribute("list", service.listSearchCriteria(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCountCriteria(cri));

		model.addAttribute("pageMaker", pageMaker);

	}

	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void readPage(@RequestParam("startupId") String startupId, @ModelAttribute("cri") SearchCriteria cri,
			Model model) throws Exception {

		model.addAttribute(service.read(startupId));

	}
	
	
	
	
	
	
	

}
