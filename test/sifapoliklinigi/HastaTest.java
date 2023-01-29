/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sifapoliklinigi;


import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author moane
 */
public class HastaTest {
    private Hasta fake,real;
    
    @Before
    public void setUp(){
        // A new patient instance whose information does NOT exist in the database
        this.fake = new Hasta(Long.parseLong("12134567084442"), "one", "two", 1);
        int randevuNo = 0;
        String tarihSaat = "2021-07-22 13:00:00";        
        // A new patient instance whose information EXISTS in the database
        Connection con = new PostgreConnector().getInstance();
        try{
            this.real = new Hasta(Long.parseLong("11992723812"));
            Statement stmt=con.createStatement(); 
            String Komut;
            //Book a randevu date for this patient
            Komut = String.format("Select nextval('RANDEVU_NO_GENERATOR')");
            ResultSet rs = stmt.executeQuery(Komut);

            if (rs.next()) {
                randevuNo = Integer.valueOf(rs.getString("nextval"));
            }
            Komut = String.format("INSERT INTO RANDEVULAR VALUES(%d, %d, %d, %d, '%s', %d);"
                            , randevuNo, Long.parseLong("11992723812"), Long.parseLong("11765432107"), 630, tarihSaat, 0);
            stmt.executeUpdate(Komut);
        } catch(NotFoundException e){
            e.printStackTrace();
            System.out.println("Given patient id does not exist in the DB");
        }
        catch (SQLException ex) {
            Logger.getLogger(HastaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    
    @Test(expected=NotFoundException.class)
    public void NotFoundTest() throws NotFoundException{
        new Hasta(Long.parseLong("1234"));
    }
    
    @Test
    public void insertPatientTest(){
        // A new patient instance whose information does NOT exist in the database
        boolean expected = fake.insertPatient();
        assertTrue(expected);
        
        // Trying to insert the same data into the database again
        boolean expected2 = real.insertPatient();
        assertFalse(expected2);
    }

    @Test
    public void updateRandevuDurumuTest(){
        // Update the randevu status of a patient whose information does Not 
        // Exist in DB
        // OR the patient's randevu status has already been updated before
        String expected = fake.updateRandevuDurumu();
        assertTrue(expected.isEmpty());
        
        // Update the randevu status of a new patient whose information does Exist
        //in DB
        String expected2 = real.updateRandevuDurumu();
        assertFalse(expected2.isEmpty());
    }
    
    
    @Test
    public void getPatientHistoryTest(){
        // A patient instance who dose NOT have any history in the database
        ArrayList<Muayene> expected = fake.getPatientHistory();
        assertEquals(expected.size(), 0);
        
        // A patient instance who DOES have history in the database
         ArrayList<Muayene> expected2 = real.getPatientHistory();
        assertNotEquals(expected2.size(), 0);
    }

    
    
    @After
    public void cleanUpAfterTest(){
        String query1 = String.format(
                "DELETE FROM KAYITLI_HASTALAR WHERE HASTA_NO = %d",
                fake.getKimlikNo()
        );
        
        String query2 = String.format(
                "DELETE FROM RANDEVULAR WHERE RANDEVU_NO = %d",
                5
        );
        Connection conn = new PostgreConnector().getInstance();
  
        try{
            conn.createStatement().executeUpdate(query1);
            conn.createStatement().executeUpdate(query2);
        } catch(SQLException e){
            System.out.println("An exception was thrown while cleanning up");
            e.printStackTrace();
        }
    } 
}
