package com.example.board.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDTO {
	private int idx;
	private String id;
	private String title;
	private String content;
	private Date regdate;
}
