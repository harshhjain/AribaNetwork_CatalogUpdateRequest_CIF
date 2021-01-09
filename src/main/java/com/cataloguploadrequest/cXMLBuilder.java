package com.cataloguploadrequest;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Properties;

public class cXMLBuilder {

    public void createcXML() throws ParserConfigurationException, TransformerConfigurationException, TransformerException, FileNotFoundException, IOException {

        Properties properties = new Properties();
        FileInputStream input = new FileInputStream("config.properties");
        properties.load(input);

        String XMLVersion = properties.getProperty("XMLVersion");
        String XMLLang = properties.getProperty("XMLLang");
        String operationType = properties.getProperty("operationType");
        String fromIdentityValue = properties.getProperty("fromIdentityValue");
        String toIdentityValue = properties.getProperty("toIdentityValue");
        String domainType = properties.getProperty("domainType");
        String sharedSecretValue = properties.getProperty("sharedSecretValue");
        String senderIdentityValue = properties.getProperty("senderIdentityValue");
        String catalogNameValue = properties.getProperty("catalogNameValue");
        String catalogDescription = properties.getProperty("catalogDescription");
        String attachmentURLValue = properties.getProperty("attachmentURLValue");
        String autoPublishEnabled = properties.getProperty("autoPublishEnabled");
        String URLPostEnabled = properties.getProperty("URLPostEnabled");
        String emailAddress = properties.getProperty("emailAddress");
        String userAgentValue = properties.getProperty("userAgentValue");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();
        doc.setXmlStandalone(true);

        DOMImplementation domImpl = doc.getImplementation();
        DocumentType docType = domImpl.createDocumentType("doctype", "", "http://xml.cXML.org/schemas/cXML/" +  XMLVersion + "/cXML.dtd");

        // cXML root element
        Element rootElement = doc.createElement("cXML");
        rootElement.setAttribute("payloadID", createPayload());
        rootElement.setAttribute("timestamp", createTimeStamp());
        //rootElement.setAttribute("version", XMLVersion);
        rootElement.setAttribute("version", XMLVersion);
        rootElement.setAttribute("xml:lang", XMLLang);
        doc.appendChild(rootElement);

        // Header
        Element header = doc.createElement("Header");
        rootElement.appendChild(header);

        // From Identity
        Element from = doc.createElement("From");
        header.appendChild(from);
        Element fromIdentity = doc.createElement("Identity");
        fromIdentity.appendChild(doc.createTextNode(fromIdentityValue));

        Element fromCredential = doc.createElement("Credential");
        fromCredential.setAttribute("domain", domainType);

        fromCredential.appendChild(fromIdentity);
        from.appendChild(fromCredential);

        // To Identity
        Element To = doc.createElement("To");
        header.appendChild(To);
        Element toIdentity = doc.createElement("Identity");
        toIdentity.appendChild(doc.createTextNode(toIdentityValue));

        Element toCredential = doc.createElement("Credential");
        toCredential.setAttribute("domain", domainType);

        toCredential.appendChild(toIdentity);
        To.appendChild(toCredential);

        // Sender
        Element sender = doc.createElement("Sender");
        header.appendChild(sender);
        Element senderCredential = doc.createElement("Credential");
        senderCredential.setAttribute("domain", domainType);

        Element senderIdentity = doc.createElement("Identity");
        senderIdentity.appendChild(doc.createTextNode(senderIdentityValue));

        senderCredential.appendChild(senderIdentity);

        sender.appendChild(senderCredential);

        Element sharedSecret = doc.createElement("SharedSecret");
        sharedSecret.appendChild(doc.createTextNode(sharedSecretValue));

        senderCredential.appendChild(sharedSecret);

        // User Agent
        Element userAgent = doc.createElement("UserAgent");

        sender.appendChild(userAgent);
        userAgent.appendChild(doc.createTextNode(userAgentValue));

        // Request Element
        Element request = doc.createElement("Request");
        rootElement.appendChild(request);

        // CatalogUploadRequest
        Element catalogUploadRequest = doc.createElement("CatalogUploadRequest");
        catalogUploadRequest.setAttribute("operation", operationType);

        request.appendChild(catalogUploadRequest);

        // Catalog Name
        Element catalogName = doc.createElement("CatalogName");
        catalogName.setAttribute("xml:lang", XMLLang);
        catalogName.appendChild(doc.createTextNode(catalogNameValue));

        catalogUploadRequest.appendChild(catalogName);

        // Description
        Element description = doc.createElement("Description");
        description.setAttribute("xml:lang", XMLLang);
        description.appendChild(doc.createTextNode(catalogDescription));

        catalogUploadRequest.appendChild(description);

        // Attachment
        Element attachment = doc.createElement("Attachment");

        catalogUploadRequest.appendChild(attachment);

        // Attachment URL
        Element attachmentURL = doc.createElement("URL");
        attachmentURL.appendChild(doc.createTextNode("cid:" + attachmentURLValue));

        attachment.appendChild(attachmentURL);

        // Auto Publish
        Element autoPublish = doc.createElement("AutoPublish");
        autoPublish.setAttribute("enabled", autoPublishEnabled);
        catalogUploadRequest.appendChild(autoPublish);

        // Notification
        Element notification = doc.createElement("Notification");
        catalogUploadRequest.appendChild(notification);

        // Email
        Element email = doc.createElement("Email");
        email.appendChild(doc.createTextNode(emailAddress));
        notification.appendChild(email);

        // Notification URL Post
        Element urlPost = doc.createElement("URLPost");
        urlPost.setAttribute("enabled", URLPostEnabled);

        notification.appendChild(urlPost);

        // Output
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult consoleResult = new StreamResult(System.out);
        DOMSource source = new DOMSource(doc);
        transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, docType.getSystemId());
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        Result output = new StreamResult(new File("files/CatalogUploadRequest.xml"));
        transformer.transform(source, output);

    }

    public String createPayload() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return String.valueOf(timestamp.getTime())+"ViaHVJPosterTool";
    }

    public String createTimeStamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.toString();
    }

}
