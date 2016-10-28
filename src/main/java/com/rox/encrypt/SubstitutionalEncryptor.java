package com.rox.encrypt;

import java.rmi.activation.UnknownObjectException;

/**
 * An algorithmic substitutional cypher implementation, avoiding complex Java collections and whatnot.
 *
 * @Author rossdrew
 */
public class SubstitutionalEncryptor {
    private final int ALPH = 0;
    private final int CYPH = 1;

    private final char[][] subs;

    public SubstitutionalEncryptor(String alphabet, String subs) throws IllegalArgumentException {
        if (subs.length() != alphabet.length())
            throw new IllegalArgumentException("Alphabet (" + alphabet.length() + ") and substitutions (" + subs.length() + ") provided were not of the same size.");

        this.subs = new char[alphabet.length()][2];
        for (int i=0; i<alphabet.length(); i++){
            this.subs[i][ALPH] = alphabet.charAt(i);
            this.subs[i][CYPH] = subs.charAt(i);
        }
    }

    public String encrypt(String plaintext) throws IllegalArgumentException{
        String cyphertext = "";

        for (char c : plaintext.toCharArray()){
            boolean found = false;
            for (int i=0; i<subs.length; i++){
                if (subs[i][ALPH] == c) {
                    cyphertext += subs[i][CYPH];
                    found = true;
                    break;
                }
            }

            if (!found)
                throw new IllegalArgumentException("Unknown character '" + c + "'");//XXX Better exception to use
        }

        return cyphertext;
    }
}
