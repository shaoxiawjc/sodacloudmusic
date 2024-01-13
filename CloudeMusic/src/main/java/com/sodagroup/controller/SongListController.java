package com.sodagroup.controller;

import com.sodagroup.pojo.DTO.SongListRankDTO;
import com.sodagroup.pojo.DTO.SongListSelectDTO;
import com.sodagroup.pojo.ListUser;
import com.sodagroup.pojo.SongList;
import com.sodagroup.service.SongListService;
import com.sodagroup.utils.DeleteFileUtils;
import com.sodagroup.utils.FileUtils;
import com.sodagroup.utils.UploadUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shaoxiawjc
 * @ 2023/12/7
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.controller
 * 歌单查找
 * 歌单删除
 * 歌单创建
 * 更新歌单
 * 收藏歌单
 **/
@RestController
public class SongListController {
	private SongListService songListService;
	@Autowired
	public void setSongListService(SongListService songListService) {
		this.songListService = songListService;
	}

	@CrossOrigin
	@PostMapping("/selectSongListById")
	public ResponseEntity<SongList> selectSongListById(@RequestParam("id") int id){
		SongList songList = songListService.selectListById(id);
		return ResponseEntity.ok(songList);
	}

	/***
	 * 歌单排行榜
	 * */
	@CrossOrigin
	@GetMapping("/songListRank")
	public ResponseEntity<List<SongListRankDTO>> songListRank(){
		System.out.println("热门歌单");
		return ResponseEntity.ok(songListService.selectSongListRank());
	}

	/***
	 * 通过歌单标题查找歌单
	 * */
	@CrossOrigin
	@PostMapping ("/selectListByTitleLike")
	public ResponseEntity<SongListSelectDTO> selectListByTitleLike(@RequestParam("title") String title){
		SongListSelectDTO songListSelectDTO = songListService.selectListByTitleLike(title);
		System.out.println("查询"+songListSelectDTO);
		return ResponseEntity.ok(songListSelectDTO);
	}

	/***
	 * 删除歌单
	 * 参数：歌单id
	 * */
	@GetMapping("/deleteList")
	public int deleteList(@RequestParam("listId") int listId){
		return songListService.deleteList(listId);
	}

	/**
	 * 创建歌单
	 * 参数：标题，简介，http会话（获取用户id）
	 * */
	@GetMapping("/createList")
	public ResponseEntity<Boolean> createList(@RequestParam String title,
										  @RequestParam String introduction,
										  @RequestParam("img") MultipartFile img,
										  HttpServletRequest request) throws IOException {
		int userId = (Integer) request.getSession().getAttribute("userId");
		HashMap<String, String> map = new HashMap<>();
		if (img.isEmpty()){
			map.put("msg","please select a file to upload");
			return ResponseEntity.badRequest().body(false);
		}
		String imgExtension = FileUtils.getFileExtension(img.getOriginalFilename());
		if (!(imgExtension.equals("png")||
				imgExtension.equals("jpg"))){
			map.put("msg","图片类型错误，必须为png或jpg");
			return ResponseEntity.badRequest().body(false);
		}
		String imgURL = UploadUtils.uploadFile(img,"songPicturePath");

		SongList songList = new SongList(userId, title, introduction, 1,imgURL);
		songListService.insertSongList(songList);
		return ResponseEntity.ok(true);
	}

	/**
	 * 更新歌单的标题，简介
	 * */
	@GetMapping("/updateList")
	public ResponseEntity<Map> updateList(@RequestParam("title") String title,
											  @RequestParam("introduction") String introduction,
											  @RequestParam("id") int id,
											  @RequestParam("collectedNums") int collectedNums,
											   @RequestParam("img") MultipartFile img,
											  HttpServletRequest request) throws IOException {
		Integer userId = (Integer) request.getSession().getAttribute("request");
		HashMap<String, String> map = new HashMap<>();
		if (img.isEmpty()){
			map.put("msg","please select a file to upload");
			return ResponseEntity.badRequest().body(map);
		}
		String imgExtension = FileUtils.getFileExtension(img.getOriginalFilename());
		if (!(imgExtension.equals("png")||
				imgExtension.equals("jpg"))){
			map.put("msg","图片类型错误，必须为png或jpg");
			return ResponseEntity.badRequest().body(map);
		}
		String imgURL = UploadUtils.uploadFile(img,"songPicturePath");

		// 删除原来的图片
		String OriginalURL = songListService.selectListById(id).getPicturePath();
		DeleteFileUtils.deleteFile(OriginalURL,"songPicturePath");

		SongList songList = new SongList(id, userId, title, introduction,collectedNums,imgURL);
		songListService.updateList(songList);
		map.put("msg","upload prosper");
		return ResponseEntity.ok(map);
	}


	/**
	 * 收藏歌单
	 * */
	@CrossOrigin
	@GetMapping("/collectSongList")
	public ResponseEntity<ListUser> collectSongList(HttpServletRequest request,
													@RequestParam("songListId") int songListId){

		Integer userId = (Integer)request.getSession().getAttribute("userId");
		ListUser listUser = new ListUser(userId, songListId);
		songListService.collectSongList(listUser);
		return ResponseEntity.ok(listUser);
	}


}
