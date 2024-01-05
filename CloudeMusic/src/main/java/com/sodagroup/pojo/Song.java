package com.sodagroup.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author shaoxiawjc
 * @ 2023/11/22
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.pojo
 **/
@Data
@NoArgsConstructor
public class Song {
	private int id;
	private String name;
	private String picturePath;
	private String songPath;
	private String singer;
	private Date issuingDate;
	private int uploadId;
	private int collectNums;

	public Song(String name, String picturePath, String songPath, String singer, Date issuingDate, int uploadId, int collectNums) {
		this.name = name;
		this.picturePath = picturePath;
		this.songPath = songPath;
		this.singer = singer;
		this.issuingDate = issuingDate;
		this.uploadId = uploadId;
		this.collectNums = collectNums;
	}

	public Song(int id, String name, String picturePath, String songPath, String singer, Date issuingDate, int uploadId, int collectNums) {
		this.id = id;
		this.name = name;
		this.picturePath = picturePath;
		this.songPath = songPath;
		this.singer = singer;
		this.issuingDate = issuingDate;
		this.uploadId = uploadId;
		this.collectNums = collectNums;
	}
}
