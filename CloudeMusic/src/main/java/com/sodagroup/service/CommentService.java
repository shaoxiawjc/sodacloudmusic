package com.sodagroup.service;

import com.sodagroup.pojo.Comment;
import com.sodagroup.pojo.CommentUser;
import com.sodagroup.pojo.DTO.CommentRankDTO;
import com.sodagroup.pojo.DTO.CommentResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shaoxiawjc
 * @ 2023/12/2
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.service
 **/
@Service
public interface CommentService {
	Comment addComment(Comment comment);

	int collectComment(CommentUser commentUser);
	int cancelCollect(CommentUser commentUser);
	int deleteComment(int id);
	List<CommentRankDTO> selectCommentRank();

	List<CommentResponseDTO> selectResponseComment(int songId,int userId);

}
