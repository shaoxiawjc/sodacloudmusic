package com.sodagroup.utils;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author shaoxiawjc
 * @ 2023/12/5
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.utils
 **/
public class DownloadUtils {
	// 阿里域名
	public static final String ALI_DOMAIN = "https://sodagroup-cloudmusic.oss-cn-guangzhou.aliyuncs.com/";

	public static InputStream download(String fileURL) throws IOException {
		InputStream inputStream = getFileInputStream(fileURL);
		return inputStream;
	}


	public static InputStream getFileInputStream(String fileUrl) throws IOException {
		// 使用URL和URLConnection获取文件输入流
		URL url = new URL(fileUrl);
		URLConnection connection = url.openConnection();
		return connection.getInputStream();
	}

	public static String getFileNameFromUrl(String fileUrl) {
		// 从文件URL中提取文件名
		int lastSlashIndex = fileUrl.lastIndexOf("/");
		if (lastSlashIndex != -1) {
			return fileUrl.substring(lastSlashIndex + 1);
		} else {
			return "downloaded_file";
		}
	}

}

