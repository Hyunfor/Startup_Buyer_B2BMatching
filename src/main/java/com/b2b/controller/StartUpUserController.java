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

import com.b2b.DTO.StartUpLoginDTO;
import com.b2b.domain.SearchCriteria;
import com.b2b.domain.StartUpUserVO;
import com.b2b.service.StartUpUserService;

@Controller
@RequestMapping("/startupUser")
public class StartUpUserController {

	private static final Logger logger = LoggerFactory.getLogger(StartUpUserController.class);

	@Inject
	private StartUpUserService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") StartUpLoginDTO dto) throws Exception {

	}

	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(StartUpLoginDTO dto, Model model) throws Exception {

		StartUpUserVO vo = service.login(dto);

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
	public String user_registerPOST(StartUpUserVO vo, RedirectAttributes rttr, Model model) throws Exception {

		logger.info("register post...");

		service.register(vo);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/startup/login";

	}

	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("s_id") String s_id, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {

		logger.info("read get...");

		model.addAttribute(service.read(s_id));

	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public String modifyPageGET(@RequestParam("s_id") String s_id, @ModelAttribute("cri") SearchCriteria cri,
			RedirectAttributes rttr, HttpSession session, Model model) throws Exception {

		logger.info("modifyPage get...");

		StartUpUserVO startUpUser = (StartUpUserVO) session.getAttribute("login");

		StartUpUserVO vo = service.read(s_id);

		if (startUpUser.getS_id().equals(vo.getS_id())) {

			model.addAttribute(service.read(s_id));
			return "/user/modifyPage";

		} else {

			rttr.addAttribute("s_id", s_id);
			rttr.addAttribute("page", cri.getPage());
			rttr.addAttribute("perPageNum", cri.getPerPageNum());
			rttr.addAttribute("searchType", cri.getSearchType());
			rttr.addAttribute("keyword", cri.getKeyword());

			rttr.addFlashAttribute("msg", "잘못된 접근입니다");

			return "redirect:/startup/readPage";

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

		return "redirect:/start/list";

	}

}
