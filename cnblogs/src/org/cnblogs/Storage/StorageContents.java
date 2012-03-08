package org.cnblogs.Storage;

import java.util.Vector;

public class StorageContents {
	public StorageContents() {
		
		items = new Vector<String>();
		summeries = new Vector<String>();
		postTimes = new Vector<String>();
		postContentPath = new Vector<String>();
		length = 0;
	}
	public int getLength(){
		return  items.size();
	}
	
	public Vector<String> getItems() {
		return items;
	}
	public void setItems(Vector<String> items) {
		this.items = items;
	}
	public Vector<String> getSummeries() {
		return summeries;
	}
	public void setSummeries(Vector<String> summeries) {
		this.summeries = summeries;
	}

	
	public Vector<String> getPostTimes() {
		return postTimes;
	}
	public void setPostTimes(Vector<String> postTimes) {
		this.postTimes = postTimes;
	}
	


	public Vector<String> getPostContentPath() {
		return postContentPath;
	}

	public void setPostContentPath(Vector<String> postContentPath) {
		this.postContentPath = postContentPath;
	}



	private Vector<String> items ;
	private Vector<String> summeries;
	private Vector<String> postTimes;
	private Vector<String> postContentPath;
	private int length ;
	

}
