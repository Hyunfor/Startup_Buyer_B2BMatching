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

import com.b2b.domain.SearchCriteria;
import com.b2b.domain.StartUpUserVO;
import com.b2b.domain.StartupVO;
import com.b2b.dto.StartUpLoginDTO;
import com.b2b.service.StartUpUserService;
import com.b2b.service.StartupService;

@Controller
@RequestMapping("/startupUser")
public class StartUpUserController {

	private static final Logger logger = LoggerFactory.getLogger(StartUpUserController.class);

	@Inject
	private StartUpUserService service;
	
	@Inject
	private StartupService startservice;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") StartUpLoginDTO dto) throws Exception {

	}

	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(StartUpLoginDTO dto, HttpSession session, Model model) throws Exception {

		logger.info("dto =======> " + dto);
		
		StartUpUserVO vo = service.login(dto);
		
		logger.info("loginPost =======> " + vo);

		if (vo == null) {
			return;
		}

		model.addAttribute("startUpUserVO", vo);

	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {

		Object startUpUserVO = session.getAttribute("login");

		if (startUpUserVO != null) {
			session.removeAttribute("login");
			session.invalidate();
		}

		return "redirect:/";

	}

	@RequestMapping(value = "/memberRegister", method = RequestMethod.GET)
	public void user_registerGET() throws Exception {

		logger.info("register get...");
		
		
	}

	@RequestMapping(value = "/memberRegister", method = RequestMethod.POST)
	public String user_registerPOST(StartUpUserVO vo, StartupVO svo, RedirectAttributes rttr, Model model) throws Exception {

		logger.info("register post...");
		
		

		service.register(vo);
		
		svo.setStartupId(vo.getsId());
		svo.setNames(vo.getsName());
		
	
		startservice.register(svo);
		
		
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/";

	}

	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("sId") String sId, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {

		logger.info("read get...");

		model.addAttribute(service.read(sId));

	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public String modifyPageGET(@RequestParam("sId") String sId, @ModelAttribute("cri") SearchCriteria cri,
			RedirectAttributes rttr, HttpSession session, Model model) throws Exception {

		logger.info("modifyPage get...");

		StartUpUserVO startUpUser = (StartUpUserVO) session.getAttribute("login");

		StartUpUserVO vo = service.read(sId);

		if (startUpUser.getsId().equals(vo.getsId())) {

			model.addAttribute(service.read(sId));
			return "/starupUser/modifyPage";

		} else {

			rttr.addAttribute("sId", sId);
			rttr.addAttribute("page", cri.getPage());
			rttr.addAttribute("perPageNum", cri.getPerPageNum());
			rttr.addAttribute("searchType", cri.getSearchType());
			rttr.addAttribute("keyword", cri.getKeyword());

			rttr.addFlashAttribute("msg", "잘못된 접근입니다");

			return "redirect:/startupUser/readPage";

		}

	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagePOST(StartUpUserVO vo, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr)
			throws Exception {

		logger.info("modifyPage posts...");

		service.modify(vo);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("serachType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/startupUser/readPage";

	}

}
