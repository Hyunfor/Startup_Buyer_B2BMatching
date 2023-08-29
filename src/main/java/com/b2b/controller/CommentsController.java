package com.b2b.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.b2b.domain.CommentsVO;
import com.b2b.service.CommentsService;

@Controller
@RequestMapping("/comments")
public class CommentsController {

	private static final Logger logger = LoggerFactory.getLogger(CommentsController.class);
	
	@Inject
	private CommentsService service;

	// 댓글 등록
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody CommentsVO vo) {

		ResponseEntity<String> entity = null;

		try {
			service.create(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;

	}

	// 댓글 삭제
	@RequestMapping(value = "/{comment_No}", method = RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("comment_No") int comment_No) {
		ResponseEntity<String> entity = null;

		try {

			service.delete(comment_No);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;

	}

	// 전체 댓글 목록
	@RequestMapping(value = "/all/{pno}", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<List<CommentsVO>> list(@PathVariable("pno") int pno) {
		ResponseEntity<List<CommentsVO>> entity = null;

		try {

			service.listByProduct(pno);
			entity = new ResponseEntity<>(service.listByProduct(pno), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return entity;

	}

}