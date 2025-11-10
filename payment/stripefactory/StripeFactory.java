package com.rentmate.service.payment.stripefactory;

import com.rentmate.service.payment.user.User;
import com.stripe.exception.StripeException;
import com.stripe.model.Account;
import com.stripe.model.AccountLink;
import com.stripe.model.Customer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StripeFactory {

    public Account createAccount(User user){
        Map<String, Object> capabilities = new HashMap<>();
        capabilities.put("transfers", Map.of("requested", true));
        Map<String, Object> params= new HashMap<>();
        params.put("type", "express");
        params.put("email", user.getEmail());
        params.put("business_type", "individual");
        params.put("individual", Map.of("first_name", user.getName()));
        params.put("country", "US");
        params.put("capabilities", capabilities);
        Account account;
        try{
            account = Account.create(params);
        }catch (StripeException e){
            user.setErrorMessage(e.getMessage());
            return null;
        }
        user.setStripeAccountId(account.getId());
        return account;
    }

    public AccountLink createAccountLink(Account account){
        Map<String, Object> accountLinkParams = new HashMap<>();
        accountLinkParams.put("account", account.getId());
        accountLinkParams.put("type", "account_onboarding");
        accountLinkParams.put("refresh_url", "http://localhost:8080/onboarding");
        accountLinkParams.put("return_url", "http://localhost:8080/success");
        AccountLink accountLink;
        try {
            accountLink = AccountLink.create(accountLinkParams);
        }catch(StripeException e){
            return null;
        }
        return accountLink;
    }

    public Customer createCustomer(User user){
        Map<String, Object> params = new HashMap<>();
        params.put("name", user.getName());
        params.put("email", user.getEmail());
        Customer customer;
        try {
            customer = Customer.create(params);
        }catch (StripeException e){
            user.setErrorMessage(e.getMessage());
            return null;
        }
        user.setStripeCustomerId(customer.getId());
        return customer;
    }
}
