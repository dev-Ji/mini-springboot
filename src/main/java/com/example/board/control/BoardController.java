package com.example.board.control;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		
	
	
	@RequestMapping(value = "/list/{page}", method = RequestMethod.GET)
	public ModelAndView index(@PathVariable("page") int page, BoardDTO boardDTO) {
		ModelAndView mav = new ModelAndView("view/main/index");
		List<BoardDTO> boardDTOList = new ArrayList<BoardDTO>();
		try {
			boardDTOList = boardservice.list(page);
			mav.addObject("boardlist", boardDTOList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value="/view/{idx}", method = RequestMethod.GET)
	public ModelAndView view(HttpServletRequest req, HttpServletResponse res, @PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("view/main/view");
		BoardDTO boardDTO = boardservice.view(idx);
		try {
			boardDTO = boardservice.view(idx);
			mav.addObject("boardView", boardDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value="/write_page", method = RequestMethod.GET)
	public String write_page() {
		return "view/main/write_page";
	}
	
	@RequestMapping(value="/write_page", method = RequestMethod.POST)
	public String write_page2(BoardDTO boardDTO) {
		try {
			
			boardservice.write(boardDTO);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/edit/{idx}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("view/main/edit");
		try {
			BoardDTO boardDTO = boardservice.edit(idx);
			mav.addObject("boardcontent", boardDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value="/edit/{idx}", method = RequestMethod.POST)
	public ModelAndView update(BoardDTO boardDTO) {
		ModelAndView mav = new ModelAndView("redirect:/board/list");
		try {
			boardservice.update(boardDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value="/delete/{idx}" , method = RequestMethod.GET)
	public String delete(@PathVariable("idx") int idx) {
		
		try {
			boardservice.delete(idx);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/board/list";
	}
//	@RequestMapping(value="/post", method = RequestMethod.GET)
//	public String write_commit() {
//		return "view/main/write_commit";
//	}

//	@RequestMapping(value="/write_commit", method = RequestMethod.POST)
//	public String write_commit2() {
//		return "view/main/write_commit";
//	}
	
}
