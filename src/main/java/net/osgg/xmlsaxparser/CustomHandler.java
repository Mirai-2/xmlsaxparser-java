package net.osgg.xmlsaxparser;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CustomHandler extends DefaultHandler {
	boolean nombre = false;
    boolean hombres= false;
    boolean mujeres = false;
    Integer total = 0, hombres_poblacion = 0, mujeres_poblacion = 0 ;

    
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //System.out.println("(starts element:" + qName + ")");
 
        if (qName.equalsIgnoreCase("paises")) {
            String id = attributes.getValue("year");
            System.out.println("Datos del año: " + id);
            System.out.println("****************************************");
        }
        if (qName.equalsIgnoreCase("nombre")) {
        	nombre = true;
        }
        if (qName.equalsIgnoreCase("hombres")) {
        	hombres = true;
        }
        if (qName.equalsIgnoreCase("mujeres")) {
        	mujeres = true;
        }

    }
    
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //System.out.println("ends element:" + qName);
    }
    
    public void characters(char ch[], int start, int length) throws SAXException {
        if (nombre) {
            System.out.println("País: " + new String(ch, start, length));
            nombre = false;
        }
        if (hombres) {
        	hombres_poblacion = Integer.parseInt (new String(ch, start, length));
            System.out.println("Hombres: " + hombres_poblacion);
            hombres = false;
        }
        if (mujeres) {
        	mujeres_poblacion = Integer.parseInt (new String(ch, start, length));
            System.out.println("Mujeres: " + mujeres_poblacion);
        }
        
        if(mujeres) {
	        total = mujeres_poblacion + hombres_poblacion;
	        System.out.println("Poblacion total: " + total);
	        System.out.println("***************************************************");
	        
	        mujeres = false;
        }
    }
    
}
