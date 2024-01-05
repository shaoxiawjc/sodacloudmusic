package com.sodagroup.mapper;

import com.sodagroup.pojo.CommentUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shaoxiawjc
 * @ 2023/12/2
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.mapper
 **/
@Mapper
@Repository
public interface CommentUserMapper {
	List<CommentUser> selectAllCommentUser();
	List<CommentUser> selectCommentUserByUserId(int userId);
	List<CommentUser> selectCommentUserByCommentId(int commentId);
	CommentUser selectCommentUserByUserIdAndCommentId(@Param("userId") int userId,@Param("commentId") int commentId);

	int insertCommentUser(CommentUser commentUser);
	int deleteCommentUser(CommentUser commentUser);
}
