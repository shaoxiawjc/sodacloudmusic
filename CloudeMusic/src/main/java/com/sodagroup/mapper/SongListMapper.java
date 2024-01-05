package com.sodagroup.mapper;

import com.sodagroup.pojo.DTO.SongListDTO;
import com.sodagroup.pojo.DTO.SongListRankDTO;
import com.sodagroup.pojo.SongList;
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
public interface SongListMapper {
	List<SongList> selectAllList();
	List<SongList> selectListByTitle(@Param("title") String title);
	List<SongList> selectListByTitleAndUserId (@Param("title") String title,@Param("userId") int userId);
	List<SongListDTO> selectListByTitleLike(@Param("title") String title);
	SongList selectListById(@Param("id") int id);
	List<SongListRankDTO> selectSongListRank();

	int insertList(SongList songList);
	int deleteList(@Param("id") int id);
	int updateList(SongList songList);
}
