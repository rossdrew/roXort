package com.rox.encrypt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CaesarEncryptorTest {
    @Test
    public void testZeroRotations(){
        CaesarEncryptor encryptor = new CaesarEncryptor("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890");
        String ciphertext = encryptor.encrypt("TEST", 0);

        assertEquals("TEST", ciphertext);
    }

    @Test
    public void testRotation(){
        CaesarEncryptor encryptor = new CaesarEncryptor("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890");
        String ciphertext = encryptor.encrypt("TEST", 1);

        assertEquals("UFTU", ciphertext);
    }

    @Test
    public void testInvalidCharactersInPlaintext(){
        try {
            CaesarEncryptor encryptor = new CaesarEncryptor("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890");
            String ciphertext = encryptor.encrypt("?", 1);
            fail("Invalid characters should throw an exception");
        }catch(IllegalArgumentException ex){}
    }

    @Test
    public void testOverflowIteration(){
        CaesarEncryptor encryptor = new CaesarEncryptor("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890");
        String ciphertext = encryptor.encrypt("0", 1);

        assertEquals("A", ciphertext);
    }

    @Test
    public void testDoubleOverflowIteration(){
        CaesarEncryptor encryptor = new CaesarEncryptor("ABC");
        String ciphertext = encryptor.encrypt("A", 6);

        assertEquals("A", ciphertext);
    }
}
