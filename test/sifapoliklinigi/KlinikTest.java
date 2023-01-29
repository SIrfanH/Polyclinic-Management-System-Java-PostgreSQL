/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sifapoliklinigi;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author moane
 */
public class KlinikTest {
    private Klinik fake,real;
    
    @Before
    public void setUp(){
        // A new clinik instance whose information does NOT exist in the database
        this.fake = new Klinik(500, "one");
        // A new clinic instance whose information EXISTS in the database
        try{
            this.real = new Klinik(630);
        } catch(NotFoundException e){
            e.printStackTrace();
            System.out.println("Given clinic id does not exist in the DB");
        }
    }
        
    
    @Test(expected=NotFoundException.class)
    public void NotFoundTest() throws NotFoundException{
        new Klinik(500);
    }
    
    @Test
    public void AddKlinikTest(){
        // A new klinik instance whose information does NOT exist in the database
        boolean expected = fake.veriTabaninaIsle();
        assertTrue(expected);
        
        // Trying to insert the same data into the database again
        boolean expected2 = real.veriTabaninaIsle();
        assertFalse(expected2);
    }
    
    
    
    @After
    public void cleanUpAfterTest(){
        String query = String.format(
                "DELETE FROM KLINIKLER WHERE KLINIK_NO = %d",
                fake.getKlinikNo()
        );
        Connection conn = new PostgreConnector().getInstance();
        try{
            conn.createStatement().executeUpdate(query);
        } catch(SQLException e){
            System.out.println("An exception was thrown while cleanning up");
            e.printStackTrace();
        }
    }
    
    
}
