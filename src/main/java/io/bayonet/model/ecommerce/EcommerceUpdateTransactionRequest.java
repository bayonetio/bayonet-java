package io.bayonet.model.ecommerce;

import io.bayonet.model.base.AuthModel;

/**
 * Created by imranarshad on 11/28/17
 */

public class EcommerceUpdateTransactionRequest {

    /** Auth info of the client */

    private AuthModel auth;


    /** ID of an order maintained by the client (previously sent by the client that needs to be updated) */

    private String order_id;


    /** ID of the transaction (previously sent by the client that needs to be updated) */

    private String transaction_id;


    /** Tracking ID returned by the Bayonet API */

    private String bayonet_tracking_id;


    /** What happened with the consumer transaction on the client - success, cancelled, suspected_fraud, bank_decline or chargeback */

    private String transaction_status;


    /** Payment decline reason received by the client from the processing bank - should be sent when transaction_status = bank_decline */

    private String bank_decline_reason;


    /** Reason why the chargeback happened */

    private String chargeback_reason;


    /** Code sent back by the processing bank to the client when a transaction is processed */

    private String bank_auth_code;


    /**
     * Getter and Setter methods
     */

    public void setApiKey(String api_key) {
        this.auth = new AuthModel(api_key);
    }

    public EcommerceUpdateTransactionRequest setTransactionStatus(String transaction_status) {
        this.transaction_status = transaction_status;
        return this;
    }

    public EcommerceUpdateTransactionRequest setTransactionId(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public EcommerceUpdateTransactionRequest setOrderId(String order_id) {
        this.order_id = order_id;
        return this;
    }

    public EcommerceUpdateTransactionRequest setBayonetTrackingId(String bayonet_tracking_id) {
        this.bayonet_tracking_id = bayonet_tracking_id;
        return this;
    }

    public EcommerceUpdateTransactionRequest setBankDeclineReason(String bank_decline_reason) {
        this.bank_decline_reason = bank_decline_reason;
        return this;
    }

    public EcommerceUpdateTransactionRequest setChargebackReason(String chargeback_reason) {
        this.chargeback_reason = chargeback_reason;
        return this;
    }

    public EcommerceUpdateTransactionRequest setBankAuthCode(String bank_auth_code) {
        this.bank_auth_code = bank_auth_code;
        return this;
    }
}
