package com.sodagroup.mapper;

import com.sodagroup.pojo.Comment;
import com.sodagroup.pojo.DTO.CommentRankDTO;
import com.sodagroup.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shaoxiawjc
 * @ 2023/11/24
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.mapper
 **/
@Mapper
@Repository
public interface CommentMapper {
	List<Comment> selectAllComment();
	List<Comment> selectCommentByUser(@Param("userId") int userId);
	List<Comment> selectCommentBySong(@Param("songId") int songId);
	List<CommentRankDTO> selectCommentRank();
	List<Comment> selectCommentInSongRank(@Param("songId") int songId);

	int insertComment(Comment comment);
	int deleteComment(@Param("id") int id);
	int updateComment(Comment comment);
	int collectComment(@Param("id") int id);
	int cancelCollect(@Param("id") int id);


}
