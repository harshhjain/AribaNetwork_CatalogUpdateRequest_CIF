package com.cataloguploadrequest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class Inc{
    int i;
    public Inc(){
        i = 0;
    }
}

class UI{
    public static void userInterface() throws FileNotFoundException, IOException{
        Properties properties = new Properties();
        FileInputStream input = new FileInputStream("config.properties");
        properties.load(input);

        JFrame f = new JFrame("Catalog poster");

        JLabel XMLVersionLabel = new JLabel("XML Version:");
        XMLVersionLabel.setBounds(30, 30, 200, 20);
        f.add(XMLVersionLabel);

        JTextField XMLVersionField = new JTextField(properties.getProperty("XMLVersion"));
        XMLVersionField.setBounds(250, 30, 400, 20);
        XMLVersionField.setToolTipText("<HTML>Enter the DTD version you want to use<BR>Check http://cxml.org/ to get know the latest DTD version.");
        f.add(XMLVersionField);

        /////////////////////////////
        JLabel URLLabel = new JLabel("URL:");
        URLLabel.setBounds(30, 60, 200, 20);
        f.add(URLLabel);

        JTextField URLField = new JTextField(properties.getProperty("URL"));
        URLField.setBounds(250, 60, 400, 20);
        URLField.setToolTipText("<html>Ariba Network which takes catalog MIME.<br>To confirm the URL post ProfileRequest to AN.</html>");
        f.add(URLField);

        /////////////////////////////
        JLabel operationTypeLabel = new JLabel("Operation type:");
        operationTypeLabel.setBounds(30, 90, 200, 20);
        f.add(operationTypeLabel);

        JTextField operationTypeField = new JTextField(properties.getProperty("operationType"));
        operationTypeField.setBounds(250, 90, 400, 20);
        operationTypeField.setToolTipText("<html>Use 'new' when you uploading the 1st version of catalog<br>Use 'update' when you are updating the previous version.</html>");
        f.add(operationTypeField);

        /////////////////////////////
        JLabel fromIdentityValueLabel = new JLabel("From Identity Value:");
        fromIdentityValueLabel.setBounds(30, 120, 200, 20);
        f.add(fromIdentityValueLabel);

        JTextField fromIdentityValueField = new JTextField(properties.getProperty("fromIdentityValue"));
        fromIdentityValueField.setBounds(250, 120, 400, 20);
        fromIdentityValueField.setToolTipText("Enter Supplier's ANID");
        f.add(fromIdentityValueField);

        /////////////////////////////
        JLabel senderIdentityValueLabel = new JLabel("Sender Identity Value:");
        senderIdentityValueLabel.setBounds(30, 150, 200, 20);
        f.add(senderIdentityValueLabel);

        JTextField senderIdentityValueField = new JTextField(properties.getProperty("senderIdentityValue"));
        senderIdentityValueField.setBounds(250, 150, 400, 20);
        senderIdentityValueField.setToolTipText("Enter Sender ANID which should be same as Supplier's ANID");
        f.add(senderIdentityValueField);

        /////////////////////////////
        JLabel buyerIdentityValueLabel = new JLabel("Buyer Identity Value:");
        buyerIdentityValueLabel.setBounds(30, 180, 200, 20);
        f.add(buyerIdentityValueLabel);

        JTextField buyerIdentityValueField = new JTextField(properties.getProperty("toIdentityValue"));
        buyerIdentityValueField.setBounds(250, 180, 400, 20);
        buyerIdentityValueField.setToolTipText("<html>Enter Buyer's ANID to which you want to send the catalog.<br>For a public catalog user 'AN01000000001' as Buyer's ANID.</html>");
        f.add(buyerIdentityValueField);

        /////////////////////////////
        JLabel sharedSecretValueLabel = new JLabel("Sender's Shared Secret:");
        sharedSecretValueLabel.setBounds(30, 210, 200, 20);
        f.add(sharedSecretValueLabel);

//        JTextField sharedSecretValueField = new JTextField(properties.getProperty("sharedSecretValue"));
//        sharedSecretValueField.setBounds(250, 210, 400, 20);
//        sharedSecretValueField.setToolTipText("Enter Shared Secret which should be the Supplier's Shared Secret");
//        f.add(sharedSecretValueField);

        JPasswordField sharedSecretValueField = new JPasswordField(properties.getProperty("sharedSecretValue"));
        sharedSecretValueField.setBounds(250, 210, 400, 20);
        sharedSecretValueField.setToolTipText("Enter Shared Secret which should be the Supplier's Shared Secret");
        f.add(sharedSecretValueField);

        /////////////////////////////
        JLabel catalogNameValueLabel = new JLabel("Catalog Name:");
        catalogNameValueLabel.setBounds(30, 240, 200, 20);
        f.add(catalogNameValueLabel);

        JTextField catalogNameValueField = new JTextField(properties.getProperty("catalogNameValue"));
        catalogNameValueField.setBounds(250, 240, 400, 20);
        catalogNameValueField.setToolTipText("Replace 'Name' with your catalog name which you want to display in AN UI.");
        f.add(catalogNameValueField);

        /////////////////////////////
        JLabel catalogDescriptionLabel = new JLabel("Catalog Description");
        catalogDescriptionLabel.setBounds(30, 270, 200, 20);
        f.add(catalogDescriptionLabel);

        JTextField catalogDescriptionField = new JTextField(properties.getProperty("catalogDescription"));
        catalogDescriptionField.setBounds(250, 270, 400, 20);
        catalogDescriptionField.setToolTipText("Replace 'Catalog Description' with description which you want to display on AN UI. ");
        f.add(catalogDescriptionField);

        /////////////////////////////
        JLabel emailAddressLabel = new JLabel("E-mail Address");
        emailAddressLabel.setBounds(30, 300, 200, 20);
        f.add(emailAddressLabel);

        JTextField emailAddressField = new JTextField(properties.getProperty("emailAddress"));
        emailAddressField.setBounds(250, 300, 400, 20);
        emailAddressField.setToolTipText("Enter your e-mail");
        f.add(emailAddressField);

        /////////////////////////////
        JLabel userAgentValueLabel = new JLabel("User Agent");
        userAgentValueLabel.setBounds(30, 330, 200, 20);
        f.add(userAgentValueLabel);

        JLabel userAgentValueField = new JLabel(properties.getProperty("userAgentValue"));
        userAgentValueField.setBounds(250, 330, 200, 20);
        f.add(userAgentValueField);

        /////////////////////////////
        JLabel XMLLangLabel = new JLabel("XML Lang");
        XMLLangLabel.setBounds(30, 360, 200, 20);
        f.add(XMLLangLabel);

        JLabel XMLLangField = new JLabel(properties.getProperty("XMLLang"));
        XMLLangField.setBounds(250, 360, 100, 20);
        f.add(XMLLangField);

        /////////////////////////////
        JLabel domainTypeLabel = new JLabel("Domain Type");
        domainTypeLabel.setBounds(30, 390, 200, 20);
        f.add(domainTypeLabel);

        JLabel domainTypeField = new JLabel(properties.getProperty("domainType"));
        domainTypeField.setBounds(250, 390, 100, 20);
        domainTypeField.setToolTipText("<html>Here I have been using domain as NetworkID, incase you want to use something else like your DUNS or userID,<br>check cXML Solutions guide and use one of the supported domain.</html>");
        f.add(domainTypeField);

        /////////////////////////////
        JLabel autoPublishEnabledLabel = new JLabel("autoPublishEnabled");
        autoPublishEnabledLabel.setBounds(30, 420, 200, 20);
        f.add(autoPublishEnabledLabel);

        JLabel autoPublishEnabledField = new JLabel(properties.getProperty("autoPublishEnabled"));
        autoPublishEnabledField.setBounds(250, 420, 100, 20);
        f.add(autoPublishEnabledField);

        /////////////////////////////
        JLabel URLPostEnabledLabel = new JLabel("URLPostEnabled");
        URLPostEnabledLabel.setBounds(30, 450, 200, 20);
        f.add(URLPostEnabledLabel);

        JLabel URLPostEnabledField = new JLabel(properties.getProperty("URLPostEnabled"));
        URLPostEnabledField.setBounds(250, 450, 100, 20);
        f.add(URLPostEnabledField);


        /////////////////////////////
        JButton submit = new JButton("Save & Post");
        submit.setBounds(200, 480, 200, 30);
        Inc check = new Inc();
        InfoListener ls = new InfoListener(check, properties, f, XMLVersionField, URLField, operationTypeField, fromIdentityValueField,
                senderIdentityValueField, buyerIdentityValueField, sharedSecretValueField, catalogNameValueField, catalogDescriptionField,
                emailAddressField);
        submit.addActionListener(ls);
        f.add(submit);


        f.setSize(850, 600);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        while(check.i == 0){
            System.out.print("");
        }

        properties.store(new FileOutputStream("config.properties"), null);

//        return f;
    }

