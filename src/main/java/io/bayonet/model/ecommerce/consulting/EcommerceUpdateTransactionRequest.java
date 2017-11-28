package io.bayonet.model.ecommerce.consulting;

import io.bayonet.model.base.AuthModel;

/**
 * Created by imranarshad on 11/28/17
 */

public class EcommerceUpdateTransactionRequest {

    /** Auth info of the client */

    private AuthModel auth;


    /** ID of the transaction (previously sent by the client that needs to be udpated */

    private String transaction_id;


    /** What happened with the consumer transaction on the client - success, cancelled, suspected_fraud, bank_decline or chargeback */

    private String transaction_status;


    /** Payment decline reason received by the client from the processing bank - should be sent when transaction_status = bank_decline */

    private String bank_decline_reason;


    /** Reason why the chargeback happened */

    private String chargeback_reason;


    /** Timestamp when the transaction status changed */

    private Long status_change_time;


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

    public EcommerceUpdateTransactionRequest setBankDeclineReason(String bank_decline_reason) {
        this.bank_decline_reason = bank_decline_reason;
        return this;
    }

    public EcommerceUpdateTransactionRequest setChargebackReason(String chargeback_reason) {
        this.chargeback_reason = chargeback_reason;
        return this;
    }

    public EcommerceUpdateTransactionRequest setStatusChangeTime(Long status_change_time) {
        this.status_change_time = status_change_time;
        return this;
    }
}
