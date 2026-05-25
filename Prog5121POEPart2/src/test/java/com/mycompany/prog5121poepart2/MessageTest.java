/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.prog5121poepart2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Student
 */
public class MessageTest {
    
    public MessageTest() {
    }

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }
    
    

    /**
     * Test of checkRecipientCell method, of class Message.
     */
    @org.junit.Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        String cellNumber = "";
        Message instance = new Message();
        boolean expResult = false;
        boolean result = instance.checkRecipientCell(cellNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMessageID method, of class Message.
     */
    @org.junit.Test
    public void testCreateMessageID() {
        System.out.println("createMessageID");
        Message instance = new Message();
        String expResult = "";
        String result = instance.createMessageID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMessageHash method, of class Message.
     */
    @org.junit.Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        String messageID = "";
        int messageNum = 0;
        String message = "";
        Message instance = new Message();
        String expResult = "";
        String result = instance.createMessageHash(messageID, messageNum, message);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
