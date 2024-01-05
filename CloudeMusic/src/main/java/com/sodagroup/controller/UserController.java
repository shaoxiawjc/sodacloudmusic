package com.sodagroup.controller;

import com.sodagroup.pojo.SongList;
import com.sodagroup.pojo.User;
import com.sodagroup.service.SongListService;
import com.sodagroup.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shaoxiawjc
 * @ 2023/11/22
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.controller
 * 用户查询
 * 用户登录
 * 用户注册
 **/
@RestController
public class UserController {
	private UserService userService;
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 查询指定用户 ok
	 * **/
	@RequestMapping("/user/query")
	public ResponseEntity<List<User>> selectUser(@RequestParam("name") String name){
		return ResponseEntity.ok().body(userService.selectUserByNameLike(name));
	}


	/**
	 * 用户登录
	 * **/
	@CrossOrigin
	@PostMapping("/user/login")
	public ResponseEntity<Boolean> login(
						@RequestParam("name") String name,
						@RequestParam("password") String password,
						HttpSession session){
		String sessionId = session.getId();
		System.out.println(name+password);
		Map<String,Object> map = userService.loginUser(name,password);
		if (map == null){
			System.out.println("false");
			return ResponseEntity.ok(false);
		}else {
			session.setAttribute("userId",map.get("userId"));
			session.setAttribute("userName",map.get("userName"));
			Map<String, String> response = new HashMap<>();
			response.put("sessionId", sessionId);
			System.out.println("true");
			return ResponseEntity.ok(true);
		}
	}

		/**
		 * 用户注册ok
		 * **/
		@CrossOrigin
		@PostMapping("/user/register")
		public ResponseEntity<Boolean> register(@RequestParam("name") String name,
							   @RequestParam("password") String password){
			// 判断用户名称是否重复
			if (userService.registerUser(new User(name,password))){
				System.out.println(name+"  "+password);
				return ResponseEntity.ok(true);
			}else {
				System.out.println("false");
				return ResponseEntity.ok(false);
			}
		}

	/**
	 * 用户注销
	 * **/
	@PostMapping("/user/logout")
	public String logout(){
		return " ";
	}
}
