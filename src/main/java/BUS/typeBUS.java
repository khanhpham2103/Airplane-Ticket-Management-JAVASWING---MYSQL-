package BUS;

import DAO.typeDAO;
import DTO.typeDTO;
import java.util.ArrayList;

public class typeBUS {

    private ArrayList<typeDTO> dsType;
    private typeDAO typDAO = new typeDAO();

    public typeBUS() {
    }

    public void init() {
        dsType = new ArrayList<>();
        dsType = typDAO.docdsType();
    }

    public typeDTO get(String id) {
        for (typeDTO a : dsType) {
            if (a.getTypeID().equals(id)) {
                return a;
            }
        }
        return null;
    }

    public ArrayList<typeDTO> getList() {
        return dsType;
    }

    public void add(typeDTO a) {
        dsType.add(a);
        typDAO.add(a);
    }

    public void delete(String ID) {
        for (typeDTO n : dsType) {
            if (n.getTypeID().equals(ID)) {
                dsType.remove(n);
                typDAO.delete(ID);
                return;
            }
        }
    }

    public void set(typeDTO s) {
        for (int i = 0; i < dsType.size(); i++) {
            if (dsType.get(i).getTypeID().equals(s.getTypeID())) {
                dsType.set(i, s);
                typDAO.set(s);
                return;
            }
        }

    }

    public void getList2() {
        dsType = new ArrayList<>();
        dsType = typDAO.docdsType();
    }

    public boolean checkTypeId(String typeID) {
        for (typeDTO type : dsType) {
            if (type.getTypeID().equals(typeID)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkType(typeDTO typeCheck) {
        for (typeDTO tk : dsType) {
            if (tk.getTypeName().equals(typeCheck.getTypeName()) && tk.getWaittingRoom() == typeCheck.getWaittingRoom() && tk.getTypePrice() == typeCheck.getTypePrice()) {
                return true;
            }
        }
        return false;
    }

//    public boolean checkCustomerId(String customerId)
//    {
//        ArrayList<customerDTO> dsCustomer;
//        for(ticketDTO tk : dsTicket)
//        {
//            if(tk.getTicketID().equals(ticketId))
//            {
//                return true;
//            }
//        }
//        return false;
//    }
}
