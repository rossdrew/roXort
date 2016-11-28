package com.rox.encrypt;

/**
 * Substitution Cipher
 *
 * The plaintext is made up of a set of available characters which each have a
 * substitution value.  For example, all occurrences of character 'A' will be
 * replaced with the character 'Z' and so on
 *
 * @author rossdrew
 */
public class SubstitutionEncryptor {
    private final int ALPH = 0;
    private final int CIPH = 1;

    private final char[][] subs;

    public SubstitutionEncryptor(String alphabet, String subs) throws IllegalArgumentException {
        if (subs.length() != alphabet.length())
            throw new IllegalArgumentException("Alphabet (" + alphabet.length() + ") and substitutions (" + subs.length() + ") provided were not of the same size.");

        this.subs = new char[alphabet.length()][2];
        for (int i=0; i<alphabet.length(); i++){
            this.subs[i][ALPH] = alphabet.charAt(i);
            this.subs[i][CIPH] = subs.charAt(i);
        }
    }

    public String encrypt(String plaintext) throws IllegalArgumentException{
        String ciphertext = "";

        for (char c : plaintext.toCharArray()){
            boolean found = false;
            for (char[] sub : subs) {  //XXX Pitest: "changed conditional boundary → SURVIVED"
                if (sub[ALPH] == c) {
                    ciphertext += sub[CIPH];
                    found = true;
                    break;
                }
            }

            if (!found)
                throw new IllegalArgumentException("Unknown character '" + c + "'");//XXX Better exception to use
        }

        return ciphertext;
    }
}
