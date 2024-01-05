package com.sodagroup.utils;

import java.nio.file.Path;
import java.util.UUID;

/**
 * @author shaoxiawjc
 * @ 2023/12/2
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.utils
 **/
public class FileUtils {
	public static String getFileExtension(String fileName) {
		Path path = Path.of(fileName);
		String fileExtension = "";

		int dotIndex = fileName.lastIndexOf('.');

		if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
			fileExtension = fileName.substring(dotIndex + 1);
		}
		return fileExtension;
	}

	public static String getNewName(String fileExtension){
		String newName = UUID.randomUUID().toString()+"."+fileExtension;
		System.out.println(newName);
		return newName;
	}
}
