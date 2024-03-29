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
public class GorevliAnaSayfasi extends javax.swing.JPanel {

    /**
     * Creates new form gorevliAnaSayfasi
     */
    
    private final Gorevli gorevli;

    PostgreConnector postgresql = new PostgreConnector();
    
    
    public GorevliAnaSayfasi(Gorevli gorevli) {
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

        gorevliAdSoyadProfile = new javax.swing.JLabel();
        gorevliTarihLabel = new javax.swing.JLabel();
        gorevliGuncelleButon = new javax.swing.JButton();
        gorevliKullaniciAdLabel = new javax.swing.JLabel();
        gorevliKullaniciAdTextField = new javax.swing.JTextField();
        gorevliSifreTextField = new javax.swing.JTextField();
        gorevliSifreLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gorevliDuyuruTextField = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(841, 524));

        gorevliAdSoyadProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sifapoliklinigi/icons8-male-user-32.png"))); // NOI18N
        gorevliAdSoyadProfile.setText("Ad Soyad");

        gorevliTarihLabel.setText("Tarih");

        gorevliGuncelleButon.setText("Güncelle");
        gorevliGuncelleButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gorevliGuncelleButonActionPerformed(evt);
            }
        });

        gorevliKullaniciAdLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gorevliKullaniciAdLabel.setText("Yeni Kullanıcı Adınız");

        gorevliKullaniciAdTextField.setEditable(false);
        gorevliKullaniciAdTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        gorevliSifreTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        gorevliSifreLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gorevliSifreLabel.setText("Yeni şifreniz");

        gorevliDuyuruTextField.setEditable(false);
        gorevliDuyuruTextField.setColumns(20);
        gorevliDuyuruTextField.setRows(5);
        gorevliDuyuruTextField.setText("Dikkat Covid19");
        jScrollPane1.setViewportView(gorevliDuyuruTextField);

        jLabel21.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel21.setText("Bilgileri Güncelleme:");

        jLabel22.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel22.setText("Duyurular:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gorevliAdSoyadProfile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(gorevliTarihLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gorevliGuncelleButon, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(gorevliKullaniciAdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(gorevliSifreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(gorevliKullaniciAdTextField)
                                .addComponent(gorevliSifreTextField))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(276, 276, 276))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gorevliAdSoyadProfile)
                    .addComponent(gorevliTarihLabel))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(gorevliKullaniciAdLabel)
                        .addGap(12, 12, 12)
                        .addComponent(gorevliKullaniciAdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(gorevliSifreLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gorevliSifreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(34, 34, 34)
                .addComponent(gorevliGuncelleButon)
                .addContainerGap(195, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void gorevliGuncelleButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gorevliGuncelleButonActionPerformed
        // TODO add your handling code here:

        String yeniKullaniciSifre = gorevliSifreTextField.getText();
        if(checkComponent()){
            gorevli.setSifre(yeniKullaniciSifre);
            JOptionPane.showMessageDialog(this, "Şifreniz Güncellenmiştir");
        }else{
            JOptionPane.showMessageDialog(this, "Boş Alanları Doldurunuz");
        }
    }//GEN-LAST:event_gorevliGuncelleButonActionPerformed

    public void setGorevliAdSoyadProfile(String gorevliAdSoyadProfile) {
        this.gorevliAdSoyadProfile.setText(gorevliAdSoyadProfile);
    }

    public void setGorevliTarihLabel(String gorevliTarihLabel) {
        this.gorevliTarihLabel.setText(gorevliTarihLabel);
    }
    
    public boolean checkComponent(){
        return !gorevliSifreTextField.getText().equals("");
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel gorevliAdSoyadProfile;
    private javax.swing.JTextArea gorevliDuyuruTextField;
    private javax.swing.JButton gorevliGuncelleButon;
    private javax.swing.JLabel gorevliKullaniciAdLabel;
    private javax.swing.JTextField gorevliKullaniciAdTextField;
    private javax.swing.JLabel gorevliSifreLabel;
    private javax.swing.JTextField gorevliSifreTextField;
    private javax.swing.JLabel gorevliTarihLabel;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
