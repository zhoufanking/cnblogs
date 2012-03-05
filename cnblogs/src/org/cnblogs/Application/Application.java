package org.cnblogs.Application;

import org.cnblogs.FetchMethod.Fetch;
import org.cnblogs.FetchMethod.FetchBlogs;
import org.cnblogs.Resourse.R;

public class Application {
	

	public static void FetchAPage(Fetch aInstance,String address){
		aInstance.Connect(address);
		aInstance.getItems();
		aInstance.getItemSummery();
		aInstance.getItemLink();
		aInstance.getPostDate();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Fetch fetchBlogsIns = FetchBlogs.newFetchBlogsInstance();
		
		FetchAPage(fetchBlogsIns,R.getBaseAddress());
		
		fetchBlogsIns.printContent();
	}
}



