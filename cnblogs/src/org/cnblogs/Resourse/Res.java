package org.cnblogs.Resourse;

import java.io.File;

public class Res {

	private  final static String  BASE_ADDRESS ="http://www.cnblogs.com";
	private  final static String  FOLLOWING_ADDRESS = BASE_ADDRESS + "/p";
	private  final static String  StorageFileName ="cache.xml";
	private  final static String  ContentsDir = "contents";
	private  final static String  ImgDir = "Images";
	private  final static int	  RetryTimes = 3;
	private  final static int     TimeOut = 3000;
	
	//MESSAGE DEFINATION
	private  final static String  MSG_CONNECTION_RETRY = "重建连接...";
	private  final static String  MSG_CONNECTION_FAILURE = "网络不给力哦，请稍候再试...";
	private  final static String  MSG_FILE_NOT_EXIST ="NOCONTENT";
	
	
	public static String getFileNotExistMsg() {
		return MSG_FILE_NOT_EXIST;
	}
	public static int getRetrytimes() {
		return RetryTimes;
	}
	public static String getBaseAddress(){
		return BASE_ADDRESS;
	}
	public static String getFollowingAddress(){
		return FOLLOWING_ADDRESS;
	}
	public static int geTimeOut(){
		return TimeOut;
	}

	public static String getStorageFilePath(){
		return buildPath(StorageFileName);
	}
	
	public static String getContentsDir(){
		return buildPath(ContentsDir);
	}
	
	public static String getImgDir(){
		return buildPath(ImgDir);
	}
	
	public static String getConFailueMsg() {
		return MSG_CONNECTION_FAILURE;
	}
	public static String getConRetryMsg() {
		return MSG_CONNECTION_RETRY;
	}
	
	private static String getUserHome(){
		String UserHome = System.getProperty("user.home");
		
		return UserHome;		
	}
	private static String getFSeparator(){
		String separator;
		separator = System.getProperty("file.separator");
		
		return separator;
	}
	
	private static String buildPath(String name){
		String HomeDir = getUserHome();
		String Separator = getFSeparator();
		String Path;
		
		Path  = HomeDir + Separator + name;
		
		return Path;
		
	}
	
	

}
