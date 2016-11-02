package com.rox.encrypt;

/**
 * @Author rossdrew
 * @Created 02/11/16.
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
