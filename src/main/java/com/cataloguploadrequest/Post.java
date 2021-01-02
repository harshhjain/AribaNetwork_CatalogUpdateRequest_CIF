package com.cataloguploadrequest;

import org.apache.http.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.FormBodyPartBuilder;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Post {

    public void HttpPost() {

        try {
            Properties properties = new Properties();
            FileInputStream input = new FileInputStream("config.properties");
            properties.load(input);
            
            String URL = properties.getProperty("URL");
            String userAgent = properties.getProperty("userAgent");
            
            
            try {
                CloseableHttpClient client = HttpClientBuilder.create().build();
                HttpPost httpPost = new HttpPost(URL);
                httpPost.setHeader("User-Agent", userAgent);

                MultipartEntityBuilder builder = MultipartEntityBuilder.create();

                FormBodyPartBuilder part1 = FormBodyPartBuilder.create()
                        .setName("cXML Name")
                        .setField("Content-Type", "text/xml")
                        .setBody(new FileBody(new File("files/CatalogUploadRequest.xml")));

                FormBodyPartBuilder part2 = FormBodyPartBuilder.create()
                        .setName("CIF")
                        .setField("Content-Type", "text/plain")
                        .setBody(new FileBody(new File("files/catalog_1.cif")));

                builder.addPart(part1.build());
                builder.addPart(part2.build());

                httpPost.setEntity(builder.build());

                HttpEntity entity = httpPost.getEntity();

                HttpResponse response = client.execute(httpPost);                
                
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                while (reader.readLine() != null) {
                    System.out.println(reader.readLine());
                }
                System.out.println(response.getStatusLine());
                System.out.println(response.toString());
                
                
            } catch (IOException ex) {
                Logger.getLogger(Post.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Post.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Post.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