    private static class InfoListener implements ActionListener{
        Inc i;
        Properties properties;
        JFrame f;
        JTextField XMLVersionField, URLField, operationTypeField, fromIdentityValueField,
                senderIdentityValueField, buyerIdentityValueField, catalogNameValueField, catalogDescriptionField,
                emailAddressField;
        JPasswordField sharedSecretValueField;

        public InfoListener(Inc i, Properties properties, JFrame f, JTextField XMLVersionField, JTextField URLField, JTextField operationTypeField,
                            JTextField fromIdentityValueField, JTextField senderIdentityValueField, JTextField buyerIdentityValueField,
                            JPasswordField sharedSecretValueField, JTextField catalogNameValueField, JTextField catalogDescriptionField,
                            JTextField emailAddressField){
            this.i = i;
            this.properties = properties;
            this.f = f;
            this.XMLVersionField = XMLVersionField;
            this.URLField = URLField;
            this.operationTypeField = operationTypeField;
            this.fromIdentityValueField = fromIdentityValueField;
            this.senderIdentityValueField = senderIdentityValueField;
            this.buyerIdentityValueField = buyerIdentityValueField;
            this.sharedSecretValueField = sharedSecretValueField;
            this.catalogNameValueField = catalogNameValueField;
            this.catalogDescriptionField = catalogDescriptionField;
            this.emailAddressField = emailAddressField;
        }

        public void actionPerformed(ActionEvent e){
            properties.setProperty("XMLVersion", XMLVersionField.getText());
            properties.setProperty("URL", URLField.getText());
            properties.setProperty("operationType", operationTypeField.getText());
            properties.setProperty("fromIdentityValue", fromIdentityValueField.getText());
            properties.setProperty("senderIdentityValue", senderIdentityValueField.getText());
            properties.setProperty("toIdentityValue", buyerIdentityValueField.getText());
            char[] SS = sharedSecretValueField.getPassword();
            properties.setProperty("sharedSecretValue", String.valueOf(SS));
            properties.setProperty("catalogNameValue", catalogNameValueField.getText());
            properties.setProperty("catalogDescription", catalogDescriptionField.getText());
            properties.setProperty("emailAddress", emailAddressField.getText());


            f.removeAll();
            f.setVisible(false);
            f.dispose();
            i.i = 1;
        }
    }
}