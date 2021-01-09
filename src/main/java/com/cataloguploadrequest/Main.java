package com.cataloguploadrequest;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.lang.InterruptedException;

//import javax.xml.bind.JAXBException;

public class Main {

    public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException, URISyntaxException, InterruptedException {
//JAXBException,
        com.cataloguploadrequest.UI ui = new com.cataloguploadrequest.UI();
        ui.userInterface();

        com.cataloguploadrequest.cXMLBuilder cb = new com.cataloguploadrequest.cXMLBuilder();
        cb.createcXML();

        com.cataloguploadrequest.Post p = new com.cataloguploadrequest.Post();
        p.HttpPost();

    }

}