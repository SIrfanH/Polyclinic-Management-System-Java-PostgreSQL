/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sifapoliklinigi;

import javax.swing.JOptionPane;

/**
 *
 * @author sayid
 */
public class DoktorAnaSayfasi extends javax.swing.JPanel {

    /**
     * Creates new form doktorAnaSayfasi
     */
    
    private final Doktor doktor;
    PostgreConnector postgresql = new PostgreConnector();
    
    public DoktorAnaSayfasi(Doktor doktor) {
        this.doktor = doktor;
        initComponents();
    }

    public void setDoktorAdSoyadProfil(String doktorAdSoyadProfil) {
        this.doktorAdSoyadProfil.setText(doktorAdSoyadProfil);
    }

    public void setDoktorTarihLabel(String doktorTarihLabel) {
        this.doktorTarihLabel.setText(doktorTarihLabel);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        doktorAdSoyadProfil = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        doktorKullaniciAdLabel = new javax.swing.JLabel();
        doktorKullanicAdTextField = new javax.swing.JTextField();
        doktorSifreTextField = new javax.swing.JTextField();
        doktorGuncelleButon = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        doktorDuyuruTextField = new javax.swing.JTextArea();
        doktorDuyuruLabel = new javax.swing.JLabel();
        doktorTarihLabel = new javax.swing.JLabel();
        doktorSifreLabel = new javax.swing.JLabel();

        doktorAdSoyadProfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sifapoliklinigi/icons8-male-user-32.png"))); // NOI18N
        doktorAdSoyadProfil.setText("Ad Soyad");

        jLabel28.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel28.setText("Bilgileri Güncelleme:");

        doktorKullaniciAdLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        doktorKullaniciAdLabel.setText("Yeni Kullanıcı Adınız");

        doktorKullanicAdTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        doktorSifreTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        doktorGuncelleButon.setText("Güncelle");
        doktorGuncelleButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doktorGuncelleButonActionPerformed(evt);
            }
        });

        doktorDuyuruTextField.setEditable(false);
        doktorDuyuruTextField.setColumns(20);
        doktorDuyuruTextField.setRows(5);
        doktorDuyuruTextField.setText("Dikkat Covid19");
        jScrollPane3.setViewportView(doktorDuyuruTextField);

        doktorDuyuruLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        doktorDuyuruLabel.setText("Duyurular:");

        doktorTarihLabel.setText("Tarih");

        doktorSifreLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        doktorSifreLabel.setText("Yeni şifreniz");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(doktorAdSoyadProfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(doktorTarihLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(doktorKullaniciAdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(doktorSifreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(doktorGuncelleButon, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(doktorKullanicAdTextField)
                            .addComponent(doktorSifreTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(doktorDuyuruLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(276, 276, 276))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(doktorAdSoyadProfil)
                            .addComponent(doktorTarihLabel))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(doktorDuyuruLabel))
                        .addGap(43, 43, 43)
                        .addComponent(doktorKullaniciAdLabel)
                        .addGap(18, 18, 18)
                        .addComponent(doktorKullanicAdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(doktorSifreLabel))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(doktorSifreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(doktorGuncelleButon)
                .addContainerGap(203, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void doktorGuncelleButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doktorGuncelleButonActionPerformed
        // TODO add your handling code here:
        String yeniKullaniciAd = doktorKullanicAdTextField.getText();
        String yeniKullaniciSifre = doktorSifreTextField.getText();
        if(checkComponent()){
            doktor.setKullaniciAd(yeniKullaniciAd);
            doktor.setSifre(yeniKullaniciSifre);
            JOptionPane.showMessageDialog(this, "Kullanıcı Adınız ve Şifreniz Güncellenmiştir");
        }else if(yeniKullaniciAd.equals("")){
            doktor.setSifre(yeniKullaniciSifre);
            JOptionPane.showMessageDialog(this, "Şifreniz Güncellenmiştir");
        }else if(yeniKullaniciSifre.equals("")){
            doktor.setKullaniciAd(yeniKullaniciAd);
            JOptionPane.showMessageDialog(this, "Kullanıcı Adınız Güncellenmiştir");
        }else{
            JOptionPane.showMessageDialog(this, "Boş Alanları Doldurunuz");
        }
    }//GEN-LAST:event_doktorGuncelleButonActionPerformed

    public boolean checkComponent(){
        return !doktorKullanicAdTextField.getText().equals("") && !doktorSifreTextField.getText().equals("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel doktorAdSoyadProfil;
    private javax.swing.JLabel doktorDuyuruLabel;
    private javax.swing.JTextArea doktorDuyuruTextField;
    private javax.swing.JButton doktorGuncelleButon;
    private javax.swing.JTextField doktorKullanicAdTextField;
    private javax.swing.JLabel doktorKullaniciAdLabel;
    private javax.swing.JLabel doktorSifreLabel;
    private javax.swing.JTextField doktorSifreTextField;
    private javax.swing.JLabel doktorTarihLabel;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
