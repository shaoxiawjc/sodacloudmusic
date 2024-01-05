package com.sodagroup.pojo;

import lombok.Data;

/**
 * @author shaoxiawjc
 * @ 2023/11/24
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.pojo
 **/
@Data
public class SongSongList {
	private int id;
	private int listId;
	private int songId;

	public SongSongList(int listId, int songId) {
		this.listId = listId;
		this.songId = songId;
	}

	public SongSongList(int id, int listId, int songId) {
		this.id = id;
		this.listId = listId;
		this.songId = songId;
	}
}
