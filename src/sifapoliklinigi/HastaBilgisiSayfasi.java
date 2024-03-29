/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sifapoliklinigi;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sayid, Majd
 */
public class HastaBilgisiSayfasi extends javax.swing.JPanel {

    /**
     * Creates new form hastaBilgisiSayfasi
     */
    
    private Doktor doktor;
    private Gorevli gorevli;
    private Klinik klinik;
    private Hasta hasta;
    private Randevu randevu;
    private Muayene muayene;
    PostgreConnector postgresql = new PostgreConnector();
    private ArrayList<Randevu> randevular;
    
    
    public HastaBilgisiSayfasi(Doktor doktor) {
        this.doktor = doktor;
        this.randevular = doktor.getRandevular();
        initComponents();
        muayeneButon.setEnabled(false);
        
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
            // do some actions here, for example
            // print first column value from selected row
                muayeneButon.setEnabled(true);
            }
        
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        muayeneButon = new javax.swing.JButton();

        jTable1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Randevu No", "Hasta No", "Randevu Tarihi"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        muayeneButon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        muayeneButon.setText("Muayeneye Geç");
        muayeneButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                muayeneButonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(muayeneButon)
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(muayeneButon)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void muayeneButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_muayeneButonActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel Table = (DefaultTableModel)jTable1.getModel();
        int SelectedIndex = jTable1.getSelectedRow();
        
        int muayeneNo = Integer.parseInt(Table.getValueAt(SelectedIndex, 0).toString());
        long hastaNo = Long.parseLong(Table.getValueAt(SelectedIndex, 2).toString());
        
        hastaMuayenePaneli p = new hastaMuayenePaneli(this,hastaNo, this.doktor, randevular.get(jTable1.getSelectedRow()));
        p.updateTable();
        this.add(p);
        this.getParent().add(p);
        p.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_muayeneButonActionPerformed

    
    public void updateTableWithArray(){
        String[][] content = new String[randevular.size()][3];
        int i = 0;
        for(Randevu r: randevular){
            content[i][0] = Integer.toString(r.getRandevuNo());
            content[i][1] = r.getRandevuTarihi();
            content[i][2] = Long.toString(r.getHastaKimlikNo());
            i++;
        }
        DefaultTableModel df = new DefaultTableModel(content, new String [] {
                "Randevu No", "Randevu Tarihi", "Hasta No"
            });
        System.out.println("here");
        jTable1.setModel(df);
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton muayeneButon;
    // End of variables declaration//GEN-END:variables
}
