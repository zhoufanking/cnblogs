package org.cnblogs.Application;

import java.io.File;
import java.util.Vector;

import org.cnblogs.FetchMethod.Fetch;
import org.cnblogs.FetchMethod.FetchEachItemContent;
import org.cnblogs.FetchMethod.FetcherFactory;
import org.cnblogs.Resourse.R;
import org.cnblogs.Storage.LocalStorageFactory;
import org.cnblogs.Storage.Storage;
import org.cnblogs.Storage.StorageContents;
import org.cnblogs.Storage.StoreEachContent;

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
		Vector<String> postContentPath = new Vector<String>();
			
		System.out.println("Fetching............");
		fetchBlogsIns.Connect(R.getBaseAddress());
		
		items = fetchBlogsIns.getItems();
		summeries= fetchBlogsIns.getItemSummery();
		links = fetchBlogsIns.getItemLink();
		postTimes = fetchBlogsIns.getPostDate();
		
		
		
		for(int lp=0; lp < items.size(); lp++)
		{
			System.out.println(items.get(lp));
			System.out.println(summeries.get(lp));
			System.out.println(links.get(lp));
			System.out.println(postTimes.get(lp));
			
		}
		Storage cache = LocalStorageFactory.newInstance();
		
		StorageContents sc = new StorageContents();
		sc.setItems(items);
		sc.setPostTimes(postTimes);
		sc.setSummeries(summeries);
		sc.setPostContentPath(links);
		cache.WritetoStorage(new File(R.getStorageFilePath()),sc);
		
		System.out.println("saving content fils.......");
		postContentPath =StoreEachContent.Store(FetchEachItemContent.getPostContent(links));
		
		
		System.out.println("done!");
		
	}
}



