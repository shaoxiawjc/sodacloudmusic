package com.sodagroup.mapper;

import com.sodagroup.pojo.DTO.SongRankDTO;
import com.sodagroup.pojo.DTO.SongDTO;
import com.sodagroup.pojo.Song;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author shaoxiawjc
 * @ 2023/11/22
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.mapper
 **/
@Mapper
@Repository
public interface SongMapper {
	// 分页查询
	List<Song> selectAllSongs(@Param("startIndex") int startIndex, @RequestParam("pageSize") int pageSize);
	Song selectSongById(@Param("id") int id);
	List<Song> selectSongByName(@Param("name") String name);
	List<SongDTO> selectSongByNameLike(@Param("name") String name);
	List<Song> selectSongByUserId(@Param("uploadId") int uploadId);
	List<SongRankDTO> selectSongRank();
	List<SongRankDTO> selectNewSongRank();


	int addSong(Song song);
	int deleteSong(@Param("id") int id);
	int updateSong(Song song);
}
