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
@RequestMapping("/productCommon/*")
public class ProductCommonController {

	private static final Logger logger = LoggerFactory.getLogger(ProductCommonController.class);

	@Inject
	private ProductService service;

	// ��ǰ ���
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		logger.info("list get ...");

		// ���õ� �������� �Խñ� ������ 10�� ��������
		model.addAttribute("list", service.listSearch(cri));

		// ������ �׺���̼� �߰�
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));

		// ����¡ ���� ȭ�� ����
		model.addAttribute("pageMaker", pageMaker);

	}

	// �Ϲ� ���� ���� - �󼼺���
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("pno") int pno, @ModelAttribute("cri") SearchCriteria cri, Model model)
			throws Exception {

		// 1) ��ǰ ��
		model.addAttribute(service.read(pno));

		// 2)÷�� ����
		model.addAttribute("ProductIMGVO", service.fileList(pno));

	}

}