package com.sodagroup.mapper;

import com.sodagroup.pojo.ListUser;
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
public interface ListUserMapper {
	List<ListUser> selectAllListUser();
	ListUser selectListUserById(@Param("id") int id);

	int insertListUser(ListUser listUser);
	int deleteListUserById(@Param("id") int id);
	int deleteListUserByUserIdAndListId(@Param("userId") int userId,
										@Param("listId") int listId);
	int updateListUser(ListUser listUser);
}
