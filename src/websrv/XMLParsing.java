package webServ;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class XMLParsing extends WebServices
{

	String parseXML(StringBuffer result) {
		Document doc = null;
		try
		{
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(result.toString()));
			 doc= dBuilder.parse(is);
			doc.getDocumentElement().normalize();
			System.out.println(doc.getDocumentElement().getTextContent());
			
		} 
		catch (Exception e)
		{
		e.printStackTrace();
		}
		return doc.getDocumentElement().getTextContent();
	}

	
}

