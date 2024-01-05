package com.sodagroup.service.Impl;

import com.sodagroup.mapper.CommentMapper;
import com.sodagroup.mapper.CommentUserMapper;
import com.sodagroup.pojo.Comment;
import com.sodagroup.pojo.CommentUser;
import com.sodagroup.pojo.DTO.CommentRankDTO;
import com.sodagroup.pojo.DTO.CommentResponseDTO;
import com.sodagroup.pojo.DTO.UserCommentRelationDTO;
import com.sodagroup.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shaoxiawjc
 * @ 2023/12/19
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.service.Impl
 **/
@Service
public class CommentServiceImpl implements CommentService{

	private CommentMapper commentMapper;
	private CommentUserMapper commentUserMapper;
	@Autowired
	public void setCommentUserMapper(CommentUserMapper commentUserMapper) {
		this.commentUserMapper = commentUserMapper;
	}
	@Autowired
	public void setCommentMapper(CommentMapper commentMapper) {
		this.commentMapper = commentMapper;
	}

	@Override
	public Comment addComment(Comment comment) {
		commentMapper.insertComment(comment);
		return comment;
	}

	@Override
	public int collectComment(CommentUser commentUser) {
		commentUserMapper.insertCommentUser(commentUser);
		commentMapper.collectComment(commentUser.getCommentId());
		return 0;
	}

	@Override
	public int cancelCollect(CommentUser commentUser) {
		// 删除一行关联表
		commentUserMapper.deleteCommentUser(commentUser);
		// 响应的评论的收藏量减1
		commentMapper.cancelCollect(commentUser.getCommentId());
		return 0;
	}

	@Override
	public int deleteComment(int id) {
		commentMapper.deleteComment(id);
		return 0;
	}


	@Override
	public List<CommentRankDTO> selectCommentRank() {
		return commentMapper.selectCommentRank();
	}

	@Override
	public List<CommentResponseDTO> selectResponseComment(int songId,int userId) {
		List<Comment> comments = commentMapper.selectCommentInSongRank(songId);

		List<CommentResponseDTO> responseDTOList = new ArrayList<>();

		for (Comment comment: comments) {
			// 查找每一个评论是否被用户点赞过
			CommentUser commentUser = commentUserMapper.selectCommentUserByUserIdAndCommentId(userId,comment.getId());
			UserCommentRelationDTO userCommentRelationDTO = new UserCommentRelationDTO();

			// 封装数据
			CommentResponseDTO commentResponseDTO = new CommentResponseDTO();

			if (commentUser == null){
				commentResponseDTO.setLiked(false);
			}else {
				commentResponseDTO.setLiked(true);
			}
			commentResponseDTO.set(comment.getId(),songId,comment.getDetail(),userId,comment.getCreateDate(),comment.getCollectedNums());
			responseDTOList.add(commentResponseDTO);
		}
		return responseDTOList;
	}


}
