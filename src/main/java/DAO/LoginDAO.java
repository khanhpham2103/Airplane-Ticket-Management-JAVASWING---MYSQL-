/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.LoginDTO;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class LoginDAO {

    public  LoginDTO getUserByName(LoginDTO a) {
        LoginDTO res = new LoginDTO();
        MySQLConnect ms = new MySQLConnect();
        try {
            String sql = "SELECT * FROM staff WHERE staffID = '" + a.getUser() + "'";
            System.out.println(sql);
            ResultSet rs = ms.executeQuery(sql);
            while (rs.next()) {
                res = new LoginDTO(rs.getString("staffID"), rs.getString("password"));
                return res;
            }
            rs.close();
            ms.disConnect();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi kết nối");
        }
        return res;
    }

    
}
