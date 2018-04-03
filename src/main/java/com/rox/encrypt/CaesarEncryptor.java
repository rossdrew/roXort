package com.rox.encrypt;

/**
 * Caesar Cipher
 *
 * Given a set of available characters from which a plaintext can be made.
 * Substitute any given character in the plaintext for one that is n steps
 * along the list of available character.
 *
 * @author rossdrew
 */
public class CaesarEncryptor {
    private final char[] alphabet;

    public CaesarEncryptor(String alphabet) {
        this.alphabet = alphabet.toCharArray();
    }

    public String encrypt(String plaintext, int increments) throws IllegalArgumentException {
        String ciphertext = "";

        for (int p=0; p < plaintext.length(); p++){
            char plaintextChar = plaintext.charAt(p);
            boolean found = false;

            for (int k=0; k < alphabet.length; k++){
                if (plaintextChar == alphabet[k]){
                    int ciphertextCharIndex = (k + increments) % alphabet.length;
                    ciphertext += alphabet[ciphertextCharIndex];
                    found = true;
                }
            }

            if (!found)
                throw new IllegalArgumentException("Unknown character '" + plaintextChar + "'");//XXX Better exception to use
        }

        return ciphertext;
    }
}
