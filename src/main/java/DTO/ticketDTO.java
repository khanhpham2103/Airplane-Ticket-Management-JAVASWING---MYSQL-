
package DTO;

public class ticketDTO {
    private String ticketID;
    private String customerID;
    private String flightID;
    private String typeID;
    private String invoiceID;

    public ticketDTO(String ticketID, String customerID, String flightID, String typeID, String invoiceID) {
        this.ticketID = ticketID;
        this.customerID = customerID;
        this.flightID = flightID;
        this.typeID = typeID;
        this.invoiceID = invoiceID;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(String invoiceID) {
        this.invoiceID = invoiceID;
    }
    
    
    
}
