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
import com.b2b.domain.StartUpUserVO;
import com.b2b.service.ProductService;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Inject
	private ProductService service;

	// ��ǰ ���
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET() throws Exception {

		logger.info("register get ...");

	}

	// ��ǰ��� ���� ���
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(ProductVO vo, RedirectAttributes rttr) throws Exception {

		logger.info("register post ...");

		// ��ǰ ���
		service.register(vo);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/product/adminList";

	}

	// ��ŸƮ�� ������ ���������� ����
	@RequestMapping(value = "/adminList", method = RequestMethod.GET)
	public void adminListPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info("adminList get ...");

		model.addAttribute("list", service.listSearch(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));

		model.addAttribute("pageMaker", pageMaker);

	}

	// ��ŸƮ�� ������ ���� - �󼼺���
	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("pno") int pno, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		// 1) ��ǰ ��
		model.addAttribute(service.read(pno));

		// 2)÷�� ����
		model.addAttribute("ProductIMGVO", service.fileList(pno));

	}

	// ��ǰ ����
	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public String modifyPageGET(@RequestParam("pno") int pno, HttpSession session,
			@ModelAttribute("cri") SearchCriteria cri, Model model, RedirectAttributes rttr) throws Exception {

		// ���� �Ϸ��� �α����� ������ �Խñ��� �ۼ��ڰ� ��ġ

		// 1) �α��� ���� ��������
		StartUpUserVO startUpUser = (StartUpUserVO) session.getAttribute("login");

		// 2) �Խñ� �ۼ��� ������ ��
		// 2-1) �Խñ� ���� ��������
		ProductVO vo = service.read(pno);
		// 2-2) �Խñ� ������ �ۼ��� ���� ��
		if (startUpUser.getsId().equals(vo.getStartupId())) {
			// ���� ��ġ - > �Խñ� ������������ �̵�
			// ��ǰ ����
			model.addAttribute(vo);

			// ��ǰ �̹��� ÷������
			model.addAttribute("fileList", service.fileList(vo.getPno()));

			return "/product/modifyPage";

		} else {

			// ���� ����ġ - > ���������� ���� �̵�
			rttr.addAttribute("pno", pno);
			rttr.addAttribute("page", cri.getPage());
			rttr.addAttribute("perPageNum", cri.getPerPageNum());
			rttr.addAttribute("searchType", cri.getSearchType());
			rttr.addAttribute("keyword", cri.getKeyword());

			rttr.addFlashAttribute("msg", "�߸��� ���� �Դϴ�.");

			return "redirect:/product/readPage";

		}
	}

	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagePOST(ProductVO vo, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr)
			throws Exception {

		// ��ǰ�� ���� + ÷�����ϵ� ����ε�
		service.modify(vo);

		// ���� �� ����¡ �� �˻� ��� ����
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/product/adminList";

	}

	// �����ϱ� - > POST�� ���� - > ���� �� redirectó��
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("pno") int pno, HttpSession session, @ModelAttribute("cri") SearchCriteria cri,
			RedirectAttributes rttr) throws Exception {

		logger.info("remove get ..." + pno);

		// ���� �Ϸ��� �α����� ������ �Խñ��� �ۼ��ڰ� ��ġ

		// 1) �α��� ���� ��������
		StartUpUserVO startUpUser = (StartUpUserVO) session.getAttribute("login");

		// 2) �Խñ� �ۼ��� ������ ��
		// 2-1) �Խñ� ���� ��������
		ProductVO vo = service.read(pno);
		// 2-2) �Խñ� ������ �ۼ��� ���� ��
		if (startUpUser.getsId().equals(vo.getStartupId())) {
			// ���� ��ġ - > �Խñ� ����
			service.remove(pno);

			// ���ȭ������ �̵�
			rttr.addFlashAttribute("msg", "SUCCESS");
			return "redirect:/product/adminList";
		} else {

			// ���� ����ġ - > ���������� ���� �̵�
			rttr.addAttribute("pno", pno);
			rttr.addAttribute("page", cri.getPage());
			rttr.addAttribute("perPageNum", cri.getPerPageNum());
			rttr.addAttribute("searchType", cri.getSearchType());
			rttr.addAttribute("keyword", cri.getKeyword());

			rttr.addFlashAttribute("msg", "�߸��� ���� �Դϴ�.");

			return "redirect:/product/adminList";
		}

	}

}