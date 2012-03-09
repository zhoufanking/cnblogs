package org.cnblogs.Resourse;

public class Res {
	private  final static String  BASE_ADDRESS ="http://www.cnblogs.com";
	private  final static String  FOLLOWING_ADDRESS = BASE_ADDRESS + "/p";
	private  final static String  StorageFilePath ="c:\\cache.xml";
	private  final static String  ContentsDir = "c:\\contents";
	private  final static int	  RetryTimes = 3;
	private  final static String  Connection_Retry = "重建连接...";
	private  final static String  Connection_Failue = "网络不给力哦，请稍候再试...";
	private  final static String  FILENOTEXIST ="NOTCONTENT";
	
	
	public static String getFileNotExistMsg() {
		return FILENOTEXIST;
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
	public static String getStorageFilePath(){
		return StorageFilePath;
	}
	
	public static String getContentsDir(){
		return ContentsDir;
	}
	public static String getConFailueMsg() {
		return Connection_Failue;
	}
	public static String getConRetryMsg() {
		return Connection_Retry;
	}
	

}
