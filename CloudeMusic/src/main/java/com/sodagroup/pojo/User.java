package com.sodagroup.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shaoxiawjc
 * @ 2023/11/22
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.pojo
 **/
@Data
@NoArgsConstructor
public class User {
	private int id;
	private String name;
	private String password;
	public User(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
}
