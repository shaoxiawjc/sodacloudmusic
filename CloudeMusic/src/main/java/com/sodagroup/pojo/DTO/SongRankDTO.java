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
public class SongRankDTO {
	private int id;
	private String name;
	private String singer;
	private String picturePath;

	public SongRankDTO(String name, String singer, String picturePath) {
		this.name = name;
		this.singer = singer;
		this.picturePath = picturePath;
	}

	public SongRankDTO(int id, String name, String singer, String picturePath) {
		this.id = id;
		this.name = name;
		this.singer = singer;
		this.picturePath = picturePath;
	}
}
