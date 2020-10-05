package com.usc;

public class PostOffice {
    private String recipientName;
    private String recipientId;
    private String recipientAddress;
    private String recipientCode;
    private String senderName;
    private String senderId;

    public PostOffice() {
        System.out.println("object is created.");
    }

    public PostOffice(String name1, String id1, String address, String code, String name2, String id2) {
        setRecipientName(name1);
        setRecipientId(id1);
        setRecipientAddress(address);
        setRecipientCode(code);
        setSenderName(name2);
        setSenderId(id2);
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String getRecipientCode() {
        return recipientCode;
    }

    public void setRecipientCode(String recipientCode) {
        this.recipientCode = recipientCode;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public void showInformation() {
        System.out.println("Recipient information:");
        System.out.println("name is: " + getRecipientName());
        System.out.println("id number is: " + getRecipientId());
        System.out.println("address is: " + getRecipientAddress());
        System.out.println("postal code is: " + getRecipientCode());
        System.out.println("Sender information:");
        System.out.println("name is: " + getSenderName());
        System.out.println("id number is: " + getSenderId());
    }
}
