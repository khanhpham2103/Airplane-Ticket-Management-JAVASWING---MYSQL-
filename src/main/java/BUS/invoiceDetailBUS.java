package BUS;

import DAO.invoiceDetailDAO;
import DTO.invoiceDetailDTO;
import DTO.typeDTO;
import java.util.ArrayList;
import DAO.ChuyenBayDAO;
import DTO.ChuyenBayDTO;
import DTO.HoaDonDTO;
import DTO.ticketDTO;
import java.util.Comparator;

public class invoiceDetailBUS {

    private ArrayList<invoiceDetailDTO> dsiDetail;
    private invoiceDetailDAO iDetailDAO = new invoiceDetailDAO();
    private HoaDonBUS hdBUS = new HoaDonBUS();
    private ArrayList<HoaDonDTO> hdList;
    private ticketBUS tkBUS;
    private ChuyenBayBUS cbBUS = new ChuyenBayBUS();
    private ChuyenBayDAO cbDAO = new ChuyenBayDAO();

    public invoiceDetailBUS() {
        init();
    }

    public void init() {
        dsiDetail = new ArrayList<>();
        dsiDetail = iDetailDAO.docdsInvoiceDetail();
    }

    public ArrayList<invoiceDetailDTO> getList() {
        return dsiDetail;
    }

    public void add(invoiceDetailDTO a) {
        dsiDetail.add(a);
        iDetailDAO.add(a);
    }

    public void delete(String invoiceID, String typeID) {
        for (invoiceDetailDTO n : dsiDetail) {
            if (n.getInvoiceID().equals(invoiceID) && n.getTypeID().equals(typeID)) {
                dsiDetail.remove(n);
                iDetailDAO.delete(invoiceID, typeID);
                return;
            }
        }
    }

    public void set(invoiceDetailDTO s) {
        for (int i = 0; i < dsiDetail.size(); i++) {
            if (dsiDetail.get(i).getTypeID().equals(s.getTypeID()) && dsiDetail.get(i).getInvoiceID().equals(s.getInvoiceID())) {
                dsiDetail.set(i, s);
                iDetailDAO.set(s);
                return;
            }
        }

    }

    public void getList2() {
        dsiDetail = new ArrayList<>();
        dsiDetail = iDetailDAO.docdsInvoiceDetail();
    }

