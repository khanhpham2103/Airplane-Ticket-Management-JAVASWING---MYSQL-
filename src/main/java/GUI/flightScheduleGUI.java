package GUI;

import BUS.flightScheduleBUS;
import DTO.flightScheduleDTO;
import GUISupport.RoundJTextField;
import GUISupport.TableDark;
import GUISupport.jpanelGradient;
import GUISupport.ScrollBarCustom;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class flightScheduleGUI extends javax.swing.JFrame {

    private boolean showMenuNow = false;
    private flightScheduleBUS fSBUS = new flightScheduleBUS();
//    private common comvar = new common();
    private common comvar;
    DefaultTableModel tblModelFlightSchedule;

    public flightScheduleGUI() {
        initComponents();
        myInit();
        initTable();
        loadTable();
    }

    protected void myInit() {
        fixTable(jScrollPane2);
        tblFlightSchedule.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    protected void initTable() {
        tblFlightSchedule.setDefaultEditor(Object.class, null);
        tblModelFlightSchedule = new DefaultTableModel();
        tblModelFlightSchedule.setColumnIdentifiers(new String[]{"Mã lịch trình", "Nơi đi", "Nơi đến", "Ngày", "Giờ"});
//        tblFlightSchedule.setOpaque(false);
        tblFlightSchedule.setModel(tblModelFlightSchedule);

//        setCellsAlignment(tblTicket, SwingConstants.CENTER);
    }

    private void loadTable() {
        if (fSBUS.getList() == null) {
            fSBUS.getList2();
        }
        ArrayList<flightScheduleDTO> fSList = fSBUS.getList();

        tblModelFlightSchedule.setRowCount(0);
        for (flightScheduleDTO fS : fSList) {
            String[] row = new String[]{
                fS.getFlightScheduleID(), fS.getDepartureAirport(), fS.getArrivalAirport(), fS.getWeekdays(), fS.getTime()
            };
            tblModelFlightSchedule.addRow(row);
        }
        tblModelFlightSchedule.fireTableDataChanged();
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
        jLabel24 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        mainMenu = new javax.swing.JPanel();
        showSubMenuPanel = new javax.swing.JPanel();
        showMenuLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new RoundJTextField(15);
        btnSearch = new javax.swing.JButton();
        subMenu = new javax.swing.JPanel();
        deletePanel2 = new javax.swing.JPanel();
        toSellTicket = new javax.swing.JButton();
        deletePanel3 = new javax.swing.JPanel();
        toAirplaneBtn = new javax.swing.JButton();
        deletePanel4 = new javax.swing.JPanel();
        toFlightBtn = new javax.swing.JButton();
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
        deletePanel12 = new javax.swing.JPanel();
        ToStatisticsBtn = new javax.swing.JButton();
        deletePanel13 = new javax.swing.JPanel();
        ToStatisticsBtn1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        typePanel = new jpanelGradient();
        jPanel1 = new javax.swing.JPanel();
        editPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        editBtn1 = new javax.swing.JButton();
        addPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        addBtn1 = new javax.swing.JButton();
        deletePanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        deleteBtn1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtFlightScheduleID = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtDepartureAirport = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtArrivalAirport = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        reloadTablePanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        loadTableBtn = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        hour = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        minute = new javax.swing.JComboBox<>();
        comboBoxWeekdays = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFlightSchedule = new TableDark();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý vé");
        setUndecorated(true);
        setSize(new java.awt.Dimension(0, 0));

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

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

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 204, 0));
        jLabel24.setText("Lịch trình");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1056, Short.MAX_VALUE)
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
                    .addComponent(btnClose, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel14.setLayout(new java.awt.BorderLayout());

        menu.setPreferredSize(new java.awt.Dimension(200, 100));
        menu.setLayout(new java.awt.BorderLayout());

        mainMenu.setBackground(new java.awt.Color(51, 51, 51));
        mainMenu.setPreferredSize(new java.awt.Dimension(200, 10));
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
                .addComponent(showMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        showSubMenuPanelLayout.setVerticalGroup(
            showSubMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, showSubMenuPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(showMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainMenu.add(showSubMenuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 50, -1));

        jLabel1.setBackground(new java.awt.Color(255, 204, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tìm kiếm lịch trình");
        jLabel1.setOpaque(true);
        mainMenu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 83, 200, 29));

        txtSearch.setForeground(new java.awt.Color(153, 153, 153));
        txtSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSearch.setText("CN, 2, 3, 4 ...");
        txtSearch.setBorder(null);
        txtSearch.setName(""); // NOI18N
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        mainMenu.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 160, 32));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search_16px.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        mainMenu.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 40, 30));

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

        subMenu.add(deletePanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 177, -1));

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

        subMenu.add(deletePanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 177, -1));

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

        subMenu.add(deletePanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 177, -1));

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

        subMenu.add(deletePanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 177, -1));

        deletePanel12.setBackground(new java.awt.Color(51, 51, 51));

        ToStatisticsBtn.setBackground(new java.awt.Color(51, 51, 51));
        ToStatisticsBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ToStatisticsBtn.setForeground(new java.awt.Color(255, 204, 0));
        ToStatisticsBtn.setText("Thống kê");
        ToStatisticsBtn.setBorderPainted(false);
        ToStatisticsBtn.setContentAreaFilled(false);
        ToStatisticsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ToStatisticsBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ToStatisticsBtn.setOpaque(true);
        ToStatisticsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ToStatisticsBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ToStatisticsBtnMouseExited(evt);
            }
        });
        ToStatisticsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ToStatisticsBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deletePanel12Layout = new javax.swing.GroupLayout(deletePanel12);
        deletePanel12.setLayout(deletePanel12Layout);
        deletePanel12Layout.setHorizontalGroup(
            deletePanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
            .addGroup(deletePanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deletePanel12Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(ToStatisticsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        deletePanel12Layout.setVerticalGroup(
            deletePanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(deletePanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deletePanel12Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(ToStatisticsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        subMenu.add(deletePanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 177, -1));

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

        subMenu.add(deletePanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 177, -1));

        menu.add(subMenu, java.awt.BorderLayout.CENTER);

        jPanel14.add(menu, java.awt.BorderLayout.WEST);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel1.setOpaque(false);

        editPanel1.setBackground(new java.awt.Color(255, 102, 102));

        jLabel12.setBackground(new java.awt.Color(255, 153, 153));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/settings_32px.png"))); // NOI18N
        jLabel12.setOpaque(true);

        editBtn1.setBackground(new java.awt.Color(255, 102, 102));
        editBtn1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editBtn1.setForeground(new java.awt.Color(255, 255, 255));
        editBtn1.setText("Sửa");
        editBtn1.setBorderPainted(false);
        editBtn1.setContentAreaFilled(false);
        editBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBtn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editBtn1.setOpaque(true);
        editBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editBtn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editBtn1MouseExited(evt);
            }
        });
        editBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editPanel1Layout = new javax.swing.GroupLayout(editPanel1);
        editPanel1.setLayout(editPanel1Layout);
        editPanel1Layout.setHorizontalGroup(
            editPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPanel1Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(editBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        editPanel1Layout.setVerticalGroup(
            editPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(editBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        addPanel1.setBackground(new java.awt.Color(0, 153, 255));
        addPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setBackground(new java.awt.Color(153, 204, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/downloading_updates_28px.png"))); // NOI18N
        jLabel11.setOpaque(true);

        addBtn1.setBackground(new java.awt.Color(0, 153, 255));
        addBtn1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addBtn1.setForeground(new java.awt.Color(255, 255, 255));
        addBtn1.setText("Thêm");
        addBtn1.setBorder(null);
        addBtn1.setBorderPainted(false);
        addBtn1.setContentAreaFilled(false);
        addBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBtn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addBtn1.setOpaque(true);
        addBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addBtn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addBtn1MouseExited(evt);
            }
        });
        addBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addPanel1Layout = new javax.swing.GroupLayout(addPanel1);
        addPanel1.setLayout(addPanel1Layout);
        addPanel1Layout.setHorizontalGroup(
            addPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPanel1Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(addBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        addPanel1Layout.setVerticalGroup(
            addPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(addPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        deletePanel1.setBackground(new java.awt.Color(51, 51, 255));

        jLabel13.setBackground(new java.awt.Color(102, 102, 255));
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/waste_28px.png"))); // NOI18N
        jLabel13.setOpaque(true);

        deleteBtn1.setBackground(new java.awt.Color(51, 51, 255));
        deleteBtn1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        deleteBtn1.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn1.setText("Xóa");
        deleteBtn1.setBorderPainted(false);
        deleteBtn1.setContentAreaFilled(false);
        deleteBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteBtn1.setOpaque(true);
        deleteBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteBtn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteBtn1MouseExited(evt);
            }
        });
        deleteBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deletePanel1Layout = new javax.swing.GroupLayout(deletePanel1);
        deletePanel1.setLayout(deletePanel1Layout);
        deletePanel1Layout.setHorizontalGroup(
            deletePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deletePanel1Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(deleteBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        deletePanel1Layout.setVerticalGroup(
            deletePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deletePanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(deletePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Mã lịch trình");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Nơi đi");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Nơi đến");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Ngày trong tuần");

        reloadTablePanel.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh_28px.png"))); // NOI18N
        jLabel3.setOpaque(true);

        loadTableBtn.setBackground(new java.awt.Color(0, 0, 0));
        loadTableBtn.setForeground(new java.awt.Color(255, 255, 255));
        loadTableBtn.setText("Load");
        loadTableBtn.setContentAreaFilled(false);
        loadTableBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loadTableBtn.setOpaque(true);
        loadTableBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loadTableBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loadTableBtnMouseExited(evt);
            }
        });
        loadTableBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadTableBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout reloadTablePanelLayout = new javax.swing.GroupLayout(reloadTablePanel);
        reloadTablePanel.setLayout(reloadTablePanelLayout);
        reloadTablePanelLayout.setHorizontalGroup(
            reloadTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reloadTablePanelLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(loadTableBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        reloadTablePanelLayout.setVerticalGroup(
            reloadTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reloadTablePanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(reloadTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(loadTableBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Giờ:");

        hour.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        hour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hourActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Phút:");

        minute.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));

        comboBoxWeekdays.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chủ nhật", "Thứ hai", "Thứ ba", "Thứ tư", "Thứ năm", "Thứ sáu", "Thứ bảy" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDepartureAirport, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(txtFlightScheduleID, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(txtArrivalAirport, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(comboBoxWeekdays, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hour, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deletePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reloadTablePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minute, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(reloadTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFlightScheduleID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(addPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deletePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDepartureAirport, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtArrivalAirport, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxWeekdays, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 29, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(minute, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(26, Short.MAX_VALUE))))
        );

        jPanel2.setOpaque(false);

        jScrollPane2.setOpaque(false);

        tblFlightSchedule.setBackground(new java.awt.Color(50, 50, 50));
        tblFlightSchedule.setForeground(new java.awt.Color(200, 200, 200));
        tblFlightSchedule.setModel(new javax.swing.table.DefaultTableModel(
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
        tblFlightSchedule.setOpaque(false);
        tblFlightSchedule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFlightScheduleMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblFlightSchedule);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(406, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout typePanelLayout = new javax.swing.GroupLayout(typePanel);
        typePanel.setLayout(typePanelLayout);
        typePanelLayout.setHorizontalGroup(
            typePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        typePanelLayout.setVerticalGroup(
            typePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typePanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.add(typePanel, java.awt.BorderLayout.CENTER);

        jPanel14.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel14, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1501, 764));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        if (txtSearch.getText().equals("CN, 2, 3, 4 ...")) {
            txtSearch.setText("");
            txtSearch.setForeground(new Color(0, 0, 0));
        }

    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText().equals("")) {
            txtSearch.setText("CN, 2, 3, 4 ...");
            txtSearch.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtSearchFocusLost

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
            fixTable(jScrollPane2);
        } else {
            showMenuLabel.setOpaque(false);
            showSubMenuPanel.setBackground(new Color(255, 204, 0));

            showAndHide(menu, showMenuNow);
            SwingUtilities.updateComponentTreeUI(this);
            showMenuNow = true;
            fixTable(jScrollPane2);
        }
    }//GEN-LAST:event_showMenuLabelMouseClicked

    private void tblFlightScheduleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFlightScheduleMouseClicked
        int row = tblFlightSchedule.getSelectedRow();

        String price = tblFlightSchedule.getValueAt(row, 3).toString().substring(2).replace(",", "");

        if (row >= 0) {
            txtFlightScheduleID.setText(tblFlightSchedule.getValueAt(row, 0).toString());
            txtDepartureAirport.setText(tblFlightSchedule.getValueAt(row, 1).toString());
            txtArrivalAirport.setText(tblFlightSchedule.getValueAt(row, 2).toString());
            comboBoxWeekdays.setSelectedItem(String.valueOf(tblFlightSchedule.getValueAt(row, 3)));
            hour.setSelectedItem(String.valueOf(tblFlightSchedule.getValueAt(row, 4)).split(":")[0]);
            minute.setSelectedItem(String.valueOf(tblFlightSchedule.getValueAt(row, 4)).split(":")[1]);
        }
    }//GEN-LAST:event_tblFlightScheduleMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (fSBUS.getList() == null) {
            fSBUS.getList2();
        }

        String weekday = txtSearch.getText();
        switch (weekday) {
            case "CN":
                weekday = "Chủ nhật";
                break;
            case "cn":
                weekday = "Chủ nhật";
                break;
            case "2":
                weekday = "Thứ hai";
                break;
            case "3":
                weekday = "Thứ ba";
                break;
            case "4":
                weekday = "Thứ tư";
                break;
            case "5":
                weekday = "Thứ năm";
                break;
            case "6":
                weekday = "Thứ sáu";
                break;
            case "7":
                weekday = "thứ bảy";
                break;    
            default:
                weekday = "";
        }

        if (weekday.equals("CN, 2, 3, 4 ...") || weekday.equals("")) {
            JOptionPane.showMessageDialog(null, "Hãy nhập một ngày trong tuần vào text field", "Search", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ArrayList<flightScheduleDTO> fSSearchList = new ArrayList<>();
        fSSearchList = fSBUS.searchWeekdays(weekday);

        if (!fSSearchList.isEmpty()) {
            loadTableSearch(fSSearchList);
        } else {
            JOptionPane.showMessageDialog(null, "Tìm hổng thấy!!", "Search", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void hourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hourActionPerformed

    private void loadTableBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadTableBtnActionPerformed
        loadTable();
    }//GEN-LAST:event_loadTableBtnActionPerformed

    private void loadTableBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadTableBtnMouseExited
        changecolor(loadTableBtn, new Color(0, 0, 0));
    }//GEN-LAST:event_loadTableBtnMouseExited

    private void loadTableBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadTableBtnMouseEntered
        changecolor(loadTableBtn, new Color(50, 50, 50));
    }//GEN-LAST:event_loadTableBtnMouseEntered

    private void deleteBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtn1ActionPerformed
        if (fSBUS.getList() == null) {
            fSBUS.getList2();
        }

        String flightScheduleID = txtFlightScheduleID.getText();

        if (flightScheduleID.equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy chọn/nhập mã cần xóa");
        } else if (!fSBUS.checkfSId(flightScheduleID)){
            JOptionPane.showMessageDialog(this, "Không thể xóa vì mã lịch trình không tồn tại!");
        } else {

            int i = JOptionPane.showConfirmDialog(null, "Xác nhận xóa lịch trình này?", "Xóa", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                //Upload sản phẩm lên DAO và BUS
                fSBUS.delete(flightScheduleID);

                JOptionPane.showMessageDialog(null, "Xóa thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                loadTable();
                resetfSInput();
            }
        }
    }//GEN-LAST:event_deleteBtn1ActionPerformed

    private void deleteBtn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtn1MouseExited
        changecolor(deleteBtn1, new Color(51, 51, 255));
    }//GEN-LAST:event_deleteBtn1MouseExited

    private void deleteBtn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtn1MouseEntered
        changecolor(deleteBtn1, new Color(50, 50, 200));
    }//GEN-LAST:event_deleteBtn1MouseEntered

    private void addBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtn1ActionPerformed

        String flightScheduleID = txtFlightScheduleID.getText();
        String departureAirport = txtDepartureAirport.getText();
        String arrivalAirport = txtArrivalAirport.getText();
        String weekdays = String.valueOf(comboBoxWeekdays.getSelectedItem());
        String time = String.valueOf(hour.getSelectedItem()) + ":" + String.valueOf(minute.getSelectedItem()) + ":00";

        flightScheduleDTO fS = new flightScheduleDTO(flightScheduleID, departureAirport, arrivalAirport, weekdays, time);

        if (fSBUS.getList() == null) {
            fSBUS.getList2();
        }

        if (flightScheduleID.equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập mã lịch trình!!");
        }
        else if (fSBUS.checkfSId(flightScheduleID)) {
            JOptionPane.showMessageDialog(this, "Mã lịch trình đã tồn tại!!");
        } else if (fSBUS.checkFS(weekdays, time, departureAirport, arrivalAirport)) {
            JOptionPane.showMessageDialog(this, "Lịch trình đã tồn tại");
        } else if (departureAirport.equals("") || flightScheduleID.equals("") || arrivalAirport.equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập đầy đủ các field!!");
        } else if (!fSBUS.checkDep(departureAirport)){
            JOptionPane.showMessageDialog(this, "Hãy nhập đúng mã nơi đi!");
        } else if (!fSBUS.checkArri(arrivalAirport)){
            JOptionPane.showMessageDialog(this, "Hãy nhập đúng mã nơi đến!");
        }
        else {
            fSBUS.add(fS);
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadTable();
            resetfSInput();
        }
    }//GEN-LAST:event_addBtn1ActionPerformed

    private void addBtn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtn1MouseExited
        changecolor(addBtn1, new Color(0, 153, 255));
    }//GEN-LAST:event_addBtn1MouseExited

    private void addBtn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtn1MouseEntered
        changecolor(addBtn1, new Color(0, 150, 200));
    }//GEN-LAST:event_addBtn1MouseEntered

    private void editBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtn1ActionPerformed
        if (fSBUS.getList() == null) {
            fSBUS.getList2();
        }

        String flightScheduleID = txtFlightScheduleID.getText();
        String departureAirport = txtDepartureAirport.getText();
        String arrivalAirport = txtArrivalAirport.getText();
        String weekdays = String.valueOf(comboBoxWeekdays.getSelectedItem());
        String time = String.valueOf(hour.getSelectedItem()) + ":" + String.valueOf(minute.getSelectedItem()) + ":00";

        if (flightScheduleID.equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy chọn/nhập mã cần sửa");
        } else if (departureAirport.equals("") || arrivalAirport.equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống field!!");
        } else if (!fSBUS.checkfSId(flightScheduleID)) {
            JOptionPane.showMessageDialog(this, "Mã lịch trình không tồn tại để sửa!!");
        } else if (fSBUS.checkFS(weekdays, time, departureAirport, arrivalAirport)) {
            JOptionPane.showMessageDialog(this, "Item đã tồn tại!!");
        } else if (!fSBUS.checkDep(departureAirport)){
            JOptionPane.showMessageDialog(this, "Hãy nhập đúng mã nơi đi!");
        } else if (!fSBUS.checkArri(arrivalAirport)){
            JOptionPane.showMessageDialog(this, "Hãy nhập đúng mã nơi đến!");
        } else {
            int i = JOptionPane.showConfirmDialog(null, "Xác nhận sửa item?", "Sửa", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                //Upload sản phẩm lên DAO và BUS
                flightScheduleDTO fSDTO = new flightScheduleDTO(flightScheduleID, departureAirport, arrivalAirport, weekdays, time);
                fSBUS.set(fSDTO);
                JOptionPane.showMessageDialog(null, "Sửa thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                loadTable();
                resetfSInput();
            }
        }
    }//GEN-LAST:event_editBtn1ActionPerformed

    private void editBtn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtn1MouseExited
        changecolor(editBtn1, new Color(255, 102, 102));
    }//GEN-LAST:event_editBtn1MouseExited

    private void editBtn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtn1MouseEntered
        changecolor(editBtn1, new Color(200, 100, 100));
    }//GEN-LAST:event_editBtn1MouseEntered

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

    private void ToStatisticsBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ToStatisticsBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ToStatisticsBtnMouseEntered

    private void ToStatisticsBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ToStatisticsBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ToStatisticsBtnMouseExited

    private void ToStatisticsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ToStatisticsBtnActionPerformed
        statisticsGUI bv = new statisticsGUI();
        bv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ToStatisticsBtnActionPerformed

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

    public void loadTableSearch(ArrayList<flightScheduleDTO> tkSearchList) {
        tblModelFlightSchedule.setRowCount(0);
        for (flightScheduleDTO fS : tkSearchList) {
            String[] row = new String[]{
                fS.getFlightScheduleID(), fS.getDepartureAirport(), fS.getArrivalAirport(), fS.getWeekdays(), fS.getTime()
            };
            tblModelFlightSchedule.addRow(row);
        }
        tblModelFlightSchedule.fireTableDataChanged();
    }

    public void showAndHide(JPanel menu, boolean dashboard) {
        if (dashboard == true) {
            menu.setPreferredSize(new Dimension(200, menu.getHeight()));
        } else {
            menu.setPreferredSize(new Dimension(400, menu.getHeight()));
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

    private void resetfSInput() {
        txtFlightScheduleID.setText("");
        txtDepartureAirport.setText("");
        txtArrivalAirport.setText("");
        comboBoxWeekdays.setSelectedIndex(0);
        hour.setSelectedIndex(0);
        minute.setSelectedIndex(0);
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
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new flightScheduleGUI().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ToStatisticsBtn;
    private javax.swing.JButton ToStatisticsBtn1;
    private javax.swing.JButton addBtn1;
    private javax.swing.JPanel addPanel1;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnFullScreen;
    private javax.swing.JButton btnHide;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> comboBoxWeekdays;
    private javax.swing.JButton deleteBtn1;
    private javax.swing.JPanel deletePanel1;
    private javax.swing.JPanel deletePanel10;
    private javax.swing.JPanel deletePanel11;
    private javax.swing.JPanel deletePanel12;
    private javax.swing.JPanel deletePanel13;
    private javax.swing.JPanel deletePanel2;
    private javax.swing.JPanel deletePanel3;
    private javax.swing.JPanel deletePanel4;
    private javax.swing.JPanel deletePanel7;
    private javax.swing.JPanel deletePanel8;
    private javax.swing.JPanel deletePanel9;
    private javax.swing.JButton editBtn1;
    private javax.swing.JPanel editPanel1;
    private javax.swing.JLabel homeFrameLabel;
    private javax.swing.JComboBox<String> hour;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton loadTableBtn;
    private javax.swing.JPanel mainMenu;
    private javax.swing.JPanel menu;
    private javax.swing.JComboBox<String> minute;
    private javax.swing.JPanel reloadTablePanel;
    private javax.swing.JLabel showMenuLabel;
    private javax.swing.JPanel showSubMenuPanel;
    private javax.swing.JPanel subMenu;
    private javax.swing.JTable tblFlightSchedule;
    private javax.swing.JButton toAirplaneBtn;
    private javax.swing.JButton toCustomerBtn;
    private javax.swing.JButton toFlightBtn;
    private javax.swing.JButton toInvoiceBtn;
    private javax.swing.JButton toRouteBtn;
    private javax.swing.JButton toSellTicket;
    private javax.swing.JButton toStaffBtn;
    private javax.swing.JButton toTicketBtn;
    private javax.swing.JTextField txtArrivalAirport;
    private javax.swing.JTextField txtDepartureAirport;
    private javax.swing.JTextField txtFlightScheduleID;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JPanel typePanel;
    // End of variables declaration//GEN-END:variables
}
