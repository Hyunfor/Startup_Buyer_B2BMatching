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
import com.b2b.domain.ProductVO;
import com.b2b.domain.SearchCriteria;
import com.b2b.domain.UserVO;
import com.b2b.service.ProductService;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Inject
	private ProductService service;

	// 상품 등록
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception {

		logger.info("register get ...");

	}

	// 상품등록 정보 등록
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(ProductVO vo) throws Exception {

		logger.info("register post ...");

		// 상품 등록
		service.register(vo);

		return "redirect:/product/list";

	}

	// 상품 목록
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info("list get ...");

		// 선택된 페이지의 게시글 정보를 10개 가져오기
		model.addAttribute("list", service.listSearch(cri));

		// 페이지 네비게이션 추가
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));

		// 페이징 정보 화면 전달
		model.addAttribute("pageMaker", pageMaker);

	}

	// 상세보기
	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("pno") int pno, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {

		logger.info("read get ...");

		model.addAttribute(service.read(pno));

	}

	// 삭제하기 - > POST로 구현 - > 삭제 후 redirect처리
	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("pno") int pno, HttpSession session, @ModelAttribute("cri") SearchCriteria cri,
			RedirectAttributes rttr) throws Exception {

		logger.info("remove get ...");

		// 삭제 하려면 로그인한 정보와 게시글의 작성자가 일치

		// 1) 로그인 정보 가져오기
		UserVO user = (UserVO) session.getAttribute("login");

		// 2) 게시글 작성자 정보와 비교
		// 2-1) 게시글 정보 가져오기
		ProductVO vo = service.read(pno);
		// 2-2) 게시글 정보와 작성자 정보 비교
		if (user.getUsid().equals(vo.getstartup_id())) {
			// 정보 일치 - > 게시글 삭제
			service.remove(pno);

			// 목록화면으로 이동
			rttr.addFlashAttribute("msg", "SUCCESS");
			return "redirect:/product/list";
		} else {

			// 정보 불일치 - > 상세페이지로 강제 이동
			rttr.addAttribute("pno", pno);
			rttr.addAttribute("page", cri.getPage());
			rttr.addAttribute("perPageNum", cri.getPerPageNum());
			rttr.addAttribute("searchType", cri.getSearchType());
			rttr.addAttribute("keyword", cri.getKeyword());

			rttr.addFlashAttribute("msg", "잘못된 접근 입니다.");

			return "redirect:/product/list";
		}

	}

	// 상품 수정
	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public String modifyPageGET(@RequestParam("pno") int pno, HttpSession session, 
			@ModelAttribute("cri") SearchCriteria cri, Model model, RedirectAttributes rttr) throws Exception {

		// 수정 하려면 로그인한 정보와 게시글의 작성자가 일치

		// 1) 로그인 정보 가져오기
		UserVO user = (UserVO) session.getAttribute("login");

		// 2) 게시글 작성자 정보와 비교
		// 2-1) 게시글 정보 가져오기
		ProductVO vo = service.read(pno);
		// 2-2) 게시글 정보와 작성자 정보 비교
		if (user.getUsid().equals(vo.getstartup_id())) {
			// 정보 일치 - > 게시글 수정
			// 목록화면으로 이동
			model.addAttribute(service.read(pno));
			return "/product/modifyPage";
		} else {

			// 정보 불일치 - > 상세페이지로 강제 이동
			rttr.addAttribute("pno", pno);
			rttr.addAttribute("page", cri.getPage());
			rttr.addAttribute("perPageNum", cri.getPerPageNum());
			rttr.addAttribute("searchType", cri.getSearchType());
			rttr.addAttribute("keyword", cri.getKeyword());

			rttr.addFlashAttribute("msg", "잘못된 접근 입니다.");

			return "redirect:/product/readPage";

		}
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagePOST(ProductVO vo, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr)
			throws Exception {

		service.modify(vo);

		// 수정 후 페이징 및 검색 기능 유지
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/product/list";

	}

}
