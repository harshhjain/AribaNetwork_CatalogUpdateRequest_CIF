# AribaNetwork_CatalogUpdateRequest_CIF

### This is to upload CIF catalog file to Ariba Network supplier account. 

# Prerequisite's 
* You need have a supplier ANID on Ariba Network (https://service.ariba.com/Supplier.aw/)
* Have a trading relationship with buyer
* If you don't have trading relation, you need to mention AN01000000001 as buyer ANID, and the catalog you upload will be a Public Catalog, i.e. visible to all buyers. In this case, Ariba Network has a upper limit of 3 i.e. you can only upload only 3 catalogs. Once a trading relationship is created, there is no upper limit. 

# How to use? 
### Update 'config.properties' which should go in to cXML-CatalogUploadREquest

* Enter the DTD version you want to use, as of Aug 2020, Ariba Network is on version 1.2.046. AN is always backward compatible. 
Ariba provides cXML solution guidelines and recommendation to supplement the general description of cXML provided by the cXML Reference Guide available at http://www.cxml.org .

* Enter URL where you want to URL to be posted, as of Aug 2020 'https://service.ariba.com/ANCatalogProcessor.aw/ad/catalog' is the URL, you can check the lastest URL by posting a ProfileRequest to AN. 
* operationTpe can have two values (new|update)
* Enter Supplier_ANID
* Enter Sender_ANID which should be your Supplier_ANID
* Enter Buyer_ANID
* Here I have been using domain as NetworkID, incase you want to use something else like your DUNS or userID, check cXML Solutions guide from [here](https://github.com/harshhjain/AribaNetwork_CatalogUpdateRequest_CIF/tree/master/Related%20Documentation) and use one of the supported domain. 
* Replace ********* with your Supplier ANID's SharedSecret
* Replace 'Name' with your catalog name which you want to display in AN UI. 
* Replace 'Catalog Description' with your Catalog Description which you want to display in AN UI. 
* Based on your use case, chnge below two values, refer to AN guide for more information. 
* Enter your e-mail ID by replacing 'test@test.com'

### I used Intellij IDEA for this project

# Thanks for reading enjoy..!!
