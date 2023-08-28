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

		return "redirect:/buyer/list";

	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info("list get ...");

		model.addAttribute("list", service.listSearch(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);

	}

	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("buyer_id") int buyer_id, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {

		model.addAttribute(service.read(buyer_id));

	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public String modifyPageGET(@RequestParam("buyer_id") int buyer_id, HttpSession session,
			@ModelAttribute("cri") SearchCriteria cri, Model model, RedirectAttributes rttr) throws Exception {

		// 1) 로그인 정보 가져오기
		BuyerUserVO buyerUser = (BuyerUserVO) session.getAttribute("login");

		// 2) 게시글 작성자 정보와 비교
		// 2-1) 게시글 정보 가져오기
		BuyerVO vo = service.read(buyer_id);
		// 2-2) 게시글 정보와 작성자 정보 비교
		if (buyerUser.getbId().equals(vo.getBuyerId())) {
			// 정보 일치 - > 게시글 수정
			// 목록화면으로 이동
			service.modify(vo);
			return "/buyer/modifyPage";
		} else {

			// 정보 불일치 - > 상세페이지로 강제 이동
			rttr.addAttribute("buyer_id", buyer_id);
			rttr.addAttribute("page", cri.getPage());
			rttr.addAttribute("perPageNum", cri.getPerPageNum());
			rttr.addAttribute("searchType", cri.getSearchType());
			rttr.addAttribute("keyword", cri.getKeyword());

			rttr.addFlashAttribute("msg", "잘못된 접근 입니다.");

			return "redirect:/buyer/readPage";

		}
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagePOST(BuyerVO vo, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr)
			throws Exception {

		service.modify(vo);

		// 수정 후 페이징 및 검색 기능 유지
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/buyer/list";

	}

	// 삭제하기 - > POST로 구현 - > 삭제 후 redirect처리
	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("buyer_id") int buyer_id, HttpSession session,
			@ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr) throws Exception {

		logger.info("remove get ...");

		// 삭제 하려면 로그인한 정보와 게시글의 작성자가 일치

		// 1) 로그인 정보 가져오기
		BuyerUserVO buyerUser = (BuyerUserVO) session.getAttribute("login");

		// 2) 게시글 작성자 정보와 비교
		// 2-1) 게시글 정보 가져오기
		BuyerVO vo = service.read(buyer_id);
		// 2-2) 게시글 정보와 작성자 정보 비교
		if (buyerUser.getbId().equals(vo.getBuyerId())) {
			// 정보 일치 - > 게시글 삭제
			service.remove(buyer_id);

			// 목록화면으로 이동
			rttr.addFlashAttribute("msg", "SUCCESS");
			return "redirect:/buyer/list";
		} else {

			// 정보 불일치 - > 상세페이지로 강제 이동
			rttr.addAttribute("buyer_id", buyer_id);
			rttr.addAttribute("page", cri.getPage());
			rttr.addAttribute("perPageNum", cri.getPerPageNum());
			rttr.addAttribute("searchType", cri.getSearchType());
			rttr.addAttribute("keyword", cri.getKeyword());

			rttr.addFlashAttribute("msg", "잘못된 접근 입니다.");

			return "redirect:/buyer/list";
		}

	}

}
