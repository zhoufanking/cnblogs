package org.cnblogs.FetchMethod;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Vector;

import org.cnblogs.Resourse.Res;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class FetchEachItemContent {

	private static Document doc = null;
	private static String post = null;
	private static Vector<String> tempVec = new Vector<String>();
	
	public static Vector<String> getPostContent(Vector<String> postLinksVec) {
		// TODO Auto-generated method stub
		Vector<String> postContentVec = new Vector<String>();
//		Document doc = null;
		
		for(int i = 0; i< postLinksVec.size();i++)
		{
			System.out.println("geting content of :"+postLinksVec.get(i));
			
			for (int j = 0; doc == null&&j < Res.getRetrytimes(); j++) {
				System.out.println("Startting the jsoup fetching process");
				try {
					doc = Jsoup.connect(postLinksVec.get(i))
							.userAgent("Mozilla").timeout(Res.geTimeOut()).get();
				} catch (IOException e) {
					//e.printStackTrace();
					System.out.println(Res.getConRetryMsg());
				}
			}
			if(doc == null){
				System.out.println("jsoup fetch tips error, doc is null");
				postContentVec.add(Res.getFileNotExistMsg());
			}
				
			else{
				//post = doc.getElementsByClass("post").html();
				getContentImg(doc);
				postContentVec.add(doc.getElementsByClass("post").html());
			}
					
			
			doc = null;
		}
	
		return postContentVec;
	}
	
	private static void  getContentImg(Document doc){
		
		Elements Imgs = doc.select("[src]");
		
		String imgLink = null;
		String imgPath = null;
		
		tempVec.clear();
		
		 for (Element src : Imgs) {
			 
			 if(src.tagName().equals("img")){
				 //obtain the image link
				 imgLink = src.attr("abs:src");
				 //fetch the image and store it in a local dir
				 imgPath = makeImg(imgLink,Res.getImgDir()+File.separator);
				 
				 if(imgPath.equals(null))
					 imgPath = "BADIMAGE";
				 //replace the image link in the post body from a web link to a local link
				src.attr("abs:src", imgPath);
				 
			 }
		}
		
		
	}
	
	
	// ����ͼƬ����
	// return the image's local path
	private static String makeImg(String imgUrl, String imgDir) {
		String path = null;
		try {

			// ������
			BufferedInputStream in = new BufferedInputStream(
					new URL(imgUrl).openStream());
			if(in.equals(null))
			{
				return null;
			}

			// ����ͼƬ��
			int index = imgUrl.lastIndexOf("/");
			String sName = imgUrl.substring(index + 1, imgUrl.length());
			path = imgDir + File.separator+sName;
			System.out.println(sName);
			// ��ŵ�ַ
			File img = new File(path);
			// ����ͼƬ
			BufferedOutputStream out = new BufferedOutputStream(
					new FileOutputStream(img));
			byte[] buf = new byte[2048];
			int length = in.read(buf);
			while (length != -1) {
				out.write(buf, 0, length);
				length = in.read(buf);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return path;
	}
}
