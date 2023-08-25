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

import com.b2b.DTO.BuyerLoginDTO;
import com.b2b.domain.BuyerUserVO;
import com.b2b.domain.SearchCriteria;
import com.b2b.service.BuyerUserService;

@Controller
@RequestMapping("/buyerUser")
public class BuyerUserController {

	private static final Logger logger = LoggerFactory.getLogger(BuyerUserController.class);

	@Inject
	private BuyerUserService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") BuyerLoginDTO dto) throws Exception {

	}

	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(BuyerLoginDTO dto, Model model) throws Exception {

		BuyerUserVO vo = service.login(dto);

		if (vo == null) {
			return;
		}

		model.addAttribute("BuyerUserVO", vo);

	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {

		Object buyerUserVO = session.getAttribute("login");

		if (buyerUserVO != null) {
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
	public String registerPOST(BuyerUserVO vo, RedirectAttributes rttr, Model model) throws Exception {

		logger.info("register post...");

		service.register(vo);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/buyer/list";

	}

	@RequestMapping(value = "/memberRegister", method = RequestMethod.GET)
	public void user_registerGET() throws Exception {

		logger.info("register get...");

	}

	@RequestMapping(value = "/memberRegister", method = RequestMethod.POST)
	public String user_registerPOST(BuyerUserVO vo, RedirectAttributes rttr, Model model) throws Exception {

		logger.info("register post...");

		service.register(vo);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/buyer/login";

	}

	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("b_id") String b_id, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {

		logger.info("read get...");

		model.addAttribute(service.read(b_id));

	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public String modifyPageGET(@RequestParam("b_id") String b_id, @ModelAttribute("cri") SearchCriteria cri,
			RedirectAttributes rttr, HttpSession session, Model model) throws Exception {

		logger.info("modifyPage get...");

		BuyerUserVO buyerUser = (BuyerUserVO) session.getAttribute("login");

		BuyerUserVO vo = service.read(b_id);

		if (buyerUser.getB_id().equals(vo.getB_id())) {

			model.addAttribute(service.read(b_id));
			return "/buyer/modifyPage";

		} else {

			rttr.addAttribute("b_id", b_id);
			rttr.addAttribute("page", cri.getPage());
			rttr.addAttribute("perPageNum", cri.getPerPageNum());
			rttr.addAttribute("searchType", cri.getSearchType());
			rttr.addAttribute("keyword", cri.getKeyword());

			rttr.addFlashAttribute("msg", "잘못된 접근입니다");

			return "redirect:/buyer/readPage";

		}

	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagePOST(BuyerUserVO vo, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr)
			throws Exception {

		logger.info("modifyPage posts...");

		service.modify(vo);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/buyer/list";

	}

	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("b_id") String b_id, HttpSession session,
			@ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr) throws Exception {

		BuyerUserVO buyerUser = (BuyerUserVO) session.getAttribute("login");

		BuyerUserVO vo = service.read(b_id);

		if (buyerUser.getB_id().equals(vo.getB_id())) {
			service.remove(b_id);

			rttr.addFlashAttribute("msg", "SUCCESS");
			return "redirect:/buyer/list";

		} else {

			rttr.addFlashAttribute("b_id", "b_id");
			rttr.addFlashAttribute("page", "cri.getPage");
			rttr.addFlashAttribute("perPageNum", "cri.getperPageNum");
			rttr.addFlashAttribute("searchType", "cri.getsearchType");
			rttr.addFlashAttribute("keyword", "cri.getkeyword");

			rttr.addFlashAttribute("msg", "잘못된 접근입니다");

			return "redirect:/buyer/readPage";

		}

	}

}
