package org.cnblogs.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Vector;

import org.cnblogs.Resourse.Res;

public class StoreEachContent {

	public static Vector<String> Store(	Vector<String> eachContent){
		
		//create the  contents dir
		Vector<String> ContentPathes = new Vector<String>();
		String path = null;
		System.out.println("create content dir");
		
		File dir = new File(Res.getContentsDir());
		if(!dir.exists() ||!dir.isDirectory())
		{
			if(!dir.mkdir()){
				System.out.println("Create" + Res.getContentsDir() +"failed!");
				return null;
			}
								
		}
		
		File dirImg = new File(Res.getImgDir());
		if(!dirImg.exists() ||!dirImg.isDirectory())
		{
			if(!dirImg.mkdir()){
				System.out.println("Create" + Res.getImgDir() +"failed!");
				return null;
			}
			System.out.println("image dir ok,path is :" + Res.geTimeOut()+File.separator);
								
		}
		
		//write content to local file
		for(int i = 0; i< eachContent.size();i++){
			path = Res.getContentsDir()+File.separator+i+".html";
			System.out.println("Creating content file:  "+path);
			
			File file = new File(path);
			
			ContentPathes.add(path);
			
			PrintWriter output = null;
			try {
				output = new PrintWriter(file);
			} catch (FileNotFoundException e) {
				System.out.println("Saving content file " +path+" error");
				e.printStackTrace();
			}
			System.out.println("saving");
			output.print(eachContent.get(i));
			output.close();
		}
		
		System.out.println("save content done");
		return ContentPathes;
	}
		

}
