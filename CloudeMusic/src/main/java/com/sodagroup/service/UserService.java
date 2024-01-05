package com.sodagroup.service;

import com.sodagroup.mapper.UserMapper;
import com.sodagroup.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public interface UserService {

	List<User> selectUserByNameLike(String name);
	boolean registerUser(User user);
	Map<String,Object> loginUser(String name,String password);



}
