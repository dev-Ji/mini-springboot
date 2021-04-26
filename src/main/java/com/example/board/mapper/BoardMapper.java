package com.example.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.dto.BoardDTO;

@Mapper
public interface BoardMapper {
	public List<BoardDTO> list(int page);
	
	public BoardDTO view(int idx);
	
	public int write(BoardDTO dto);
	
	public BoardDTO edit(int idx);
	
	public int update(BoardDTO dto);
	
	public int delete(int idx);
}
