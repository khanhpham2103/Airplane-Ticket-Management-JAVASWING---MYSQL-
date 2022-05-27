
package DTO;


public class invoiceDetailDTO {
    private String invoiceID;
    private String typeID;
    private int amount;
    private float total;

    public invoiceDetailDTO(String invoiceID, String typeID, int amount, float total) {
        this.invoiceID = invoiceID;
        this.typeID = typeID;
        this.amount = amount;
        this.total = total;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    
}
