package io.bayonet.model.ecommerce.consulting;

import io.bayonet.model.base.AuthModel;

/**
 * Created by imranarshad on 11/28/17
 */

public class EcommerceFeedbackRequest {

    /** Auth info of the client */

    private AuthModel auth;


    /** Trans code given to the client in the previous consulting request - this trans code links the feedback api call to the previous consulting api call */

    private String feedback_api_trans_code;


    /** What happened with the consumer transaction on the client - success, suspected_fraud or bank_decline */

    private String transaction_status;


    /** Code sent back by the processing bank to the client when a transaction is processed */

    private String bank_auth_code;


    /** Internal id of a transaction maintained by the client (and not by Bayonet or the processing bank in question) */

    private String transaction_id;


    /** Payment decline reason received by the client from the processing bank - should be sent when transaction_status = bank_decline */

    private String bank_decline_reason;


    /**
     * Getter and Setter methods
     */

    public void setApiKey(String api_key) {
        this.auth = new AuthModel(api_key);
    }

    public EcommerceFeedbackRequest setFeedbackApiTransCode(String feedback_api_trans_code) {
        this.feedback_api_trans_code = feedback_api_trans_code;
        return this;
    }

    public EcommerceFeedbackRequest setTransactionStatus(String transaction_status) {
        this.transaction_status = transaction_status;
        return this;
    }

    public EcommerceFeedbackRequest setBankAuthCode(String bank_auth_code) {
        this.bank_auth_code = bank_auth_code;
        return this;
    }

    public EcommerceFeedbackRequest setTransactionId(String transaction_id) {
        this.transaction_id = transaction_id;
        return this;
    }

    public EcommerceFeedbackRequest setBankDeclineReason(String bank_decline_reason) {
        this.bank_decline_reason = bank_decline_reason;
        return this;
    }
}
