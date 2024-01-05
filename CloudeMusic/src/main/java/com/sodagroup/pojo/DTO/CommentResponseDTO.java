package com.sodagroup.pojo.DTO;

import com.sodagroup.pojo.Comment;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author shaoxiawjc
 * @ 2023/12/29
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.pojo.DTO
 **/
@Data
@NoArgsConstructor
public class CommentResponseDTO {
//	private Comment comment;
	private int id;
	private int songId;
	private String detail;
	private int userId;
	private Date createDate;
	private int collectedNums;
	private Boolean liked;

	public void set(int id,int songId,String detail, int userId, Date createDate, int collectedNums){
		this.id = id;
		this.songId = songId;
		this.detail = detail;
		this.collectedNums = collectedNums;
		this.userId = userId;
		this.createDate = createDate;
	}
}
