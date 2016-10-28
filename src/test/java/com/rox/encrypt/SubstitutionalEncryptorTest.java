package com.rox.encrypt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SubstitutionalEncryptorTest {
    @Test
    public void testNotEnoughSubs(){
        try {
            SubstitutionalEncryptor encryptor = new SubstitutionalEncryptor("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "1");
            fail("Mismatched substitutions are invalid");
        }catch(IllegalArgumentException e){ }
    }

    @Test
    public void testTooManySubs(){
        try {
            SubstitutionalEncryptor encryptor = new SubstitutionalEncryptor("A", "123");
            fail("Mismatched substitutions are invalid");
        }catch(IllegalArgumentException e){ }
    }

    @Test
    public void testNonTransformingSubstitution() throws IllegalArgumentException{
        SubstitutionalEncryptor encryptor = new SubstitutionalEncryptor("ABCDEFGHIJKLMNOPQRSTUVWXYZ", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        String cyphertext = encryptor.encrypt("A");
        assertEquals(cyphertext, "A");
    }

    @Test
    public void testTransformingSubstitution() throws IllegalArgumentException{
        SubstitutionalEncryptor encryptor = new SubstitutionalEncryptor("ZYXWVUTSRQPONMLKJIHGFEDCBA", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");

        assertEquals(encryptor.encrypt("A"), "Z");
        assertEquals(encryptor.encrypt("Z"), "A");
        assertEquals(encryptor.encrypt("D"), "W");
    }
}
