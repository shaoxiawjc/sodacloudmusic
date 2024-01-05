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
public class SongList {
	private int id;
	private int userId;
	private String title;
	private String introduction;
	private int collectedNums;
	private String picturePath;

	public SongList(int userId, String title, String introduction, int collectedNums, String picturePath) {
		this.userId = userId;
		this.title = title;
		this.introduction = introduction;
		this.collectedNums = collectedNums;
		this.picturePath = picturePath;
	}

	public SongList(int id, int userId, String title, String introduction, int collectedNums, String picturePath) {
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.introduction = introduction;
		this.collectedNums = collectedNums;
		this.picturePath = picturePath;
	}
}
