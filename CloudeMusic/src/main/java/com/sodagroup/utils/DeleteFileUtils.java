package com.sodagroup.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;

/**
 * @author shaoxiawjc
 * @ 2023/12/22
 * @ IntelliJ IDEA
 * @ CloudeMusic
 * @ com.sodagroup.utils
 **/
public class DeleteFileUtils {
	public static final String ALI_DOMAIN = "https://sodagroup-cloudmusic.oss-cn-guangzhou.aliyuncs.com/";

	public static void deleteFile(String url,String folderName){
		// 地域结点
		String endPoint = "https://oss-cn-guangzhou.aliyuncs.com";
		String accessKeyId = "LTAI5tKZaNsujUjisLPJD7Cg";
		String accessKeySecret = "H9dmnmiOTPGfV0RmHvbmPXkZBz2OMX";
		// OSS客户端对象
		OSS ossClient = new OSSClientBuilder().build(endPoint, accessKeyId, accessKeySecret);

		try {
			// 删除文件或目录。如果要删除目录，目录必须为空。
			ossClient.deleteObject("sodagroup-cloudmusic",folderName+"/"+DeleteFileUtils.getLastSegmentFromUrl(url));;
		} catch (OSSException oe) {
			System.out.println("Caught an OSSException, which means your request made it to OSS, "
					+ "but was rejected with an error response for some reason.");
			System.out.println("Error Message:" + oe.getErrorMessage());
			System.out.println("Error Code:" + oe.getErrorCode());
			System.out.println("Request ID:" + oe.getRequestId());
			System.out.println("Host ID:" + oe.getHostId());
		} catch (ClientException ce) {
			System.out.println("Caught an ClientException, which means the client encountered "
					+ "a serious internal problem while trying to communicate with OSS, "
					+ "such as not being able to access the network.");
			System.out.println("Error Message:" + ce.getMessage());
		} finally {
			if (ossClient != null) {
				ossClient.shutdown();
			}
		}
		return;
	}

	public static String getLastSegmentFromUrl(String url) {
		int lastIndex = url.lastIndexOf("/");
		if (lastIndex != -1 && lastIndex < url.length() - 1) {
			return url.substring(lastIndex + 1);
		}
		return "";
	}
}
