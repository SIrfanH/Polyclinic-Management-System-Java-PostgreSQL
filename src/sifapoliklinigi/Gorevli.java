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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sayid, mounes
 */
public class Gorevli {
    private String kullaniciAd;
    private String sifre;
    private String tip;

    public Gorevli(String kullaniciAd, String sifre, String tip) {
        this.kullaniciAd = kullaniciAd;
        this.sifre = sifre;
        this.tip = tip;
    }
    
    
    

    // Get employee's info directly from the database.
    public Gorevli(String kullaniciAd) throws NotFoundException{
        try {
            this.kullaniciAd = kullaniciAd;
            Connection conn = new PostgreConnector().getInstance();
            String query = String.format("SELECT * FROM CALISANLAR WHERE CALISAN_KULLANICI_AD = '%s';", kullaniciAd);
            ResultSet rslt = conn.createStatement().executeQuery(query);
            if(rslt.next()){
                this.sifre = rslt.getString("CALISAN_SIFRE");
                this.tip = rslt.getString("CALISAN_TIPI");
            }
            else{
                throw new NotFoundException("Girilien Kullanıcı adı kayıtlı değil!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gorevli.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public String getTip() {
        return tip;
    }

    public String getKullanicAd() {
        return kullaniciAd;
    }

    public void setKullaniciAd(String kullaniciAd) {
        this.kullaniciAd = kullaniciAd;
        
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
        
        PostgreConnector posql = new PostgreConnector();  
        Connection con = posql.connectorSender(); 
        
        try{       
            Statement stmt=con.createStatement(); 
            String Komut;
            Komut = String.format("update calisanlar set CALISAN_SIFRE = '%s' where CALISAN_KULLANICI_AD = '%s'", sifre, this.kullaniciAd );
            stmt.executeUpdate(Komut);
            
        }catch(SQLException e){ 
            System.out.println(e);
            System.out.println("SQL EXception");
        }
    }
    
    
}
