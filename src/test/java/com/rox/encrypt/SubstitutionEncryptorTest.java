package com.rox.encrypt;

import org.junit.Test;

import static org.junit.Assert.*;

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
        }catch(IllegalArgumentException e){
            //Mismatched substitutions ("1,2,3") for alphabet ("A") expected
        }
    }

    @Test
    public void testUnknownAlphabetCharacter(){
        SubstitutionEncryptor encryptor = new SubstitutionEncryptor("ABC", "123");

        try {
            encryptor.encrypt("DEF");

            fail("Plaintext must be made up of Substitution alphabet");
        }catch(IllegalArgumentException e){
            //Plaintext ("DEF") contained characters not in the substitution index ("ABC")
        }
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
