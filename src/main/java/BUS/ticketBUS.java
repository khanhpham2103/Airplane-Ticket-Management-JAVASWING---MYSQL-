package BUS;

import DAO.ticketDAO;
import DTO.HoaDonDTO;
import DTO.KhachHangDTO;
import DTO.invoiceDetailDTO;
import DTO.ticketDTO;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ticketBUS {
    private ArrayList<ticketDTO> dsTicket;
    private ticketDAO tkDAO = new ticketDAO();
    private invoiceDetailBUS iDBUS;
    private HoaDonBUS hdBUS = new HoaDonBUS();
    
    public ticketBUS() {
    }

    public void init()
    {
        dsTicket = new ArrayList<>();
        dsTicket = tkDAO.docdsTicket();
    }
    
    public ArrayList<ticketDTO> getList() {
        return dsTicket;
    }

    public void add(ticketDTO a) {
        dsTicket.add(a);
        tkDAO.add(a);
    }

    public void delete(String ID) {
        for (ticketDTO n : dsTicket) {
            if (n.getTicketID().equals(ID)) {
                dsTicket.remove(n);
                tkDAO.delete(ID);
                return;
            }
        }
    }

    public void set(ticketDTO s) {
        for (int i = 0; i < dsTicket.size(); i++) {
            if (dsTicket.get(i).getTicketID().equals(s.getTicketID())) {
                dsTicket.set(i, s);
                tkDAO.set(s);
                return;
            }
        }

    }
    
    public void getList2(){
        ticketDAO tkDAO = new ticketDAO();
        dsTicket= new ArrayList<>();
        dsTicket = tkDAO.docdsTicket();
    }
    
    public boolean checkTicketId(String ticketId)
    {
        for(ticketDTO tk : dsTicket)
        {
            if(tk.getTicketID().equals(ticketId))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean checkTicket(ticketDTO tkCheck)
    {
        for(ticketDTO tk : dsTicket)
        {
            if(tk.getCustomerID().equals(tkCheck.getCustomerID()) && tk.getFlightID().equals(tkCheck.getFlightID()) && tk.getTypeID().equals(tkCheck.getTypeID()) && tk.getInvoiceID().equals(tkCheck.getInvoiceID()))
            {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<ticketDTO> searchTicketById(String tkId) {
        ArrayList<ticketDTO> tkSearchList = new ArrayList<>();
        for(ticketDTO tk : dsTicket)
        {
            if (tk.getTicketID().toUpperCase().contains(tkId.toUpperCase())) {
                tkSearchList.add(tk);
            }
        }
        return tkSearchList;
    }
    
    public ArrayList<ticketDTO> searchTicketByKhachHangPhone(String khPhone) {
        KhachHangBUS khBus = new KhachHangBUS();
        khBus.list();
        ArrayList<KhachHangDTO> khList = khBus.getList();

        String khId = "";

        for (KhachHangDTO kh : khList) {
            if (kh.getSDT().equals(khPhone)) {
                khId = kh.getMaKH();
                break;
            }
        }

        ArrayList<ticketDTO> tkSearchList = new ArrayList<>();
        for (ticketDTO tk : dsTicket) {
            if (tk.getCustomerID().equals(khId)) {
                tkSearchList.add(tk);
            }
        }
        return tkSearchList;
    }
    
    // CHECK AMOUNT
    
    public boolean checkAmountECO(String invoiceId) {
        int count = 0;
        for (ticketDTO tk : dsTicket) {
            if (tk.getInvoiceID().equals(invoiceId) && tk.getTypeID().equals("ECO")) {
                count += 1;
            }
        }
        
        return count <= getAmountOfECO(invoiceId);
    }
    
    public boolean checkAmountBUS(String invoiceId) {
        int count = 0;
        for (ticketDTO tk : dsTicket) {
            if (tk.getInvoiceID().equals(invoiceId) && tk.getTypeID().equals("BUS")) {
                count += 1;
            }
        }
        
        return count <= getAmountOfBUS(invoiceId);
    }
    
    private int getAmountOfECO(String invoiceId) {
        iDBUS = new invoiceDetailBUS();
        int count = 0;
        if (iDBUS.getList() == null) {
            iDBUS.getList2();
        }
        ArrayList<invoiceDetailDTO> iDList = iDBUS.getList();
        for (invoiceDetailDTO iD : iDList) {
            if (iD.getInvoiceID().equals(invoiceId) && iD.getTypeID().equals("ECO")) {
                count += iD.getAmount();
            }
        }
        return count;
    }
    
    private int getAmountOfBUS(String invoiceId) {
        iDBUS = new invoiceDetailBUS();
        int count = 0;
        if (iDBUS.getList() == null) {
            iDBUS.getList2();
        }
        ArrayList<invoiceDetailDTO> iDList = iDBUS.getList();
        for (invoiceDetailDTO iD : iDList) {
            if (iD.getInvoiceID().equals(invoiceId) && iD.getTypeID().equals("BUS")) {
                count += iD.getAmount();
            }
        }
        return count;
    }
    //END CHECK AMOUNT
    
    //CHECK INVOICE AND CUSTOMER
    public boolean checkInvoiceAndCustomer(String invoiceId, String customerId) {
        if (hdBUS.getList() == null) {
            hdBUS.list();
        }
        
        ArrayList<HoaDonDTO> hdList = hdBUS.getList();
        for (HoaDonDTO hd : hdList) {
            if (hd.getInvoiceID().equals(invoiceId) && hd.getCustomerID().equals(customerId)) {
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
    
    
    
    
    
    
    
    
    //excel
    public final int COLUMN_INDEX_TICKETID = 0;
    public final int COLUMN_INDEX_CUSTOMERID = 1;
    public final int COLUMN_INDEX_FLIGHTID = 2;
    public final int COLUMN_INDEX_TYPEID = 3;
    public final int COLUMN_INDEX_INVOICEID = 4;
    private CellStyle cellStyleFormatNumber = null;

    public void writeExcel(ArrayList<ticketDTO> tickets, String excelFilePath) throws IOException {
        // Create Workticket
        Workbook workbook = getWorkbook(excelFilePath);

        // Create sheet
        Sheet sheet = workbook.createSheet("Danh sach Ve"); // Create sheet with sheet name

        int rowIndex = 0;
        
        // Write footer
        writeFooter(sheet, rowIndex);
        rowIndex++;
        
        // Write header
        writeHeader(sheet, rowIndex);

        // Write data
        rowIndex++;
        for (ticketDTO ticket : tickets) {
            // Create row
            Row row = sheet.createRow(rowIndex);
            // Write data on row
            writeBook(ticket, row);
            rowIndex++;
        }

        

        // Auto resize column witdth
        int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, numberOfColumn);

        // Create file excel
        createOutputFile(workbook, excelFilePath);
        System.out.println("Done!!!");
    }

    // Create workticket
    private Workbook getWorkbook(String excelFilePath) throws IOException {
        Workbook worktbook = null;

        if (excelFilePath.endsWith("xlsx") || excelFilePath.endsWith("XLSX")) {
            worktbook = new XSSFWorkbook();
        } else if (excelFilePath.endsWith("xls")) {
            worktbook = new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return worktbook;
    }

    // Write header with format
    private void writeHeader(Sheet sheet, int rowIndex) {
        // create CellStyle
        CellStyle cellStyle = createStyleForHeader(sheet);

        // Create row
        Row row = sheet.createRow(rowIndex);

        // Create cells
        Cell cell = row.createCell(COLUMN_INDEX_TICKETID);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Ticket Id");

        cell = row.createCell(COLUMN_INDEX_CUSTOMERID);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Customer Id");

        cell = row.createCell(COLUMN_INDEX_FLIGHTID);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Flight Id");

        cell = row.createCell(COLUMN_INDEX_TYPEID);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Type Id");

        cell = row.createCell(COLUMN_INDEX_INVOICEID);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Invoice Id");
    }

    // Write data
    private void writeBook(ticketDTO ticket, Row row) {
        if (cellStyleFormatNumber == null) {
            // Format number
            short format = (short) BuiltinFormats.getBuiltinFormat("#,##0");
            // DataFormat df = workticket.createDataFormat();
            // short format = df.getFormat("#,##0");

            //Create CellStyle
            Workbook workticket = row.getSheet().getWorkbook();
            cellStyleFormatNumber = workticket.createCellStyle();
            cellStyleFormatNumber.setDataFormat(format);
        }

        Cell cell = row.createCell(COLUMN_INDEX_TICKETID);
        cell.setCellValue(ticket.getTicketID());

        cell = row.createCell(COLUMN_INDEX_CUSTOMERID);
        cell.setCellValue(ticket.getCustomerID());

        cell = row.createCell(COLUMN_INDEX_FLIGHTID);
        cell.setCellValue(ticket.getFlightID());
        cell.setCellStyle(cellStyleFormatNumber);

        cell = row.createCell(COLUMN_INDEX_TYPEID);
        cell.setCellValue(ticket.getTypeID());

        cell = row.createCell(COLUMN_INDEX_INVOICEID);
        cell.setCellValue(ticket.getInvoiceID());

        // Create cell formula
        // totalMoney = price * quantity
//        cell = row.createCell(COLUMN_INDEX_INVOICEID, CellType.FORMULA);
//        cell.setCellStyle(cellStyleFormatNumber);
//        int currentRow = row.getRowNum() + 1;
//        String columnPrice = CellReference.convertNumToColString(COLUMN_INDEX_FLIGHTID);
//        String columnQuantity = CellReference.convertNumToColString(COLUMN_INDEX_TYPEID);
//        cell.setCellFormula(columnPrice + currentRow + "*" + columnQuantity + currentRow);
    }

    // Create CellStyle for header
    private CellStyle createStyleForHeader(Sheet sheet) {
        // Create font
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color

        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }

    // Write footer
    private void writeFooter(Sheet sheet, int rowIndex) {
        // Create row
        Row row = sheet.createRow(rowIndex);
        Cell cell = row.createCell(COLUMN_INDEX_TICKETID, CellType.FORMULA);
//        cell.setCellFormula("SUM(E2:E6)");
        cell.setCellValue("Danh sach ve!");
    }

    // Auto resize column width
    private void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }

    // Create output file
    private void createOutputFile(Workbook workticket, String excelFilePath) throws IOException {
        try ( OutputStream os = new FileOutputStream(excelFilePath)) {
            workticket.write(os);
        }
    }
}


