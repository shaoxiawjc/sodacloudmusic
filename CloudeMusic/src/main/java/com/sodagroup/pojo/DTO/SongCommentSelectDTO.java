package com.sodagroup.pojo.DTO;

import com.sodagroup.pojo.Song;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author shaoxiawjc
 * @ 2023/12/29
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.pojo.DTO
 **/
@Data
@NoArgsConstructor
public class SongCommentSelectDTO {
	private Song song;
	private List<CommentResponseDTO> commentResponseDTOS;
}
