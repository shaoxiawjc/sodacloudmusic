package com.sodagroup.pojo.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shaoxiawjc
 * @ 2023/12/22
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.pojo.DTO
 **/
@Data
@NoArgsConstructor
public class SongListRankDTO {
	private int id;
	private String title;
	private String picturePath;

	public SongListRankDTO(String title, String picturePath) {
		this.title = title;
		this.picturePath = picturePath;
	}

	public SongListRankDTO(int id, String title, String picturePath) {
		this.id = id;
		this.title = title;
		this.picturePath = picturePath;
	}
}
