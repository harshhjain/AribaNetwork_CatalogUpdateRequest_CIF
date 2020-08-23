package com.cataloguploadrequestv2;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

//import javax.xml.bind.JAXBException;

public class Main {

    public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException {
//JAXBException,
        cXMLBuilder cb = new cXMLBuilder();
        cb.createcXML();

        Post p = new Post();
        p.HttpPost();

    }

}

/*
https://service.ariba.com/ANCatalogProcessor.aw/ad/catalog

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE cXML SYSTEM "http://xml.cXML.org/schemas/cXML/1.2.014/cXML.dtd">
<cXML payloadID="456778-199@acme.com" xml:lang="en-US" timestamp="2001-03-12T18:39:09-08:00">
<Header>
<From>
<Credential domain="NetworkID">
<Identity>AN01000343488</Identity>
</Credential>
</From>
<To>
<Credential domain="NetworkID">
<Identity>AN01000000001</Identity>
</Credential>
</To>
<Sender>
<Credential domain="NetworkID">
<Identity>AN01000343488</Identity>
<SharedSecret>Ariba@12345@</SharedSecret>
</Credential>
<UserAgent>Our Download Application, v1.0</UserAgent>
</Sender>
</Header>
<Request>
<ProfileRequest></ProfileRequest>
</Request>
</cXML>
==================================================
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE cXML SYSTEM "http://xml.cxml.org/schemas/cXML/1.2.014/cXML.dtd">
<cXML timestamp="2020-08-17T07:18:08-07:00" payloadID="1597673888865-6597094747028721161@10.162.97.212">
	<Response>
		<Status code="200" text="OK"></Status>
		<ProfileResponse effectiveDate="2000-06-22T00:00:00-07:00">
			<Transaction requestName="ProviderSetupRequest">
				<URL>https://service.ariba.com/ANCXMLPunchOutProcessor.aw/ad/cxml</URL>
			</Transaction>
			<Transaction requestName="RequisitionMessage">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="SalesOrderRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="AuthRequest">
				<URL>https://service.ariba.com/ANCXMLAuthenticationProcessor.aw/ad/cxml</URL>
			</Transaction>
			<Transaction requestName="ContractStatusUpdateRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="QuoteMessage">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="ApprovalRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="DataRequest">
				<URL>https://service.ariba.com/VendData.aw</URL>
			</Transaction>
			<Transaction requestName="ServiceEntryRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="L3ChargeFileRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="PaymentReceiptConfirmationRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="NotificationRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="SubscriptionStatusUpdateRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="OrderStatusDataRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="InvoiceDetailRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="PaymentProposalRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="TransportConfirmation">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="CollaborationRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="CatalogUploadRequest">
				<URL>https://service.ariba.com/ANCatalogProcessor.aw/ad/catalog</URL>
			</Transaction>
			<Transaction requestName="PriceAvailabilityRequest">
				<URL>https://service.ariba.com/ANCXMLPunchOutProcessor.aw/ad/cxml</URL>
			</Transaction>
			<Transaction requestName="CatalogChangeRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="OrganizationChangeMessage">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="ReceiptRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="PunchOutSetupRequest">
				<URL>https://service.ariba.com/ANCXMLPunchOutProcessor.aw/ad/cxml</URL>
			</Transaction>
			<Transaction requestName="PaymentBatchRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="BlanketOrderStatusUpdateRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="TimeCardInfoRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="CopyRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="TradeRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="OrderRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="GetPendingRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="SupplierDataRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="QualityInspectionResultRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="ChargeFileRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="SupplierListRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="MasterAgreementRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="SubscriptionListRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="PurchaseRequisitionRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="FullfillmentUpdateRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="SubscriptionChangeMessage">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="PaymentRemittanceRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="ProviderDataRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="QualityInspectionDecisionRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="ProductActivityMessage">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="OrganizationDataRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="QualityNotificationRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="SubscriptionContentRequest">
				<URL>https://service.ariba.com/ANCatalogProcessor.aw/ad/catalog</URL>
			</Transaction>
			<Transaction requestName="RelationshipRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="RFxPublishRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="ComponentConsumptionRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="OrderStatusSetupRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="QuoteRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="TransportRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="PrivateOrganizationRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="PaymentRemittanceStatusUpdateRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="ContractRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="QualityInspectionRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="MapSyncRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="ProfileRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="RFxEventRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="StatusUpdateRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="ProductReplenishmentMessage">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="OrderStatusRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="ConfirmationRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="ShipNoticeRequest">
				<URL>https://service.ariba.com/service/transaction/cxml.asp</URL>
			</Transaction>
			<Transaction requestName="SupplierLogin">
				<URL>https://service.ariba.com/Supplier.aw</URL>
			</Transaction>
			<Transaction requestName="RFXDetail">
				<URL>https://service.ariba.com/Discovery.aw/ad/busOpp</URL>
			</Transaction>
			<Transaction requestName="DataSyncChangeListRequest">
				<URL>https://service.ariba.com/USEDataSyncProcessor.aw/ad/cxml</URL>
			</Transaction>
			<Transaction requestName="DataSyncDataRequest">
				<URL>https://service.ariba.com/USEDataSyncProcessor.aw/ad/cxml</URL>
			</Transaction>
			<Transaction requestName="S4DataPushRequest">
				<URL>https://service.ariba.com/USEDataSyncProcessor.aw/ad/cxml</URL>
			</Transaction>
			<Transaction requestName="CopyInvoiceGenerateIR">
				<URL>https://service.ariba.com/ANSapGateway.aw/ad/cxml/copyInvoiceGenerateIR</URL>
			</Transaction>
		</ProfileResponse>
	</Response>
</cXML>
*/


