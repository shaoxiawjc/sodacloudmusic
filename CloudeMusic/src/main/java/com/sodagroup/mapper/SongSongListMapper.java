package com.sodagroup.mapper;

import com.sodagroup.pojo.SongSongList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shaoxiawjc
 * @ 2023/11/25
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.mapper
 **/
@Mapper
@Repository
public interface SongSongListMapper {
	List<SongSongList> selectAllSongSongList();
	List<SongSongList> selectSongSongListById(@Param("id") int id);
	List<SongSongList> selectSongSongListByListId(@Param("listId") int listId);
	List<SongSongList> selectSongSongListBySongId(@Param("songId") int songId);

	int insertSongSongList(SongSongList songSongList);

	int deleteSongSongListById(@Param("id") int id);
	int deleteSongSongListByListId(@Param("listId") int listId);
	int deleteSongSongListByListIdAndSongId(@Param("listId") int listId,
											@Param("songId") int songId);

	int updateSongSongListMapper(SongSongList songSongList);


}
