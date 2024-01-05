package com.sodagroup.pojo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
public class SongSelectDTO {
	private List<SongDTO> songDTOS;
	private int total;
}
