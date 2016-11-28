package com.rox.encrypt;

/**
 * XOR Cipher
 * 
 * Encrypt a given plaintext (P) using a given key (K) by applying XOR between each plaintext
 * char (i) and a mod to a char in the key, selected using the modulus of the current
 * plaintext index over the length of the key.  i.e.
 *
 *  C[i] = P[i] XOR K[i MOD len(K)]
 *
 *  This is symmetrical. So the key will also decrypt in the exact same way as it encrypts.
 *
 * @author rossdrew
 */
public class XOREncryptor {
    private char[] key = new char [0];

    public XOREncryptor(String key) {
        this.key = key.toCharArray();
    }

    public String decrypt(String ciphertext){
        //Symmetrical encryption, so it's the same as encryption
        return encrypt(ciphertext);
    }

    public String encrypt(String plaintext) {
        if (key.length < 1)
            return plaintext;

        String ciphertext = "";

        for (int i=0; i<plaintext.length(); i++){
            char pc = plaintext.charAt(i);
            char cc = (char)(pc ^ key[i % key.length]);
            ciphertext += cc;
        }

        return ciphertext;
    }
}
