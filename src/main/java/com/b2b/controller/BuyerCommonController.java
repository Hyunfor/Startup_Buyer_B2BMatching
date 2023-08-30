package com.b2b.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.b2b.domain.PageMaker;
import com.b2b.domain.SearchCriteria;
import com.b2b.service.BuyerService;

@Controller
@RequestMapping("/buyerCommon/*")
public class BuyerCommonController {

	private static final Logger logger = LoggerFactory.getLogger(BuyerCommonController.class);

	@Inject
	private BuyerService service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info("list get ...");

		model.addAttribute("list", service.listSearch(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);

	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void readPage(@RequestParam("buyerId") int buyerId, HttpSession session,
			@ModelAttribute("cri") SearchCriteria cri, Model model, RedirectAttributes rttr) throws Exception {

		model.addAttribute(service.readPage(buyerId));

	}

}
