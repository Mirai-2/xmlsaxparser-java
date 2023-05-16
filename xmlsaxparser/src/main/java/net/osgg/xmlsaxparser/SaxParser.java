package net.osgg.xmlsaxparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;


public class SaxParser {
	
	private String fileName;
	
	public SaxParser(String fileName) {
		this.fileName = fileName;
	}

	public void parse() throws Exception{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        
        CustomHandler handler = new CustomHandler();
        
        File file = new File(fileName);
        InputStream inputStream = new FileInputStream(file);
        Reader reader = new InputStreamReader(inputStream, "UTF-8");
        InputSource is = new InputSource(reader);
        is.setEncoding("UTF-8");
        saxParser.parse(is, handler);

	}
	
}
