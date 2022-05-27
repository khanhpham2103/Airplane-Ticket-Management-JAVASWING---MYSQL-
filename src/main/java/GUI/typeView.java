
package GUI;

import BUS.typeBUS;
import DTO.typeDTO;
import GUISupport.ScrollBarCustom;
import GUISupport.TableDark;
import GUISupport.jpanelGradient;
import java.awt.Color;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class typeView extends javax.swing.JFrame {
    private DefaultTableModel tblModelType;
    private typeBUS typBUS = new typeBUS();
    private common comm = new common();
    public typeView() {
        initComponents();
        myInit();
    }
    
    protected void myInit() {
        initTable();
        fixTable(jScrollPane1);
        loadTableType();
    }

    protected void initTable() {
        tblType.setDefaultEditor(Object.class, null);
        tblModelType = new DefaultTableModel();
        tblModelType.setColumnIdentifiers(new String[]{"Type Id", "Type Name", "Waitting Room", "Price"});
        tblType.setModel(tblModelType);

//        setCellsAlignment(tblTicket, SwingConstants.CENTER);
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new jpanelGradient();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblType = new TableDark();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("typeView");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Chọn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(tblType);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 410));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int row = tblType.getSelectedRow();
        if (row >= 0) {
            String str = tblType.getValueAt(row, 0).toString();
            common.typeId = str;
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Hãy chọn 1 dòng trong bảng");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    
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
//            java.util.logging.Logger.getLogger(typeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(typeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(typeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(typeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new typeView().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblType;
    // End of variables declaration//GEN-END:variables
}
