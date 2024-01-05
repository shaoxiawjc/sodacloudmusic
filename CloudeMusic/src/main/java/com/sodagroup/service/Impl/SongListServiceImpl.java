package com.sodagroup.service.Impl;

import com.sodagroup.mapper.ListUserMapper;
import com.sodagroup.mapper.SongListMapper;
import com.sodagroup.mapper.SongSongListMapper;
import com.sodagroup.pojo.DTO.SongListDTO;
import com.sodagroup.pojo.DTO.SongListRankDTO;
import com.sodagroup.pojo.DTO.SongListSelectDTO;
import com.sodagroup.pojo.ListUser;
import com.sodagroup.pojo.SongList;
import com.sodagroup.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author shaoxiawjc
 * @ 2023/12/2
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.service.Impl
 **/
@Service
public class SongListServiceImpl implements SongListService {
	private SongListMapper songListMapper;
	private ListUserMapper listUserMapper;
	@Autowired
	public void setSongListMapper(SongListMapper songListMapper) {
		this.songListMapper = songListMapper;
	}

	public void setListUserMapper(ListUserMapper listUserMapper) {
		this.listUserMapper = listUserMapper;
	}



	@Override
	@Transactional
	public int insertSongList(SongList songList) {

		// 调用mapper层插入一行歌单
		songListMapper.insertList(songList);
		// 返回歌单的id
		int songListId = songList.getId();
		// 同时插入关联表
		listUserMapper.insertListUser(new ListUser(songListId,songList.getUserId()));
		// 返回歌单id
		return 1;
	}

	@Override
	public SongListSelectDTO selectListByTitleLike(String title) {
		SongListSelectDTO songListSelectDTO = new SongListSelectDTO();
		List<SongListDTO> songListDTOS = songListMapper.selectListByTitleLike(title);
		int size = songListDTOS.size();
		songListSelectDTO.setSongListDTOS(songListDTOS);
		songListSelectDTO.setTotal(size);
		return songListSelectDTO;
	}

	@Override
	public SongList selectListById(int id) {
		return songListMapper.selectListById(id);
	}

	@Override
	public List<SongListRankDTO> selectSongListRank() {
		return songListMapper.selectSongListRank();
	}

	@Override
	@Transactional
	public int deleteList(int id) {
		return songListMapper.deleteList(id);
	}

	@Override
	public int updateList(SongList songList) {
		return songListMapper.updateList(songList);
	}

	@Override
	public int collectSongList(ListUser listUser) {
		listUserMapper.insertListUser(listUser);
		return listUser.getId();
	}


}
