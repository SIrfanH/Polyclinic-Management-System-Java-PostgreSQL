/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sifapoliklinigi;
import java.sql.*;
/**
 *
 * @author sayid
 */
public class Randevu {
    private int randevuNo;
    private long hastaKimlikNo;
    private long doktorKimlikNo;
    private int klinikNo;
    private String randevuTarihi;
    private String randevuSaati;
    private final PostgreConnector postgresql = new PostgreConnector();

    public String getRandevuSaati() {
        return randevuSaati;
    }

    public void setRandevuSaati(String randevuSaati) {
        this.randevuSaati = randevuSaati;
    }
    private int randevuDurumu;

    public Randevu(int randevuNo, long hastaKimlikNo, long doktorKimlikNo,int klinikNo, String randevuTarihi, String randevuSaati, int randevuDurumu) {
        this.randevuNo = randevuNo;
        this.hastaKimlikNo = hastaKimlikNo;
        this.doktorKimlikNo = doktorKimlikNo;
        this.klinikNo = klinikNo;
        this.randevuTarihi = randevuTarihi;
        this.randevuSaati = randevuSaati;
        this.randevuDurumu = randevuDurumu;
    }

    public int getRandevuNo() {
        return randevuNo;
    }

    public void setRandevuNo(int randevuNo) {
        this.randevuNo = randevuNo;
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

    public String getRandevuTarihi() {
        return randevuTarihi;
    }

    public void setrandevuTarihi(String randevuTarihi) {
        this.randevuTarihi = randevuTarihi;
    }

    public int getRandevuDurumu() {
        return randevuDurumu;
    }

    public void setRandevuDurumu(int randevuDurumu) {
        this.randevuDurumu = randevuDurumu;
    }
    
    public boolean veriTabaninaIsle(){
        Connection con = postgresql.connectorSender();
        String tarihSaat = this.randevuTarihi+' '+this.randevuSaati+":00";
        
        try{       
            Statement stmt=con.createStatement(); 
            String Komut;
            Komut = String.format("INSERT INTO RANDEVULAR VALUES(%d, %d, %d, %d, '%s', %d);"
                            , this.randevuNo, this.hastaKimlikNo, this.doktorKimlikNo, this.klinikNo, tarihSaat, this.randevuDurumu );
            stmt.executeUpdate(Komut);
            System.out.println("Veritabanina islendi");
            return true;
        }catch(SQLException e){ 
            System.out.println(e);
            System.out.println("SQL EXception");
            return false;
        }
    }
    
}
