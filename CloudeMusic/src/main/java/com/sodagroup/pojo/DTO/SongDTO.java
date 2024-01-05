package com.sodagroup.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shaoxiawjc
 * @ 2024/1/3
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.pojo.DTO
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongDTO {
	private int id;
	private String name;
	private String singer;
	private int collectNums;
}
