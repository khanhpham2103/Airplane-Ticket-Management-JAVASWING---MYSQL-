package GUI;

import BUS.HoaDonBUS;
import BUS.ThongKeBUS;
import BUS.invoiceDetailBUS;
import BUS.statisticsBUS;
import DTO.HoaDonDTO;
import DTO.ThongKeDTO;
import DTO.invoiceDetailDTO;
import DTO.statisticsDTO;
import GUISupport.TableDark;
import GUISupport.jpanelGradient;
import GUISupport.ScrollBarCustom;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.io.File;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class statisticsGUI extends javax.swing.JFrame {

    private int mousepX;
    private int mousepY;
    private common comvar = new common();
    private boolean showMenuNow = false;
    private HoaDonBUS HdBUS = new HoaDonBUS();
    private invoiceDetailBUS iDBUS = new invoiceDetailBUS();
    DefaultTableModel tblModelInvoice;
    DefaultTableModel tblModelInvoiceDetail;
    DefaultTableModel tblModelStatistics;
    private statisticsBUS stBUS = new statisticsBUS();
    ArrayList<statisticsDTO> stListCurrent;
    
    /* NHAN VIEN BAN HANG */
    DefaultTableModel model = new DefaultTableModel();
    ThongKeBUS bus = new ThongKeBUS();
    private String[] quater1 = {"2022-01-01", "2022-03-31"};
    private String[] quater2 = {"2022-04-01", "2022-06-30"};
    private String[] quater3 = {"2022-07-01", "2022-09-30"};
    private String[] quater4 = {"2022-10-01", "2022-12-31"};
    
//    private ArrayList<>

    public statisticsGUI() {
        initComponents();
        myInit();
        initTable();
        loadTableHd();
        loadTableIDetail();
        loadTableStatistics();
    }

    protected void myInit() {
        fixTable(jScrollPane1);
        fixTable(jScrollPane2);
        fixTable(jScrollPane3);
        fixTable(jScrollPane4);
        
        CreateHeader(allQuater());
        ThongKeFunt();
    }

    protected void initTable() {
        tblInvoice.setDefaultEditor(Object.class, null);
        tblModelInvoice = new DefaultTableModel();
        tblModelInvoice.setColumnIdentifiers(new String[]{"Mã hóa đơn", "Mã nhân viên", "Mã khách hàng", "Tổng tiền HĐ", "Thời gian"});
        tblInvoice.setModel(tblModelInvoice);

        tblInvoiceDetail.setDefaultEditor(Object.class, null);
        tblModelInvoiceDetail = new DefaultTableModel();
        tblModelInvoiceDetail.setColumnIdentifiers(new String[]{"Mã hóa đơn", "Mã kiểu", "Số lượng", "Tổng tiền"});
        tblInvoiceDetail.setModel(tblModelInvoiceDetail);

        tblStatistics.setDefaultEditor(Object.class, null);
        tblModelStatistics = new DefaultTableModel();
        tblModelStatistics.setColumnIdentifiers(new String[]{"Tháng", "SL Hóa đơn", "SL vé", "SL vé ECO", "SL vé BUS", "Tổng thu"});
        tblStatistics.setModel(tblModelStatistics);
    }

    private void loadTableStatistics() {
        stListCurrent = new ArrayList<>();
        statisticsDTO stDTO;
        String year = String.valueOf(yearSt.getSelectedItem());
        tblModelStatistics.setRowCount(0);
        int SLHoaDonTotal = 0;
        int SLVeTotal = 0;
        int SLVeECOTotal = 0;
        int SLVeBUSTotal = 0;
        long tongthuTotal = 0;
        for (int i = 1; i <= 12; i++) {
            String month;
            if (i < 10) {
                month = "0" + String.valueOf(i);
            } else {
                month = String.valueOf(i);
            }

            int SLHoaDon = stBUS.SLHoadon(month, year);
            SLHoaDonTotal += SLHoaDon;

            int SLVe = stBUS.SLVe(month, year);
            SLVeTotal += SLVe;

            int SLVeECO = stBUS.SLVeECO(month, year);
            SLVeECOTotal += SLVeECO;

            int SLVeBUS = stBUS.SLVeBUS(month, year);
            SLVeBUSTotal += SLVeBUS;

            long tongthu = stBUS.tongthu(month, year);
            tongthuTotal += tongthu;

            stDTO = new statisticsDTO(month, SLHoaDon, SLVe, SLVeECO, SLVeBUS, tongthu);
            stListCurrent.add(stDTO);

            String[] row = new String[]{
                month, String.valueOf(SLHoaDon), String.valueOf(SLVe), String.valueOf(SLVeECO), String.valueOf(SLVeBUS), formatDecimal(tongthu)
            };
            tblModelStatistics.addRow(row);
        }
        stDTO = new statisticsDTO("Tổng cộng", SLHoaDonTotal, SLVeTotal, SLVeECOTotal, SLVeBUSTotal, tongthuTotal);
        stListCurrent.add(stDTO);
        String[] lastRow = new String[]{
            "Tổng cộng", String.valueOf(SLHoaDonTotal), String.valueOf(SLVeTotal), String.valueOf(SLVeECOTotal), String.valueOf(SLVeBUSTotal), formatDecimal(tongthuTotal)
        };
        tblModelStatistics.addRow(lastRow);
        tblModelStatistics.fireTableDataChanged();
    }
    
    private void loadTableStatistics(ArrayList<statisticsDTO> stList) {
        tblModelStatistics.setRowCount(0);
        for (statisticsDTO st : stList) {
            String[] row = new String[]{
                st.getMonth(), String.valueOf(st.getSLHD()), String.valueOf(st.getSLVe()), String.valueOf(st.getSLVeECO()), String.valueOf(st.getSLVeBUS()), formatDecimal(st.getTongTien())
            };
            tblModelStatistics.addRow(row);
        }
        tblModelStatistics.fireTableDataChanged();
    }

    private void loadTableHd() {
        if (HdBUS.getList() == null) {
            HdBUS.list();
        }
        ArrayList<HoaDonDTO> HdList = HdBUS.getList();

        tblModelInvoice.setRowCount(0);
        for (HoaDonDTO hd : HdList) {
            String[] row = new String[]{
                hd.getInvoiceID(), hd.getStaffID(), hd.getCustomerID(), String.valueOf(hd.getInvoiceTotal()), hd.getInvoicedDateTime()
            };
            tblModelInvoice.addRow(row);
        }
        tblModelInvoice.fireTableDataChanged();
    }

    private void loadTableIDetail() {
        if (iDBUS.getList() == null) {
            iDBUS.getList2();
        }
        ArrayList<invoiceDetailDTO> iDList = iDBUS.getList();

        tblModelInvoiceDetail.setRowCount(0);
        for (invoiceDetailDTO iD : iDList) {
            String[] row = new String[]{
                iD.getInvoiceID(), iD.getTypeID(), String.valueOf(iD.getAmount()), formatDecimal(iD.getTotal())
            };
            tblModelInvoiceDetail.addRow(row);
        }
        tblModelInvoiceDetail.fireTableDataChanged();
    }

    private void loadTableIDetail(String month, String year) {
        ArrayList<invoiceDetailDTO> iDList = iDBUS.searchByMonthAndYear(month, year);

        tblModelInvoiceDetail.setRowCount(0);
        for (invoiceDetailDTO iD : iDList) {
            String[] row = new String[]{
                iD.getInvoiceID(), iD.getTypeID(), String.valueOf(iD.getAmount()), formatDecimal(iD.getTotal())
            };
            tblModelInvoiceDetail.addRow(row);
        }
        tblModelInvoiceDetail.fireTableDataChanged();
    }

    private void loadTableHd(String month, String year) {
        if (HdBUS.getList() == null) {
            HdBUS.list();
        }
        ArrayList<HoaDonDTO> HdList = HdBUS.searchByMonthAndYear(month, year);

        tblModelInvoice.setRowCount(0);
        for (HoaDonDTO hd : HdList) {
            String[] row = new String[]{
                hd.getInvoiceID(), hd.getStaffID(), hd.getCustomerID(), String.valueOf(hd.getInvoiceTotal()), hd.getInvoicedDateTime()
            };
            tblModelInvoice.addRow(row);
        }
        tblModelInvoice.fireTableDataChanged();
    }

    public String formatDecimal(float number) {
        Locale vn = new Locale("vn", "vn");
        NumberFormat swedishFormat = NumberFormat.getCurrencyInstance(vn);
        return swedishFormat.format(number);
    }
    
    public String formatDecimal(int number) {
        Locale vn = new Locale("vn", "vn");
        NumberFormat vnFormat = NumberFormat.getCurrencyInstance(vn);
        return vnFormat.format(number);
    }

    protected void fixTable(JScrollPane scroll) {
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        scroll.getVerticalScrollBar().setUnitIncrement(25);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0));
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(new Color(30, 30, 30));
        scroll.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 60), 2));

    }

