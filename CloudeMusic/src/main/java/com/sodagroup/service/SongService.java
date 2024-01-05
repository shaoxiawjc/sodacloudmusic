package com.sodagroup.service;

import com.sodagroup.pojo.DTO.SongCommentSelectDTO;
import com.sodagroup.pojo.DTO.SongRankDTO;
import com.sodagroup.pojo.DTO.SongSelectDTO;
import com.sodagroup.pojo.Song;
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
public interface SongService {
	List<Song>  selectAllSong(int startIndex,int pageSize);
	SongSelectDTO  selectSongByNameLike(String name);
	List<SongRankDTO> selectSongRank();

	List<SongRankDTO> selectNewSongRank();

	List<Song> selectSongByUploadId(int uploadId);

	Song songPlay(int songId);

	int addSong(Song song);

}
