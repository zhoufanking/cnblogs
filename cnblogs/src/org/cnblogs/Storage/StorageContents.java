package org.cnblogs.Storage;

import java.util.Vector;

public class StorageContents {
	public StorageContents() {
		
		items = new Vector<String>();
		summeries = new Vector<String>();
		links = new Vector<String>();
		postTimes = new Vector<String>();
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
	public Vector<String> getLinks() {
		return links;
	}
	public void setLinks(Vector<String> links) {
		this.links = links;
	}
	public Vector<String> getPostTimes() {
		return postTimes;
	}
	public void setPostTimes(Vector<String> postTimes) {
		this.postTimes = postTimes;
	}


	private Vector<String> items ;
	private Vector<String> summeries;
	private Vector<String> links ;
	private Vector<String> postTimes;
	

}
