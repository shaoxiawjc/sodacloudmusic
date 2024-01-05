package com.sodagroup.controller;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.model.GetObjectRequest;
import com.sodagroup.pojo.DTO.SongCommentSelectDTO;
import com.sodagroup.pojo.DTO.SongRankDTO;
import com.sodagroup.pojo.DTO.SongSelectDTO;
import com.sodagroup.pojo.Song;
import com.sodagroup.service.SongService;
import com.sodagroup.utils.DownloadUtils;
import com.sodagroup.utils.FileUtils;
import com.sodagroup.utils.UploadUtils;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sodagroup.utils.DownloadUtils.getFileNameFromUrl;

/**
 * @author shaoxiawjc
 * @ 2023/12/2
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.controller
 * 歌曲查询（所有，模糊，上传的歌曲查询）
 * 歌曲上传
 * 歌曲下载
 **/
@RestController
public class SongController {
	private SongService songService;
	@Autowired
	public void setSongService(SongService songService) {
		this.songService = songService;
	}

	/***
	 * 歌曲排行榜
	 * */
	@CrossOrigin
	@GetMapping("/songRank")
	public ResponseEntity<List<SongRankDTO>> songRank(){
		System.out.println("热门歌曲");
		return ResponseEntity.ok(songService.selectSongRank());
	}

	/**
	 * 新歌首发
	 * */
	@CrossOrigin
	@GetMapping("/newSongs")
	public ResponseEntity<List<SongRankDTO>> newSongs(){
		System.out.println("新歌首发");
		return ResponseEntity.ok(songService.selectNewSongRank());
	}


	/***
	 * 进入播放器
	 * */
	@CrossOrigin
	@PostMapping("/songPlay")
	public ResponseEntity<Song> songPlay(@RequestParam("id") int id){
		System.out.println("songPlay");
		Song song = songService.songPlay(id);
		System.out.println(song);
		return ResponseEntity.ok(song);
	}




	/***
	 * 查询名字相似的歌曲ok
	 * */
	@CrossOrigin
	@PostMapping("/selectSongByNameLike")
	public ResponseEntity<SongSelectDTO> selectSongByNameLike(@RequestParam("name") String name){
		SongSelectDTO songSelectDTO = songService.selectSongByNameLike(name);
		System.out.println("查询到的结果是 ："+songSelectDTO);
		return ResponseEntity.ok(songSelectDTO);
	}

	/***
	 * 查询所有歌曲 ok
	 * */
	@PostMapping("/selectAllSong")
	public ResponseEntity<List<Song>> selectAllSong(@RequestParam("pageNum")int pageNum,
													@RequestParam("pageSize") int pageSize){
		List<Song> songs = songService.selectAllSong((pageNum - 1) * pageSize, pageSize);
		return ResponseEntity.ok(songs);
	}

	/***
	 * 获取登录用户的上传的歌单的信息
	 * */
	@PostMapping("/selectUploadMusic")
	public ResponseEntity<List<Song>> selectUploadMusic(HttpSession session){
		Integer userId = (Integer)session.getAttribute("userId");
		return ResponseEntity.ok(songService.selectSongByUploadId(userId));
	}

	/***
	 * 收藏音乐
	 * */
//	public ResponseEntity<Song> collectSong(HttpSession session,
//											@RequestParam("songId") int songId){
//
//	}

	/**
	 * 上传音乐 ok
	 * **/
	@PostMapping("/addMusic")
	public ResponseEntity<Map<String,String>> addMusic(@RequestParam("img") MultipartFile img,
													   @RequestParam("music") MultipartFile music,
													   @RequestParam("name") String name,
													   @RequestParam("singer") String singer,
													   HttpSession session) throws IOException {
		HashMap<String, String> map = new HashMap<>();
		// 判断文件按是否为空
		if (img.isEmpty()||music.isEmpty()){
			map.put("msg","please select a file to upload");
			return ResponseEntity.badRequest().body(map);
		}
		// 获得后缀
		String imgExtension = FileUtils.getFileExtension(img.getOriginalFilename());
		String musicExtension = FileUtils.getFileExtension(music.getOriginalFilename());

		if (!(imgExtension.equals("png")||
				imgExtension.equals("jpg"))){
			map.put("msg","图片类型错误，必须为png或jpg");
			return ResponseEntity.badRequest().body(map);
		}
		if (!(musicExtension.equals("mp3")||
				musicExtension.equals("wma"))){
			map.put("msg","音乐类型错误，必须为MP3或wma");
			return ResponseEntity.badRequest().body(map);
		}
		String imgURL = UploadUtils.uploadFile(img,"musicImg");
		String musicURL = UploadUtils.uploadFile(music,"musicResource");
		songService.addSong(new Song(name,imgURL,musicURL,singer,new Date(),(Integer) session.getAttribute("userId"),0));
		map.put("imgURL",imgURL);
		map.put("musicURL",musicURL);
		return ResponseEntity.ok(map);
	}


	/**
	 * 下载音乐
	 * 输入音乐的路径
	 * **/
	@PostMapping("/downloadMusic")
	public ResponseEntity<InputStreamResource> downloadMusic(@RequestParam String fileURL) throws IOException {
		InputStream inputStream = DownloadUtils.download(fileURL);

		// 设置HTTP响应头
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + getFileNameFromUrl(fileURL));

		return ResponseEntity.ok().
				headers(headers).
				contentType(MediaType.APPLICATION_OCTET_STREAM).
				body(new InputStreamResource(inputStream));
	}

}
