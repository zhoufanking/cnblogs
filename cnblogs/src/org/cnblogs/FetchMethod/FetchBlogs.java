package org.cnblogs.FetchMethod;

import java.io.IOException;
import java.util.Vector;

import org.cnblogs.Resourse.R;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FetchBlogs implements Fetch{

	@Override
	public boolean Connect(String WebAddress){

		for(int Retry = 0 ; (doc == null)&&(Retry < R.getRetrytimes()); Retry++){
			try {
				doc = Jsoup.connect(WebAddress).userAgent("Mozilla").timeout(3000).get();
			} catch (IOException e) {
					System.out.println(R.getConRetryMsg()+"第"+(Retry+1)+"次");			
			}
		}
		if(doc == null)
			return false;
		else
			return true;
		
	}

	@Override
	public Vector<String> getItems() {

		Elements news = null;
		Vector<String> itemsVec;
		news = doc.getElementsByClass("titlelnk");
		itemsVec = new Vector<String>();

		if (news != null) {
			// System.out.println(news.text());

			for (Element item : news) {
				itemsVec.add(item.text().replace("\u2014", "-")); // \u2014
																	// unicode涓��绌烘�
			}
		}
		return itemsVec;

	}

	@Override
	public  Vector<String> getItemSummery() {

		Elements summeries = null;
		Vector<String> summeryVec;
		summeryVec = new Vector<String>();
		
		summeries = doc.getElementsByClass("post_item_summary");
		
		if (summeries != null) {
			// System.out.println(news.text());

			for (Element summery : summeries) {
				summeryVec.add(summery.text().replace("\u2014", "-"));
			}
		}
		return summeryVec;
	}
	
	@Override
	public Vector<String> getItemLink() {
		
		Elements news = null;
		Vector<String> itemLinkVec;
		itemLinkVec = new Vector<String>();
		news = doc.getElementsByClass("titlelnk");

		if (news != null) {
			// System.out.println(news.text());

			for (Element item : news) {
				//itemsVec.add(item.text().replace("\u2014", "-")); // \u2014
																	// unicode涓��绌烘�
				itemLinkVec.add(item.absUrl("href"));
			}
		}
		return itemLinkVec;
		
	}
	
	@Override
	public Vector<String> getPostDate() {

		String tempDate = null;
		Elements pstimes = null;
		Vector<String> postDateVec;
		postDateVec = new Vector<String>();
		pstimes = doc.getElementsByClass("post_item_foot");

		if (pstimes != null) {
			// System.out.println(news.text());

			for (Element pstime : pstimes) {
				tempDate = pstime.text();
				//tempDate.substring(tempDate.indexOf(" "), tempDate.lastIndexOf(" "));
				int startPos = tempDate.lastIndexOf("发布于")+4;
				postDateVec.add(tempDate.substring(startPos, startPos+10));
			}
		}
		return postDateVec;
		
	}

	public FetchBlogs(){
		doc = null;
	}
	
	
	
	private Document doc;

}
