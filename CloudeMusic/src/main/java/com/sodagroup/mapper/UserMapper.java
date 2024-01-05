package com.sodagroup.mapper;

import com.sodagroup.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author shaoxiawjc
 * @ 2023/11/22
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.mapper
 **/
@Mapper
@Repository
public interface UserMapper {

	List<User> selectAllUsers();
	User selectUserById(@Param("id") int id);
	List<User> selectByNameLike(@Param("name") String name);
	User selectByName(@Param("name") String name);

	int addUser(User user);

	int deleteUser(@Param("id") int id);

	int updateUser(User user);

}
