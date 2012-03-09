package org.cnblogs.Storage;

import java.io.File;
import java.util.Vector;

import org.cnblogs.Resourse.Res;

public class WritetoStorageTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StorageContents sc = new StorageContents();
		
		//create the sc content;
		Vector<String> item  = new Vector<String>();
		Vector<String> summery = new Vector<String>();
		Vector<String> postContentPath  = new Vector<String>();
		Vector<String> postDate = new Vector<String>();
		
		String itemName = "item";
		String itemSumm = "abcdefg";
		String postCP = "c:\\abc.html";
		String postD = "2012-03-08";
		
		for(int i = 0; i<10; i++){
			item.add(itemName+i);
			summery.add(itemSumm+i);
			postContentPath.add(postCP);
			postDate.add(postD);
		}
		
		sc.setItems(item);
		sc.setSummeries(summery);
		sc.setPostTimes(postDate);
		sc.setPostContentPath(postContentPath);
		
//		WritetoStorage
		LocalStorageXml output = new LocalStorageXml();
		output.WritetoStorage(new File(Res.getStorageFilePath()), sc);

	}

}
