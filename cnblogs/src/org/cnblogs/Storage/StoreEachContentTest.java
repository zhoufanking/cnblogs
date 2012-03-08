package org.cnblogs.Storage;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class StoreEachContentTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("c:\\new.html");
		
		Document doc = null;
		Elements c = null;
		Vector<String> vec = new Vector<String>();
		
		try {
			 doc = Jsoup.parse(file,"UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c = doc.getElementsByClass("postBody");
		//System.out.println(c.html());
		int i = 0;
//		while(i<1){
//			vec.add(c.html());		
//	}
		for(;i<10;i++)
			vec.add(c.html());
	StoreEachContent.Store(vec);
	System.out.println("done");
		
	}

}