    public boolean checkTypeAndInvoiceID(String invoiceID, String typeID) {
        getList2();
        for (invoiceDetailDTO iDetail : dsiDetail) {
            if (iDetail.getTypeID().equals(typeID) && iDetail.getInvoiceID().equals(invoiceID)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkInvoiceID(String id) {
        if (hdBUS.getList() == null) {
            hdBUS.list();
        }
        ArrayList<HoaDonDTO> hdList = hdBUS.getList();
        for (HoaDonDTO sb : hdList) {
            if (sb.getInvoiceID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTypeId(String typeID) {
        typeBUS typBUS = new typeBUS();
        if (typBUS.getList() == null) {
            typBUS.getList2();
        }

        ArrayList<typeDTO> dsType = typBUS.getList();

        for (typeDTO type : dsType) {
            if (type.getTypeID().equals(typeID)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<invoiceDetailDTO> searchIDetailDTOsByInvoiceId(String invoiceID) {
        ArrayList<invoiceDetailDTO> iDsearchList = new ArrayList<>();
        for (invoiceDetailDTO tk : dsiDetail) {
            if (tk.getInvoiceID().toUpperCase().contains(invoiceID.toUpperCase())) {
                iDsearchList.add(tk);
            }
        }
        return iDsearchList;
    }

    public boolean updateAmountFlight(String invoiceId, String typeId, int amount) {
        tkBUS = new ticketBUS();
        if (tkBUS.getList() == null) {
            tkBUS.getList2();
        }
        ArrayList<ticketDTO> tkList = tkBUS.getList();

        if (cbBUS.getList() == null) {
            cbBUS.list();
        }
        System.out.println("amount = " + amount);
        ArrayList<ChuyenBayDTO> cbList = cbBUS.getList();

        for (ticketDTO tk : tkList) {
            if (tk.getInvoiceID().equals(invoiceId) && tk.getTypeID().equals(typeId)) {
                String flightId = tk.getFlightID();
                for (ChuyenBayDTO cb : cbList) {
                    if (cb.getFlightID().equals(flightId)) {
                        if (typeId.equals("ECO")) {
                            int currAmount = Integer.parseInt(cb.getBookedECOSaets().split("/")[0]);
                            currAmount += amount;
                            if (currAmount > Integer.parseInt(cb.getBookedECOSaets().split("/")[1])) {
                                return false;
                            } else {
                                String seat = String.valueOf(currAmount) + "/" + cb.getBookedECOSaets().split("/")[1];
                                cbDAO.updateAmountECO(flightId, seat);
                                return true;
                            }
                        } else if (typeId.equals("BUS")) {
                            int currAmount = Integer.parseInt(cb.getBookedBUSSeats().split("/")[0]);
                            currAmount += amount;
                            if (currAmount > Integer.parseInt(cb.getBookedBUSSeats().split("/")[1])) {
                                return false;
                            } else {
                                String seat = String.valueOf(currAmount) + "/" + cb.getBookedBUSSeats().split("/")[1];
                                cbDAO.updateAmountBUS(flightId, seat);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public int getOldAmount(String invoiceId, String typeId) {
        for (invoiceDetailDTO iD : dsiDetail) {
            if (iD.getInvoiceID().equals(invoiceId) && iD.getTypeID().equals(typeId)) {
                return iD.getAmount();
            }
        }
        return 0;
    }

    public int countTicketByTypeNInvoiceId(String invoiceid, String typeid) {
        tkBUS = new ticketBUS();
        if (tkBUS.getList() == null) {
            tkBUS.getList2();
        }
        ArrayList<ticketDTO> tkList = tkBUS.getList();

        int count = 0;
        for (ticketDTO tk : tkList) {
            if (tk.getInvoiceID().equals(invoiceid) && tk.getTypeID().equals(typeid)) {
                count += 1;
            }
        }
        return count;
    }

    public ArrayList<invoiceDetailDTO> searchByMonthAndYear(String month, String year) {
        if (hdBUS.getList() == null) {
            hdBUS.list();
        }
        hdList = hdBUS.getList();

        ArrayList<invoiceDetailDTO> iDsearchList = new ArrayList<>();

        for (HoaDonDTO hd : hdList) {
            String hdYear = hd.getInvoicedDateTime().split("-")[0];
            String hdMonth = hd.getInvoicedDateTime().split("-")[1];
            if (hdYear.equals(year) && hdMonth.equals(month)) {
                String maHd = hd.getInvoiceID();
                for (invoiceDetailDTO iD : dsiDetail) {
                    if (iD.getInvoiceID().equals(maHd)) {
                        iDsearchList.add(iD);
                    }
                }
            }
        }
        return iDsearchList;
    }

    public static Comparator<invoiceDetailDTO> priceComparatorAsc = (invoiceDetailDTO i1, invoiceDetailDTO i2) -> {
        float price1 = i1.getTotal();
        float price2 = i2.getTotal();

        // For ascending order
        return (int) (price1 - price2);
    };

    public static Comparator<invoiceDetailDTO> priceComparatordesc = (invoiceDetailDTO i1, invoiceDetailDTO i2) -> {
        float price1 = i1.getTotal();
        float price2 = i2.getTotal();

        // For descending order
        return (int) (price2 - price1);
    };

//    public boolean checkiDetail(invoiceDetailDTO iDetailCheck)
//    {
//        for(invoiceDetailDTO tk : dsiDetail)
//        {
//            if(tk.getInvoiceID().equals(iDetailCheck.getInvoiceID()) && tk.getTypeID().equals(iDetailCheck.getTypeID()))
//            {
//                return true;
//            }
//        }
//        return false;
//    }
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
