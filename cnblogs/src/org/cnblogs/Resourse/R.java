package org.cnblogs.Resourse;

public class R {
	private  final static String  BASE_ADDRESS ="http://www.cnblogs.com";
	private  final static String  FOLLOWING_ADDRESS = BASE_ADDRESS + "/p";
	private  final static String  StorageFileName ="cache.txt";
	
	public static String getBaseAddress(){
		return BASE_ADDRESS;
	}
	public static String getFollowingAddress(){
		return FOLLOWING_ADDRESS;
	}
	public static String getStorageFileName(){
		return StorageFileName;
	}

}
