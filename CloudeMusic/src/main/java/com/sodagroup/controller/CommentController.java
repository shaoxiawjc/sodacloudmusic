package com.sodagroup.controller;

import com.sodagroup.pojo.Comment;
import com.sodagroup.pojo.CommentUser;
import com.sodagroup.pojo.DTO.CommentRankDTO;
import com.sodagroup.pojo.DTO.CommentResponseDTO;
import com.sodagroup.service.CommentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author shaoxiawjc
 * @ 2023/12/19
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.controller
 **/
@RestController
public class CommentController {
	private CommentService commentService;
	@Autowired
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	/**
	 * 热门评论
	 * */
	@CrossOrigin
	@GetMapping("/commentRank")
	public ResponseEntity<List<CommentRankDTO>> commentRank(){
		List<CommentRankDTO> commentRankDTOS = commentService.selectCommentRank();
		System.out.println("热门评论"+commentRankDTOS);
		return ResponseEntity.ok(commentRankDTOS);
	}

	/**
	 * 显示歌曲下的精选评论信息
	 * **/
	@CrossOrigin
	@PostMapping ("/selectComment")
	public ResponseEntity<List<CommentResponseDTO>> selectComment(@RequestParam("songId") int songId,
																  HttpSession session,
																  @CookieValue(name="JSESSIONID",defaultValue = "-1") String user){
//		Integer userId = (Integer)session.getAttribute("userId");
		int userId = Integer.parseInt(user);
		System.out.println(userId+" "+songId);
		List<CommentResponseDTO> commentResponseDTOS = commentService.selectResponseComment(songId, userId);
		return ResponseEntity.ok(commentResponseDTOS);
	}


	/**
	 * 收藏评论
	 * */
	@GetMapping("/collectComment")
	public ResponseEntity<CommentUser> collectComment(@RequestParam("id") int id,
											  HttpSession session){
		int userId = (Integer)session.getAttribute("userId");
		CommentUser commentUser = new CommentUser(id, userId);
		commentService.collectComment(commentUser);
		return ResponseEntity.ok(commentUser);
	}

	/**
	 * 取消收藏评论
	 * */
	@GetMapping("/cancelCollect")
	public ResponseEntity<String> cancelCollect(@RequestParam("id") int id,
												HttpSession session){
		int userId = (Integer)session.getAttribute("userId");
		CommentUser commentUser = new CommentUser(id, userId);
		commentService.cancelCollect(commentUser);
		return ResponseEntity.ok("取消收藏");
	}

	/**
	 * 添加评论
	 * */
	@PostMapping("/addComment")
	public ResponseEntity<Boolean> addComment(@RequestParam("id") int id,
											  @RequestParam("detail") String detail,
											  HttpSession session,
											  @CookieValue(name="JSESSIONID",defaultValue = "-1") String userId){
//		Integer userId = (Integer) session.getAttribute("userId");
		int user = Integer.parseInt(userId);
		System.out.println(user);
		Comment comment = new Comment(id, detail, user, new Date(), 0);
		commentService.addComment(comment);
		return ResponseEntity.ok(true);
	}

	/**
	 * 取消评论
	 * */
	@GetMapping("/cancelComment")
	public ResponseEntity<String> cancelComment(@RequestParam int id){
		commentService.deleteComment(id);
		return ResponseEntity.ok("删除成功");
	}
}
