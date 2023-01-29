/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sifapoliklinigi;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sayid,mounes
 */

public class Klinik {
    private int klinikNo;
    private String klinikAd;
    
    public Klinik(int klinikNo, String klinikAd) {
        this.klinikNo = klinikNo;
        this.klinikAd = klinikAd;
    }
    
    // Get clinic's info directly from the database.
    public Klinik(int klinikNo) throws NotFoundException{
        try {
            this.klinikNo = klinikNo;
            Connection conn = new PostgreConnector().getInstance();
            String query = String.format("SELECT * FROM KLINIKLER WHERE KLINIK_NO = %d", klinikNo);
            ResultSet rslt = conn.createStatement().executeQuery(query);
            if(rslt.next()){
                this.klinikAd = rslt.getString("KLINIK_AD");

            }
            else{
                throw new NotFoundException("Girilien klinik no kayıtlı değil!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Klinik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getKlinikNo() {
        return klinikNo;
    }

    public void setKlinikNo(int klinikNo) {
        this.klinikNo = klinikNo;
    }

    public String getKlinikAd() {
        return klinikAd;
    }

    public void setKlinikAd(String klinikAd) {
        this.klinikAd = klinikAd;
    }
    
    public boolean veriTabaninaIsle(){
        Connection con = new PostgreConnector().connectorSender();

        try{
            Statement stmt = con.createStatement();
            String Command;
            
            Command = String.format("INSERT INTO KLINIKLER VALUES(%d, '%s');"
                            , this.klinikNo, this.klinikAd);
            stmt.executeUpdate(Command);
            return true;
        }catch(SQLException e){
            System.out.println(e);
            System.out.println("SQL EXception");
            return false;
        }
    }
    
}
