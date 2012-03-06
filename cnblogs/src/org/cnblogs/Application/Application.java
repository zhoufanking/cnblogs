package org.cnblogs.Application;

import java.util.Vector;

import org.cnblogs.FetchMethod.Fetch;
import org.cnblogs.FetchMethod.FetcherFactory;
import org.cnblogs.Resourse.R;

public class Application {
	

	public static void FetchAPage(Fetch aInstance,String address){
		aInstance.Connect(address);
		aInstance.getItems();
		aInstance.getItemSummery();
		aInstance.getItemLink();
		aInstance.getPostDate();
	}
	
	public void printContent() {
		// TODO Auto-generated method stub
		
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Fetch fetchBlogsIns = FetcherFactory.getFetcher("FetchBlogs");
		
		Vector<String> items = new Vector<String>();
		Vector<String> summeries = new Vector<String>();
		Vector<String> links = new Vector<String>();
		Vector<String> postTimes = new Vector<String>();
		
		
		fetchBlogsIns.Connect(R.getBaseAddress());
		
		items = fetchBlogsIns.getItems();
		summeries= fetchBlogsIns.getItemSummery();
		links = fetchBlogsIns.getItemLink();
		postTimes = fetchBlogsIns.getPostDate();
		
		for(int lp=0; lp < items.size(); lp++)
		{
			System.out.println(items.get(lp));
			System.out.println(		summeries.get(lp));
			System.out.println(links.get(lp));
			System.out.println(postTimes.get(lp));
			
		}
		System.out.println("done!");
		
	}
}



