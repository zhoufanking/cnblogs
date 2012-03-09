package org.cnblogs.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.cnblogs.Resourse.Res;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LocalStorageXml implements Storage {
	
	public LocalStorageXml() {
		scTemp = new StorageContents();
	}
	
	
	@Override
	public StorageContents LoadFromStorage(File fp) {
		// TODO Auto-generated method stub
		if(fp == null){
			fp = new File(Res.getStorageFilePath());
		}
		if(!fp.exists())
			return null;
		
		return LoadFromCache(fp);
	}
//
//	public Vector<String> StoreEachContent(	Vector<String> eachContent){
//		
//		Vector<String> ContentPathes = new Vector<String>();
//		String path = null;
//		
//		File dir = new File(R.getContentsDir());
//		if(!dir.exists() ||!dir.isDirectory())
//		{
//			if(!dir.mkdir())
//				return null;				
//		}
//		
//		for(int i = 0; i< eachContent.size();i++){
//			path = R.getStorageFilePath()+"\\"+i+".html";
//			File file = new File(path);
//			ContentPathes.add(path);
//			
//			PrintWriter output = null;
//			try {
//				output = new PrintWriter(file);
//			} catch (FileNotFoundException e) {
//				
//				e.printStackTrace();
//			}
//			output.print(eachContent.get(i));
//			output.close();
//		}
//		
//		return ContentPathes;
//	}
//	
	//completed
	@Override
	public void WritetoStorage(File fp, StorageContents sc) {
		// Auto-generated method stub

		DocumentBuilderFactory docFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder docBuilder = null;

		try {
			docBuilder = docFactory.newDocumentBuilder();

			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("CFG_DETAIL");
			doc.appendChild(rootElement);

			// create elements
			for (int i = 0, lpCnt = sc.getLength(); i < lpCnt; i++) {

				Element staff = doc.createElement("Item");
				rootElement.appendChild(staff);

//				Attr attr = doc.createAttribute("PostDate");
//				attr.setValue(sc.getPostTimes().get(i));
//				staff.setAttributeNode(attr);
				
				Element Title = doc.createElement("Title");
				Title.appendChild(doc.createTextNode(sc.getItems().get(i)));
				staff.appendChild(Title);
				
				Element postD = doc.createElement("PostDate");
				postD.appendChild(doc.createTextNode(sc.getPostTimes().get(i)));
				staff.appendChild(postD);

				Element Summery = doc.createElement("ItemSummery");
				Summery.appendChild(doc
						.createTextNode(sc.getSummeries().get(i)));
				staff.appendChild(Summery);

				Element postContent = doc.createElement("PostContentPath");
				postContent.appendChild(doc.createTextNode(sc
						.getPostContentPath().get(i)));
				staff.appendChild(postContent);
			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(fp);

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);

			// for test monitor
			System.out.println("File saved!");

		} catch (ParserConfigurationException e) {
			// Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private StorageContents LoadFromCache(File fp){
		Document doc = openFile(fp);
	//	Element root = doc.getDocumentElement();
		
		return parseElement(doc);
	}
	
	private Document openFile(File file) {
		
		DocumentBuilder docBuilder = null;
		Document doc = null;
		try {
			docBuilder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			doc = docBuilder.parse(file);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return doc;
	}

	private StorageContents parseElement(Document doc) {

		NodeList itemName = doc.getElementsByTagName("Title");
		NodeList itemPostD = doc.getElementsByTagName("PostDate");
		NodeList itemSummery = doc.getElementsByTagName("ItemSummery");
		NodeList itemContentPath = doc.getElementsByTagName("PostContentPath");
		
		Vector<String> item  = new Vector<String>();
		Vector<String> summery = new Vector<String>();
		Vector<String> postContentPath  = new Vector<String>();
		Vector<String> postDate = new Vector<String>();

		for(int i=0; i< itemName.getLength();i++){
			
//			System.out.println(itemName.item(i).getTextContent());
//			System.out.println(itemPostD.item(i).getTextContent());
//			System.out.println(itemSummery.item(i).getTextContent());
//			System.out.println(itemContentPath.item(i).getTextContent());
			
			item.add(itemName.item(i).getTextContent());
			summery.add(itemSummery.item(i).getTextContent());
			postContentPath.add(itemContentPath.item(i).getTextContent());
			postDate.add(itemPostD.item(i).getTextContent());						
		}
		
		scTemp.setItems(item);
		scTemp.setPostTimes(postDate);
		scTemp.setSummeries(summery);
		scTemp.setPostContentPath(postContentPath);
		return scTemp;
	}
	
	private StorageContents scTemp;
	
	
}


