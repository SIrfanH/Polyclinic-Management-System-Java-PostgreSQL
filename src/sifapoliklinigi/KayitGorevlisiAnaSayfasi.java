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
public class KayitGorevlisiAnaSayfasi extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    
    private final Gorevli gorevli;
    PostgreConnector postgresql = new PostgreConnector();
    
    
    public KayitGorevlisiAnaSayfasi(Gorevli gorevli) {
        this.gorevli = gorevli;
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

        kayitGorevlisiAdSoyadProfil = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        kayitGorevlisiKullanicAdLabel = new javax.swing.JLabel();
        kayitGorevlisiKullaniciAdTextField = new javax.swing.JTextField();
        kayitGorevlisiSifreTextField = new javax.swing.JTextField();
        KayitGorevlisiGuncelleButon = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        kayitGorevlisiDuyuruTextField = new javax.swing.JTextArea();
        jLabel40 = new javax.swing.JLabel();
        kayitGorevlisiTarihLabel = new javax.swing.JLabel();
        kayitGorevlisiSifreLabel = new javax.swing.JLabel();

        kayitGorevlisiAdSoyadProfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sifapoliklinigi/icons8-male-user-32.png"))); // NOI18N
        kayitGorevlisiAdSoyadProfil.setText("Ad Soyad");

        jLabel38.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel38.setText("Bilgileri Güncelleme:");

        kayitGorevlisiKullanicAdLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        kayitGorevlisiKullanicAdLabel.setText("Yeni Kullanıcı Adınız");

        kayitGorevlisiKullaniciAdTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        kayitGorevlisiSifreTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        KayitGorevlisiGuncelleButon.setText("Güncelle");
        KayitGorevlisiGuncelleButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KayitGorevlisiGuncelleButonActionPerformed(evt);
            }
        });

        kayitGorevlisiDuyuruTextField.setEditable(false);
        kayitGorevlisiDuyuruTextField.setColumns(20);
        kayitGorevlisiDuyuruTextField.setRows(5);
        kayitGorevlisiDuyuruTextField.setText("Dikkat Covid19");
        jScrollPane5.setViewportView(kayitGorevlisiDuyuruTextField);

        jLabel40.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel40.setText("Duyurular:");

        kayitGorevlisiTarihLabel.setText("Tarih");

        kayitGorevlisiSifreLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        kayitGorevlisiSifreLabel.setText("Yeni şifreniz");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kayitGorevlisiAdSoyadProfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kayitGorevlisiTarihLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(kayitGorevlisiKullanicAdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kayitGorevlisiSifreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KayitGorevlisiGuncelleButon, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kayitGorevlisiKullaniciAdTextField)
                            .addComponent(kayitGorevlisiSifreTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(276, 276, 276))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kayitGorevlisiAdSoyadProfil)
                            .addComponent(kayitGorevlisiTarihLabel))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(jLabel40))
                        .addGap(43, 43, 43)
                        .addComponent(kayitGorevlisiKullanicAdLabel)
                        .addGap(18, 18, 18)
                        .addComponent(kayitGorevlisiKullaniciAdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kayitGorevlisiSifreLabel))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(kayitGorevlisiSifreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(KayitGorevlisiGuncelleButon)
                .addContainerGap(207, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void KayitGorevlisiGuncelleButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KayitGorevlisiGuncelleButonActionPerformed
        // TODO add your handling code here:
        String yeniKullaniciAd = kayitGorevlisiKullaniciAdTextField.getText();
        String yeniKullaniciSifre = kayitGorevlisiSifreTextField.getText();
        if(checkComponent()){
            gorevli.setKullaniciAd(yeniKullaniciAd);
            gorevli.setSifre(yeniKullaniciSifre);
            JOptionPane.showMessageDialog(this, "Kullanıcı Adınız ve Şifreniz Güncellenmiştir");
        }else if(yeniKullaniciAd.equals("")){
            gorevli.setSifre(yeniKullaniciSifre);
            JOptionPane.showMessageDialog(this, "Şifreniz Güncellenmiştir");
        }else if(yeniKullaniciSifre.equals("")){
            gorevli.setKullaniciAd(yeniKullaniciAd);
            JOptionPane.showMessageDialog(this, "Kullanıcı Adınız Güncellenmiştir");
        }else{
            JOptionPane.showMessageDialog(this, "Boş Alanları Doldurunuz");
        }
    }//GEN-LAST:event_KayitGorevlisiGuncelleButonActionPerformed

    public void setKayitGorevlisiAdSoyadProfil(String kayitGorevlisiAdSoyadProfil) {
        this.kayitGorevlisiAdSoyadProfil.setText(kayitGorevlisiAdSoyadProfil);
    }

    public void setKayitGorevlisiTarihLabel(String kayitGorevlisiTarihLabel) {
        this.kayitGorevlisiTarihLabel.setText(kayitGorevlisiTarihLabel);
    }
    
    public boolean checkComponent(){
        return !kayitGorevlisiKullaniciAdTextField.getText().equals("") && !kayitGorevlisiSifreTextField.getText().equals("");
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton KayitGorevlisiGuncelleButon;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel kayitGorevlisiAdSoyadProfil;
    private javax.swing.JTextArea kayitGorevlisiDuyuruTextField;
    private javax.swing.JLabel kayitGorevlisiKullanicAdLabel;
    private javax.swing.JTextField kayitGorevlisiKullaniciAdTextField;
    private javax.swing.JLabel kayitGorevlisiSifreLabel;
    private javax.swing.JTextField kayitGorevlisiSifreTextField;
    private javax.swing.JLabel kayitGorevlisiTarihLabel;
    // End of variables declaration//GEN-END:variables
}
