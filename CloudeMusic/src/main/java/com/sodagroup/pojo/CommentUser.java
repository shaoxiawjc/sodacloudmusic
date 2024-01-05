package com.sodagroup.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shaoxiawjc
 * @ 2023/12/2
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.pojo
 **/
@Data
@NoArgsConstructor
public class CommentUser {
	private int id;
	private int commentId;
	private int userId;

	public CommentUser(int commentId, int userId) {
		this.commentId = commentId;
		this.userId = userId;
	}

	public CommentUser(int id, int commentId, int userId) {
		this.id = id;
		this.commentId = commentId;
		this.userId = userId;
	}
}
