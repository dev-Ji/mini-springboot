package com.example.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.dto.BoardDTO;
import com.example.board.mapper.BoardMapper;

//Repository를 사용하여 Service를 구현합니다.
//글쓰기 Form에서 내용을 입력한 뒤, '글쓰기' 버튼을 누르면 Post형식으로 요청이 오고,
// BoardService 의 savePost()를 실행하게 됩니다.

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public List<BoardDTO> list(int page) {
		return boardMapper.list(page);
	}
	
	public BoardDTO view(int idx) {
		return boardMapper.view(idx);
	}
	
	public int write(BoardDTO dto) {
		return boardMapper.write(dto);
	}
	
	public BoardDTO edit(int idx) {
		return boardMapper.edit(idx);
	}
	
	public int update(BoardDTO dto) {
		return boardMapper.update(dto);
	}
	
	public int delete(int idx) {
		return boardMapper.delete(idx);
	}
	
}
