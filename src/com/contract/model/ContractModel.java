package com.contract.model;

/**
 *
 * @author Snehal Subedi
 */
public class ContractModel {
    private int contractId;
    private String title;
    private String type;
    private double term;
    private String status;

    
    // New fields
    private String startDate;
    private String draftedBy;
    private String contactNo;
    
    public ContractModel() {
    }

    // Constructor
       public ContractModel(int contractId, String title, String type, double term, String status, String startDate, String draftedBy, String contactNo) {
        this.contractId = contractId;
        this.title = title;
        this.type = type;
        this.term = term;
        this.status = status;
        this.startDate = startDate;
        this.draftedBy = draftedBy;
        this.contactNo = contactNo;
    }

    // Getters and Setters
    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) { 
        this.type = type;
    }

    public double getTerm() {
        return term;
    }

    public void setTerm(double term) {
        this.term = term;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // New Getters and Setters
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDraftedBy() {
        return draftedBy;
    }

    public void setDraftedBy(String draftedBy) {
        this.draftedBy = draftedBy;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

}