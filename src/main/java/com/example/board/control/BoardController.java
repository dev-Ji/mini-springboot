package com.example.board.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.board.dto.BoardDTO;
import com.example.board.service.BoardService;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	//private final Log log = LogFactory.getLog(BoardController.class);
	
	@Autowired
	private BoardService boardservice;
	
//	@RequestMapping(value = "/list")
//	public List<BoardDTO> list(HttpServletRequest req, HttpServletResponse res, BoardDTO boardDTO) {
//		List<BoardDTO> boardDTOList = new ArrayList<BoardDTO>();
//		
//		try {
//			boardDTOList = boardservice.list();
//		} catch (Exception e) {
//			return boardDTOList;
//		}
//		
//		return boardDTOList;
//	}
	
//	@RequestMapping(value = "/list")
//	public List<BoardDTO> list(HttpServletRequest req, HttpServletResponse res, BoardDTO boardDTO) {
//		List<BoardDTO> boardDTOList = new ArrayList<BoardDTO>();
//		
//		try {
//			boardDTOList = boardservice.list();
//		} catch (Exception e) {
//			return boardDTOList;
//		}
//		
//		return boardDTOList;
//	}
	
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest req, HttpServletResponse res, BoardDTO boardDTO) {
		ModelAndView mav = new ModelAndView("view/main/index");
		List<BoardDTO> boardDTOList = new ArrayList<BoardDTO>();
		try {
			System.out.println("서비스가기전");
			boardDTOList = boardservice.list();
			System.out.println("ㅎㅇㅎㅇ");
			mav.addObject("boardlist", boardDTOList);
		} catch (Exception e) {
			System.out.println("에러입니다");
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value="/dd")
	public String dd() {
		return "view/main/dd";
	}
	
}
