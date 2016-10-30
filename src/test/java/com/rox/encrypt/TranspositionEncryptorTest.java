package com.rox.encrypt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TranspositionEncryptorTest {
    @Test
    public void testZeroRotations(){
        TranspositionEncryptor encryptor = new TranspositionEncryptor("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890");
        String ciphertext = encryptor.encrypt("TEST", 0);

        assertEquals("TEST", ciphertext);
    }

    @Test
    public void testRotation(){
        TranspositionEncryptor encryptor = new TranspositionEncryptor("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890");
        String ciphertext = encryptor.encrypt("TEST", 1);

        assertEquals("UFTU", ciphertext);
    }

    @Test
    public void testInvalidCharactersInPlaintext(){
        try {
            TranspositionEncryptor encryptor = new TranspositionEncryptor("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890");
            String ciphertext = encryptor.encrypt("?", 1);
            fail("Invalid characters should throw an exception");
        }catch(IllegalArgumentException ex){}
    }

    @Test
    public void testOverflowIteration(){
        TranspositionEncryptor encryptor = new TranspositionEncryptor("ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890");
        String ciphertext = encryptor.encrypt("0", 1);

        assertEquals("A", ciphertext);
    }

    @Test
    public void testDoubleOverflowIteration(){
        TranspositionEncryptor encryptor = new TranspositionEncryptor("ABC");
        String ciphertext = encryptor.encrypt("A", 6);

        assertEquals("A", ciphertext);
    }
}
