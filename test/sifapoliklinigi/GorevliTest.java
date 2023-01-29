/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sifapoliklinigi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author moane
 */
public class GorevliTest {
    private Gorevli real;
    private String oldUserName,oldUserSifre;
    @Before
    public void setUp(){
        // A new clinic instance whose information EXISTS in the database
        try{
            this.real = new Gorevli("kullanici1");
            oldUserName = real.getKullanicAd();
            oldUserSifre = real.getSifre();
        } catch(NotFoundException e){
            e.printStackTrace();
            System.out.println("Given clinic id does not exist in the DB");
        }
    }
        
    
    @Test(expected=NotFoundException.class)
    public void NotFoundTest() throws NotFoundException{
        new Gorevli("fofo153");
    }
    
    @Test
    public void UpdateEmployeePasswordTest(){
        String newPass = "5432";
        
        real.setSifre(newPass);
        try{
            //Update the instance from the database
            real = new Gorevli(real.getKullanicAd());
        }catch(NotFoundException e){
            e.printStackTrace();
        }
        
        assertNotEquals(real.getSifre(), oldUserSifre);
        assertEquals(real.getSifre(), newPass);
    }
    
    
    
    @After
    public void cleanUpAfterTest(){
        real.setSifre(oldUserSifre);
    }
    
    
      
}
