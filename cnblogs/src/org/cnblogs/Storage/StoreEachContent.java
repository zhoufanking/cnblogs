package org.cnblogs.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Vector;

import org.cnblogs.Resourse.Res;

public class StoreEachContent {

	public static Vector<String> Store(	Vector<String> eachContent){
		
		Vector<String> ContentPathes = new Vector<String>();
		String path = null;
		System.out.println("create dir");
		
		File dir = new File(Res.getContentsDir());
		if(!dir.exists() ||!dir.isDirectory())
		{
			if(!dir.mkdir())
				return null;				
		}
		
		
		for(int i = 0; i< eachContent.size();i++){
			path = Res.getContentsDir()+"\\"+i+".html";
			File file = new File(path);
			ContentPathes.add(path);
			
			PrintWriter output = null;
			try {
				output = new PrintWriter(file);
			} catch (FileNotFoundException e) {
				
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
