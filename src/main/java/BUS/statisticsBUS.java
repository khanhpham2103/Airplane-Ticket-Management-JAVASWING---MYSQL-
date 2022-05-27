package BUS;

import DTO.HoaDonDTO;
import DTO.invoiceDetailDTO;
import DTO.statisticsDTO;
import DTO.ticketDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class statisticsBUS {

    private invoiceDetailBUS iDBUS = new invoiceDetailBUS();
    private HoaDonBUS hdBUS = new HoaDonBUS();
    private ArrayList<invoiceDetailDTO> iDList;
    private ArrayList<HoaDonDTO> hdList;

    public statisticsBUS() {
    }

    public int SLHoadon(String month, String year) {
        if (hdBUS.getList() == null) {
            hdBUS.list();
        }
        hdList = hdBUS.getList();

        int count = 0;

        for (HoaDonDTO hd : hdList) {
            String hdYear = hd.getInvoicedDateTime().split("-")[0];
            String hdMonth = hd.getInvoicedDateTime().split("-")[1];
            if (hdYear.equals(year) && hdMonth.equals(month)) {
                count += 1;
//                System.out.println(count + "  -  " + hd.getInvoiceID());
            }
        }
        return count;
    }

    public long tongthu(String month, String year) {
        if (hdBUS.getList() == null) {
            hdBUS.list();
        }
        hdList = hdBUS.getList();

        long count = 0;

        for (HoaDonDTO hd : hdList) {
            String hdYear = hd.getInvoicedDateTime().split("-")[0];
            String hdMonth = hd.getInvoicedDateTime().split("-")[1];
            if (hdYear.equals(year) && hdMonth.equals(month)) {
                count += hd.getInvoiceTotal();
            }
        }
        return count;
    }

    public int SLVe(String month, String year) {
        if (hdBUS.getList() == null) {
            hdBUS.list();
        }
        hdList = hdBUS.getList();

        if (iDBUS.getList() == null) {
            iDBUS.getList2();
        }
        iDList = iDBUS.getList();

        int count = 0;

        for (HoaDonDTO hd : hdList) {
            String hdYear = hd.getInvoicedDateTime().split("-")[0];
            String hdMonth = hd.getInvoicedDateTime().split("-")[1];
            if (hdYear.equals(year) && hdMonth.equals(month)) {
                String maHd = hd.getInvoiceID();
                for (invoiceDetailDTO iD : iDList) {
                    if (iD.getInvoiceID().equals(maHd)) {
                        count += iD.getAmount();
                    }
                }
            }
        }
        return count;
    }

    public int SLVeECO(String month, String year) {
        if (hdBUS.getList() == null) {
            hdBUS.list();
        }
        hdList = hdBUS.getList();

        if (iDBUS.getList() == null) {
            iDBUS.getList2();
        }
        iDList = iDBUS.getList();

        int count = 0;

        for (HoaDonDTO hd : hdList) {
            String hdYear = hd.getInvoicedDateTime().split("-")[0];
            String hdMonth = hd.getInvoicedDateTime().split("-")[1];
            if (hdYear.equals(year) && hdMonth.equals(month)) {
                String maHd = hd.getInvoiceID();
                for (invoiceDetailDTO iD : iDList) {
                    if (iD.getInvoiceID().equals(maHd) && iD.getTypeID().equals("ECO")) {
                        count += 1;
                    }
                }
            }
        }
        return count;
    }

    public int SLVeBUS(String month, String year) {
        if (hdBUS.getList() == null) {
            hdBUS.list();
        }
        hdList = hdBUS.getList();

        if (iDBUS.getList() == null) {
            iDBUS.getList2();
        }
        iDList = iDBUS.getList();

        int count = 0;

        for (HoaDonDTO hd : hdList) {
            String hdYear = hd.getInvoicedDateTime().split("-")[0];
            String hdMonth = hd.getInvoicedDateTime().split("-")[1];
            if (hdYear.equals(year) && hdMonth.equals(month)) {
                String maHd = hd.getInvoiceID();
                for (invoiceDetailDTO iD : iDList) {
                    if (iD.getInvoiceID().equals(maHd) && iD.getTypeID().equals("BUS")) {
                        count += 1;
                    }
                }
            }
        }
        return count;
    }

    //excel
    public final int COLUMN_INDEX_MONTH = 0;
    public final int COLUMN_INDEX_SLHD = 1;
    public final int COLUMN_INDEX_SLVE = 2;
    public final int COLUMN_INDEX_SLVEECO = 3;
    public final int COLUMN_INDEX_SLVEBUS = 4;
    public final int COLUMN_INDEX_TONGTIEN = 5;
    private CellStyle cellStyleFormatNumber = null;

    public void writeExcel(ArrayList<statisticsDTO> stList, String excelFilePath) throws IOException {
        // Create Workticket
        Workbook workbook = getWorkbook(excelFilePath);

        // Create sheet
        Sheet sheet = workbook.createSheet("Thong ke doanh thu"); // Create sheet with sheet name

        int rowIndex = 0;

        // Write footer
        writeFooter(sheet, rowIndex);
        rowIndex++;

        // Write header
        writeHeader(sheet, rowIndex);

        // Write data
        rowIndex++;
        for (statisticsDTO st : stList) {
            // Create row
            Row row = sheet.createRow(rowIndex);
            // Write data on row
            writeBook(st, row);
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
        Cell cell = row.createCell(COLUMN_INDEX_MONTH);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tháng");

        cell = row.createCell(COLUMN_INDEX_SLHD);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("SL Hóa đơn");

        cell = row.createCell(COLUMN_INDEX_SLVE);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("SL Vé");

        cell = row.createCell(COLUMN_INDEX_SLVEECO);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("SL vé ECO");

        cell = row.createCell(COLUMN_INDEX_SLVEBUS);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("SL vé BUS");

        cell = row.createCell(COLUMN_INDEX_TONGTIEN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Tổng thu");
    }

    // Write data
    private void writeBook(statisticsDTO st, Row row) {
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

        Cell cell = row.createCell(COLUMN_INDEX_MONTH);
        cell.setCellValue(st.getMonth());

        cell = row.createCell(COLUMN_INDEX_SLHD);
        cell.setCellValue(st.getSLHD());
        cell.setCellStyle(cellStyleFormatNumber);

        cell = row.createCell(COLUMN_INDEX_SLVE);
        cell.setCellValue(st.getSLVe());
        cell.setCellStyle(cellStyleFormatNumber);

        cell = row.createCell(COLUMN_INDEX_SLVEECO);
        cell.setCellValue(st.getSLVeECO());
        cell.setCellStyle(cellStyleFormatNumber);

        cell = row.createCell(COLUMN_INDEX_SLVEBUS);
        cell.setCellValue(st.getSLVeBUS());
        cell.setCellStyle(cellStyleFormatNumber);

        cell = row.createCell(COLUMN_INDEX_TONGTIEN);
        cell.setCellValue(st.getTongTien());
        cell.setCellStyle(cellStyleFormatNumber);

        // Create cell formula
        // totalMoney = price * quantity
//        cell = row.createCell(COLUMN_INDEX_SLVEBUS, CellType.FORMULA);
//        cell.setCellStyle(cellStyleFormatNumber);
//        int currentRow = row.getRowNum() + 1;
//        String columnPrice = CellReference.convertNumToColString(COLUMN_INDEX_SLVE);
//        String columnQuantity = CellReference.convertNumToColString(COLUMN_INDEX_SLVEECO);
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
        Cell cell = row.createCell(COLUMN_INDEX_MONTH, CellType.FORMULA);
//        cell.setCellFormula("SUM(E2:E6)");
        cell.setCellValue("Thong ke doanh thu!");
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

    //IMPORT EXCEL
    public ArrayList<statisticsDTO> importExcel(String excelFilePath) throws Exception {
        ArrayList<statisticsDTO> stList = new ArrayList<>();
        try {
            FileInputStream excelFile = new FileInputStream(new File(excelFilePath));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            DataFormatter fmt = new DataFormatter();
            Iterator<Row> iterator = datatypeSheet.iterator();
            Row firstRow = iterator.next();
            firstRow = iterator.next();
            Cell firstCell = firstRow.getCell(0);
            System.out.println(firstCell.getStringCellValue());

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                statisticsDTO st = new statisticsDTO();

                st.setMonth(currentRow.getCell(0).getStringCellValue());
                st.setSLHD(Integer.parseInt(fmt.formatCellValue(currentRow.getCell(1))));
                st.setSLVe(Integer.parseInt(fmt.formatCellValue(currentRow.getCell(2))));
                st.setSLVeECO(Integer.parseInt(fmt.formatCellValue(currentRow.getCell(3))));
                st.setSLVeBUS(Integer.parseInt(fmt.formatCellValue(currentRow.getCell(4))));
                st.setTongTien(Integer.parseInt(fmt.formatCellValue(currentRow.getCell(5)).replaceAll(",", "")));
                
                stList.add(st);
            }
            workbook.close();
            return stList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stList;
    }

}
