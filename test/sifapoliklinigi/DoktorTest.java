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
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Majd
 */
public class DoktorTest{
    
    
    private Doktor obama, james;
    private String oldUserName,oldUserSifre;
    
    @Before
    public void setUp(){
        // A new doctor instance whose information does NOT exist in the database
        this.obama = new Doktor(007, "Barack", "Obama", 630, "Obama", "Obama1234");
        // A new doctor instance whose information EXISTS in the database
        // with appointments registered for his id
        try{
            this.james = new Doktor(Long.parseLong("11736213544"));
            oldUserName = james.getKullaniciAd();
            oldUserSifre = james.getSifre();
        } catch(NotFoundException e){
            e.printStackTrace();
            System.out.println("Given doctor id does not exist in the DB");
        }
    }
    
    @Test
    public void AddDoctorTest(){
        // A new doctor instance whose information does NOT exist in the database
        boolean expected = obama.veriTabaninaIsle();
        assertTrue(expected);
        
        // Trying to insert the same data into the database again
        boolean expected2 = obama.veriTabaninaIsle();
        assertFalse(expected2);
    }
    
    
    @Test
    public void getRandevularTest(){
        // Since `obama` has no appointments related to his id
        // the output is expected to be empty.
        ArrayList<Randevu> expected = obama.getRandevular();
        assertEquals(expected.size(), 0);
        
        // Given that `james` has appointments related  to his id
        // the output is expected NOT to be empty.
        ArrayList<Randevu> expected2 = james.getRandevular();
        assertNotEquals(expected2.size(), 0);   
    }
    
    @Test(expected=NotFoundException.class)
    public void NotFoundTest() throws NotFoundException{
        new Doktor(Long.parseLong("1234"));
    }
    
    @Test
    public void setKullaniciAdiTest(){
        String newUserName = "Steve";
        
        james.setKullaniciAd(newUserName);
        try{
            //Update the instance from the database
            james = new Doktor(james.getKimlikNo());
        }catch(NotFoundException e){
            e.printStackTrace();
        }
        
        assertNotEquals(james.getKullaniciAd(), oldUserName);
        assertEquals(james.getKullaniciAd(), newUserName);
    }
    
    @Test
    public void setSifreTest(){
        String newPass = "5432";
        
        james.setSifre(newPass);
        try{
            //Update the instance from the database
            james = new Doktor(james.getKimlikNo());
        }catch(NotFoundException e){
            e.printStackTrace();
        }
        
        assertNotEquals(james.getSifre(), oldUserSifre);
        assertEquals(james.getSifre(), newPass);
    }
    
    // Revert the changes done to the database after the test is finished.
    @After
    public void cleanUpAfterTest(){
        String query = String.format(
                "DELETE FROM DOKTORLAR WHERE DOKTOR_NO = %d",
                obama.getKimlikNo()
        );
        Connection conn = new PostgreConnector().getInstance();
        try{
            conn.createStatement().executeUpdate(query);
        } catch(SQLException e){
            System.out.println("An exception was thrown while cleanning up");
            e.printStackTrace();
        }
        james.setKullaniciAd(oldUserName);
        james.setSifre(oldUserSifre);
    }
    
    
}