//    public static void setCellsAlignment(JTable table, int alignment)
//    {
//        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
//        rightRenderer.setHorizontalAlignment(alignment);
//
//        TableModel tableModel = table.getModel();
//
//        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
//        {
//            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
//        }
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();
        btnHide = new javax.swing.JButton();
        btnFullScreen = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        mainMenu = new javax.swing.JPanel();
        showSubMenuPanel = new javax.swing.JPanel();
        showMenuLabel = new javax.swing.JLabel();
        subMenu = new javax.swing.JPanel();
        deletePanel2 = new javax.swing.JPanel();
        toSellTicket = new javax.swing.JButton();
        deletePanel3 = new javax.swing.JPanel();
        toAirplaneBtn = new javax.swing.JButton();
        deletePanel4 = new javax.swing.JPanel();
        toFlightBtn = new javax.swing.JButton();
        deletePanel5 = new javax.swing.JPanel();
        toFlightScheduleBtn = new javax.swing.JButton();
        homeFrameLabel = new javax.swing.JLabel();
        deletePanel7 = new javax.swing.JPanel();
        toTicketBtn = new javax.swing.JButton();
        deletePanel8 = new javax.swing.JPanel();
        toRouteBtn = new javax.swing.JButton();
        deletePanel9 = new javax.swing.JPanel();
        toStaffBtn = new javax.swing.JButton();
        deletePanel10 = new javax.swing.JPanel();
        toCustomerBtn = new javax.swing.JButton();
        deletePanel11 = new javax.swing.JPanel();
        toInvoiceBtn = new javax.swing.JButton();
        deletePanel13 = new javax.swing.JPanel();
        ToStatisticsBtn1 = new javax.swing.JButton();
        contentTabbedPane = new javax.swing.JTabbedPane();
        ticketPanel = new jpanelGradient();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInvoice = new TableDark();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblInvoiceDetail = new TableDark();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblStatistics = new TableDark();
        year2Table = new javax.swing.JComboBox<>();
        month2Table = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        reloadTablePanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        loadTableBtn6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        yearSt = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        exportExcelBtn = new javax.swing.JButton();
        importExcelBtn = new javax.swing.JButton();
        typePanel = new jpanelGradient();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl = new TableDark();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thống kê");
        setUndecorated(true);
        setSize(new java.awt.Dimension(0, 0));

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel4MouseDragged(evt);
            }
        });
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel4MousePressed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(0, 0, 0));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close_window_32px.png"))); // NOI18N
        btnClose.setBorder(null);
        btnClose.setBorderPainted(false);
        btnClose.setContentAreaFilled(false);
        btnClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClose.setOpaque(true);
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCloseMouseExited(evt);
            }
        });
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnHide.setBackground(new java.awt.Color(0, 0, 0));
        btnHide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/minus_32px.png"))); // NOI18N
        btnHide.setBorder(null);
        btnHide.setContentAreaFilled(false);
        btnHide.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHide.setIconTextGap(0);
        btnHide.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnHide.setOpaque(true);
        btnHide.setRolloverEnabled(false);
        btnHide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHideMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHideMouseExited(evt);
            }
        });
        btnHide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHideActionPerformed(evt);
            }
        });

        btnFullScreen.setBackground(new java.awt.Color(0, 0, 0));
        btnFullScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fullscreen_32px.png"))); // NOI18N
        btnFullScreen.setBorder(null);
        btnFullScreen.setBorderPainted(false);
        btnFullScreen.setContentAreaFilled(false);
        btnFullScreen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFullScreen.setIconTextGap(0);
        btnFullScreen.setOpaque(true);
        btnFullScreen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnFullScreenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnFullScreenMouseExited(evt);
            }
        });
        btnFullScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFullScreenActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("Thống kê");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1172, Short.MAX_VALUE)
                .addComponent(btnHide, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFullScreen, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnFullScreen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(btnHide, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClose, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel14.setLayout(new java.awt.BorderLayout());

        menu.setPreferredSize(new java.awt.Dimension(70, 100));
        menu.setLayout(new java.awt.BorderLayout());

        mainMenu.setBackground(new java.awt.Color(51, 51, 51));
        mainMenu.setPreferredSize(new java.awt.Dimension(70, 10));
        mainMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        showMenuLabel.setBackground(new java.awt.Color(51, 51, 51));
        showMenuLabel.setForeground(new java.awt.Color(51, 51, 51));
        showMenuLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/menu_48px.png"))); // NOI18N
        showMenuLabel.setText("a");
        showMenuLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        showMenuLabel.setOpaque(true);
        showMenuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMenuLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                showMenuLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                showMenuLabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout showSubMenuPanelLayout = new javax.swing.GroupLayout(showSubMenuPanel);
        showSubMenuPanel.setLayout(showSubMenuPanelLayout);
        showSubMenuPanelLayout.setHorizontalGroup(
            showSubMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showSubMenuPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(showMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        showSubMenuPanelLayout.setVerticalGroup(
            showSubMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showSubMenuPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(showMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainMenu.add(showSubMenuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, -1));

        menu.add(mainMenu, java.awt.BorderLayout.WEST);

        subMenu.setBackground(new java.awt.Color(102, 102, 102));
        subMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deletePanel2.setBackground(new java.awt.Color(51, 51, 51));

        toSellTicket.setBackground(new java.awt.Color(51, 51, 51));
        toSellTicket.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        toSellTicket.setForeground(new java.awt.Color(255, 204, 0));
        toSellTicket.setText("Bán vé");
        toSellTicket.setBorderPainted(false);
        toSellTicket.setContentAreaFilled(false);
        toSellTicket.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        toSellTicket.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toSellTicket.setOpaque(true);
        toSellTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                toSellTicketMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                toSellTicketMouseExited(evt);
            }
        });
        toSellTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toSellTicketActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deletePanel2Layout = new javax.swing.GroupLayout(deletePanel2);
        deletePanel2.setLayout(deletePanel2Layout);
        deletePanel2Layout.setHorizontalGroup(
            deletePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toSellTicket, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
        );
        deletePanel2Layout.setVerticalGroup(
            deletePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deletePanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(toSellTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        subMenu.add(deletePanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 177, -1));

        deletePanel3.setBackground(new java.awt.Color(51, 51, 51));

        toAirplaneBtn.setBackground(new java.awt.Color(51, 51, 51));
        toAirplaneBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        toAirplaneBtn.setForeground(new java.awt.Color(255, 204, 0));
        toAirplaneBtn.setText("Máy bay");
        toAirplaneBtn.setBorderPainted(false);
        toAirplaneBtn.setContentAreaFilled(false);
        toAirplaneBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        toAirplaneBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toAirplaneBtn.setOpaque(true);
        toAirplaneBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                toAirplaneBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                toAirplaneBtnMouseExited(evt);
            }
        });
        toAirplaneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toAirplaneBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deletePanel3Layout = new javax.swing.GroupLayout(deletePanel3);
        deletePanel3.setLayout(deletePanel3Layout);
        deletePanel3Layout.setHorizontalGroup(
            deletePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toAirplaneBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
        );
        deletePanel3Layout.setVerticalGroup(
            deletePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deletePanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(toAirplaneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        subMenu.add(deletePanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        deletePanel4.setBackground(new java.awt.Color(51, 51, 51));

        toFlightBtn.setBackground(new java.awt.Color(51, 51, 51));
        toFlightBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        toFlightBtn.setForeground(new java.awt.Color(255, 204, 0));
        toFlightBtn.setText("Chuyến bay");
        toFlightBtn.setBorderPainted(false);
        toFlightBtn.setContentAreaFilled(false);
        toFlightBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        toFlightBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toFlightBtn.setOpaque(true);
        toFlightBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                toFlightBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                toFlightBtnMouseExited(evt);
            }
        });
        toFlightBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toFlightBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deletePanel4Layout = new javax.swing.GroupLayout(deletePanel4);
        deletePanel4.setLayout(deletePanel4Layout);
        deletePanel4Layout.setHorizontalGroup(
            deletePanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toFlightBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
        );
        deletePanel4Layout.setVerticalGroup(
            deletePanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deletePanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(toFlightBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        subMenu.add(deletePanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 177, -1));

        deletePanel5.setBackground(new java.awt.Color(51, 51, 51));

        toFlightScheduleBtn.setBackground(new java.awt.Color(51, 51, 51));
        toFlightScheduleBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        toFlightScheduleBtn.setForeground(new java.awt.Color(255, 204, 0));
        toFlightScheduleBtn.setText("Lịch trình");
        toFlightScheduleBtn.setBorderPainted(false);
        toFlightScheduleBtn.setContentAreaFilled(false);
        toFlightScheduleBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        toFlightScheduleBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toFlightScheduleBtn.setOpaque(true);
        toFlightScheduleBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                toFlightScheduleBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                toFlightScheduleBtnMouseExited(evt);
            }
        });
        toFlightScheduleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toFlightScheduleBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deletePanel5Layout = new javax.swing.GroupLayout(deletePanel5);
        deletePanel5.setLayout(deletePanel5Layout);
        deletePanel5Layout.setHorizontalGroup(
            deletePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
            .addGroup(deletePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deletePanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(toFlightScheduleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        deletePanel5Layout.setVerticalGroup(
            deletePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(deletePanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deletePanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(toFlightScheduleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        subMenu.add(deletePanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 177, -1));

        homeFrameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home_50px.png"))); // NOI18N
        homeFrameLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeFrameLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeFrameLabelMouseClicked(evt);
            }
        });
        subMenu.add(homeFrameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 10, 50, 60));

        deletePanel7.setBackground(new java.awt.Color(51, 51, 51));

        toTicketBtn.setBackground(new java.awt.Color(51, 51, 51));
        toTicketBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        toTicketBtn.setForeground(new java.awt.Color(255, 204, 0));
        toTicketBtn.setText("Vé & loại vé");
        toTicketBtn.setBorderPainted(false);
        toTicketBtn.setContentAreaFilled(false);
        toTicketBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        toTicketBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toTicketBtn.setOpaque(true);
        toTicketBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                toTicketBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                toTicketBtnMouseExited(evt);
            }
        });
        toTicketBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toTicketBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deletePanel7Layout = new javax.swing.GroupLayout(deletePanel7);
        deletePanel7.setLayout(deletePanel7Layout);
        deletePanel7Layout.setHorizontalGroup(
            deletePanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toTicketBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
        );
        deletePanel7Layout.setVerticalGroup(
            deletePanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deletePanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(toTicketBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        subMenu.add(deletePanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 177, -1));

        deletePanel8.setBackground(new java.awt.Color(51, 51, 51));

        toRouteBtn.setBackground(new java.awt.Color(51, 51, 51));
        toRouteBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        toRouteBtn.setForeground(new java.awt.Color(255, 204, 0));
        toRouteBtn.setText("Lộ trình");
        toRouteBtn.setBorderPainted(false);
        toRouteBtn.setContentAreaFilled(false);
        toRouteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        toRouteBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toRouteBtn.setOpaque(true);
        toRouteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                toRouteBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                toRouteBtnMouseExited(evt);
            }
        });
        toRouteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toRouteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deletePanel8Layout = new javax.swing.GroupLayout(deletePanel8);
        deletePanel8.setLayout(deletePanel8Layout);
        deletePanel8Layout.setHorizontalGroup(
            deletePanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
            .addGroup(deletePanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deletePanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(toRouteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        deletePanel8Layout.setVerticalGroup(
            deletePanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(deletePanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deletePanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(toRouteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        subMenu.add(deletePanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 177, -1));

        deletePanel9.setBackground(new java.awt.Color(51, 51, 51));

        toStaffBtn.setBackground(new java.awt.Color(51, 51, 51));
        toStaffBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        toStaffBtn.setForeground(new java.awt.Color(255, 204, 0));
        toStaffBtn.setText("Nhân viên");
        toStaffBtn.setBorderPainted(false);
        toStaffBtn.setContentAreaFilled(false);
        toStaffBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        toStaffBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toStaffBtn.setOpaque(true);
        toStaffBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                toStaffBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                toStaffBtnMouseExited(evt);
            }
        });
        toStaffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toStaffBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deletePanel9Layout = new javax.swing.GroupLayout(deletePanel9);
        deletePanel9.setLayout(deletePanel9Layout);
        deletePanel9Layout.setHorizontalGroup(
            deletePanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
            .addGroup(deletePanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deletePanel9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(toStaffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        deletePanel9Layout.setVerticalGroup(
            deletePanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(deletePanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deletePanel9Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(toStaffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        subMenu.add(deletePanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 177, -1));

        deletePanel10.setBackground(new java.awt.Color(51, 51, 51));

        toCustomerBtn.setBackground(new java.awt.Color(51, 51, 51));
        toCustomerBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        toCustomerBtn.setForeground(new java.awt.Color(255, 204, 0));
        toCustomerBtn.setText("Khách hàng");
        toCustomerBtn.setBorderPainted(false);
        toCustomerBtn.setContentAreaFilled(false);
        toCustomerBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        toCustomerBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toCustomerBtn.setOpaque(true);
        toCustomerBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                toCustomerBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                toCustomerBtnMouseExited(evt);
            }
        });
        toCustomerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toCustomerBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deletePanel10Layout = new javax.swing.GroupLayout(deletePanel10);
        deletePanel10.setLayout(deletePanel10Layout);
        deletePanel10Layout.setHorizontalGroup(
            deletePanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
            .addGroup(deletePanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deletePanel10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(toCustomerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        deletePanel10Layout.setVerticalGroup(
            deletePanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(deletePanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deletePanel10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(toCustomerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        subMenu.add(deletePanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 177, -1));

        deletePanel11.setBackground(new java.awt.Color(51, 51, 51));

        toInvoiceBtn.setBackground(new java.awt.Color(51, 51, 51));
        toInvoiceBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        toInvoiceBtn.setForeground(new java.awt.Color(255, 204, 0));
        toInvoiceBtn.setText("Hóa đơn");
        toInvoiceBtn.setBorderPainted(false);
        toInvoiceBtn.setContentAreaFilled(false);
        toInvoiceBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        toInvoiceBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toInvoiceBtn.setOpaque(true);
        toInvoiceBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                toInvoiceBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                toInvoiceBtnMouseExited(evt);
            }
        });
        toInvoiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toInvoiceBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deletePanel11Layout = new javax.swing.GroupLayout(deletePanel11);
        deletePanel11.setLayout(deletePanel11Layout);
        deletePanel11Layout.setHorizontalGroup(
            deletePanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
            .addGroup(deletePanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deletePanel11Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(toInvoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        deletePanel11Layout.setVerticalGroup(
            deletePanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(deletePanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deletePanel11Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(toInvoiceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        subMenu.add(deletePanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 177, -1));

        deletePanel13.setBackground(new java.awt.Color(51, 51, 51));

        ToStatisticsBtn1.setBackground(new java.awt.Color(51, 51, 51));
        ToStatisticsBtn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ToStatisticsBtn1.setForeground(new java.awt.Color(255, 204, 0));
        ToStatisticsBtn1.setText("Chi tiết hóa đơn");
        ToStatisticsBtn1.setBorderPainted(false);
        ToStatisticsBtn1.setContentAreaFilled(false);
        ToStatisticsBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ToStatisticsBtn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ToStatisticsBtn1.setOpaque(true);
        ToStatisticsBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ToStatisticsBtn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ToStatisticsBtn1MouseExited(evt);
            }
        });
        ToStatisticsBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToStatisticsBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deletePanel13Layout = new javax.swing.GroupLayout(deletePanel13);
        deletePanel13.setLayout(deletePanel13Layout);
        deletePanel13Layout.setHorizontalGroup(
            deletePanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
            .addGroup(deletePanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deletePanel13Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(ToStatisticsBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        deletePanel13Layout.setVerticalGroup(
            deletePanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(deletePanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deletePanel13Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(ToStatisticsBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        subMenu.add(deletePanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 177, -1));

        menu.add(subMenu, java.awt.BorderLayout.CENTER);

        jPanel14.add(menu, java.awt.BorderLayout.WEST);

        contentTabbedPane.setBackground(new java.awt.Color(0, 153, 102));
        contentTabbedPane.setForeground(new java.awt.Color(255, 204, 0));
        contentTabbedPane.setDoubleBuffered(true);
        contentTabbedPane.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        contentTabbedPane.setInheritsPopupMenu(true);
        contentTabbedPane.setOpaque(true);
        contentTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                contentTabbedPaneStateChanged(evt);
            }
        });

        ticketPanel.setLayout(new java.awt.BorderLayout());

        jPanel8.setOpaque(false);

        tblInvoice.setBackground(new java.awt.Color(50, 50, 50));
        tblInvoice.setForeground(new java.awt.Color(200, 200, 200));
        tblInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblInvoice);

        tblInvoiceDetail.setBackground(new java.awt.Color(50, 50, 50));
        tblInvoiceDetail.setForeground(new java.awt.Color(200, 200, 200));
        tblInvoiceDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblInvoiceDetail);

        tblStatistics.setBackground(new java.awt.Color(50, 50, 50));
        tblStatistics.setForeground(new java.awt.Color(200, 200, 200));
        tblStatistics.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblStatistics);

        year2Table.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2022", "2023" }));
        year2Table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                year2TableActionPerformed(evt);
            }
        });

        month2Table.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        month2Table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                month2TableActionPerformed(evt);
            }
        });

        jLabel2.setText("Tháng:");

        jLabel3.setText("Năm:");

        reloadTablePanel6.setBackground(new java.awt.Color(0, 0, 0));

        jLabel10.setBackground(new java.awt.Color(102, 102, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh_28px.png"))); // NOI18N
        jLabel10.setOpaque(true);

        loadTableBtn6.setBackground(new java.awt.Color(0, 0, 0));
        loadTableBtn6.setForeground(new java.awt.Color(255, 255, 255));
        loadTableBtn6.setText("Load");
        loadTableBtn6.setContentAreaFilled(false);
        loadTableBtn6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loadTableBtn6.setOpaque(true);
        loadTableBtn6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loadTableBtn6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loadTableBtn6MouseExited(evt);
            }
        });
        loadTableBtn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadTableBtn6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout reloadTablePanel6Layout = new javax.swing.GroupLayout(reloadTablePanel6);
        reloadTablePanel6.setLayout(reloadTablePanel6Layout);
        reloadTablePanel6Layout.setHorizontalGroup(
            reloadTablePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reloadTablePanel6Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(loadTableBtn6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        reloadTablePanel6Layout.setVerticalGroup(
            reloadTablePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reloadTablePanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(reloadTablePanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(loadTableBtn6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Chi tiết hóa đơn");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Hóa đơn");

        jLabel13.setText("Năm:");

        yearSt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2022", "2023" }));
        yearSt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearStActionPerformed(evt);
            }
        });

        exportExcelBtn.setBackground(new java.awt.Color(255, 204, 0));
        exportExcelBtn.setText("Export Excel");
        exportExcelBtn.setContentAreaFilled(false);
        exportExcelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exportExcelBtn.setOpaque(true);
        exportExcelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exportExcelBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exportExcelBtnMouseExited(evt);
            }
        });
        exportExcelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportExcelBtnActionPerformed(evt);
            }
        });

        importExcelBtn.setBackground(new java.awt.Color(255, 204, 0));
        importExcelBtn.setText("Import Excel");
        importExcelBtn.setContentAreaFilled(false);
        importExcelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        importExcelBtn.setOpaque(true);
        importExcelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                importExcelBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                importExcelBtnMouseExited(evt);
            }
        });
        importExcelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importExcelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(month2Table, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(year2Table, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(reloadTablePanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(723, 723, 723)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(yearSt, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(importExcelBtn)
                        .addGap(18, 18, 18)
                        .addComponent(exportExcelBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1393, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(0, 19, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(year2Table, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(month2Table, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(reloadTablePanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearSt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(importExcelBtn)
                    .addComponent(exportExcelBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196))
        );

        ticketPanel.add(jPanel8, java.awt.BorderLayout.CENTER);

        contentTabbedPane.addTab("Doanh thu", ticketPanel);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel4.setText("Thống kê theo Quý");

        tbl.setBackground(new java.awt.Color(50, 50, 50));
        tbl.setForeground(new java.awt.Color(200, 200, 200));
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ));
        tbl.setToolTipText("");
        jScrollPane4.setViewportView(tbl);

        javax.swing.GroupLayout typePanelLayout = new javax.swing.GroupLayout(typePanel);
        typePanel.setLayout(typePanelLayout);
        typePanelLayout.setHorizontalGroup(
            typePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typePanelLayout.createSequentialGroup()
                .addGroup(typePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(typePanelLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel4))
                    .addGroup(typePanelLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(197, Short.MAX_VALUE))
        );
        typePanelLayout.setVerticalGroup(
            typePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typePanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(439, 439, 439))
        );

        contentTabbedPane.addTab("Nhân viên bán hàng", typePanel);

        jPanel14.add(contentTabbedPane, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel14, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1520, 799));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnFullScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFullScreenActionPerformed
        if (this.getExtendedState() != statisticsGUI.MAXIMIZED_BOTH) {
            setExtendedState(statisticsGUI.MAXIMIZED_BOTH);
        } else {
            this.setExtendedState(statisticsGUI.NORMAL);
            setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_btnFullScreenActionPerformed

    private void btnHideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHideActionPerformed
        setState(Frame.ICONIFIED);
    }//GEN-LAST:event_btnHideActionPerformed

    private void btnCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseEntered
        changecolor(btnClose, new Color(255, 43, 89));
    }//GEN-LAST:event_btnCloseMouseEntered

    private void btnCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseExited
        changecolor(btnClose, new Color(0, 0, 0));
    }//GEN-LAST:event_btnCloseMouseExited

    private void btnFullScreenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFullScreenMouseEntered
        changecolor(btnFullScreen, new Color(255, 43, 89));
    }//GEN-LAST:event_btnFullScreenMouseEntered

    private void btnFullScreenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFullScreenMouseExited
        changecolor(btnFullScreen, new Color(0, 0, 0));
    }//GEN-LAST:event_btnFullScreenMouseExited

    private void btnHideMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHideMouseEntered
        changecolor(btnHide, new Color(255, 43, 89));
    }//GEN-LAST:event_btnHideMouseEntered

    private void btnHideMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHideMouseExited
        changecolor(btnHide, new Color(0, 0, 0));
    }//GEN-LAST:event_btnHideMouseExited

    private void showMenuLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMenuLabelMouseEntered
        changecolor(showMenuLabel, new Color(255, 204, 0));
    }//GEN-LAST:event_showMenuLabelMouseEntered

    private void showMenuLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMenuLabelMouseExited
        changecolor(showMenuLabel, new Color(51, 51, 51));
    }//GEN-LAST:event_showMenuLabelMouseExited

    private void showMenuLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMenuLabelMouseClicked
        if (showMenuNow == true) {
            showSubMenuPanel.setBackground(new Color(51, 51, 51));
            showMenuLabel.setOpaque(true);
            showAndHide(menu, showMenuNow);
            SwingUtilities.updateComponentTreeUI(this);
            showMenuNow = false;
            fixTable(jScrollPane1);
            fixTable(jScrollPane2);
            fixTable(jScrollPane3);
            fixTable(jScrollPane4);
        } else {
            showMenuLabel.setOpaque(false);
            showSubMenuPanel.setBackground(new Color(255, 204, 0));

            showAndHide(menu, showMenuNow);
            SwingUtilities.updateComponentTreeUI(this);
            showMenuNow = true;
            fixTable(jScrollPane1);
            fixTable(jScrollPane2);
            fixTable(jScrollPane3);
            fixTable(jScrollPane4);
        }
    }//GEN-LAST:event_showMenuLabelMouseClicked

    private void contentTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_contentTabbedPaneStateChanged

    }//GEN-LAST:event_contentTabbedPaneStateChanged

    private void loadTableBtn6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadTableBtn6MouseEntered
        changecolor(loadTableBtn6, new Color(50, 50, 50));
    }//GEN-LAST:event_loadTableBtn6MouseEntered

    private void loadTableBtn6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadTableBtn6MouseExited
        changecolor(loadTableBtn6, new Color(0, 0, 0));
    }//GEN-LAST:event_loadTableBtn6MouseExited

    private void loadTableBtn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadTableBtn6ActionPerformed
        loadTableHd();
        loadTableIDetail();
    }//GEN-LAST:event_loadTableBtn6ActionPerformed

    private void yearStActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearStActionPerformed
        loadTableStatistics();
    }//GEN-LAST:event_yearStActionPerformed

    private void month2TableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_month2TableActionPerformed
        String month = String.valueOf(month2Table.getSelectedItem());
        String year = String.valueOf(year2Table.getSelectedItem());
        loadTableHd(month, year);
        loadTableIDetail(month, year);
    }//GEN-LAST:event_month2TableActionPerformed

    private void year2TableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_year2TableActionPerformed
        String month = String.valueOf(month2Table.getSelectedItem());
        String year = String.valueOf(year2Table.getSelectedItem());
        loadTableHd(month, year);
        loadTableIDetail(month, year);
    }//GEN-LAST:event_year2TableActionPerformed

    private void jPanel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseDragged
        int kordinatX = evt.getXOnScreen();
        int kordinatY = evt.getYOnScreen();
        this.setLocation(kordinatX - mousepX, kordinatY - mousepY);
    }//GEN-LAST:event_jPanel4MouseDragged

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
        mousepX = evt.getX();
        mousepY = evt.getY();
    }//GEN-LAST:event_jPanel4MousePressed

    private void exportExcelBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportExcelBtnMouseEntered
        changecolor(exportExcelBtn, new Color(200, 150, 0));
    }//GEN-LAST:event_exportExcelBtnMouseEntered

    private void exportExcelBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportExcelBtnMouseExited
        changecolor(exportExcelBtn, new Color(255, 204, 0));
    }//GEN-LAST:event_exportExcelBtnMouseExited

    private void exportExcelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportExcelBtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter excelFilter = new FileNameExtensionFilter("Excel", "xlsx", "xls");
        fileChooser.setFileFilter(excelFilter);
        fileChooser.setMultiSelectionEnabled(false);
        int x = fileChooser.showDialog(this, "Chọn file");

        if (x == JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();

            ArrayList<statisticsDTO> stList = stListCurrent;
            String excelFilePath = f.getAbsolutePath();
            try {
                stBUS.writeExcel(stList, excelFilePath);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            return;
        }
    }//GEN-LAST:event_exportExcelBtnActionPerformed

    private void importExcelBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importExcelBtnMouseEntered
        changecolor(importExcelBtn, new Color(200, 150, 0));
    }//GEN-LAST:event_importExcelBtnMouseEntered

    private void importExcelBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importExcelBtnMouseExited
        changecolor(importExcelBtn, new Color(255, 204, 0));
    }//GEN-LAST:event_importExcelBtnMouseExited

    private void importExcelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importExcelBtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter excelFilter = new FileNameExtensionFilter("Excel", "xlsx", "xls");
        fileChooser.setFileFilter(excelFilter);
        fileChooser.setMultiSelectionEnabled(false);
        int x = fileChooser.showDialog(this, "Chọn file");

        if (x == JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();
            String excelFilePath = f.getAbsolutePath();
            try {
                ArrayList<statisticsDTO> stListImport = new ArrayList<>();
                stListImport = stBUS.importExcel(excelFilePath);
                stListCurrent = stListImport;
                loadTableStatistics(stListImport);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else {
            return;
        }
    }//GEN-LAST:event_importExcelBtnActionPerformed

    private void toSellTicketMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toSellTicketMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_toSellTicketMouseEntered

    private void toSellTicketMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toSellTicketMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_toSellTicketMouseExited

    private void toSellTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toSellTicketActionPerformed
        BanVeGUI bv = new BanVeGUI();
        bv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_toSellTicketActionPerformed

    private void toAirplaneBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toAirplaneBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_toAirplaneBtnMouseEntered

    private void toAirplaneBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toAirplaneBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_toAirplaneBtnMouseExited

    private void toAirplaneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toAirplaneBtnActionPerformed
        AirplaneGUI bv = new AirplaneGUI();
        bv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_toAirplaneBtnActionPerformed

    private void toFlightBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toFlightBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_toFlightBtnMouseEntered

    private void toFlightBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toFlightBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_toFlightBtnMouseExited

    private void toFlightBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toFlightBtnActionPerformed
        ChuyenBayGUI bv = null;
        try {
            bv = new ChuyenBayGUI();
        } catch (Exception ex) {
            
        }
        bv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_toFlightBtnActionPerformed

    private void toFlightScheduleBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toFlightScheduleBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_toFlightScheduleBtnMouseEntered

    private void toFlightScheduleBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toFlightScheduleBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_toFlightScheduleBtnMouseExited

    private void toFlightScheduleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toFlightScheduleBtnActionPerformed
        flightScheduleGUI bv = new flightScheduleGUI();
        bv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_toFlightScheduleBtnActionPerformed

    private void homeFrameLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeFrameLabelMouseClicked
        MENU tk = new MENU();
        tk.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeFrameLabelMouseClicked

    private void toTicketBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toTicketBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_toTicketBtnMouseEntered

    private void toTicketBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toTicketBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_toTicketBtnMouseExited

    private void toTicketBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toTicketBtnActionPerformed
        ticketGUI bv = new ticketGUI();
        bv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_toTicketBtnActionPerformed

    private void toRouteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toRouteBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_toRouteBtnMouseEntered

    private void toRouteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toRouteBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_toRouteBtnMouseExited

    private void toRouteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toRouteBtnActionPerformed
        LoTrinhGUI bv = new LoTrinhGUI();
        bv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_toRouteBtnActionPerformed

    private void toStaffBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toStaffBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_toStaffBtnMouseEntered

    private void toStaffBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toStaffBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_toStaffBtnMouseExited

    private void toStaffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toStaffBtnActionPerformed
        NhanVienGUI bv = new NhanVienGUI();
        bv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_toStaffBtnActionPerformed

    private void toCustomerBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toCustomerBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_toCustomerBtnMouseEntered

    private void toCustomerBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toCustomerBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_toCustomerBtnMouseExited

    private void toCustomerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toCustomerBtnActionPerformed
        KhachHangGUI bv = new KhachHangGUI();
        bv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_toCustomerBtnActionPerformed

    private void toInvoiceBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toInvoiceBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_toInvoiceBtnMouseEntered

    private void toInvoiceBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toInvoiceBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_toInvoiceBtnMouseExited

    private void toInvoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toInvoiceBtnActionPerformed
        HoaDonGUI bv = null;
        try {
            bv = new HoaDonGUI();
        } catch (Exception ex) {
            
        }
        bv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_toInvoiceBtnActionPerformed

    private void ToStatisticsBtn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ToStatisticsBtn1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ToStatisticsBtn1MouseEntered

    private void ToStatisticsBtn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ToStatisticsBtn1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ToStatisticsBtn1MouseExited

    private void ToStatisticsBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToStatisticsBtn1ActionPerformed
        invoiceDetailGUI bv = new invoiceDetailGUI();
        bv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ToStatisticsBtn1ActionPerformed

    public void showAndHide(JPanel menu, boolean dashboard) {
        if (dashboard == true) {
            menu.setPreferredSize(new Dimension(70, menu.getHeight()));
        } else {
            menu.setPreferredSize(new Dimension(270, menu.getHeight()));
        }
    }

    public void changecolor(JButton hover, Color rand) {
        hover.setBackground(rand);
    }

    public void changecolor(JLabel hover, Color rand) {
        hover.setBackground(rand);
    }

    public void changecolor(JPanel hover, Color rand) {
        hover.setBackground(rand);
    }
    
    /* NHAN VIEN BAN HANG */
    
    private String[] allQuater() {
        String[] quy = {"Nhân viên", "Quý 1", "Quý 2", "Quý 3", "Quý 4", "Tổng cộng"};
        return quy;
    }
    
    public void ThongKeFunt() {
        ArrayList<ThongKeDTO> dtmp = bus.invoiceByTime();
        for (ThongKeDTO a : dtmp) {
            Vector data = new Vector();
            data.add(a.getID());
            data.add(a.getQuy1());
            data.add(a.getQuy2());
            data.add(a.getQuy3());
            data.add(a.getQuy4());
            data.add(a.getQuy1() + a.getQuy2() + a.getQuy3() + a.getQuy4());
            model.addRow(data);
//            a.Output();
        }
        tbl.setModel(model);
    }
    
    public void CreateHeader(String[] quater) {
        Vector header = new Vector();
        for (String str : quater) {
            header.add(str);
        }
        if (model.getRowCount() == 0) {
            model = new DefaultTableModel(header, 0);
        }
        tbl.setModel(model);
    }

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(statisticsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(statisticsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(statisticsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(statisticsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new statisticsGUI().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ToStatisticsBtn1;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnFullScreen;
    private javax.swing.JButton btnHide;
    private javax.swing.JTabbedPane contentTabbedPane;
    private javax.swing.JPanel deletePanel10;
    private javax.swing.JPanel deletePanel11;
    private javax.swing.JPanel deletePanel13;
    private javax.swing.JPanel deletePanel2;
    private javax.swing.JPanel deletePanel3;
    private javax.swing.JPanel deletePanel4;
    private javax.swing.JPanel deletePanel5;
    private javax.swing.JPanel deletePanel7;
    private javax.swing.JPanel deletePanel8;
    private javax.swing.JPanel deletePanel9;
    private javax.swing.JButton exportExcelBtn;
    private javax.swing.JLabel homeFrameLabel;
    private javax.swing.JButton importExcelBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton loadTableBtn6;
    private javax.swing.JPanel mainMenu;
    private javax.swing.JPanel menu;
    private javax.swing.JComboBox<String> month2Table;
    private javax.swing.JPanel reloadTablePanel6;
    private javax.swing.JLabel showMenuLabel;
    private javax.swing.JPanel showSubMenuPanel;
    private javax.swing.JPanel subMenu;
    private javax.swing.JTable tbl;
    private javax.swing.JTable tblInvoice;
    private javax.swing.JTable tblInvoiceDetail;
    private javax.swing.JTable tblStatistics;
    private javax.swing.JPanel ticketPanel;
    private javax.swing.JButton toAirplaneBtn;
    private javax.swing.JButton toCustomerBtn;
    private javax.swing.JButton toFlightBtn;
    private javax.swing.JButton toFlightScheduleBtn;
    private javax.swing.JButton toInvoiceBtn;
    private javax.swing.JButton toRouteBtn;
    private javax.swing.JButton toSellTicket;
    private javax.swing.JButton toStaffBtn;
    private javax.swing.JButton toTicketBtn;
    private javax.swing.JPanel typePanel;
    private javax.swing.JComboBox<String> year2Table;
    private javax.swing.JComboBox<String> yearSt;
    // End of variables declaration//GEN-END:variables
}
