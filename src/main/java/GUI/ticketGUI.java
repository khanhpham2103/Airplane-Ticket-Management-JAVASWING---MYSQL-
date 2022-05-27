package GUI;

import BUS.ticketBUS;
import BUS.typeBUS;
import DTO.ticketDTO;
import DTO.typeDTO;
import GUISupport.RoundJTextField;
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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class ticketGUI extends javax.swing.JFrame {

    private common comvar = new common();
    private boolean showMenuNow = false;
    private ticketBUS tBUS = new ticketBUS();
    private typeBUS typBUS = new typeBUS();
    DefaultTableModel tblModel;
    DefaultTableModel tblModelType;

    public ticketGUI() {
        initComponents();
        myInit();
        initTable();
        loadTable();
        loadTableType();
    }

    protected void myInit() {
        fixTable(jScrollPane1);
        fixTable(jScrollPane2);
        tblTicket.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblType.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        comvar.currentFrame = "ticketGUI";
//        addPanel.setVisible(false);
        //tabbed pane
//        contentTabbedPane.setForegroundAt(0, new Color(255,204,0));
//        contentTabbedPane.setForegroundAt(1, new Color(255,204,0));
    }

    protected void initTable() {
        tblTicket.setDefaultEditor(Object.class, null);
        tblModel = new DefaultTableModel();
        tblModel.setColumnIdentifiers(new String[]{"Ticket Id", "Customer Id", "Flight Id", "Type Id", "Invoice Id"});
        tblTicket.setModel(tblModel);

        tblType.setDefaultEditor(Object.class, null);
        tblModelType = new DefaultTableModel();
        tblModelType.setColumnIdentifiers(new String[]{"Type Id", "Type Name", "Waitting Room", "Price"});
        tblType.setModel(tblModelType);

//        setCellsAlignment(tblTicket, SwingConstants.CENTER);
    }

    private void loadTable() {
        if (tBUS.getList() == null) {
            tBUS.getList2();
        }
        tBUS.getList2();
        ArrayList<ticketDTO> tkList = tBUS.getList();

        tblModel.setRowCount(0);
        for (ticketDTO tk : tkList) {
            String[] row = new String[]{
                tk.getTicketID(), tk.getCustomerID(), tk.getFlightID(), tk.getTypeID(), tk.getInvoiceID()
            };
            tblModel.addRow(row);
        }
        tblModel.fireTableDataChanged();
    }

    private void loadTableType() {
        if (typBUS.getList() == null) {
            typBUS.getList2();
        }
        ArrayList<typeDTO> typeList = typBUS.getList();

        tblModelType.setRowCount(0);
        for (typeDTO type : typeList) {
            String[] row = new String[]{
                type.getTypeID(), type.getTypeName(), String.valueOf(type.getWaittingRoom()), formatDecimal(type.getTypePrice())
            };
            tblModelType.addRow(row);
        }
        tblModelType.fireTableDataChanged();
    }

    public String formatDecimal(float number) {
        Locale vn = new Locale("vn", "vn");
        NumberFormat swedishFormat = NumberFormat.getCurrencyInstance(vn);
        return swedishFormat.format(number);
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
        jLabel22 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        mainMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new RoundJTextField(15);
        btnSearch = new javax.swing.JButton();
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
        deletePanel14 = new javax.swing.JPanel();
        toHHKBtn = new javax.swing.JButton();
        deletePanel15 = new javax.swing.JPanel();
        toAirportBtn = new javax.swing.JButton();
        contentTabbedPane = new javax.swing.JTabbedPane();
        ticketPanel = new jpanelGradient();
        jPanel8 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtTicketId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCustomerId = new javax.swing.JTextField();
        txtTypeId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtFlightId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtInvoiceId = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        addPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        editPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        editBtn = new javax.swing.JButton();
        deletePanel = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JButton();
        reloadTablePanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        loadTableBtn = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTicket = new TableDark();
        exportExcelBtn = new javax.swing.JButton();
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
        txtTypeId1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTypeName = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtWaittingRoom = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblType = new TableDark();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý vé");
        setUndecorated(true);
        setSize(new java.awt.Dimension(0, 0));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

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

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 204, 0));
        jLabel22.setText("Vé và loại vé");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1051, Short.MAX_VALUE)
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
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel14.setLayout(new java.awt.BorderLayout());

        menu.setPreferredSize(new java.awt.Dimension(200, 100));
        menu.setLayout(new java.awt.BorderLayout());

        mainMenu.setBackground(new java.awt.Color(51, 51, 51));
        mainMenu.setPreferredSize(new java.awt.Dimension(200, 10));
        mainMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 204, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tìm kiếm ticket");
        jLabel1.setOpaque(true);
        mainMenu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 83, 200, 29));

        txtSearch.setForeground(new java.awt.Color(153, 153, 153));
        txtSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSearch.setText("SĐT Khách hàng/ticket id");
        txtSearch.setBorder(null);
        txtSearch.setEnabled(false);
        txtSearch.setName(""); // NOI18N
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        mainMenu.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 150, 32));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search_16px.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        mainMenu.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 40, 30));

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

        subMenu.add(deletePanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 177, -1));

        homeFrameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/home_50px.png"))); // NOI18N
        homeFrameLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeFrameLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeFrameLabelMouseClicked(evt);
            }
        });
        subMenu.add(homeFrameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 10, 50, 60));

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

        deletePanel14.setBackground(new java.awt.Color(51, 51, 51));

        toHHKBtn.setBackground(new java.awt.Color(51, 51, 51));
        toHHKBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        toHHKBtn.setForeground(new java.awt.Color(255, 204, 0));
        toHHKBtn.setText("Hãng hàng không");
        toHHKBtn.setBorderPainted(false);
        toHHKBtn.setContentAreaFilled(false);
        toHHKBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        toHHKBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toHHKBtn.setOpaque(true);
        toHHKBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                toHHKBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                toHHKBtnMouseExited(evt);
            }
        });
        toHHKBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toHHKBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deletePanel14Layout = new javax.swing.GroupLayout(deletePanel14);
        deletePanel14.setLayout(deletePanel14Layout);
        deletePanel14Layout.setHorizontalGroup(
            deletePanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
            .addGroup(deletePanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deletePanel14Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(toHHKBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        deletePanel14Layout.setVerticalGroup(
            deletePanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(deletePanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deletePanel14Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(toHHKBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        subMenu.add(deletePanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 177, -1));

        deletePanel15.setBackground(new java.awt.Color(51, 51, 51));

        toAirportBtn.setBackground(new java.awt.Color(51, 51, 51));
        toAirportBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        toAirportBtn.setForeground(new java.awt.Color(255, 204, 0));
        toAirportBtn.setText("Sân bay");
        toAirportBtn.setBorderPainted(false);
        toAirportBtn.setContentAreaFilled(false);
        toAirportBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        toAirportBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toAirportBtn.setOpaque(true);
        toAirportBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                toAirportBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                toAirportBtnMouseExited(evt);
            }
        });
        toAirportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toAirportBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deletePanel15Layout = new javax.swing.GroupLayout(deletePanel15);
        deletePanel15.setLayout(deletePanel15Layout);
        deletePanel15Layout.setHorizontalGroup(
            deletePanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
            .addGroup(deletePanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deletePanel15Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(toAirportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        deletePanel15Layout.setVerticalGroup(
            deletePanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(deletePanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(deletePanel15Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(toAirportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        subMenu.add(deletePanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, 177, -1));

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

        jPanel11.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Mã vé");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Mã Khách hàng");

        txtCustomerId.setEnabled(false);

        txtTypeId.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Mã loại vé");

        txtFlightId.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Mã chuyến bay");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mã hóa đơn");

        txtInvoiceId.setEnabled(false);

        jButton2.setText("...");
        jButton2.setAlignmentX(0.5F);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("...");
        jButton3.setAlignmentX(0.5F);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("...");
        jButton4.setAlignmentX(0.5F);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setText("...");
        jButton6.setAlignmentX(0.5F);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtInvoiceId, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtFlightId, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtTicketId, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addGap(64, 64, 64)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(txtCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(txtTypeId, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)))))
                .addContainerGap(410, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTicketId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFlightId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTypeId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(30, 30, 30)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtInvoiceId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setOpaque(false);

        addPanel.setBackground(new java.awt.Color(0, 153, 255));
        addPanel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setBackground(new java.awt.Color(153, 204, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/downloading_updates_28px.png"))); // NOI18N
        jLabel8.setOpaque(true);

        addBtn.setBackground(new java.awt.Color(0, 153, 255));
        addBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Thêm");
        addBtn.setBorder(null);
        addBtn.setBorderPainted(false);
        addBtn.setContentAreaFilled(false);
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addBtn.setOpaque(true);
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addBtnMouseExited(evt);
            }
        });
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addPanelLayout = new javax.swing.GroupLayout(addPanel);
        addPanel.setLayout(addPanelLayout);
        addPanelLayout.setHorizontalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPanelLayout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
        );
        addPanelLayout.setVerticalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
            .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        editPanel.setBackground(new java.awt.Color(255, 102, 102));

        jLabel9.setBackground(new java.awt.Color(255, 153, 153));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/settings_32px.png"))); // NOI18N
        jLabel9.setOpaque(true);

        editBtn.setBackground(new java.awt.Color(255, 102, 102));
        editBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBtn.setText("Sửa");
        editBtn.setBorderPainted(false);
        editBtn.setContentAreaFilled(false);
        editBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editBtn.setOpaque(true);
        editBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editBtnMouseExited(evt);
            }
        });
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editPanelLayout = new javax.swing.GroupLayout(editPanel);
        editPanel.setLayout(editPanelLayout);
        editPanelLayout.setHorizontalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPanelLayout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        editPanelLayout.setVerticalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(editBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        deletePanel.setBackground(new java.awt.Color(51, 51, 255));

        jLabel10.setBackground(new java.awt.Color(102, 102, 255));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/waste_28px.png"))); // NOI18N
        jLabel10.setOpaque(true);

        deleteBtn.setBackground(new java.awt.Color(51, 51, 255));
        deleteBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Xóa");
        deleteBtn.setBorderPainted(false);
        deleteBtn.setContentAreaFilled(false);
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteBtn.setOpaque(true);
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteBtnMouseExited(evt);
            }
        });
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deletePanelLayout = new javax.swing.GroupLayout(deletePanel);
        deletePanel.setLayout(deletePanelLayout);
        deletePanelLayout.setHorizontalGroup(
            deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deletePanelLayout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        deletePanelLayout.setVerticalGroup(
            deletePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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
                .addComponent(loadTableBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        reloadTablePanelLayout.setVerticalGroup(
            reloadTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(reloadTablePanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(reloadTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadTableBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(reloadTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(addPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(editPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(deletePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(400, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deletePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reloadTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        ticketPanel.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel13.setOpaque(false);

        jPanel5.setOpaque(false);

        jScrollPane1.setMaximumSize(new java.awt.Dimension(452, 402));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(452, 402));

        tblTicket.setBackground(new java.awt.Color(50, 50, 50));
        tblTicket.setForeground(new java.awt.Color(200, 200, 200));
        tblTicket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"5", "6", "7", "8"},
                {"1", "2", "3", "4"},
                {"9", "10", "11", "12"},
                {"13", "14", "151", "16"},
                {"17", "18", "19", "20"},
                {"21", "22", "23", "24"},
                {"4", "4", "4", "4"},
                {"6", "6", "4", "4"},
                {"4", "4", "4", "4"},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblTicket.setOpaque(false);
        tblTicket.setRowHeight(25);
        tblTicket.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblTicket.setShowGrid(false);
        tblTicket.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tblTicketFocusLost(evt);
            }
        });
        tblTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTicketMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTicket);

        exportExcelBtn.setBackground(new java.awt.Color(255, 204, 0));
        exportExcelBtn.setText("Xuất Excel");
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exportExcelBtn)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(298, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(exportExcelBtn)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        ticketPanel.add(jPanel13, java.awt.BorderLayout.PAGE_END);

        contentTabbedPane.addTab("Ticket", ticketPanel);

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
        jLabel14.setText("Mã kiểu");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Tên kiểu");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Phòng chờ");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Giá");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTypeName, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTypeId1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtWaittingRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(122, 122, 122)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deletePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(addPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deletePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTypeId1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTypeName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtWaittingRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jPanel2.setOpaque(false);

        jScrollPane2.setOpaque(false);

        tblType.setBackground(new java.awt.Color(50, 50, 50));
        tblType.setForeground(new java.awt.Color(200, 200, 200));
        tblType.setModel(new javax.swing.table.DefaultTableModel(
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
        tblType.setOpaque(false);
        tblType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTypeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblType);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(365, 365, 365))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );

        javax.swing.GroupLayout typePanelLayout = new javax.swing.GroupLayout(typePanel);
        typePanel.setLayout(typePanelLayout);
        typePanelLayout.setHorizontalGroup(
            typePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        typePanelLayout.setVerticalGroup(
            typePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(typePanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        contentTabbedPane.addTab("Type", typePanel);

        jPanel14.add(contentTabbedPane, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel14, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1501, 879));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        if (txtSearch.getText().equals("SĐT Khách hàng/ticket id")) {
            txtSearch.setText("");
            txtSearch.setForeground(new Color(0, 0, 0));
        }

    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        if (txtSearch.getText().equals("")) {
            txtSearch.setText("SĐT Khách hàng/ticket id");
            txtSearch.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtSearchFocusLost

    private void exportExcelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportExcelBtnActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter excelFilter = new FileNameExtensionFilter("Excel", "xlsx", "xls");
        fileChooser.setFileFilter(excelFilter);
        fileChooser.setMultiSelectionEnabled(false);
        int x = fileChooser.showDialog(this, "Chọn file");

        if (x == JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();

            if (tBUS.getList() == null) {
                tBUS.getList2();
            }
            tBUS.getList2();
            ArrayList<ticketDTO> tkList = tBUS.getList();
            String excelFilePath = f.getAbsolutePath();
            try {
                tBUS.writeExcel(tkList, excelFilePath);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            return;
        }
    }//GEN-LAST:event_exportExcelBtnActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnFullScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFullScreenActionPerformed
        if (this.getExtendedState() != ticketGUI.MAXIMIZED_BOTH) {
            setExtendedState(ticketGUI.MAXIMIZED_BOTH);
        } else {
            this.setExtendedState(ticketGUI.NORMAL);
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
        } else {
            showMenuLabel.setOpaque(false);
            showSubMenuPanel.setBackground(new Color(255, 204, 0));

            showAndHide(menu, showMenuNow);
            SwingUtilities.updateComponentTreeUI(this);
            showMenuNow = true;
            fixTable(jScrollPane1);
        }
    }//GEN-LAST:event_showMenuLabelMouseClicked

    private void addBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseEntered
        changecolor(addBtn, new Color(0, 150, 200));
    }//GEN-LAST:event_addBtnMouseEntered

    private void addBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseExited
        changecolor(addBtn, new Color(0, 153, 255));
    }//GEN-LAST:event_addBtnMouseExited

    private void editBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseEntered
        changecolor(editBtn, new Color(200, 100, 100));
    }//GEN-LAST:event_editBtnMouseEntered

    private void editBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseExited
        changecolor(editBtn, new Color(255, 102, 102));
    }//GEN-LAST:event_editBtnMouseExited

    private void deleteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseEntered
        changecolor(deleteBtn, new Color(50, 50, 200));
    }//GEN-LAST:event_deleteBtnMouseEntered

    private void deleteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseExited
        changecolor(deleteBtn, new Color(51, 51, 255));
    }//GEN-LAST:event_deleteBtnMouseExited

    private void exportExcelBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportExcelBtnMouseEntered
        changecolor(exportExcelBtn, new Color(200, 150, 0));
    }//GEN-LAST:event_exportExcelBtnMouseEntered

    private void exportExcelBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exportExcelBtnMouseExited
        changecolor(exportExcelBtn, new Color(255, 204, 0));
    }//GEN-LAST:event_exportExcelBtnMouseExited

    private void tblTicketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTicketMouseClicked
        int row = tblTicket.getSelectedRow();

        if (row >= 0) {
            String flightId = tblTicket.getValueAt(row, 2).toString();
            String customerId = tblTicket.getValueAt(row, 1).toString();
            String typeId = tblTicket.getValueAt(row, 3).toString();
            String invoiceId = tblTicket.getValueAt(row, 4).toString();

            txtTicketId.setText(tblTicket.getValueAt(row, 0).toString());
            txtCustomerId.setText(customerId);
            txtFlightId.setText(flightId);
            txtTypeId.setText(typeId);
            txtInvoiceId.setText(invoiceId);

            comvar.flightId = flightId;
            comvar.customerId = customerId;
            comvar.typeId = typeId;
            comvar.invoiceId = invoiceId;
        }
    }//GEN-LAST:event_tblTicketMouseClicked

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        if (tBUS.getList() == null) {
            tBUS.getList2();
        }

        String ticketId = txtTicketId.getText();
        String customerId = txtCustomerId.getText();
        String flightId = txtFlightId.getText();
        String typeId = txtTypeId.getText();
        String invoiceId = txtInvoiceId.getText();
        ticketDTO tkDTO = new ticketDTO(ticketId, customerId, flightId, typeId, invoiceId);
        if (tBUS.getList() == null) {
            tBUS.getList2();
        }
        ArrayList<ticketDTO> dsTicket = tBUS.getList();

        if (tBUS.checkTicketId(ticketId)) {
            JOptionPane.showMessageDialog(this, "Id đã tồn tại!!");
        } else if (ticketId.equals("") || customerId.equals("") || flightId.equals("") || typeId.equals("") || invoiceId.equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập đầy đủ các field!!");
        } else if (typeId.equals("ECO") && !tBUS.checkAmountECO(invoiceId)) {
            JOptionPane.showMessageDialog(this, "Vượt quá số lượng vé ECO trong hóa đơn!!");
            reSetTicket();
        } else if (typeId.equals("BUS") && !tBUS.checkAmountBUS(invoiceId)) {
            JOptionPane.showMessageDialog(this, "Vượt quá số lượng vé BUS trong hóa đơn!!");
            reSetTicket();
        } else if (!tBUS.checkInvoiceAndCustomer(invoiceId, customerId)) {
            JOptionPane.showMessageDialog(this, "Hóa đơn này không thuộc về " + customerId + "!!");
            reSetTicket();
        } else {

            tBUS.add(tkDTO);
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadTable();
            reSetTicket();
            comvar.resetCommonVariables();
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void tblTicketFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tblTicketFocusLost
        tblTicket.clearSelection();
    }//GEN-LAST:event_tblTicketFocusLost

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        if (tBUS.getList() == null) {
            tBUS.getList2();
        }

        String ticketId = txtTicketId.getText();
        String customerId = txtCustomerId.getText();
        String flightId = txtFlightId.getText();
        String typeId = txtTypeId.getText();
        String invoiceId = txtInvoiceId.getText();
        ticketDTO tk = new ticketDTO(ticketId, customerId, flightId, typeId, invoiceId);
        if (ticketId.equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy chọn/nhập mã cần sửa");
        } else if (!ticketId.equals("") && (customerId.equals("") || flightId.equals("") || typeId.equals("") || invoiceId.equals(""))) {
            JOptionPane.showMessageDialog(this, "Không được để trống field!!");
        } else if (!tBUS.checkTicketId(ticketId)) {
            JOptionPane.showMessageDialog(this, "Ticket Id không khớp!!");
        } else if (!typBUS.checkTypeId(typeId)) {
            JOptionPane.showMessageDialog(this, "Type id không khớp!!");
        } else if (typeId.equals("ECO") && !tBUS.checkAmountECO(invoiceId)) {
            JOptionPane.showMessageDialog(this, "Vượt quá số lượng vé ECO trong hóa đơn!!");
            reSetTicket();
        } else if (typeId.equals("BUS") && !tBUS.checkAmountBUS(invoiceId)) {
            JOptionPane.showMessageDialog(this, "Vượt quá số lượng vé BUS trong hóa đơn!!");
            reSetTicket();
        } else if (!tBUS.checkInvoiceAndCustomer(invoiceId, customerId)) {
            JOptionPane.showMessageDialog(this, "Hóa đơn này không thuộc về " + customerId + "!!");
            reSetTicket();
        } else {
            int i = JOptionPane.showConfirmDialog(null, "Xác nhận sửa vé với id = " + ticketId, "", JOptionPane.YES_NO_OPTION);
            if (i == 0) {

                //Upload sản phẩm lên DAO và BUS
                tBUS.set(tk);

                JOptionPane.showMessageDialog(null, "Sửa thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                loadTable();
                reSetTicket();
                comvar.resetCommonVariables();
            }
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        if (tBUS.getList() == null) {
            tBUS.getList2();
        }

        if (txtTicketId.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy chọn/nhập mã cần xóa");
        } else if (!tBUS.checkTicketId(txtTicketId.getText())) {
            JOptionPane.showMessageDialog(this, "Ticket Id không khớp!!");
        } else {
            String ticketId = txtTicketId.getText();
            int i = JOptionPane.showConfirmDialog(null, "Xác nhận xóa vé với id = " + ticketId, "", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                //Upload sản phẩm lên DAO và BUS
                tBUS.delete(ticketId);

                JOptionPane.showMessageDialog(null, "Xóa thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                loadTable();
                reSetTicket();
                comvar.resetCommonVariables();
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void addBtn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtn1MouseEntered
        changecolor(addBtn1, new Color(0, 150, 200));
    }//GEN-LAST:event_addBtn1MouseEntered

    private void addBtn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtn1MouseExited
        changecolor(addBtn1, new Color(0, 153, 255));
    }//GEN-LAST:event_addBtn1MouseExited

    private void addBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtn1ActionPerformed

        String typeID = txtTypeId1.getText();
        String typeName = txtTypeName.getText();
        int waittingRoom = 0;
        float price = 0;
        if (!comvar.isNumeric(txtWaittingRoom.getText()) || !comvar.isNumeric(txtPrice.getText())) {
            JOptionPane.showMessageDialog(this, "Input sai định dạng");
            reSetTicket();
            return;
        } else {
            waittingRoom = Integer.parseInt(txtWaittingRoom.getText());
            price = Float.parseFloat(txtPrice.getText());
        }
        typeDTO type = new typeDTO(typeID, typeName, waittingRoom, price);

        if (typBUS.getList() == null) {
            typBUS.getList2();
        }
        ArrayList<typeDTO> dsType = typBUS.getList();

        if (typBUS.checkTypeId(typeID)) {
            JOptionPane.showMessageDialog(this, "Id đã tồn tại!!");
        } else if (typeID.equals("") || typeName.equals("") || txtWaittingRoom.getText().equals("") || txtPrice.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập đầy đủ các field!!");
        } else if (typBUS.checkType(type)) {
            JOptionPane.showMessageDialog(this, "Type bị trùng!!");
        } else {
            typBUS.add(type);
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadTableType();
            reSetType();
        }
    }//GEN-LAST:event_addBtn1ActionPerformed

    private void editBtn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtn1MouseEntered
        changecolor(editBtn1, new Color(200, 100, 100));
    }//GEN-LAST:event_editBtn1MouseEntered

    private void editBtn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtn1MouseExited
        changecolor(editBtn1, new Color(255, 102, 102));
    }//GEN-LAST:event_editBtn1MouseExited

    private void editBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtn1ActionPerformed
        if (typBUS.getList() == null) {
            typBUS.getList2();
        }

        String typeID = txtTypeId1.getText();
        String typeName = txtTypeName.getText();

        if (typeID.equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy chọn/nhập mã cần sửa");
        } else if (!typeID.equals("") && (typeName.equals("") || txtWaittingRoom.getText().equals("") || txtPrice.getText().equals(""))) {
            JOptionPane.showMessageDialog(this, "Không được để trống field!!");
        } else if (!typBUS.checkTypeId(typeID)) {
            JOptionPane.showMessageDialog(this, "Type id không khớp!!");
        } else {
            int i = JOptionPane.showConfirmDialog(null, "Xác nhận sửa Type với id = " + typeID, "", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                int waittingRoom = 0;
                float price = 0;
                if (!comvar.isNumeric(txtWaittingRoom.getText()) || !comvar.isNumeric(txtPrice.getText())) {
                    JOptionPane.showMessageDialog(this, "Input sai định dạng");
                    reSetTicket();
                    return;
                } else {
                    waittingRoom = Integer.parseInt(txtWaittingRoom.getText());
                    price = Float.parseFloat(txtPrice.getText());
                }
                //Upload sản phẩm lên DAO và BUS
                typeDTO type = new typeDTO(typeID, typeName, waittingRoom, price);
                typBUS.set(type);
                JOptionPane.showMessageDialog(null, "Sửa thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                loadTableType();
                reSetType();
            }
        }
    }//GEN-LAST:event_editBtn1ActionPerformed

    private void deleteBtn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtn1MouseEntered
        changecolor(deleteBtn1, new Color(50, 50, 200));
    }//GEN-LAST:event_deleteBtn1MouseEntered

    private void deleteBtn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtn1MouseExited
        changecolor(deleteBtn1, new Color(51, 51, 255));
    }//GEN-LAST:event_deleteBtn1MouseExited

    private void deleteBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtn1ActionPerformed
        if (typBUS.getList() == null) {
            typBUS.getList2();
        }

        String typeID = txtTypeId1.getText();

        if (typeID.equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy chọn/nhập mã cần xóa");
        } else if (!typBUS.checkTypeId(typeID)) {
            JOptionPane.showMessageDialog(this, "Type Id không khớp!!");
        } else {

            int i = JOptionPane.showConfirmDialog(null, "Xác nhận xóa vé với id = " + typeID, "", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                //Upload sản phẩm lên DAO và BUS
                typBUS.delete(typeID);

                JOptionPane.showMessageDialog(null, "Xóa thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                loadTableType();
                reSetType();
            }
        }
    }//GEN-LAST:event_deleteBtn1ActionPerformed

    private void tblTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTypeMouseClicked
        int row = tblType.getSelectedRow();

        String price = tblType.getValueAt(row, 3).toString().substring(2).replace(",", "");

        if (row >= 0) {
            txtTypeId1.setText(tblType.getValueAt(row, 0).toString());
            txtTypeName.setText(tblType.getValueAt(row, 1).toString());
            txtWaittingRoom.setText(tblType.getValueAt(row, 2).toString());
            txtPrice.setText(price);
        }
    }//GEN-LAST:event_tblTypeMouseClicked

    private void contentTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_contentTabbedPaneStateChanged
        if (contentTabbedPane.getSelectedIndex() == 1) {
            txtSearch.setEnabled(false);
            btnSearch.setEnabled(false);
        } else if (contentTabbedPane.getSelectedIndex() == 0) {
            txtSearch.setEnabled(true);
            btnSearch.setEnabled(true);
        }
    }//GEN-LAST:event_contentTabbedPaneStateChanged

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (tBUS.getList() == null) {
            tBUS.getList2();
        }

        String tkId = txtSearch.getText();

        if (tkId.equals("SĐT Khách hàng/ticket id") || tkId.equals("")) {
            JOptionPane.showMessageDialog(null, "Hãy nhập SĐT Khách hàng/ticket id vào text field", "Search", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ArrayList<ticketDTO> tkSearchList = new ArrayList<>();
        tkSearchList = tBUS.searchTicketById(tkId);

        if (tkSearchList.size() != 0) {
            loadTableSearch(tkSearchList);
            return;
        } else {
            tkSearchList = tBUS.searchTicketByKhachHangPhone(tkId);
            if (tkSearchList.size() != 0) {
                loadTableSearch(tkSearchList);
            } else {
                JOptionPane.showMessageDialog(null, "Tìm hổng thấy!!", "Search", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void loadTableBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadTableBtnActionPerformed
        loadTable();
        txtSearch.setText("SĐT khách hàng/Mã vé");
        txtSearch.setForeground(new Color(153, 153, 153));
        comvar.resetCommonVariables();
        reSetTicket();
    }//GEN-LAST:event_loadTableBtnActionPerformed

    private void loadTableBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadTableBtnMouseEntered
        changecolor(loadTableBtn, new Color(50, 50, 50));
    }//GEN-LAST:event_loadTableBtnMouseEntered

    private void loadTableBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadTableBtnMouseExited
        changecolor(loadTableBtn, new Color(0, 0, 0));
    }//GEN-LAST:event_loadTableBtnMouseExited

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        flightView fView = new flightView();
        fView.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        typeView typView = new typeView();
        typView.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        customerView cusView = new customerView();
        cusView.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        invoiceView iView = new invoiceView();
        iView.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        txtTypeId.setText(comvar.typeId);
        txtCustomerId.setText(comvar.customerId);
        txtFlightId.setText(comvar.flightId);
        txtInvoiceId.setText(comvar.invoiceId);
    }//GEN-LAST:event_formWindowGainedFocus

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
            JOptionPane.showMessageDialog(this, "Error!");
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
            JOptionPane.showMessageDialog(this, "Error!");
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

    private void toHHKBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toHHKBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_toHHKBtnMouseEntered

    private void toHHKBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toHHKBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_toHHKBtnMouseExited

    private void toHHKBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toHHKBtnActionPerformed
        HHKhongGUI bv = new HHKhongGUI();
        bv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_toHHKBtnActionPerformed

    private void toAirportBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toAirportBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_toAirportBtnMouseEntered

    private void toAirportBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toAirportBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_toAirportBtnMouseExited

    private void toAirportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toAirportBtnActionPerformed
        SanBayGUI bv = new SanBayGUI();
        bv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_toAirportBtnActionPerformed

    public void loadTableSearch(ArrayList<ticketDTO> tkSearchList) {
        tblModel.setRowCount(0);
        for (ticketDTO tk : tkSearchList) {
            String[] row = new String[]{
                tk.getTicketID(), tk.getCustomerID(), tk.getFlightID(), tk.getTypeID(), tk.getInvoiceID()
            };
            tblModel.addRow(row);
        }
        tblModel.fireTableDataChanged();
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

    private void reSetTicket() {
        txtTicketId.setText("");
        txtCustomerId.setText("");
        txtFlightId.setText("");
        txtTypeId.setText("");
        txtInvoiceId.setText("");
    }

    private void reSetType() {
        txtTypeId1.setText("");
        txtTypeName.setText("");
        txtWaittingRoom.setText("");
        txtPrice.setText("");
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
//            java.util.logging.Logger.getLogger(ticketGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ticketGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ticketGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ticketGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ticketGUI().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ToStatisticsBtn;
    private javax.swing.JButton ToStatisticsBtn1;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton addBtn1;
    private javax.swing.JPanel addPanel;
    private javax.swing.JPanel addPanel1;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnFullScreen;
    private javax.swing.JButton btnHide;
    private javax.swing.JButton btnSearch;
    private javax.swing.JTabbedPane contentTabbedPane;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton deleteBtn1;
    private javax.swing.JPanel deletePanel;
    private javax.swing.JPanel deletePanel1;
    private javax.swing.JPanel deletePanel10;
    private javax.swing.JPanel deletePanel11;
    private javax.swing.JPanel deletePanel12;
    private javax.swing.JPanel deletePanel13;
    private javax.swing.JPanel deletePanel14;
    private javax.swing.JPanel deletePanel15;
    private javax.swing.JPanel deletePanel2;
    private javax.swing.JPanel deletePanel3;
    private javax.swing.JPanel deletePanel4;
    private javax.swing.JPanel deletePanel5;
    private javax.swing.JPanel deletePanel8;
    private javax.swing.JPanel deletePanel9;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton editBtn1;
    private javax.swing.JPanel editPanel;
    private javax.swing.JPanel editPanel1;
    private javax.swing.JButton exportExcelBtn;
    private javax.swing.JLabel homeFrameLabel;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton loadTableBtn;
    private javax.swing.JPanel mainMenu;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel reloadTablePanel;
    private javax.swing.JLabel showMenuLabel;
    private javax.swing.JPanel showSubMenuPanel;
    private javax.swing.JPanel subMenu;
    private javax.swing.JTable tblTicket;
    private javax.swing.JTable tblType;
    private javax.swing.JPanel ticketPanel;
    private javax.swing.JButton toAirplaneBtn;
    private javax.swing.JButton toAirportBtn;
    private javax.swing.JButton toCustomerBtn;
    private javax.swing.JButton toFlightBtn;
    private javax.swing.JButton toFlightScheduleBtn;
    private javax.swing.JButton toHHKBtn;
    private javax.swing.JButton toInvoiceBtn;
    private javax.swing.JButton toRouteBtn;
    private javax.swing.JButton toSellTicket;
    private javax.swing.JButton toStaffBtn;
    private javax.swing.JTextField txtCustomerId;
    private javax.swing.JTextField txtFlightId;
    private javax.swing.JTextField txtInvoiceId;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTicketId;
    private javax.swing.JTextField txtTypeId;
    private javax.swing.JTextField txtTypeId1;
    private javax.swing.JTextField txtTypeName;
    private javax.swing.JTextField txtWaittingRoom;
    private javax.swing.JPanel typePanel;
    // End of variables declaration//GEN-END:variables
}
