package com.sodagroup.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shaoxiawjc
 * @ 2023/11/24
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.pojo
 **/
@Data
@NoArgsConstructor
public class ListUser {
	private int id;
	private int listId;
	private int userId;

	public ListUser(int listId, int userId) {
		this.listId = listId;
		this.userId = userId;
	}

	public ListUser(int id, int listId, int userId) {
		this.id = id;
		this.listId = listId;
		this.userId = userId;
	}
}
