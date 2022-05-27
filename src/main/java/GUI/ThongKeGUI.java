/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.HoaDonBUS;
import BUS.NhanVienBUS;
import BUS.ThongKeBUS;
import DTO.HoaDonDTO;
import DTO.NhanVienDTO;
import DTO.ThongKeDTO;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PHAM PHU KHANH
 */
public class ThongKeGUI extends javax.swing.JFrame {

    /**
     * Creates new form ThongKeGUI
     */
    public ThongKeGUI() {
        initComponents();
        CreateHeader(allQuater());
//        statByQuaters();
        ThongKeFunt();
        setLocationRelativeTo(null);
    }
    
    private String[] allQuater() {
        String[] quy = {"Nhân viên", "Quý 1", "Quý 2", "Quý 3", "Quý 4", "Tổng cộng"};
        return quy;
    }
//    private boolean quaterIsEmpty(String quater[]) {
//        if(bus.invoiceByTime(quater).size()==0){
//            System.out.println("Empty");
//            return true;
//        }
//        return false;
//    }
//    private Vector addToVector(Vector v, String[] quater) {
//        for (HoaDonDTO hd : bus.invoiceByTime(quater)) {
//            v.add(hd.getInvoiceTotal());
//        }
//        return v;
//    }

//    private void statByQuaters() {
////        Vector data;
//        NhanVienBUS busnv = new NhanVienBUS();
//        busnv.list();
////        ArrayList<HoaDonDTO> dsdtohd = bus.invoiceByTime(quater2);
//
//        for (int i = 0; i < dsdtohd.size(); i++) {
////            if(i==4) break;
//            Vector data;
//            NhanVienDTO dtotmp = busnv.get(dsdtohd.get(i).getStaffID());
//            data = new Vector();
//            data.add(dsdtohd.get(i).getStaffID() + dtotmp.getStaffLast() + " " + dtotmp.getStaffFirst());
//            data.add(dsdtohd.get(i).getInvoiceTotal());
//            model.addRow(data);
////            data.add(staff);
////            System.out.println(dsdtohd.get(0).getInvoiceTotal());
////            for(HoaDonDTO hd : dsdtohd ){
////                System.out.println(hd.getStaffID());
//////                if(hd.getStaffID().equals(staff.substring(0,4))){
//////                    System.out.println(hd.getInvoiceTotal());
//////                    data.add(hd.getInvoiceTotal());
//////                }
//////                else{}
////            }
////            model.addRow(data);
//        }
//        if (model.getRowCount() == 0) {
//            CreateHeader(allQuater());
//        }
////        tbl.getModel().setValueAt("Test", , 1);
//        tbl.setModel(model);
//    }
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infomationPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        quaterLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jScrollPane2.setViewportView(tbl);

        quaterLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("Thống kê theo Quý");

        javax.swing.GroupLayout infomationPanelLayout = new javax.swing.GroupLayout(infomationPanel);
        infomationPanel.setLayout(infomationPanelLayout);
        infomationPanelLayout.setHorizontalGroup(
            infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infomationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infomationPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(163, 163, 163)
                        .addComponent(quaterLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(511, 511, 511))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        infomationPanelLayout.setVerticalGroup(
            infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infomationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infomationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quaterLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infomationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infomationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(ThongKeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ThongKeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ThongKeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ThongKeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ThongKeGUI().setVisible(true);
//            }
//        });
//    }
    DefaultTableModel model = new DefaultTableModel();
    ThongKeBUS bus = new ThongKeBUS();
    private String[] quater1 = {"2022-01-01", "2022-03-31"};
    private String[] quater2 = {"2022-04-01", "2022-06-30"};
    private String[] quater3 = {"2022-07-01", "2022-09-30"};
    private String[] quater4 = {"2022-10-01", "2022-12-31"};
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel infomationPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel quaterLabel;
    private javax.swing.JTable tbl;
    // End of variables declaration//GEN-END:variables
}