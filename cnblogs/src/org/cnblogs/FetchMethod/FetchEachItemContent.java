package org.cnblogs.FetchMethod;

import java.io.IOException;
import java.util.Vector;

import org.cnblogs.Resourse.Res;
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
			
			for (int j = 0; doc == null&&j < Res.getRetrytimes(); j++) {
				System.out.println("Startting the jsoup fetching process");
				try {
					doc = Jsoup.connect(postLinksVec.get(i))
							.userAgent("Mozilla").timeout(3000).get();
				} catch (IOException e) {
					//e.printStackTrace();
					System.out.println(Res.getConRetryMsg());
				}
			}
			if(doc == null){
				System.out.println("jsoup fetch tips error, doc is null");
				postContentVec.add(Res.getFileNotExistMsg());
			}
				
			else
				postContentVec.add(doc.getElementsByClass("post").html());	
			if(i%3 == 0){
//				System.out.println(doc.getElementsByClass("postbody").html());
			}
			doc = null;
		}
	
		return postContentVec;
	}
}
