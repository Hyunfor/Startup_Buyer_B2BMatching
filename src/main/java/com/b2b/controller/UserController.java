package com.mis.controller;

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

import com.mis.domain.SearchCriteria;
import com.mis.domain.UserVO;
import com.mis.dto.LoginDTO;
import com.mis.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private UserService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto) throws Exception {

	}

	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, Model model) throws Exception {

		UserVO vo = service.login(dto);

		if (vo == null) {
			return;
		}

		model.addAttribute("userVO", vo);

	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {

		Object userVO = session.getAttribute("login");

		if (userVO != null) {
			session.removeAttribute("login");
			session.invalidate();
		}

		return "redirect:/";

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception {

		logger.info("register get...");

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(UserVO vo, RedirectAttributes rttr, Model model) throws Exception {

		logger.info("register post...");

		service.register(vo);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/user/list";

	}

	@RequestMapping(value = "/memberRegister", method = RequestMethod.GET)
	public void user_registerGET() throws Exception {

		logger.info("register get...");

	}

	@RequestMapping(value = "/memberRegister", method = RequestMethod.POST)
	public String user_registerPOST(UserVO vo, RedirectAttributes rttr, Model model) throws Exception {

		logger.info("register post...");

		service.register(vo);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/user/login";

	}

	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("usid") String usid, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {

		logger.info("read get...");

		model.addAttribute(service.read(usid));

	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public String modifyPageGET(@RequestParam("usid") String usid, @ModelAttribute("cri") SearchCriteria cri,
			RedirectAttributes rttr, HttpSession session, Model model) throws Exception {

		logger.info("modifyPage get...");

		UserVO user = (UserVO) session.getAttribute("login");

		UserVO vo = service.read(usid);

		if (user.getUsid().equals(vo.getUsid())) {

			model.addAttribute(service.read(usid));
			return "/user/modifyPage";

		} else {

			rttr.addAttribute("usid", usid);
			rttr.addAttribute("page", cri.getPage());
			rttr.addAttribute("perPageNum", cri.getPerPageNum());
			rttr.addAttribute("searchType", cri.getSearchType());
			rttr.addAttribute("keyword", cri.getKeyword());

			rttr.addFlashAttribute("msg", "잘못된 접근입니다");

			return "redirect:/user/readPage";

		}

	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagePOST(UserVO vo, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr)
			throws Exception {

		logger.info("modifyPage posts...");

		service.modify(vo);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("serachType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/user/list";

	}

	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("usid") String usid, HttpSession session,
			@ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr) throws Exception {

		UserVO user = (UserVO) session.getAttribute("login");

		UserVO vo = service.read(usid);

		if (user.getUsid().equals(vo.getUsid())) {
			service.remove(usid);

			rttr.addFlashAttribute("msg", "SUCCESS");
			return "redirect:/user/list";

		} else {

			rttr.addFlashAttribute("usid", "usid");
			rttr.addFlashAttribute("page", "cri.getPage");
			rttr.addFlashAttribute("perPageNum", "cri.getperPageNum");
			rttr.addFlashAttribute("searchType", "cri.getsearchType");
			rttr.addFlashAttribute("keyword", "cri.getkeyword");

			rttr.addFlashAttribute("msg", "잘못된 접근입니다");

			return "redirect:/usid/readPage";

		}

	}

}
