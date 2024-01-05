package com.sodagroup.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author shaoxiawjc
 * @ 2023/12/3
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.utils
 **/
public class UploadUtils {
	// 阿里域名
	public static final String ALI_DOMAIN = "https://sodagroup-cloudmusic.oss-cn-guangzhou.aliyuncs.com/";

	public static String uploadFile(MultipartFile file,String folderName) throws IOException {
		// 生成文件名
		String fileExtension = FileUtils.getFileExtension(file.getOriginalFilename());
		String newName = FileUtils.getNewName(fileExtension);
		// 地域结点
		String endPoint = "https://oss-cn-guangzhou.aliyuncs.com";
		String accessKeyId = "LTAI5tKZaNsujUjisLPJD7Cg";
		String accessKeySecret = "H9dmnmiOTPGfV0RmHvbmPXkZBz2OMX";
		// OSS客户端对象
		OSS build = new OSSClientBuilder().build(endPoint, accessKeyId, accessKeySecret);
		String objectKey = folderName+"/"+newName;
		try{
			build.putObject(
					"sodagroup-cloudmusic",// 仓库名
					objectKey, // 文件名
					file.getInputStream()
			);
		}finally {
			build.shutdown();
		}
		return ALI_DOMAIN+objectKey;
	}
}
