package com.b2b.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.b2b.domain.PageMaker;
import com.b2b.domain.SearchCriteria;
import com.b2b.domain.StartUpUserVO;
import com.b2b.domain.StartupVO;
import com.b2b.service.StartupService;

@Controller
@RequestMapping("/startup/*")

public class StartupController {

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(StartupController.class);

	@Inject
	private StartupService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception {

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(StartupVO vo, RedirectAttributes rttr) throws Exception {

		service.register(vo);

		rttr.addAttribute("msg", "SUCCESS");

		return "redirect:/startup/list";

	}

	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("startupId") String startupId, HttpSession session,
			@ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr) throws Exception {

		// 삭제하려면 로그인한 정보와 게시글의 작성자가 일치

		// 1)로그인 정보 가져오기
		StartUpUserVO startUpUser = (StartUpUserVO) session.getAttribute("login");

		// 2)게시글 작성자 정보와 비교
		// 2-1)게시글 정보 가져오기
		StartupVO vo = service.read(startupId);

		// 2-2)게시글 정보와 작성자 정보 비교 여기 수정해야함
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		if (startUpUser.getsId().equals(vo.getStartupId())) {
			// 정보일치 -> 게시글 삭제
			service.remove(startupId);
			// 목록화면으로 이동
			rttr.addAttribute("msg", "SUCCESS");

			return "redirect:/startup/list";

		} else {
			// 정보불일치 시-> 상세페이지로 강제이동
			rttr.addAttribute("startupId", startupId);
			rttr.addAttribute("page", cri.getPage());
			rttr.addAttribute("perPageNum", cri.getPerPageNum());
			rttr.addAttribute("serchType", cri.getSearchType());
			rttr.addAttribute("keyword", cri.getKeyword());

			rttr.addAttribute("msg", "잘못된 접근입니다.");

			return "redirect:/startup/readPage";
		}

	}

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

	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public String modifyPageGET(@RequestParam("startupId") String startupId, HttpSession session,
			@ModelAttribute("cri") SearchCriteria cri, Model model, RedirectAttributes rttr) throws Exception {
		// 수정하려면 로그인한 정보와 게시글의 작성자가 일치

		// 1)로그인 정보 가져오기
		StartUpUserVO startUpUser = (StartUpUserVO) session.getAttribute("login");

		// 2)게시글 작성자 정보와 비교
		// 2-1)게시글 정보 가져오기
		StartupVO vo = service.read(startupId);

		// 2-2)게시글 정보와 작성자 정보 비교 여기도 수정해야
		// 함!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		if (startUpUser.getsId().equals(vo.getStartupId())) {
			// 정보일치 -> 게시글 수정페이지 이동
			model.addAttribute(service.read(startupId));
			
			
			return "/startup/modifyPage";

		} else {
			// 정보불일치 시-> 상세페이지로 강제이동
			rttr.addAttribute("startupId", startupId);
			rttr.addAttribute("page", cri.getPage());
			rttr.addAttribute("perPageNum", cri.getPerPageNum());
			rttr.addAttribute("serchType", cri.getSearchType());
			rttr.addAttribute("keyword", cri.getKeyword());

			rttr.addAttribute("msg", "잘못된 접근입니다.");

			return "redirect:/startup/readPage";
		}

	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagePOST(StartupVO vo, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr)
			throws Exception {

		service.modify(vo);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/startup/list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
