package com.sodagroup.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author shaoxiawjc
 * @ 2023/11/24
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.pojo
 **/
@Data
@NoArgsConstructor
public class Comment {
	private int id;
	private int songId;
	private String detail;
	private int userId;
	private Date createDate;
	private int collectedNums;

	public Comment(int songId, String detail, int userId, Date createDate, int collectedNums) {
		this.songId = songId;
		this.detail = detail;
		this.userId = userId;
		this.createDate = createDate;
		this.collectedNums = collectedNums;
	}

	public Comment(int id, int songId, String detail, int userId, Date createDate, int collectedNums) {
		this.id = id;
		this.songId = songId;
		this.detail = detail;
		this.userId = userId;
		this.createDate = createDate;
		this.collectedNums = collectedNums;
	}
}
