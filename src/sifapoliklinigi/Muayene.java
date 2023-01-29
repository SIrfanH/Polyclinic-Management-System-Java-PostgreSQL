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
import javax.swing.JOptionPane;

/**
 *
 * @author sayid, mounes
 */
public class Muayene {
    private long muayeneNo;
    private long hastaKimlikNo;
    private long doktorKimlikNo;
    private int ucret;
    private String aciklama;
    private String verilenDokuman;
    private int odemeDurumu;

    public Muayene(long hastaKimlikNo, long doktorKimlikNo, int odemeDurumu) {
        this.hastaKimlikNo = hastaKimlikNo;
        this.doktorKimlikNo = doktorKimlikNo;
        this.odemeDurumu = odemeDurumu;
    }
    

    
    public Muayene(long muayeneNo){
        Connection conn = new PostgreConnector().getInstance(); 
        String query = String.format("SELECT * FROM MUAYENELER WHERE MUAYENE_NO = %d", muayeneNo);
        try{
            ResultSet resultSet = conn.createStatement().executeQuery(query);
            if (resultSet.next()){
                this.muayeneNo = muayeneNo;
                this.doktorKimlikNo = resultSet.getLong("DOKTOR_NO");
                this.hastaKimlikNo = resultSet.getLong("HASTA_NO");
                this.ucret = resultSet.getInt("MUAYENE_UCRETI");
                this.aciklama = resultSet.getString("MUAYENE_ACIKLAMASI");
                this.verilenDokuman = resultSet.getString("VERILEN_DOKUMAN");
                this.odemeDurumu = resultSet.getInt("ODEME_DURUMU");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    

    public long getHastaKimlikNo() {
        return hastaKimlikNo;
    }

    public void setHastaKimlikNo(int hastaKimlikNo) {
        this.hastaKimlikNo = hastaKimlikNo;
    }

    public long getDoktorKimlikNo() {
        return doktorKimlikNo;
    }

    public void setDoktorKimlikNo(int doktorKimlikNo) {
        this.doktorKimlikNo = doktorKimlikNo;
    }

    public int getUcret() {
        return ucret;
    }

    public void setUcret(int ucret) {
        this.ucret = ucret;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getVerilenDokuman() {
        return verilenDokuman;
    }

    public void setVerilenDokuman(String verilenDokuman) {
        this.verilenDokuman = verilenDokuman;
    }

    public int getOdemeDurumu() {
        return odemeDurumu;
    }

    public void setOdemeDurumu(int odemeDurumu) {
        this.odemeDurumu = odemeDurumu;
    }
    
}
