package com.number26.restAPI.challenge;


public class Transaction {
    protected double amount;
    protected String type;
    protected long parent_id;
    
    public Transaction() {
    	
    }
    
    public Transaction(double amount, String type, long parent_id) {
    	this.amount = amount;
    	this.type = type;
    	this.parent_id = parent_id;
    }
    
    public Transaction(double amount, String type) {
    	this(amount,type,0);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getParent_id() {
        return parent_id;
    }

    public void setParent_id(long parent_id) {
        this.parent_id = parent_id;
    }


    @Override
    public String toString() {
        return "Transaction [amount=" + amount + ", type=" + type + ", parent_id=" + parent_id + "]";
    }
}