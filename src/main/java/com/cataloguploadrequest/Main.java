package com.cataloguploadrequest;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

//import javax.xml.bind.JAXBException;

public class Main {

    public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException {
//JAXBException,
        com.cataloguploadrequestv2.cXMLBuilder cb = new com.cataloguploadrequestv2.cXMLBuilder();
        cb.createcXML();

        com.cataloguploadrequestv2.Post p = new com.cataloguploadrequestv2.Post();
        p.HttpPost();

    }

}
