package com.cataloguploadrequest;

import javax.swing.*;
import java.net.http.*;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.URI;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.lang.InterruptedException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class Post {

    public static void HttpPost() throws IOException, URISyntaxException, InterruptedException{
        Properties properties = new Properties();
        FileInputStream input = new FileInputStream("config.properties");
        properties.load(input);

        String URL = properties.getProperty("URL");
        String userAgent = properties.getProperty("userAgent");

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(new URI(URL))
                .header("User-Agent", userAgent)
                .POST(BodyPublishers.ofFile(Paths.get("files/CatalogUploadRequest.xml")))
                .POST(BodyPublishers.ofFile(Paths.get("files/catalog_1.cif")))
                .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        System.out.println(response.body());

        JFrame f1 = new JFrame("Response Details");

        JLabel responseLabel = new JLabel("Response cXML:");
        responseLabel.setBounds(30, 30, 200, 20);
        f1.add(responseLabel);

        JTextArea  responseField = new JTextArea (response.body());
        responseField.setBounds(30, 60, 800, 200);
        responseField.setToolTipText("Response which AN has sent");
        f1.add(responseField);

        /////////////////////////////////////

        JLabel requestMIMELabel = new JLabel("Request MIME:");
        requestMIMELabel.setBounds(30, 300, 200, 20);
        f1.add(requestMIMELabel);

        JTextArea  responseMIMEField = new JTextArea (response.body());
        responseMIMEField.setBounds(30, 330, 800, 200);
        responseMIMEField.setToolTipText("Response which AN has sent");
        f1.add(responseMIMEField);

        /////////////////////////////////////

        f1.setSize(850, 800);
        f1.setLayout(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);

    }

}