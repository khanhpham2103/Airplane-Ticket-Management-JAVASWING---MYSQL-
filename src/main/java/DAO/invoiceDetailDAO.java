package DAO;

import DTO.invoiceDetailDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

public class invoiceDetailDAO {

    

    public invoiceDetailDAO() {
    }

    public ArrayList docdsInvoiceDetail() {
        MySQLConnect ms = new MySQLConnect();
        ArrayList dsiDetail = new ArrayList<invoiceDetailDTO>();
        try {
            String sql = "select * from invoicedetail";
            ResultSet rs = ms.executeQuery(sql);
            while (rs.next()) {
                String invoiceID = rs.getString("invoiceID");
                String typeID = rs.getString("typeID");
                int amount = rs.getInt("amount");
                float total = rs.getFloat("total");

                invoiceDetailDTO i = new invoiceDetailDTO(invoiceID, typeID, amount, total);
                dsiDetail.add(i);

            }
            ms.disConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsiDetail;
    }

    public void add(invoiceDetailDTO iDDTO) {
        MySQLConnect ms = new MySQLConnect();
        String sql = " INSERT INTO invoicedetail VALUES (";
        sql += "'" + iDDTO.getInvoiceID() + "',";
        sql += "'" + iDDTO.getTypeID() + "',";
        sql += "" + iDDTO.getAmount() + ",";
        sql += "" + iDDTO.getTotal() + ")";
        System.out.println(sql + "\n");
        ms.executeUpdate(sql);
    }

    public void set(invoiceDetailDTO iDetailDTO) {
        MySQLConnect ms = new MySQLConnect();
        String sql = " UPDATE invoicedetail SET ";
        sql += "invoiceID ='" + iDetailDTO.getInvoiceID() + "', ";
        sql += "typeID ='" + iDetailDTO.getTypeID() + "', ";
        sql += "amount =" + iDetailDTO.getAmount() + ", ";
        sql += "total =" + iDetailDTO.getTotal() + " ";
        sql += "WHERE typeID ='" + iDetailDTO.getTypeID() + "'" + " AND invoiceID = '" + iDetailDTO.getInvoiceID() + "'";
        System.out.println(sql);
        ms.executeUpdate(sql);
    }

    public void delete(String invoiceID, String typeID) {
        MySQLConnect ms = new MySQLConnect();
        String sql = "DELETE FROM invoicedetail WHERE invoiceID = '" + invoiceID + "'" + " AND typeID = '" + typeID + "'";
        System.out.println(sql);
        ms.executeUpdate(sql);
    }
}
