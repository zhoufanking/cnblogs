package org.cnblogs.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class LocalStorage implements Storage {

	@Override
	public StorageContents LoadFromStorage(File fp) {
		// TODO complete the implement
		return null;
	}

	@Override
	public void WritetoStorage(File fp, StorageContents sc) {
		
		PrintWriter output = null;
		try {
			output = new PrintWriter(fp);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		for (int i = 0,length = sc.getItems().size(); i < length; i++) {
			output.println(sc.getItems().get(i));
			output.println(sc.getSummeries().get(i));
			output.println(sc.getLinks().get(i));
			output.println(sc.getPostTimes().get(i));
			output.println(i);
		}
		output.close();

	}

}
