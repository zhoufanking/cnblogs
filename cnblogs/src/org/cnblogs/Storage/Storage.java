package org.cnblogs.Storage;

import java.io.File;

public interface Storage {
	public StorageContents LoadFromStorage(File fp);
	public void WritetoStorage(File fp,StorageContents sc);

}
