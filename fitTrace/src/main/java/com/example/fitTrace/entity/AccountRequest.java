package com.example.fitTrace.entity;

public class AccountRequest {

    private Long userId; // ID of the user associated with the account
    private String accountType; // Type of the account (e.g., Checking, Savings)
    private Double initialBalance; // Initial balance for the account

    // Default constructor
    public AccountRequest() {
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(Double initialBalance) {
        this.initialBalance = initialBalance;
    }
}
