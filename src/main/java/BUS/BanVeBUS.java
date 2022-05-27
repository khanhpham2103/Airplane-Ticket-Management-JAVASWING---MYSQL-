/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.BanVeDAO;
import DAO.KhachHangDAO;
import DTO.BanVeDTO;
import DTO.BanVeDTO1;
import DTO.ChuyenBayDTO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.invoiceDetailDTO;
import DTO.typeDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class BanVeBUS {

    private ArrayList<BanVeDTO> ds;
    private ArrayList<BanVeDTO1> ds1;
    private KhachHangBUS bus = new KhachHangBUS();

    public void listBanVe() {

    }

    public void listChuyenBayTable() {
        System.out.println("Dang Lay DATA ben DB");
        BanVeDAO dao = new BanVeDAO();
        ds1 = new ArrayList<>();
        ds1 = dao.ListChuyenBayTable();
    }

    private void AddCustomer(BanVeDTO cus, String MaCB) {
        String IDTMP = "KH";

        if (cus.getMa().equals("")) {
            System.out.println("Khong co trong db");
            bus.list();
            ArrayList<KhachHangDTO> arr = bus.getList();
            KhachHangDTO getLast = arr.get(arr.size() - 1);
            String tmpMa = getLast.getMaKH();
            tmpMa = tmpMa.substring(tmpMa.indexOf('H') + 1);
            int tmpINT = Integer.parseInt(tmpMa);
            String MaKhachHang;
            if (tmpINT < 10) {
                MaKhachHang = IDTMP + "00" + (tmpINT + 1);
            } else if (tmpINT < 100) {
                MaKhachHang = IDTMP + "0" + (tmpINT + 1);
            } else {
                MaKhachHang = IDTMP + (tmpINT + 1);
            }
            String Ma = MaKhachHang;
            String Ho = cus.getHo();
            String Ten = cus.getTen();
            String SDT = cus.getSDt();
            String DiaChi = cus.getDiaChi();
            String Gender = cus.getGioiTinh();
            String birth = cus.getBirth();
            KhachHangDTO dto = new KhachHangDTO(Ma, Ho, Ten, Gender, birth, DiaChi, SDT);
            bus.add(dto);
            addInvoice(cus, dto.getMaKH(), MaCB);

        } else {
            System.out.println("Co trong db");
            addInvoice(cus, cus.getMa(), MaCB);
        }

    }

    private void addInvoice(BanVeDTO tick, String cus, String MaChuyenBay) {
        HoaDonBUS hdbus = new HoaDonBUS();
        typeBUS typebus = new typeBUS();

        typebus.getList2();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = String.valueOf(dtf.format(now));
        System.out.println(date);
        ArrayList<typeDTO> getTypeData = typebus.getList();
//        typeDTO IdLast = getTypeData.get(getTypeData.size() - 1);
//        String lastid = IdLast.getTypeID().substring(2);
//        System.out.println("Last Id "+ lastid);
        hdbus.list();
        ArrayList<HoaDonDTO> getHoaDonData = hdbus.getList();
        HoaDonDTO IdLast = getHoaDonData.get(getHoaDonData.size() - 1);
        String lastid = IdLast.getInvoiceID().substring(2);
        System.out.println("Last Id " + lastid);
        int id = Integer.parseInt(lastid);
        String MaHoaDon = "HD";
        if (id < 10) {
            id++;
            MaHoaDon = MaHoaDon + "00" + id;
        }
        if (id < 100) {
            id++;
            MaHoaDon = MaHoaDon + "0" + id;
        } else {
            id++;
            MaHoaDon = MaHoaDon + id;

        }
        int Total = 0;
        if (!tick.getBusNum().equals("")) {
            for (typeDTO a : getTypeData) {
                if (a.getTypeID().equals("BUS")) {
                    Total += (int) a.getTypePrice() * Integer.parseInt(tick.getBusNum());
                }
            }
        }

        if (!tick.getEcoNum().equals("")) {
            for (typeDTO a : getTypeData) {
                if (a.getTypeID().equals("ECO")) {
                    Total += (int) a.getTypePrice() * Integer.parseInt(tick.getBusNum());
                }
            }
        }
        ChuyenBayBUS busCB = new ChuyenBayBUS();
        busCB.list();
        ArrayList<ChuyenBayDTO> dataCB = busCB.getList();
        ChuyenBayDTO tmp = busCB.get(MaChuyenBay);
        String BusNum = tmp.getBookedBUSSeats();
        String EcoNum = tmp.getBookedECOSaets();
        int TotalBus = Integer.parseInt(BusNum.substring(BusNum.indexOf('/') + 1));
        int ToTalEco = Integer.parseInt(EcoNum.substring(EcoNum.indexOf('/') + 1));
//        System.out.println(BusNum.substring(0, BusNum.indexOf('/') )+ " "+ EcoNum.substring(0, EcoNum.indexOf('/') - 1));
        int BusBooked = Integer.parseInt(BusNum.substring(0, BusNum.indexOf('/')));
        int EcoBooked = Integer.parseInt(EcoNum.substring(0, EcoNum.indexOf('/')));
        System.out.println(ToTalEco + " " + TotalBus + " " + EcoBooked + " " + BusBooked);
        HoaDonDTO dtotmp = new HoaDonDTO(MaHoaDon, "NV01", cus, Total, date);
        if ((BusBooked + Integer.parseInt(tick.getBusNum())) <= TotalBus && (EcoBooked + Integer.parseInt(tick.getEcoNum())) <= ToTalEco) {
            hdbus.add(dtotmp);
            int BookEcoSeat = EcoBooked + Integer.parseInt(tick.getEcoNum());
            int BookBusSeat = BusBooked + Integer.parseInt(tick.getBusNum());
            addInvoiceDetail(tick, tmp, dtotmp, BookEcoSeat, BookBusSeat, TotalBus, ToTalEco);
        }

    }

    public void addInvoiceDetail(BanVeDTO tick, ChuyenBayDTO cb, HoaDonDTO hd, int BookedEco, int BookedBus, int ToTalBus, int ToTalEco) {
        invoiceDetailBUS HDDetailBUS = new invoiceDetailBUS();
        typeBUS typebus = new typeBUS();
        ChuyenBayBUS busCB = new ChuyenBayBUS();
        typebus.getList2();
        HDDetailBUS.getList2();
        busCB.list();
        int BusNum = Integer.parseInt(tick.getBusNum());
        int EcoNum = Integer.parseInt(tick.getEcoNum());
        int PriceBus = (int) typebus.get("BUS").getTypePrice();
        int PriceEco = (int) typebus.get("ECO").getTypePrice();

        if (BusNum > 0) {
            int TotalPrice = BusNum * PriceBus;
            invoiceDetailDTO dto = new invoiceDetailDTO(hd.getInvoiceID(), "BUS", BusNum, TotalPrice);
            HDDetailBUS.add(dto);
        }
        if (EcoNum > 0) {
            int TotalPrice = EcoNum * PriceEco;
            invoiceDetailDTO dto = new invoiceDetailDTO(hd.getInvoiceID(), "ECO", BusNum, TotalPrice);
            HDDetailBUS.add(dto);
        }
//        System.out.println("So Ve Moi Loaij " + BusNum + " " + EcoNum);
        String EcoBookedString = BookedEco + "/" + ToTalEco;
        String BusBookedString = BookedBus + "/" + ToTalBus;
        ChuyenBayDTO dtp = new ChuyenBayDTO(cb.getFlightID(), cb.getRouteID(), cb.getAirplaneID(), cb.getFlightScheduleID(), cb.getDepartureTime(), cb.getArrivalTime(), cb.getTotalSeats(), EcoBookedString, BusBookedString);
        busCB.set(dtp);
        System.out.println(EcoBookedString + "  " + BusBookedString);
    }

    public void addCustomerTicket(BanVeDTO a, String Ma) {
        if (a.getBusNum().equals("")) {
            a.setBusNum("0");
        }
        if (a.getEcoNum().equals("")) {
            a.setEcoNum("0");
        }
        AddCustomer(a, Ma);

    }

    public ArrayList<BanVeDTO> getListBanVe() {
        return ds;
    }

    public ArrayList<BanVeDTO1> getListChuyenBayTable() {
        return ds1;
    }
}
