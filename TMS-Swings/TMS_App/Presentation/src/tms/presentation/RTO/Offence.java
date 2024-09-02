/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tms.presentation.RTO;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tms.business.RTOOperations;
import tms.business.impl.RTOOperationsImpl;
import tms.persistence.entity.OffenceDetailEO;
import tms.presentation.Clerk.ClerkPage;

/**
 *
 * @author bhagya.shree
 */
public class Offence extends javax.swing.JFrame {
    
    private final RTOOperations rto = new RTOOperationsImpl();

    /**
     * Creates new form offence
     */
    public Offence() {
        initComponents();
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
         setVisible(Boolean.TRUE);
    }
    
    private String regNo;
    public Offence(String regNo){
        this.regNo = regNo;
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
         setVisible(Boolean.TRUE);
         clear(regNo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCopClearOffence = new javax.swing.JPanel();
        labelClearOffenceByCop = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableViewHistoryToClearByRto = new javax.swing.JTable();
        btnClearOffence = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelClearOffenceByCop.setFont(new java.awt.Font("Times New Roman", 3, 40)); // NOI18N
        labelClearOffenceByCop.setForeground(new java.awt.Color(204, 0, 51));
        labelClearOffenceByCop.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelClearOffenceByCop.setText("Clear Offence");

        tableViewHistoryToClearByRto.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        tableViewHistoryToClearByRto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Select", "Sl No.", "Offence Detail ID", "Offence Date and Time", "Place", "Proof", "Registration Number", "Offence ID", "Recorded By", "Penalty Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableViewHistoryToClearByRto.setRowHeight(30);
        tableViewHistoryToClearByRto.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tableViewHistoryToClearByRto);

        btnClearOffence.setFont(new java.awt.Font("DejaVu Math TeX Gyre", 1, 20)); // NOI18N
        btnClearOffence.setText("Clear Offence");
        btnClearOffence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearOffenceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCopClearOffenceLayout = new javax.swing.GroupLayout(panelCopClearOffence);
        panelCopClearOffence.setLayout(panelCopClearOffenceLayout);
        panelCopClearOffenceLayout.setHorizontalGroup(
            panelCopClearOffenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCopClearOffenceLayout.createSequentialGroup()
                .addContainerGap(404, Short.MAX_VALUE)
                .addComponent(btnClearOffence)
                .addGap(367, 367, 367))
            .addComponent(labelClearOffenceByCop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelCopClearOffenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE))
        );
        panelCopClearOffenceLayout.setVerticalGroup(
            panelCopClearOffenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCopClearOffenceLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelClearOffenceByCop, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 519, Short.MAX_VALUE)
                .addComponent(btnClearOffence, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
            .addGroup(panelCopClearOffenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelCopClearOffenceLayout.createSequentialGroup()
                    .addGap(162, 162, 162)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(204, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCopClearOffence, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelCopClearOffence, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearOffenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearOffenceActionPerformed
        try {
            // TODO add your handling code here:
            ArrayList<OffenceDetailEO> details = rto.fetchAllOffencesCommited(regNo);
            int count = 0;
            int row = 0;
            
            for (OffenceDetailEO detail : details) {
                if (detail.getPenaltyStatus().equals("Unpaid")) {
                    boolean isSelected = (boolean) tableViewHistoryToClearByRto.getValueAt(row++, 0);
                if (isSelected) {
                    detail.setPenaltyStatus("Paid");
                    rto.clearOffense(detail);
                    count++;
                }
            }
        }
            if (count > 0) {
                System.out.println(count + " details updated..");
                JOptionPane.showMessageDialog(this, count + " details updated");
                clear(regNo);
                this.dispose();
            } else {
                System.out.println("No details found..!");
                JOptionPane.showMessageDialog(this, "No details found..!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(Offence.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Some error occurredwhile updating.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnClearOffenceActionPerformed

    private ArrayList<OffenceDetailEO> clear(String regNo) {

        ArrayList<OffenceDetailEO> details = new ArrayList<>();
        try {
            ArrayList<OffenceDetailEO> offDetails = rto.fetchAllOffencesCommited(regNo);
            DefaultTableModel model = (DefaultTableModel) tableViewHistoryToClearByRto.getModel();
            while (model.getRowCount() != 0) {
                model.removeRow(0);
            }
            int count = 1;
            for (OffenceDetailEO offenceDetailEO : offDetails) {
                if (offenceDetailEO.getPenaltyStatus().equals("Unpaid")) {
                    model.addRow(new Object[]{
                        false,
                        count,
                        offenceDetailEO.getOffenseDetailID(),
                        offenceDetailEO.getOffenseDateTime(),
                        offenceDetailEO.getPlace(),
                        offenceDetailEO.getImage(),
                        offenceDetailEO.getRegistration().getRegistrationID(),
                        offenceDetailEO.getOffense().getOffenseID(),
                        offenceDetailEO.getUser().getUserName(),
                        offenceDetailEO.getPenaltyStatus()
                    });
                    details.add(offenceDetailEO);
                    count++;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ClerkPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        return details;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Offence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Offence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Offence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Offence.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Offence().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearOffence;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelClearOffenceByCop;
    private javax.swing.JPanel panelCopClearOffence;
    private javax.swing.JTable tableViewHistoryToClearByRto;
    // End of variables declaration//GEN-END:variables
}
