package com.sodagroup.pojo.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author shaoxiawjc
 * @ 2023/12/22
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.pojo.DTO
 **/
@Data
@NoArgsConstructor
public class CommentRankDTO {
	private int id;
	private String author;
	private String detail;
	private Date date;
	private int collectedNums;

	public CommentRankDTO(String author, String detail, Date date, int collectedNums) {
		this.author = author;
		this.detail = detail;
		this.date = date;
		this.collectedNums = collectedNums;
	}

	public CommentRankDTO(int id, String author, String detail, Date date, int collectedNums) {
		this.id = id;
		this.author = author;
		this.detail = detail;
		this.date = date;
		this.collectedNums = collectedNums;
	}

	public CommentRankDTO(int id, String author, String detail, int collectedNums) {
		this.id = id;
		this.author = author;
		this.detail = detail;
		this.collectedNums = collectedNums;
	}

	public CommentRankDTO(String author, String detail, int collectedNums) {
		this.author = author;
		this.detail = detail;
		this.collectedNums = collectedNums;
	}
}
