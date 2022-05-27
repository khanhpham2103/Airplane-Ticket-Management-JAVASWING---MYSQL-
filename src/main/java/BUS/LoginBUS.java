/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.LoginDAO;
import DTO.LoginDTO;

/**
 *
 * @author ASUS
 */
public class LoginBUS {

    public boolean CheckUser(LoginDTO a) {
        LoginDAO dao = new LoginDAO();
        LoginDTO res = dao.getUserByName(a);
        if(res.getUser() == null){
            return false;
        }
        return res.getUser().equalsIgnoreCase(a.getUser()) && res.getPass().toLowerCase().equals(a.getPass().toLowerCase());
    }
}
