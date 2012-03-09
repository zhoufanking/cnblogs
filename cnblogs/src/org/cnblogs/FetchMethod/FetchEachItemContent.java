package org.cnblogs.FetchMethod;

import java.io.IOException;
import java.util.Vector;

import org.cnblogs.Resourse.R;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class FetchEachItemContent {

	public static Vector<String> getPostContent(Vector<String> postLinksVec) {
		// TODO Auto-generated method stub
		Vector<String> postContentVec = new Vector<String>();
		Document doc = null;
		
		for(int i = 0; i< postLinksVec.size();i++)
		{
			System.out.println("geting content of :"+postLinksVec.get(i));
			
			for (int j = 0; doc == null&&j < R.getRetrytimes(); j++) {
				
				try {
					doc = Jsoup.connect(postLinksVec.get(i))
							.userAgent("Mozilla").timeout(3000).get();
				} catch (IOException e) {
					//e.printStackTrace();
				}
			}
			if(doc == null)
				postContentVec.add(R.getFileNotExistMsg());
			else
				postContentVec.add(doc.getElementsByClass("postBody").html());	
			doc = null;
		}
	
		return postContentVec;
	}
}
