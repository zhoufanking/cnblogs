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
		String imgPath = "BADIMAGE";
		
		File dirImg = new File(Res.getImgDir());
		if(!dirImg.exists() ||!dirImg.isDirectory())
		{
			if(!dirImg.mkdir()){
				System.out.println("Create" + Res.getImgDir() +"failed!");
			}
			System.out.println("image dir ok,path is :" + Res.getImgDir()+File.separator);
							
		}
		
		 for (Element src : Imgs) {
			 
			 if(src.tagName().equals("img")){
				 //obtain the image link
				 imgLink = src.attr("abs:src");
				 if(!imgLink.contains("?")&&!imgLink.equals(null))
					 //fetch the image and store it in a local dir
					 imgPath = makeImg(imgLink,Res.getImgDir()+File.separator);
				 else
					 imgPath = "BADIMAGE";
				 //replace the image link in the post body from a web link to a local link
				src.attr("src", imgPath);
				 
			
		}
		
		
	}
	}
	
	
	// 生成图片函数
	// return the image's local path
	private static String makeImg(String imgUrl, String imgDir) {
		String path = null;
		if(imgUrl.equals(null) || imgDir.equals(null)){
			path = "BADLINK OR DIRNAME";
			return path;
		}
			
		
		try {

			// 创建流
			BufferedInputStream in = null;
			try {
				in = new BufferedInputStream(
						new URL(imgUrl).openStream());
			} catch (Exception e) {
				path = "BADLINK";
				return path;
			}finally{
				if(in.equals(null))
				{
					path = "BADLINK";
					return path;
				}
			}
			

			// 生成图片名
			int index = imgUrl.lastIndexOf("/");
			String sName = imgUrl.substring(index + 1, imgUrl.length());
			path = imgDir+sName;
			System.out.println(sName);
			// 存放地址
			File img = new File(path);
			// 生成图片
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
			//e.printStackTrace();
			return (path = "BADIMAGE");
		}
		
		return path;
	}
}
