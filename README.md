# AribaNetwork_CatalogUpdateRequest_CIF

### This is to upload the CIF catalog file to the Ariba Network supplier account. 

# Prerequisite's 
* You need have a supplier ANID on [SAP Business Network](https://service.ariba.com/Supplier.aw/) aka Ariba Network
* Have a trading relationship with the buyer
* If you don't have trading relation, you need to mention AN01000000001 as buyer ANID, and the catalog you upload will be a Public Catalog, i.e. visible to all buyers. In this case, Ariba Network has an upper limit of 3 i.e. you can only upload 3 catalogs. Once a trading relationship is created, there is no upper limit. 

# How to use? 
### Update 'config.properties' which should go in to cXML-CatalogUploadREquest

* Enter the DTD version you want to use, as of Aug 2020, Ariba Network is on version 1.2.046. AN is always backward compatible. 
Ariba provides cXML solution guidelines and recommendation to supplement the general description of cXML provided by the cXML Reference Guide available [here](http://www.cxml.org).

* Enter URL where you want to URL to be posted, as of Aug 2020 'https://service.ariba.com/ANCatalogProcessor.aw/ad/catalog' is the URL, you can check the lastest URL by posting a ProfileRequest to AN. 
* operationType can have two values (new|update)
* Enter Supplier_ANID
* Enter Sender_ANID which should be your Supplier_ANID
* Enter Buyer_ANID
* Here I have been using the domain as NetworkID, incase you want to use something else like your DUNS or userID, check the cXML Solutions guide from [here](https://github.com/harshhjain/AribaNetwork_CatalogUpdateRequest_CIF/tree/master/Related%20Documentation) and use one of the supported domain. 
* Replace ********* with your Supplier ANID's SharedSecret
* Replace 'Name' with your catalog name which you want to display in AN UI. 
* Replace 'Catalog Description' with your Catalog Description which you want to display in AN UI. 
* Based on your use case, change below two values, refer to AN guide for more information. 
* Enter your e-mail ID by replacing 'test@test.com'

### I used Intellij IDEA for this project

# Thanks for reading enjoy..!!

### How to contact me
 * E-mail: [harshh.jain@gmail.com](mailto:harshh.jain@gmail.com)
 * LinkedIn: [Harsh Vardhan Jain](https://www.linkedin.com/in/harsh-vardhan-jain-a651816a/)
