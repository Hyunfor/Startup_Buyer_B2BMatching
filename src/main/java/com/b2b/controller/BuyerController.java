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

import com.b2b.domain.BuyerUserVO;
import com.b2b.domain.BuyerVO;
import com.b2b.domain.PageMaker;
import com.b2b.domain.SearchCriteria;
import com.b2b.service.BuyerService;

@Controller
@RequestMapping("/buyer/*")
public class BuyerController {

	private static final Logger logger = LoggerFactory.getLogger(BuyerController.class);

	@Inject
	private BuyerService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception {

		logger.info("register get ...");

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(BuyerVO vo, RedirectAttributes rttr) throws Exception {

		logger.info("register post ...");

		service.register(vo);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/buyer/adminList";

	}

	@RequestMapping(value = "/adminList", method = RequestMethod.GET)
	public void adminListPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info("list get ...");

		model.addAttribute("adminList", service.listSearch(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);

	}

	@RequestMapping(value = "/matchingList", method = RequestMethod.GET)
	public void matchingListPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info("list get ...");

		model.addAttribute("matchingList", service.listSearch(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);

	}

	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("buyerId") int buyerId, HttpSession session,
			@ModelAttribute("cri") SearchCriteria cri, Model model, RedirectAttributes rttr) throws Exception {

		model.addAttribute(service.read(buyerId));

	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public String modifyPageGET(@RequestParam("buyerId") int buyerId, HttpSession session,
			@ModelAttribute("cri") SearchCriteria cri, Model model, RedirectAttributes rttr) throws Exception {

		// 수정 할 수 있으려면, 로그인한 정보와 글의 작성자 정보가 일치

		// 1) 로그인 정보 가져오기
		BuyerUserVO buyerUser = (BuyerUserVO) session.getAttribute("login");

		// 2) 게시글의 작성자 정보와 비교
		// 2-1) 게시글 정보를 가져오기
		BuyerVO vo = service.read(buyerId);

		// 2-2) 게시글 정보와 작성자 정보 비교
		if (buyerUser.getbName().equals(vo.getBuyerName())) {

			// 정보 일치 -> 수정 페이지로 이동
			model.addAttribute(vo);

			return "/buyer/modifyPage";

		} else {
			// 정보 불일치 -> 상세페이지로 강제 이동
			rttr.addAttribute("buyerId", buyerId);
			rttr.addAttribute("page", cri.getPage());
			rttr.addAttribute("perPageNum", cri.getPerPageNum());
			rttr.addAttribute("searchType", cri.getSearchType());
			rttr.addAttribute("keyword", cri.getKeyword());

			rttr.addFlashAttribute("msg", "로그인 정보가 일치하지 않아 수정 불가능 합니다.");

			return "redirect:/buyer/readPage";

		}

	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagePOST(BuyerVO vo, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr)
			throws Exception {

		service.modify(vo);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/buyer/adminList";

	}

	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String removePOST(@RequestParam("buyerId") int buyerId, @ModelAttribute("cri") SearchCriteria cri,
			RedirectAttributes rttr) throws Exception {

		service.remove(buyerId);

		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/buyer/adminList";

	}

}
