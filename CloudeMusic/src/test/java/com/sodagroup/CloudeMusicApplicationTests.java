package com.sodagroup;

import com.sodagroup.mapper.CommentMapper;
import com.sodagroup.mapper.SongListMapper;
import com.sodagroup.mapper.SongMapper;
import com.sodagroup.mapper.UserMapper;
import com.sodagroup.pojo.Song;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Date;

@SpringBootTest
class CloudeMusicApplicationTests {

	@Autowired
	DataSource dataSource;
	@Autowired
	UserMapper userMapper;
	@Autowired
	SongMapper songMapper;
	@Autowired
	CommentMapper commentMapper;
	@Autowired
	SongListMapper songListMapper;
	@Test
	void contextLoads() throws SQLException {
		/**
		// usermapper 测试 id查询，全部查询，模糊查询
//		System.out.println(userMapper.selectUserById(1));
//		System.out.println(userMapper.selectAllUsers());
//		System.out.println(userMapper.selectByName("侠"));
//		System.out.println("----------------------------------------------------------");

//		User user1 = new User("吴金超", "a123456", 2);
//		User user2 = new User("aa", "a123456", 3);
//		User user3 = new User("bb", "a123456", 2);
//		userMapper.addUser(user1);
//		userMapper.addUser(user2);
//		userMapper.addUser(user3);
//		System.out.println(userMapper.selectAllUsers());

//		userMapper.deleteUser(5);
//		System.out.println(userMapper.selectAllUsers());
//		System.out.println("----------------------------------------------------------");

//		userMapper.updateUser(new User(4,"少","a1234567",2));
//		System.out.println(userMapper.selectAllUsers());
//		System.out.println("----------------------------------------------------------");
		**/
		/**
		 * user表的curd测试成功无误
		 * */

		/** songmapper 测试无误
		System.out.println(songMapper.selectAllSongs()); // ok
		Song song = new Song("たぶん",
				"static/img/d4628535e5dde71190ef9a2f23bad91b9d16fcfacb96.png",
				"static/audio/YOASOBI-たぶん.mp3",
				"YOASOBI",
				new Date(),
				1, 1);
//		songMapper.addSong(song);
		System.out.println("-------插入后---------");// ok
		System.out.println(songMapper.selectAllSongs());
//		songMapper.updateSong(new Song(1,"たぶん",
//				"static/img/d4628535e5dde71190ef9a2f23bad91b9d16fcfacb96.png",
//				"static/audio/YOASOBI-たぶん.mp3",
//				"YOASOBI",
//				new Date(),
//				1, 2)); // ok
		System.out.println(songMapper.selectAllSongs());
		songMapper.deleteSong(1); //ok
		System.out.println(songMapper.selectAllSongs());
		**/



	}

}
