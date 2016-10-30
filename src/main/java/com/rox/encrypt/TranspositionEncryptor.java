package com.rox.encrypt;

/**
 * Transposition Cipher
 *
 * Given a set of available characters from which a plaintext can be made.
 * Substitute any given character in the plaintext for one that is n steps
 * along the list of available character.
 *
 * @Author rossdrew
 */
public class TranspositionEncryptor {
    private char[] alphabet;

    public TranspositionEncryptor(String alphabet) {
        this.alphabet = alphabet.toCharArray();
    }

    public String encrypt(String plantext, int increments) throws IllegalArgumentException {
        String ciphertext = "";

        for (int p=0; p < plantext.length(); p++){
            char plaintextChar = plantext.charAt(p);
            boolean found = false;

            for (int k=0; k < alphabet.length; k++){
                if (plaintextChar == alphabet[k]){
                    int cyphertextCharIndex = (k + increments) % alphabet.length;
                    ciphertext += alphabet[cyphertextCharIndex];
                    found = true;
                }
            }

            if (!found)
                throw new IllegalArgumentException("Unknown character '" + plaintextChar + "'");//XXX Better exception to use
        }

        return ciphertext;
    }
}
