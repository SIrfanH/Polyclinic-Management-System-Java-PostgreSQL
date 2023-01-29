/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sifapoliklinigi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;

/**
 *
 * @author sayid
 */
public class HastaRandevuSayfasi extends javax.swing.JPanel {

    /**
     * Creates new form hastaRandevuSayfasi
     */
    
    private Gorevli gorevli;
    private Hasta hasta;
    private Randevu randevu;
    private Muayene muayene;
    PostgreConnector postgresql = new PostgreConnector();
    
    
    public HastaRandevuSayfasi() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        randevuHastaKimlikTextField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        randevuHastaKlinikComboBox = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        randevuHastaSaatComboBox = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        randevuHastaTarihComboBox = new javax.swing.JComboBox<>();
        randevuHastaDoktorComboBox = new javax.swing.JComboBox<>();
        randevuVerButon = new javax.swing.JButton();

        randevuHastaKimlikTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Hastanın Kimlik Numarası");

        randevuHastaKlinikComboBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        randevuHastaKlinikComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz" }));
        randevuHastaKlinikComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randevuHastaKlinikComboBoxActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Klinik");

        randevuHastaSaatComboBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        randevuHastaSaatComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz" }));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Doktor");

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("Tarih");

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setText("Saat");

        randevuHastaTarihComboBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        randevuHastaTarihComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz" }));
        randevuHastaTarihComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randevuHastaTarihComboBoxActionPerformed(evt);
            }
        });

        randevuHastaDoktorComboBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        randevuHastaDoktorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz" }));
        randevuHastaDoktorComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randevuHastaDoktorComboBoxActionPerformed(evt);
            }
        });

        randevuVerButon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        randevuVerButon.setText("Randevu Ver");
        randevuVerButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randevuVerButonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(randevuHastaDoktorComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(randevuHastaKimlikTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(randevuHastaKlinikComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(randevuVerButon)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(randevuHastaSaatComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(randevuHastaTarihComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(335, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(randevuHastaKimlikTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(12, 12, 12)
                .addComponent(randevuHastaKlinikComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(randevuHastaDoktorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(randevuHastaTarihComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(randevuHastaSaatComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(randevuVerButon)
                .addContainerGap(47, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void randevuHastaKlinikComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randevuHastaKlinikComboBoxActionPerformed
        // TODO add your handling code here:
        randevuHastaDoktorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz" }));
        updateRandevuDoktorComboBox();
    }//GEN-LAST:event_randevuHastaKlinikComboBoxActionPerformed

    private void randevuHastaTarihComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randevuHastaTarihComboBoxActionPerformed
        // TODO add your handling code here:
        randevuHastaSaatComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz" }));
        updateRandevuSaatComboBox();
    }//GEN-LAST:event_randevuHastaTarihComboBoxActionPerformed

    private void randevuHastaDoktorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randevuHastaDoktorComboBoxActionPerformed
        // TODO add your handling code here:
        randevuHastaTarihComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz" }));
        updateRandevuTarihComboBox();
    }//GEN-LAST:event_randevuHastaDoktorComboBoxActionPerformed

    private void randevuVerButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randevuVerButonActionPerformed
        // TODO add your handling code here:
        int randevuNo = 1;

        if (checkComponents()) {
            long hastaKimlikNo = Long.parseLong(randevuHastaKimlikTextField.getText());
            String klinikNo = randevuHastaKlinikComboBox.getSelectedItem().toString().split(" ")[0];
            String doktorAd = randevuHastaDoktorComboBox.getSelectedItem().toString().split(" ")[0];
            String doktorSoyad = randevuHastaDoktorComboBox.getSelectedItem().toString().split(" ")[1];
            String tarih = randevuHastaTarihComboBox.getSelectedItem().toString();
            String saat = randevuHastaSaatComboBox.getSelectedItem().toString();
            int durum = 0;

            Connection con = postgresql.getInstance();

            try {
                Statement stmt = con.createStatement();
                String komut;
                komut = String.format("Select nextval('RANDEVU_NO_GENERATOR')");
                ResultSet rs = stmt.executeQuery(komut);

                if (rs.next()) {
                    randevuNo = Integer.valueOf(rs.getString("nextval"));
                }
                System.out.println("Burada");

                komut = String.format("select *from kayitli_hastalar where HASTA_NO = %s", hastaKimlikNo);
                rs = stmt.executeQuery(komut);

                if (rs.next()) {
                    durum = 1;
                }
                System.out.println("Burada");

                komut = String.format("select DOKTOR_NO from doktorlar where DOKTOR_AD = '%s' and DOKTOR_SOYAD = '%s'", doktorAd, doktorSoyad);
                rs = stmt.executeQuery(komut);

                if (rs.next()) {
                    long doktorNo = Long.parseLong(rs.getString("DOKTOR_NO"));
                    randevu = new Randevu(randevuNo, hastaKimlikNo, doktorNo, Integer.parseInt(klinikNo), tarih, saat, durum);
                    if (durum == 1) {
                        randevu.veriTabaninaIsle();
                        String message = String.format("Randevu Oluşturuldu, Randevu No %d\n", randevuNo);
                        JOptionPane.showMessageDialog(this, message);
                    } else {
                        randevu.veriTabaninaIsle();
                        String message = String.format("Randevu Oluşturuldu, Randevu No %d\n" + "Hastanın Kaydı Yok", randevuNo);
                        JOptionPane.showMessageDialog(this, message);
                        System.out.println("Randevu Verildi");
                    }
                }
            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("SQL EXception");
                JOptionPane.showMessageDialog(this, "Randevu Oluşturulamadı");
            }
            randevuHastaKimlikTextField.setText("");
            randevuHastaKlinikComboBox.setSelectedIndex(0);
            randevuHastaTarihComboBox.setSelectedIndex(0);
            randevuHastaSaatComboBox.setSelectedIndex(0);
        }else{
            System.out.println("bos alan");
            JOptionPane.showMessageDialog(this, "Hata Oluştu, Boş Alanları Doldurunuz");
        }

    }//GEN-LAST:event_randevuVerButonActionPerformed

    public void updateRandevuDoktorComboBox(){
        if (randevuHastaKlinikComboBox.getSelectedIndex() != 0) {

            Connection con = postgresql.getInstance();
            String klinikNo = randevuHastaKlinikComboBox.getSelectedItem().toString().split(" ")[0];
            randevuHastaDoktorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Seçiniz"}));
            try {
                Statement stmt = con.createStatement();
                String Komut;
                Komut = String.format("Select *from doktorlar where DOKTOR_KLINIK_NO = %s", klinikNo);
                ResultSet rs = stmt.executeQuery(Komut);

                while (rs.next()) {
                    randevuHastaDoktorComboBox.addItem(rs.getString("DOKTOR_AD") + ' ' + rs.getString("DOKTOR_SOYAD"));
                }
            } catch (SQLException e) {
                System.out.println(e);
                System.out.println("SQL EXception");
            }
        }
    }

    public void updateRandevuSaatComboBox() {
        if (randevuHastaTarihComboBox.getSelectedIndex() != 0) {

            Connection con = postgresql.getInstance();
            LocalTime time = LocalTime.of(9, 0);
            String date = randevuHastaTarihComboBox.getSelectedItem().toString();
            String doktorAd = randevuHastaDoktorComboBox.getSelectedItem().toString().split(" ")[0];
            String doktorSoyad = randevuHastaDoktorComboBox.getSelectedItem().toString().split(" ")[1];
            randevuHastaSaatComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Seçiniz"}));

            for (int i = 0; i <= 15; i++) {
                if (i != 0) {
                    time = time.plusMinutes(30);
                }
                String dateTime = date.concat(" " + time.toString());
                System.out.println(date);

                try {
                    Statement stmt = con.createStatement();
                    String Komut;
                    Komut = String.format("Select *from doktorlar d, randevular r where d.DOKTOR_NO = r.DOKTOR_NO and "
                            + " r.RANDEVU_TARIHI = '%s' and d.DOKTOR_AD = '%s' and d.DOKTOR_SOYAD = '%s'", dateTime, doktorAd, doktorSoyad);
                    ResultSet rs = stmt.executeQuery(Komut);

                    if (rs.next()) {
                        continue;
                    }
                    randevuHastaSaatComboBox.addItem(time.toString());
                } catch (SQLException e) {
                    System.out.println(e);
                    System.out.println("SQL EXception");
                }
            }
        }
    }
    
    public void updateRandevuTarihComboBox(){
        if (randevuHastaDoktorComboBox.getSelectedIndex() != 0) {
            LocalDate date = LocalDate.now();
            randevuHastaTarihComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Seçiniz"}));
            for (int i = 1; i <= 7; i++) {
                randevuHastaTarihComboBox.addItem(date.plusDays(i).toString());
            }
        }
    }
    
    public void updateRandevuKlinikComboBox(){
        Connection con = postgresql.getInstance(); 
        randevuHastaKlinikComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçiniz" }));
        try{       
            Statement stmt=con.createStatement(); 
            String Komut;
            Komut = String.format("Select *from klinikler");
            ResultSet rs = stmt.executeQuery(Komut);
            
            while (rs.next()) {
                randevuHastaKlinikComboBox.addItem(rs.getString("KLINIK_NO")+' '+rs.getString("KLINIK_AD"));
            }
        }catch(SQLException e){ 
            System.out.println(e);
            System.out.println("SQL EXception");
        }
    }
    
    public boolean checkComponents(){
        return !randevuHastaKimlikTextField.getText().equals("") && randevuHastaKlinikComboBox.getSelectedIndex() != 0 &&
                randevuHastaDoktorComboBox.getSelectedIndex() != 0 && randevuHastaTarihComboBox.getSelectedIndex() != 0 &&
                randevuHastaSaatComboBox.getSelectedIndex() != 0;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JComboBox<String> randevuHastaDoktorComboBox;
    private javax.swing.JTextField randevuHastaKimlikTextField;
    private javax.swing.JComboBox<String> randevuHastaKlinikComboBox;
    private javax.swing.JComboBox<String> randevuHastaSaatComboBox;
    private javax.swing.JComboBox<String> randevuHastaTarihComboBox;
    private javax.swing.JButton randevuVerButon;
    // End of variables declaration//GEN-END:variables
}
