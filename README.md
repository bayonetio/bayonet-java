## Bayonet
Bayonet enables companies to feed and consult a global database about online consumers’ reputation, based on historic payments. Start making smarter business decisions today.

### Introduction
Bayonet’s API is organized around REST and exposes endpoints for HTTP requests. It is designed to have predictable, resource-oriented URLs and uses standard HTTP response codes to indicate the outcome of operations. Request and response payloads are formatted as JSON.

### About the service
Bayonet provides an Ecosystem of Trust and Protection where companies can colaborate with each other to combat online fraud together. We provide a secure platform to share and consult data to understand when a consumer is related to fraudulent activity or has a fraud-free record. Different technologies that run algorithms to link parameters seen in different transactions, fed by companies connected to the ecosystem are employed in order to build consumer profiles. By consulting Bayonet’s API, a response with data provided by companies themselves is available in real-time for your risk assesment process to analyze it and take better decisions.

### Bayonet's API details
The examples shown in this README are only for demonstration of the functionality of this SDK. For the detailed integration flow, and when to send which API call, please refer to the Bayonet [API documentation](https://bayonet.io/console/docs).

## Getting started
To use this SDK, please make sure:
  * You have Java 1.6 or superior installed on your system.
  * You have an API KEY (sandbox and/or live) generated on your Bayonet console.
  * Maven:
  
      ````xml
      <dependency>
        <groupId>io.bayonet</groupId>
        <artifactId>bayonet-java</artifactId>
        <version>2.1.0</version>
      </dependency>
      ````
   * Gradle:
      
       ````
       dependencies {
           compile 'io.bayonet:bayonet-java:2.1.0'
       }
       ````
   * Manually:

        You can also install the Bayonet SDK manually. Please downloaded the latest build from the [releases](https://github.com/bayonetio/bayonet-java/releases) page. The zip contains bayonet-java and Gson (that bayonet-java depends on). Make sure you add both JARs to your project
    
## Usage
Once you have Bayonet's SDK configured, you can call the APIs with the following syntax. Follow the guidelines specific to the product you are integrating:

* [Ecommerce](#ecommerce)

* [Lending](#lending)

### Ecommerce

* Consult API
  
    ```java
    import io.bayonet.clients.EcommerceClient;
    import io.bayonet.exceptions.BayonetException;
    import io.bayonet.model.base.Address;
    import io.bayonet.model.base.Product;
    import io.bayonet.model.ecommerce.EcommerceConsultRequest;

    import java.util.ArrayList;
    import java.util.HashMap;

    /* Initialize the Ecommerce client with your Api key and Api version */
    EcommerceClient client = new EcommerceClient("<your api key>", "<api version>");
    
    /* Build the consulting request */
    EcommerceConsultRequest params = new EcommerceConsultRequest()
            .setEmail("example@bayonet.io")
            .setConsumerName("Example name")
            .setConsumerInternalId("<your internal ID for this consumer>")
            .setCardholderName("Example name")
            .setTelephone("1234567890")
            .setCardNumber("123456")
            .setTransactionAmount(100.00)
            .setCurrencyCode("MXN")
            .setPaymentMethod("card")
            .setPaymentGateway("stripe")
            .setChannel("ecommerce")
            .setShippingAddress(
                new Address()
                    .setLine1("example line 1")
                    .setLine2("example line 2")
                    .setCity("Mexico City")
                    .setState("CDMX")
                    .setCountry("MEX")
                    .setZipCode("123")
            )
            .setBillingAddress(new Address()
                    .setLine1("example line 1")
                    .setLine2("example line 2")
                    .setCity("Mexico City")
                    .setState("CDMX")
                    .setCountry("MEX")
                    .setZipCode("123"))
            .setTransactionId("<your internal transaction ID>")
            .setBayonetFingerprintToken("<token generated by Bayonet fingerprinting JS>");
            
    // Add product information - products that the consumer is buying on your store
    ArrayList<Product> products = new ArrayList<Product>();
            products.add(
                    new Product()
                    .setProductId("1")
                    .setProductName("product_1")
                    .setProductPrice(75.00)
                    .setProductCategory("example category")
            );
            products.add(
                    new Product()
                    .setProductId("2")
                    .setProductName("product_2")
                    .setProductPrice(25.00)
                    .setProductCategory("example category")
            );
    params.setProducts(products);
    
    /* Send consulting request */
    try {
        client.consult(params);
        
        /* process the response */
        System.out.println(client.getHttpResponseCode());                   // 200
        System.out.println(client.getReasonCode());                         // 0
        System.out.println(client.getReasonMessage());                      // "success"
        
        // decision whether to accept the transaction or not
        System.out.println(client.getDecision());
        // all the rules that were triggered by this consumer
        ArrayList<String> rules_triggered = client.getRulesTriggered();
        
        HashMap<String, Object> payload = client.getResponsePayload();      // response payload as nested map
        
    } catch (BayonetException e) {
        System.out.println("error occurred");
        System.out.println("Reason code: " + e.getReasonCode());
        System.out.println("Reason message: " + e.getReasonMessage());
    }
    
    ```
* Update transaction API
  
    ```java
    import io.bayonet.clients.EcommerceClient;
    import io.bayonet.exceptions.BayonetException;
    import io.bayonet.model.ecommerce.EcommerceUpdateTransactionRequest;
    
    /* Initialize the Ecommerce client with your Api key and Api version */
    EcommerceClient client = new EcommerceClient("<your api key>", "<api version>");
    
    /* Build the transaction update request */
    EcommerceUpdateTransactionRequest params = new EcommerceUpdateTransactionRequest()
            .setTransactionId("<your internal transaction ID (as sent in the consult call)>")
            .setTransactionStatus("success")
            .setBankAuthCode("<auth code returned by the processing bank>");
    /* Send transaction update request */
    try {
        client.updateTransaction(params);
        
        /* process the response */
        System.out.println(client.getHttpResponseCode());                   // 200
        System.out.println(client.getReasonCode());                         // 0
        System.out.println(client.getReasonMessage());                      // "success"
        
    } catch (BayonetException e) {
        System.out.println("error occurred");
        System.out.println("Reason code: " + e.getReasonCode());
        System.out.println("Reason message: " + e.getReasonMessage());
    }
    
    ```
* Feedback-historical API
  
    ```java
    import io.bayonet.clients.EcommerceClient;
    import io.bayonet.exceptions.BayonetException;
    import io.bayonet.model.base.Address;
    import io.bayonet.model.base.Product;
    import io.bayonet.model.ecommerce.EcommerceFeedbackHistoricalRequest;

    import java.util.ArrayList;

    /* Initialize the Ecommerce client with your Api key and Api version */
    EcommerceClient client = new EcommerceClient("<your api key>", "<api version>");
    
    /* Build the feedback historical request */
    EcommerceFeedbackHistoricalRequest params = new EcommerceFeedbackHistoricalRequest()
            .setEmail("example@bayonet.io")
            .setConsumerName("Example name")
            .setConsumerInternalId("<your internal ID for this consumer>")
            .setCardholderName("Example name")
            .setTelephone("1234567890")
            .setCardNumber("123456")
            .setTransactionAmount(100.00)
            .setCurrencyCode("MXN")
            .setPaymentMethod("card")
            .setTransactionTime(1506468823L)
            .setPaymentGateway("stripe")
            .setChannel("ecommerce")
            .setShippingAddress(
                new Address()
                    .setLine1("example line 1")
                    .setLine2("example line 2")
                    .setCity("Mexico City")
                    .setState("CDMX")
                    .setCountry("MEX")
                    .setZipCode("123")
            )
            .setBillingAddress(new Address()
                    .setLine1("example line 1")
                    .setLine2("example line 2")
                    .setCity("Mexico City")
                    .setState("CDMX")
                    .setCountry("MEX")
                    .setZipCode("123"))
            .setBayonetFingerprintToken("<token generated by Bayonet fingerprinting JS>")
            .setTransactionId("<your internal transaction ID>")
            .setTransactionStatus("success")
            .setBankAuthCode("<auth code returned by the processing bank>");
            
    // Add product information - products that the consumer is buying on your store
    ArrayList<Product> products = new ArrayList<Product>();
            products.add(
                    new Product()
                    .setProductId("1")
                    .setProductName("product_1")
                    .setProductPrice(75.00)
                    .setProductCategory("example category")
            );
            products.add(
                    new Product()
                    .setProductId("2")
                    .setProductName("product_2")
                    .setProductPrice(25.00)
                    .setProductCategory("example category")
            );
    params.setProducts(products);
    
    /* Send feedback historical request */
    try {
        client.feedbackHistorical(params);
        
        /* process the response */
        System.out.println(client.getHttpResponseCode());                   // 200
        System.out.println(client.getReasonCode());                         // 0
        System.out.println(client.getReasonMessage());                      // "success"
        
    } catch (BayonetException e) {
        System.out.println("error occurred");
        System.out.println("Reason code: " + e.getReasonCode());
        System.out.println("Reason message: " + e.getReasonMessage());
    }
    
    ```
    
### Lending
* Report Transaction (Request for loan received)
   ```java
   import io.bayonet.clients.LendingClient;
   import io.bayonet.exceptions.BayonetException;
   import io.bayonet.model.base.Address;
   import io.bayonet.model.lending.LendingReportTransactionRequest;

   /* Initialize the Lending client with your Api key and Api version */
   LendingClient client = new LendingClient("<your api key>", "<api version>");

   /* Build the report transaction request */
   LendingReportTransactionRequest params = new LendingReportTransactionRequest()
       .setEmail("example@bayonet.io")
       .setConsumerName("Example name")
       .setConsumerInternalId("<your internal ID for this consumer>")
       .setTelephoneFixed("1234567890")
       .setTelephoneMobile("1234567891")
       .setTelephoneReference1("1234567892")
       .setTelephoneReference2("1234567893")
       .setTelephoneReference3("1234567894")
       .setRfc("Example RFC")
       .setCurp("Example CURP")
       .setAddress(
           new Address()
               .setLine1("example line 1")
               .setLine2("example line 2")
               .setCity("Mexico City")
               .setState("CDMX")
               .setCountry("MEX")
               .setZipCode("123")
       )
       .setBayonetFingerprintToken("<token generated by Bayonet fingerprinting JS>")
       .setTransactionCategory("crowdfunding")
       .setTransactionId("<your internal ID for this transaction>")
       .setTransactionTime(1506468823L);

   /* Send the report transaction request */
   try {
       client.reportTransaction(params);

       /* process the response */
       System.out.println(client.getHttpResponseCode());                   // 200
       System.out.println(client.getReasonCode());                         // 0
       System.out.println(client.getReasonMessage());                      // "success"

   } catch (BayonetException e) {
       System.out.println("error occurred");
       System.out.println("Reason code: " + e.getReasonCode());
       System.out.println("Reason message: " + e.getReasonMessage());
   }
   ```
* Report Transaction (Request for loan received) + Consult

   This lets you report a transaction (solicitud) and consult Bayonet at the same time. The only difference from the above method (Report Transaction) is that this method will also return a consult response
   
   ```java
   import io.bayonet.clients.LendingClient;
   import io.bayonet.exceptions.BayonetException;
   import io.bayonet.model.base.Address;
   import io.bayonet.model.lending.LendingReportTransactionRequest;
   
   import java.util.HashMap;

   /* Initialize the Lending client with your Api key and Api version */
   LendingClient client = new LendingClient("<your api key>", "<api version>");

   /* Build the report transaction request */
   LendingReportTransactionRequest params = new LendingReportTransactionRequest()
       .setEmail("example@bayonet.io")
       .setConsumerName("Example name")
       .setConsumerInternalId("<your internal ID for this consumer>")
       .setTelephoneFixed("1234567890")
       .setTelephoneMobile("1234567891")
       .setTelephoneReference1("1234567892")
       .setTelephoneReference2("1234567893")
       .setTelephoneReference3("1234567894")
       .setRfc("Example RFC")
       .setCurp("Example CURP")
       .setAddress(
           new Address()
               .setLine1("example line 1")
               .setLine2("example line 2")
               .setCity("Mexico City")
               .setState("CDMX")
               .setCountry("MEX")
               .setZipCode("123")
       )
       .setBayonetFingerprintToken("<token generated by Bayonet fingerprinting JS>")
       .setTransactionCategory("crowdfunding")
       .setTransactionId("<your internal ID for this transaction>")
       .setTransactionTime(1506468823L);

   /* Send the report transaction request */
   try {
       client.reportTransaction(params);

       /* process the response */
       System.out.println(client.getHttpResponseCode());                   // 200
       System.out.println(client.getReasonCode());                         // 0
       System.out.println(client.getReasonMessage());                      // "success"
       
       // get response payload - nested Map
       HashMap<String, Object> responsePayload = client.getResponsePayload();

   } catch (BayonetException e) {
       System.out.println("error occurred");
       System.out.println("Reason code: " + e.getReasonCode());
       System.out.println("Reason message: " + e.getReasonMessage());
   }
   ```
* Consult (consult the persona present in the transaction)
   ```java
   import io.bayonet.clients.LendingClient;
   import io.bayonet.exceptions.BayonetException;
   import io.bayonet.model.lending.LendingConsultRequest;

   import java.util.HashMap;

   /* Initialize the Lending client with your Api key and Api version */
   LendingClient client = new LendingClient("<your api key>", "<api version>");

   /* Build the consult request */
   LendingConsultRequest params = new LendingConsultRequest()
       .setTransactionId("<transaction ID that you used when reporting the transaction or solicitud>");

   /* Send the consult request */
   try {
       client.consult(params);

       /* process the response */
       System.out.println(client.getHttpResponseCode());                   // 200
       System.out.println(client.getReasonCode());                         // 0
       System.out.println(client.getReasonMessage());                      // "success"

       // get response payload - nested Map
       HashMap<String, Object> responsePayload = client.getResponsePayload();

   } catch (BayonetException e) {
       System.out.println("error occurred");
       System.out.println("Reason code: " + e.getReasonCode());
       System.out.println("Reason message: " + e.getReasonMessage());
   }
   ```
* Feedback (send feedback regarding a transaction - raise alert or block the user)
   ```java
   import io.bayonet.clients.LendingClient;
   import io.bayonet.exceptions.BayonetException;
   import io.bayonet.model.base.Actions;
   import io.bayonet.model.lending.LendingFeedbackRequest;

   /* Initialize the Lending client with your Api key and Api version */
   LendingClient client = new LendingClient("<your api key>", "<api version>");

   /* Build the feedback request */
   LendingFeedbackRequest params = new LendingFeedbackRequest()
       .setTransactionId("<transaction ID that you used when reporting the transaction or solicitud>")
           .setActions(new Actions().setAlert(true).setBlock(true));

   /* Send the feedback request */
   try {
       client.feedback(params);

       /* process the response */
       System.out.println(client.getHttpResponseCode());                   // 200
       System.out.println(client.getReasonCode());                         // 0
       System.out.println(client.getReasonMessage());                      // "success"

   } catch (BayonetException e) {
       System.out.println("error occurred");
       System.out.println("Reason code: " + e.getReasonCode());
       System.out.println("Reason message: " + e.getReasonMessage());
   }
   ```
   
* Feedback historical (for reporting historical transactions that were not sent to Bayonet)
   ```java
   import io.bayonet.clients.LendingClient;
   import io.bayonet.exceptions.BayonetException;
   import io.bayonet.model.base.Actions;
   import io.bayonet.model.base.Address;
   import io.bayonet.model.lending.LendingFeedbackHistoricalRequest;

   /* Initialize the Lending client with your Api key and Api version */
   LendingClient client = new LendingClient("<your api key>", "<api version>");

   /* Build the feedback historical request */
   LendingFeedbackHistoricalRequest params = new LendingFeedbackHistoricalRequest()
       .setEmail("example@bayonet.io")
       .setConsumerName("Example name")
       .setConsumerInternalId("<your internal ID for this consumer>")
       .setTelephoneFixed("1234567890")
       .setTelephoneMobile("1234567891")
       .setTelephoneReference1("1234567892")
       .setTelephoneReference2("1234567893")
       .setTelephoneReference3("1234567894")
       .setRfc("Example RFC")
       .setCurp("Example CURP")
       .setAddress(
               new Address()
                       .setLine1("example line 1")
                       .setLine2("example line 2")
                       .setCity("Mexico City")
                       .setState("CDMX")
                       .setCountry("MEX")
                       .setZipCode("123")
       )
       .setTransactionCategory("crowdfunding")
       .setTransactionId("<your internal ID for this transaction>")
       .setTransactionTime(1506468823L)
       .setActions(new Actions().setAlert(true).setBlock(true));

   /* Send the feedback historical request */
   try {
       client.feedbackHistorical(params);

       /* process the response */
       System.out.println(client.getHttpResponseCode());                   // 200
       System.out.println(client.getReasonCode());                         // 0
       System.out.println(client.getReasonMessage());                      // "success"

   } catch (BayonetException e) {
       System.out.println("error occurred");
       System.out.println("Reason code: " + e.getReasonCode());
       System.out.println("Reason message: " + e.getReasonMessage());
   }
   ```
   
### Device Fingerprint
* Get-fingerprint-data API

   You can use this endpoint to get detailed information about a fingerprint generated by the Bayonet fingerprinting JS installed on your front-end
  
    ```java
    import io.bayonet.clients.DeviceFingerprintClient;
    import io.bayonet.exceptions.BayonetException;
    import io.bayonet.model.device_fingerprint.DeviceFingerprintRequest;

    import java.util.HashMap;

    /* Initialize the Device Fingerprint client with your Api key and Api version */
    DeviceFingerprintClient client = new DeviceFingerprintClient("<your api key>", "<api version>");

    /* Build the fingerprint request */
    DeviceFingerprintRequest params = new DeviceFingerprintRequest()
            .setBayonetFingerprintToken("<fingerprint-token-generated-by-JS-snippet>");

    /* Send the fingerprint request */
    try {
        client.queryFingerprintData(params);

        /* process the response */
        System.out.println(client.getHttpResponseCode());                   // 200
        System.out.println(client.getReasonCode());                         // 0
        System.out.println(client.getReasonMessage());                      // "success"

        // get fingerprint information
        String bayonet_fingerprint = client.getBayonetFingerprint();
        HashMap<String, Object> device_information = client.getDeviceInfo();

    } catch (BayonetException e) {
        System.out.println("error occurred");
        System.out.println("Reason code: " + e.getReasonCode());
        System.out.println("Reason message: " + e.getReasonMessage());
    }
    ``` 
    
    ### Error Handling
    Bayonet's SDK raises exceptions whenever calling an event. Make sure you use a `try-catch` block to avoid uncaught exceptions in production:

    ```java
    try {
        client.EVENT(params);
        // process the successful response
    } catch (BayonetException e) {
        // do something with the exception
        System.out.println("error occurred");
        System.out.println("Reason code: " + e.getReasonCode());
        System.out.println("Reason message: " + e.getReasonMessage());
    }
    ```
