package DTO;

import java.math.BigDecimal;

public class HoaDonDTO {
    private String invoiceID;
    private String staffID;
    private String customerID;
    private long invoiceTotal;
    private String invoicedDateTime;

    public HoaDonDTO() {
        invoiceID = "";
        staffID = "";
        invoiceTotal = 0;
        invoicedDateTime = "";
    }

    public HoaDonDTO(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public HoaDonDTO(String invoiceID, String staffID) {
        this.invoiceID = invoiceID;
        this.staffID = staffID;
    }

    public HoaDonDTO(String invoiceID, String staffID, String customerID) {
        this.invoiceID = invoiceID;
        this.staffID = staffID;
        this.customerID = customerID;
    }

    public HoaDonDTO(String staffID, long invoiceTotal) {
        this.staffID = staffID;
        this.invoiceTotal = invoiceTotal;
    }
    
    public HoaDonDTO(String invoiceID, String staffID, String customerID, long invoiceTotal, String invoicedDateTime) {
        this.invoiceID = invoiceID;
        this.staffID = staffID;
        this.customerID = customerID;
        this.invoiceTotal = invoiceTotal;
        this.invoicedDateTime = invoicedDateTime;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public long getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(long invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }

    public String getInvoicedDateTime() {
        return invoicedDateTime;
    }

    public void setInvoicedDateTime(String invoicedDateTime) {
        this.invoicedDateTime = invoicedDateTime;
    }

    @Override
    public String toString() {
        return "HoaDonDTO{" + "invoiceID=" + invoiceID + ", staffID=" + staffID + ", customerID=" + customerID + ", invoiceTotal=" + invoiceTotal + ", invoicedDateTime=" + invoicedDateTime + '}';
    }
}
