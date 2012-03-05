package org.cnblogs.FetchMethod;

import java.io.IOException;
import java.util.Vector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FetchBlogs implements Fetch{

	@Override
	public void Connect(String WebAddress){
		// TODO Auto-generated method stub
		try {
			doc = Jsoup.connect(WebAddress).userAgent("Mozilla").timeout(30000).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getItems() {
		// TODO Auto-generated method stub
		Elements news = null;
		news = doc.getElementsByClass("titlelnk");

		if (news != null) {
			// System.out.println(news.text());

			for (Element item : news) {
				itemsVec.add(item.text().replace("\u2014", "-")); // \u2014
																	// unicode涓��绌烘�
			}
		}

	}

	@Override
	public  void getItemSummery() {
		// TODO Auto-generated method stub
		Elements summeries = null;
		summeries = doc.getElementsByClass("post_item_summary");
		
		if (summeries != null) {
			// System.out.println(news.text());

			for (Element summery : summeries) {
				summeryVec.add(summery.text().replace("\u2014", "-"));
			}
		}
	}
	
	@Override
	public void getItemLink() {
		// TODO Auto-generated method stub
		Elements news = null;
		news = doc.getElementsByClass("titlelnk");

		if (news != null) {
			// System.out.println(news.text());

			for (Element item : news) {
				//itemsVec.add(item.text().replace("\u2014", "-")); // \u2014
																	// unicode涓��绌烘�
				itemLinkVec.add(item.absUrl("href"));
			}
		}
		
	}
	@Override
	public void printContent() {
		// TODO Auto-generated method stub
		for(int lp=0; lp < itemsVec.size(); lp++)
		{
			print(itemsVec.get(lp));
			print(summeryVec.get(lp));
			print(itemLinkVec.get(lp));
			print(postDateVec.get(lp));
			print("down");
		}
		
	}
	
	private void print(String arg0){
		System.out.println(arg0);
	}
	
	private FetchBlogs(){
		itemsVec = new Vector<String>();
		summeryVec = new Vector<String>();
		postDateVec = new Vector<String>();
		itemLinkVec = new Vector<String>();
		doc = null;
		itemsVec.clear();
		summeryVec.clear();
		postDateVec.clear();
	}
	
	public static Fetch newFetchBlogsInstance(){
		FetchBlogs aInstance = new FetchBlogs();
		return aInstance;
	}
	
	
	@Override
	public void getPostDate() {
		// TODO Auto-generated method stub
		String tempDate = null;
		Elements pstimes = null;
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
		
		
		
	}
	
	private Vector<String> itemsVec;
	private Vector<String> summeryVec;
	private Vector<String> itemLinkVec;
	private Vector<String> postDateVec;
	private Document doc;


}
