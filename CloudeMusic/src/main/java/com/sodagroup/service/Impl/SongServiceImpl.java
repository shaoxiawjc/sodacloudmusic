package com.sodagroup.service.Impl;

import com.sodagroup.mapper.CommentMapper;
import com.sodagroup.mapper.CommentUserMapper;
import com.sodagroup.mapper.SongMapper;
import com.sodagroup.mapper.UserMapper;
import com.sodagroup.pojo.Comment;
import com.sodagroup.pojo.CommentUser;
import com.sodagroup.pojo.DTO.*;
import com.sodagroup.pojo.Song;
import com.sodagroup.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shaoxiawjc
 * @ 2023/12/3
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.service.Impl
 **/
@Service
public class SongServiceImpl implements SongService {
	private SongMapper songMapper;
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
	@Autowired
	public void setSongMapper(SongMapper songMapper) {
		this.songMapper = songMapper;
	}

	@Override
	public List<Song> selectAllSong(int startIndex, int pageSize) {
		return songMapper.selectAllSongs(startIndex,pageSize);
	}

	@Override
	public SongSelectDTO  selectSongByNameLike(String name) {
		List<SongDTO> songDTOS = songMapper.selectSongByNameLike(name);
		SongSelectDTO songSelectDTO = new SongSelectDTO();
		songSelectDTO.setSongDTOS(songDTOS);
		// 搜索到的结果个数
		int size = songDTOS.size();
		songSelectDTO.setTotal(size);
		return songSelectDTO;
	}

	@Override
	public List<SongRankDTO> selectSongRank() {
		return songMapper.selectSongRank();
	}

	@Override
	public List<SongRankDTO> selectNewSongRank() {
		return songMapper.selectNewSongRank();
	}

	@Override
	public List<Song> selectSongByUploadId(int uploadId) {
		return songMapper.selectSongByUserId(uploadId);
	}

	@Override
	public Song songPlay(int songId) {
		Song song = songMapper.selectSongById(songId);
		return song;
	}

	@Override
	@Transactional
	public int addSong(Song song) {
		return songMapper.addSong(song);
	}

}
