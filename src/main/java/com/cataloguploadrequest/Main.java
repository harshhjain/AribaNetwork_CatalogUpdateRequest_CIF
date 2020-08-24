package com.cataloguploadrequest;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

//import javax.xml.bind.JAXBException;

public class Main {

    public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException {
//JAXBException,
        com.cataloguploadrequest.cXMLBuilder cb = new com.cataloguploadrequest.cXMLBuilder();
        cb.createcXML();

        com.cataloguploadrequest.Post p = new com.cataloguploadrequest.Post();
        p.HttpPost();

    }

}
