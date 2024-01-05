package com.sodagroup.service;

import com.sodagroup.pojo.DTO.SongListRankDTO;
import com.sodagroup.pojo.DTO.SongListSelectDTO;
import com.sodagroup.pojo.ListUser;
import com.sodagroup.pojo.SongList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author shaoxiawjc
 * @ 2023/12/2
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.service
 **/
@Service
public interface SongListService {
	int insertSongList(SongList songList);

	SongListSelectDTO selectListByTitleLike(String title);
	SongList selectListById(int id);
	List<SongListRankDTO> selectSongListRank();

	int deleteList(int id);

	int updateList(SongList songList);

	int collectSongList(ListUser listUser);


}
