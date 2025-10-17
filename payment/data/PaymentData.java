package com.rentmate.service.payment.data;

import com.rentmate.service.payment.status.PaymentStatus;

public class PaymentData {
    private final String currency = "usd";
    private Long amount;
    private String renterId;
    private String ownerId;
    private String retnerStripeAccountID;
    private String ownerStripeAccountID;
    private PaymentStatus status;
    private Long insurance;
    private String renterPaymentID;
    private String rentalID;
    private String ownerPaymentID;
    private String errorMessage;

    public Long getTransferedToOwner(){
        return this.amount - this.insurance;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getRenterPaymentID() {
        return renterPaymentID;
    }

    public void setRenterPaymentID(String renterPaymentID) {
        this.renterPaymentID = renterPaymentID;
    }

    public String getRentalID() {
        return rentalID;
    }

    public void setRentalID(String rentalID) {
        this.rentalID = rentalID;
    }


    public String getOwnerPaymentID() {
        return ownerPaymentID;
    }

    public void setOwnerPaymentID(String paymentID) {
        this.ownerPaymentID = paymentID;
    }


    public Long getInsurance() {
        return insurance;
    }

    public void setInsurance(Long insuranceAmount) {
        this.insurance= insuranceAmount;
    }


    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public String getCurrency(){
        return currency;
    }
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getRenterId() {
        return renterId;
    }

    public void setRenterId(String renterId) {
        this.renterId = renterId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getRetnerStripeAccountID() {
        return retnerStripeAccountID;
    }

    public void setRetnerStripeAccountID(String retnerStripeAccount) {
        this.retnerStripeAccountID = retnerStripeAccount;
    }

    public String getOwnerStripeAccountID() {
        return ownerStripeAccountID;
    }

    public void setOwnerStripeAccountID(String ownerStripeAccount) {
        this.ownerStripeAccountID = ownerStripeAccount;
    }

}
