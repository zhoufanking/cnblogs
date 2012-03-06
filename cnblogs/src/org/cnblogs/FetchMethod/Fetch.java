package org.cnblogs.FetchMethod;

import java.util.Vector;

public interface Fetch {
	public void Connect(String WebAddress);
	public Vector<String> getItems();
	public Vector<String> getItemSummery();
	public Vector<String> getItemLink();
	public Vector<String> getPostDate();
}
