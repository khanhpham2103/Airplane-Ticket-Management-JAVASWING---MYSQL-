package DAO;

import DTO.ticketDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ticketDAO {

//    private MySQLCOnnect dbc = new MySQLCOnnect();

    public ticketDAO() {
    }

    public ArrayList docdsTicket() {
        MySQLConnect ms = new MySQLConnect();
        ArrayList dsTicket = new ArrayList<ticketDTO>();
        try {
            String sql = "select * from ticket";
            ResultSet rs = ms.executeQuery(sql);
            while (rs.next()) {
                String ticketID = rs.getString("ticketID");
                String customerID = rs.getString("customerID");
                String flightID = rs.getString("flightID");
                String typeID = rs.getString("typeID");
                String invoiceID = rs.getString("invoiceID");

                ticketDTO t = new ticketDTO(ticketID, customerID, flightID, typeID, invoiceID);
                dsTicket.add(t);
            }
            ms.disConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsTicket;
    }

    public void add(ticketDTO tkDTO) {
        MySQLConnect ms = new MySQLConnect();
        String sql = " INSERT INTO ticket VALUES (";
        sql += "'" + tkDTO.getTicketID() + "',";
        sql += "'" + tkDTO.getCustomerID() + "',";
        sql += "'" + tkDTO.getFlightID() + "',";
        sql += "'" + tkDTO.getTypeID() + "',";
        sql += "'" + tkDTO.getInvoiceID() + "')";
        System.out.println(sql + "\n");
        ms.executeUpdate(sql);
    }

    public void set(ticketDTO tk) {
        MySQLConnect ms = new MySQLConnect();
        String sql = " UPDATE ticket SET ";
        sql += "ticketID ='" + tk.getTicketID() + "', ";
        sql += "customerID ='" + tk.getCustomerID() + "', ";
        sql += "flightID ='" + tk.getFlightID() + "', ";
        sql += "typeID ='" + tk.getTypeID() + "', ";
        sql += "invoiceID ='" + tk.getInvoiceID() + "' ";
        sql += "WHERE ticketID ='" + tk.getTicketID() + "'";
        System.out.println(sql);
        ms.executeUpdate(sql);
    }

    public void delete(String ID) {
        MySQLConnect ms = new MySQLConnect();
        String sql = "DELETE FROM ticket WHERE ticketID = '" + ID + "'";
        System.out.println(sql);
        ms.executeUpdate(sql);
    }
}
