package org.cnblogs.Storage;

public class LocalStorageFactory {
	public static Storage newInstance(){
		return new LocalStorageXml();
	}

}
