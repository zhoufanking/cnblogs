package org.cnblogs.FetchMethod;

public class FetcherFactory {
	public static Fetch getFetcher(String type){
		
		Fetch aFetchInstance = null;
		try {
			aFetchInstance  = (Fetch)Class.forName("org.cngblogs.FetchMethod."+type).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aFetchInstance;
		
	}

}
