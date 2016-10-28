package com.rox.encrypt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SubstitutionEncryptorTest {
    @Test
    public void testNotEnoughSubs(){
        try {
            new SubstitutionEncryptor("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "1");
            fail("Mismatched substitutions are invalid");
        }catch(IllegalArgumentException e){ }
    }

    @Test
    public void testTooManySubs(){
        try {
            new SubstitutionEncryptor("A", "123");
            fail("Mismatched substitutions are invalid");
        }catch(IllegalArgumentException e){ }
    }

    @Test
    public void testNonTransformingSubstitution() throws IllegalArgumentException{
        SubstitutionEncryptor encryptor = new SubstitutionEncryptor("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        String ciphertext = encryptor.encrypt("A");
        assertEquals(ciphertext, "A");
    }

    @Test
    public void testTransformingSubstitution() throws IllegalArgumentException{
        SubstitutionEncryptor encryptor = new SubstitutionEncryptor("ZYXWVUTSRQPONMLKJIHGFEDCBA", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");

        assertEquals(encryptor.encrypt("A"), "Z");
        assertEquals(encryptor.encrypt("Z"), "A");
        assertEquals(encryptor.encrypt("D"), "W");
    }
}
