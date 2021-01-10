package com.cataloguploadrequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.FormBodyPartBuilder;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.swing.*;
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

                String statusResponse = "";

                while (reader.readLine() != null) {
                    String responseLine = reader.readLine();
                    if (responseLine.contains("Status")) {
                        System.out.println(responseLine);
                        statusResponse = responseLine;
                    }

                }
//                System.out.println(response.getStatusLine());
//                System.out.println(response.toString());

                JFrame f1 = new JFrame("Response Details");

                JLabel responseLabel = new JLabel("Status Response from AN:");
                responseLabel.setBounds(30, 30, 200, 20);
                f1.add(responseLabel);

                JTextField  responseField = new JTextField (statusResponse);
                responseField.setBounds(30, 60, 1300, 75);
                responseField.setToolTipText("Response which AN has sent");
                JScrollPane scrollableTextArea = new JScrollPane(responseField);
                scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                f1.getContentPane().add(scrollableTextArea);

                f1.add(responseField);

                /////////////////////////////////////

                JLabel responseLabel1 = new JLabel("Developed by:");
                responseLabel1.setBounds(30, 150, 200, 20);
                f1.add(responseLabel1);

                JLabel responseLabel2 = new JLabel("Harsh Vardhan Jain");
                responseLabel2.setBounds(30, 170, 200, 20);
                f1.add(responseLabel2);

                /////////////////////////////////////

//                JLabel requestMIMELabel = new JLabel("Request MIME:");
//                requestMIMELabel.setBounds(30, 300, 200, 20);
//                f1.add(requestMIMELabel);
//
//                JTextArea  responseMIMEField = new JTextArea (response.body());
//                responseMIMEField.setBounds(30, 330, 800, 200);
//                responseMIMEField.setToolTipText("Response which AN has sent");
//                f1.add(responseMIMEField);

                /////////////////////////////////////

//                f1.setSize(850, 800);
                f1.setSize(1500, 300);
                f1.setLayout(null);
                f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f1.setVisible(true);


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
