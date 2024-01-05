package com.sodagroup.service.Impl;

import com.sodagroup.mapper.ListUserMapper;
import com.sodagroup.mapper.SongListMapper;
import com.sodagroup.mapper.UserMapper;
import com.sodagroup.pojo.ListUser;
import com.sodagroup.pojo.SongList;
import com.sodagroup.pojo.User;
import com.sodagroup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shaoxiawjc
 * @ 2023/11/22
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.service
 **/
@Service
public class UserServiceImpl implements UserService {

	private UserMapper userMapper;
	private SongListMapper songListMapper;
	private ListUserMapper listUserMapper;
	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	@Autowired
	public void setSongListMapper(SongListMapper songListMapper) {
		this.songListMapper = songListMapper;
	}
	@Autowired
	public void setListUserMapper(ListUserMapper listUserMapper) {
		this.listUserMapper = listUserMapper;
	}

	@Override
	public List<User> selectUserByNameLike(String name) {
		return userMapper.selectByNameLike(name);
	}




	/**
	 * 注册同时创建我的喜欢歌单
	 * **/
	@Override
	public boolean registerUser(User user) {
		User user1 = userMapper.selectByName(user.getName());
		if (user1 == null) {
			userMapper.addUser(user);
			// 获取该用户的id
			int userId = userMapper.selectByName(user.getName()).getId();
			// 添加我的喜欢歌单
			SongList favorite = new SongList(userId,"我的喜欢","无",1,
					"https://sodagroup-cloudmusic.oss-cn-guangzhou.aliyuncs.com/songPicturePath/heart.png");
			songListMapper.insertList(favorite);
			// 获取刚刚注册的用户创建的歌单的id
			List<SongList> songLists = songListMapper.selectListByTitleAndUserId("我的喜欢", userId);
			int songListId = songLists.get(0).getId();
			// 添加我的收藏
			listUserMapper.insertListUser(new ListUser(userId,songListId));
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Map<String,Object> loginUser(String name, String password) {
		User user = userMapper.selectByName(name);
		Map<String, Object> map = new HashMap<>();
		if (userMapper.selectByName(name) == null){
			return null;
		}
		if (user.getPassword().equals(password) ) {
			map.put("userId", user.getId());
			map.put("userName", user.getName());
			map.put("msg", "登录成功");
			return map;
		}else {
			return null;
		}
	}
}
