package com.cataloguploadrequest;

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
    }
    public static void main(String []args) throws IOException, URISyntaxException, InterruptedException{
        HttpPost();
    }
}