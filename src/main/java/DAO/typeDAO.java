package DAO;


import DAO.MySQLConnect;
import DTO.typeDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

public class typeDAO {

    private MySQLConnect dbc = new MySQLConnect();

    public typeDAO() {
    }

    public ArrayList docdsType() {
        ArrayList dsType = new ArrayList<typeDTO>();
        try {
            String sql = "select * from tickettype";
            ResultSet rs = dbc.executeQuery(sql);
            while (rs.next()) {
                String typeID = rs.getString("typeID");
                String typeName = rs.getString("typeName");
                int waittingRoom = rs.getInt("waittingRoom");
                float typePrice = rs.getFloat("typePrice");

                typeDTO t = new typeDTO(typeID, typeName, waittingRoom, typePrice);
                dsType.add(t);
            }
            dbc.disConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsType;
    }

    public void add(typeDTO tDTO) {
        String sql = " INSERT INTO tickettype VALUES (";
        sql += "'" + tDTO.getTypeID() + "',";
        sql += "'" + tDTO.getTypeName()+ "',";
        sql += "" + tDTO.getWaittingRoom()+ ",";
        sql += "" + tDTO.getTypePrice()+ ")";
        System.out.println(sql + "\n");
        dbc.executeUpdate(sql);
    }

    public void set(typeDTO type) {
        String sql = " UPDATE tickettype SET ";
        sql += "typeID ='" + type.getTypeID()+ "', ";
        sql += "typeName ='" + type.getTypeName() + "', ";
        sql += "waittingRoom =" + type.getWaittingRoom() + ", ";
        sql += "typePrice =" + type.getTypePrice() + " ";
        sql += "WHERE typeID ='" + type.getTypeID()+ "'";
        System.out.println(sql);
        dbc.executeUpdate(sql);
    }

    public void delete(String ID) {
        String sql = "DELETE FROM tickettype WHERE typeID = '" + ID + "'";
        System.out.println(sql);
        dbc.executeUpdate(sql);
    }
}
