package BUS;

import DAO.flightScheduleDAO;
import DAO.flightScheduleDAO;
import DTO.KhachHangDTO;
import DTO.SanBayDTO;
import DTO.flightScheduleDTO;
import java.util.ArrayList;

public class flightScheduleBUS {

    private ArrayList<flightScheduleDTO> dsflightSchedule;
    private flightScheduleDAO fSDAO = new flightScheduleDAO();
    private SanBayBUS sbBUS = new SanBayBUS();
    public flightScheduleBUS() {
    }

    public void init() {
        dsflightSchedule = new ArrayList<>();
        dsflightSchedule = fSDAO.docdsflightSchedule();
    }

    public ArrayList<flightScheduleDTO> getList() {
        return dsflightSchedule;
    }

    public void add(flightScheduleDTO a) {
        dsflightSchedule.add(a);
        fSDAO.add(a);
    }

    public void delete(String ID) {
        for (flightScheduleDTO n : dsflightSchedule) {
            if (n.getFlightScheduleID().equals(ID)) {
                dsflightSchedule.remove(n);
                fSDAO.delete(ID);
                return;
            }
        }
    }

    public void set(flightScheduleDTO s) {
        for (int i = 0; i < dsflightSchedule.size(); i++) {
            if (dsflightSchedule.get(i).getFlightScheduleID().equals(s.getFlightScheduleID())) {
                dsflightSchedule.set(i, s);
                fSDAO.set(s);
                return;
            }
        }

    }

    public void getList2() {
        flightScheduleDAO fSDAO = new flightScheduleDAO();
        dsflightSchedule = new ArrayList<>();
        dsflightSchedule = fSDAO.docdsflightSchedule();
    }

    public boolean checkfSId(String fSId) {
        for (flightScheduleDTO fS : dsflightSchedule) {
            if (fS.getFlightScheduleID().equals(fSId)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkFS(String weekDay, String time, String depart, String arrive) {
        for (flightScheduleDTO fS : dsflightSchedule) {
            if (fS.getWeekdays().equals(weekDay) && fS.getTime().equals(time) && fS.getArrivalAirport().equals(arrive) && fS.getDepartureAirport().equals(depart)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkDep(String depart) {
        if (sbBUS.getList() == null) {
            sbBUS.list();
        }
        ArrayList<SanBayDTO> sbList = sbBUS.getList();
        for (SanBayDTO sb : sbList) {
            if (sb.getAirportID().equals(depart)) {
                System.out.println("true");
                return true;
            }
        }
        System.out.println("false");
        return false;
    }
    
    public boolean checkArri(String arrive) {
        if (sbBUS.getList() == null) {
            sbBUS.list();
        }
        ArrayList<SanBayDTO> sbList = sbBUS.getList();
        for (SanBayDTO sb : sbList) {
            if (sb.getAirportID().equals(arrive)) {
                return true;
            }
        }
        return false;
    }

//    public boolean checkTicket(flightScheduleDTO tkCheck) {
//        for (flightScheduleDTO tk : dsflightSchedule) {
//            if (tk.getCustomerID().equals(tkCheck.getCustomerID()) && tk.getFlightID().equals(tkCheck.getFlightID()) && tk.getTypeID().equals(tkCheck.getTypeID()) && tk.getInvoiceID().equals(tkCheck.getInvoiceID())) {
//                return true;
//            }
//        }
//        return false;
//    }

    public ArrayList<flightScheduleDTO> searchWeekdays(String weekdays) {
        ArrayList<flightScheduleDTO> fSSearchList = new ArrayList<>();
        fSSearchList = fSDAO.getAndSortDateOrderByTime(weekdays);
        return fSSearchList;
    }

//    public ArrayList<flightScheduleDTO> searchTicketByKhachHangPhone(String khPhone) {
//        KhachHangBUS khBus = new KhachHangBUS();
//        khBus.list();
//        ArrayList<KhachHangDTO> khList = khBus.getList();
//
//        String khId = "";
//
//        for (KhachHangDTO kh : khList) {
//            if (kh.getSDT().equals(khPhone)) {
//                khId = kh.getMaKH();
//                break;
//            }
//        }
//
//        ArrayList<flightScheduleDTO> tkSearchList = new ArrayList<>();
//        for (flightScheduleDTO tk : dsflightSchedule) {
//            if (tk.getCustomerID().equals(khId)) {
//                tkSearchList.add(tk);
//            }
//        }
//        return tkSearchList;
//    }

//    public boolean checkCustomerId(String customerId)
//    {
//        ArrayList<customerDTO> dsCustomer;
//        for(flightScheduleDTO tk : dsflightSchedule)
//        {
//            if(tk.getFlightScheduleID().equals(ticketId))
//            {
//                return true;
//            }
//        }
//        return false;
//    }
    
}

