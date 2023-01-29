/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sifapoliklinigi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mounes
 */
public class Hasta {
    private long kimlikNo;
    private String fName;
    private String lName;
    private int sigortaDurumu;
    
    public Hasta(long kimlikNo, String fName, String lName, int sigortaDurumu) {
        this.kimlikNo = kimlikNo;
        this.fName = fName;
        this.lName = lName;
        this.sigortaDurumu = sigortaDurumu;
        
    }

    // Get patients's info directly from the database.
    public Hasta(long kimlikNo) throws NotFoundException{
        try {
            this.kimlikNo = kimlikNo;
            Connection conn = new PostgreConnector().getInstance();
            String query = String.format("SELECT * FROM KAYITLI_HASTALAR WHERE HASTA_NO = %d", kimlikNo);
            ResultSet rslt = conn.createStatement().executeQuery(query);
            if(rslt.next()){
                this.fName = rslt.getString("HASTA_AD");
                this.lName = rslt.getString("HASTA_SOYAD");
                this.sigortaDurumu = rslt.getInt("HASTA_SIGORTA_DURUMU");
            }
            else{
                throw new NotFoundException("Girilien kimlik no kayıtlı değil!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Hasta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean insertPatient(){
        Connection conn = new PostgreConnector().getInstance();
        try{       
            Statement stmt=conn.createStatement(); 
            String Komut;
            Komut = String.format("INSERT INTO KAYITLI_HASTALAR VALUES(%d, '%s', '%s', %d);"
                            , this.kimlikNo, this.fName, this.lName, this.sigortaDurumu );
            stmt.executeUpdate(Komut);
            return true;
        }catch(SQLException e){ 
            System.out.println(e);
            System.out.println("SQL EXception");
            return false;
        }
    }
    
    public String updateRandevuDurumu(){
        Connection conn = new PostgreConnector().getInstance();
        String SQL = "UPDATE RANDEVULAR SET RANDEVU_DURUMU = ? WHERE HASTA_NO = ?";
        String result ;
        try (
            PreparedStatement pstmt = conn.prepareStatement(SQL,
            Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, 1);
            pstmt.setLong(2, this.kimlikNo);


            int affectedRows = pstmt.executeUpdate();
            // check the affected rows 
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    result = "Randevu durumu güncellenmiştir";
                } catch (SQLException ex) {
                    result = ex.getMessage();
                }
            }else{
                result = "";
            }
        } catch (SQLException ex) {
            result = ex.getMessage();
        }
        return result;
    }
    
    public ArrayList<Muayene> getPatientHistory(){
        Connection conn = new PostgreConnector().getInstance();    
        ArrayList<Muayene> out = new ArrayList<Muayene>();
        try{
            String query = String.format("SELECT * FROM MUAYENELER WHERE HASTA_NO = %d", this.kimlikNo);
            ResultSet rslt = conn.createStatement().executeQuery(query);
            while(rslt.next()){
                out.add(new Muayene(rslt.getLong("MUAYENE_NO")));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
       return out;
    }
    
    public long getKimlikNo() {
        return kimlikNo;
    }

    public void setKimlikNo(long kimlikNo) {
        this.kimlikNo = kimlikNo;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getSigortaDurumu() {
        return sigortaDurumu;
    }

    public void setSigortaDurumu(int sigortaDurumu) {
        this.sigortaDurumu = sigortaDurumu;
    }
}