package com.rox.encrypt;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 * @Author rossdrew
 * @Created 02/11/16.
 */
public class XORCipherTest {
    @Test
    public void testSingleCharacter(){
        String plaintext = "r";
        String key = "K";

        XOREncryptor encryptor = new XOREncryptor(key);
        String ciphertext = encryptor.encrypt(plaintext);
        XOREncryptor decryptor = new XOREncryptor(key);

        assertThat(ciphertext, is(not(plaintext)));
        assertThat(decryptor.decrypt(ciphertext), is(plaintext));
    }

    @Test
    public void testString(){
        String plaintext = "This is my plaintext string";
        String key = "MyTopSecretEncryptionKey";

        XOREncryptor encryptor = new XOREncryptor(key);
        String ciphertext = encryptor.encrypt(plaintext);
        XOREncryptor decryptor = new XOREncryptor(key);

        assertThat(ciphertext, is(not(plaintext)));
        assertThat(decryptor.decrypt(ciphertext), is(plaintext));
    }

    @Test
    public void testStringAndThatEncryptionIsSymmetrical(){
        String plaintext = "This is my plaintext string";
        String key = "MyTopSecretEncryptionKey";

        XOREncryptor encryptor = new XOREncryptor(key);
        String ciphertext = encryptor.encrypt(plaintext);
        XOREncryptor decryptor = new XOREncryptor(key);

        assertThat(ciphertext, is(not(plaintext)));
        assertThat(decryptor.decrypt(ciphertext), is(plaintext));
        assertThat(decryptor.encrypt(ciphertext), is(plaintext));
    }

    @Test
    public void testEmptyPlaintext(){
        String plaintext = "";
        String key = "MyTopSecretEncryptionKey";

        XOREncryptor encryptor = new XOREncryptor(key);
        String ciphertext = encryptor.encrypt(plaintext);
        XOREncryptor decryptor = new XOREncryptor(key);

        assertThat("Need something to encode", ciphertext, is(plaintext));
        assertThat(decryptor.decrypt(ciphertext), is(plaintext));
    }

    @Test
    public void testEmptyKey(){
        String plaintext = "Test";
        String key = "";

        XOREncryptor encryptor = new XOREncryptor(key);
        String ciphertext = encryptor.encrypt(plaintext);
        XOREncryptor decryptor = new XOREncryptor(key);

        assertThat("Cannot encrypt without a key", ciphertext, is(plaintext));
        assertThat(decryptor.encrypt(ciphertext), is(plaintext));
    }
}
