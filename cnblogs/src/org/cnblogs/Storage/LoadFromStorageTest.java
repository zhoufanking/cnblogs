package org.cnblogs.Storage;

import java.io.File;

import org.cnblogs.Resourse.Res;

public class LoadFromStorageTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalStorageXml input = new LocalStorageXml();
		input.LoadFromStorage(new File(Res.getStorageFilePath()));

	}

}
