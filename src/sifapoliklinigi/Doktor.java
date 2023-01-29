/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sifapoliklinigi;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author sayid, Majd
 */
public class Doktor {
    private long kimlikNo;
    private String ad;
    private String soyad;
    private int klinikNo;
    private String kullaniciAd;
    private String sifre;
    private final PostgreConnector postgresql = new PostgreConnector();

    public Doktor(long kimlikNo, String ad, String soyad, int klinikNo, String kullaniciAd, String sifre) {
        this.kimlikNo = kimlikNo;
        this.ad = ad;
        this.soyad = soyad;
        this.klinikNo = klinikNo;
        this.kullaniciAd = kullaniciAd;
        this.sifre = sifre;
    }
    
    // Get doctor's info directly from the database.
    public Doktor(long kimlikNo) throws NotFoundException{
        try {
            this.kimlikNo = kimlikNo;
            Connection conn = new PostgreConnector().getInstance();
            String query = String.format("SELECT * FROM DOKTORLAR WHERE DOKTOR_NO = %d", kimlikNo);
            ResultSet rslt = conn.createStatement().executeQuery(query);
            if(rslt.next()){
                this.ad = rslt.getString("DOKTOR_AD");
                this.soyad = rslt.getString("DOKTOR_SOYAD");
                this.klinikNo = rslt.getInt("DOKTOR_KLINIK_NO");
                this.kullaniciAd = rslt.getString("DOKTOR_KULLANICI_AD");
                this.sifre = rslt.getString("DOKTOR_SIFRE");
            }
            else{
                throw new NotFoundException("Girilien kimlik no kayıtlı değil!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doktor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public long getKimlikNo() {
        return kimlikNo;
    }

    public void setKimlikNo(int kimlikNo) {
        this.kimlikNo = kimlikNo;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getKlinikNo() {
        return klinikNo;
    }

    public void setKlinikNo(int klinikNo) {
        this.klinikNo = klinikNo;
    }

    public String getKullaniciAd() {
        return kullaniciAd;
    }

    public void setKullaniciAd(String kullaniciAd) {
        this.kullaniciAd = kullaniciAd;
 
        Connection con = postgresql.connectorSender(); 
        
        try{       
            Statement stmt=con.createStatement(); 
            String Komut;
            Komut = String.format("update doktorlar set DOKTOR_KULLANICI_AD = '%s' where doktor_no = '%s'", kullaniciAd, this.kimlikNo );
            stmt.executeUpdate(Komut);
            
        }catch(SQLException e){ 
            System.out.println(e);
            System.out.println("SQL EXception");
        }
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
   
        Connection con = postgresql.connectorSender(); 
        
        try{       
            
            Statement stmt=con.createStatement(); 
            String Komut;
            Komut = String.format("update doktorlar set doktor_sifre = '%s' where doktor_no = '%s'", sifre, this.kimlikNo );
            stmt.executeUpdate(Komut);
            
        }catch(SQLException e){ 
            System.out.println(e);
            System.out.println("SQL EXception");
        }
    }
    
    public boolean veriTabaninaIsle(){  
        Connection con = postgresql.connectorSender(); 
        
        try{       
            Statement stmt=con.createStatement(); 
            String Komut;
            Komut = String.format("INSERT INTO DOKTORLAR VALUES(%d, '%s', '%s', %d, '%s', '%s');"
                            , this.kimlikNo, this.ad, this.soyad, this.klinikNo, this.kullaniciAd, this.sifre );
            stmt.executeUpdate(Komut);
            return true;
        }catch(SQLException e){ 
            System.out.println(e);
            System.out.println("SQL EXception");
            return false;
        }
    }
    
    public ArrayList<Randevu> getRandevular(){
        Connection conn = postgresql.getInstance();
        ArrayList<Randevu> out = new ArrayList<Randevu>();
        try{
            String query = String.format("SELECT * FROM RANDEVULAR WHERE DOKTOR_NO = %d"
                    + " ORDER BY RANDEVU_TARIHI", kimlikNo);
            ResultSet rs = conn.createStatement().executeQuery(query);
            while(rs.next()){
                int randevuNo = rs.getInt("RANDEVU_NO");
                long hastaNo = rs.getLong("HASTA_NO");
                int randevuKlinikNo = rs.getInt("KLINIK_NO");
                String randevuTarihi = rs.getString("RANDEVU_TARIHI").split(" ")[0];
                String randevuSaati = rs.getString("RANDEVU_TARIHI").split(" ")[1];
                int randevuDurumu = rs.getInt("RANDEVU_DURUMU");
                
                Randevu randevu = new Randevu(
                    randevuNo, hastaNo, this.kimlikNo, randevuKlinikNo,
                    randevuTarihi, randevuSaati, randevuDurumu
                );
                LocalTime randevuTime = LocalTime.parse(randevu.getRandevuSaati());
                LocalTime nowTime = LocalTime.now();
                LocalDate randevuDate = LocalDate.parse(randevu.getRandevuTarihi());
                LocalDate todaysDate = LocalDate.now();
                //long tNow = java.util.Calendar.getInstance().getTime().getTime();
                System.out.println(randevuDate.compareTo(todaysDate));
                System.out.println(randevu.getRandevuDurumu());
                if (randevu.getRandevuDurumu() != 0 || randevuDate.compareTo(todaysDate)> 0){
                    out.add(randevu);
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        
        return out;
    }
    
}
