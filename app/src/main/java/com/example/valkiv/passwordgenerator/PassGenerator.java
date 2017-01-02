package com.example.valkiv.passwordgenerator;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

public class PassGenerator {

    private char digit;
    private ArrayList<Character> characters;
    private SecureRandom random;

    public String createPass(int passLength) {

        String password = "";
        random = new SecureRandom();
        characters = new ArrayList<>();

        char firstChar = 33;
        for (int i = 0; i < 94; i++){
            characters.add(firstChar);
            firstChar++;
        }
        Collections.shuffle(characters);
        for (int i =0; i < passLength; i++){
            digit = characters.get(random.nextInt(94)); //94 - max value. From 0 to 94
            password += digit;
        }

        return password;
    }

    public String createPassOnlyLetters(int passLength) {

        String password = "";
        random = new SecureRandom();
        characters = new ArrayList<>();

        char firstLetterBig = 65;
        for (int i = 65; i < 91; i++) {
            characters.add(firstLetterBig);
            firstLetterBig++;
        }
        Collections.shuffle(characters);
        char firstLetterSmall = 97;
        for (int i = 97; i < 123; i++) {
            characters.add(firstLetterSmall);
            firstLetterSmall++;
        }
        Collections.shuffle(characters);
        for (int i = 0; i< passLength; i++) {
            digit = characters.get(random.nextInt(52));
            password += digit;
        }
        return password;
    }

    public String createPassOnlySmallLetters(int passLength) {

        String password = "";
        random = new SecureRandom();
        characters = new ArrayList<>();

        char firstLetterSmall = 97;
        for (int i = 97; i < 123; i++) {
            characters.add(firstLetterSmall);
            firstLetterSmall++;
        }
        Collections.shuffle(characters);
        for (int i = 0; i< passLength; i++) {
            digit = characters.get(random.nextInt(26));
            password += digit;
        }
        return password;
    }

    public String createPassOnlyBigLetters(int passLength) {

        String password = "";
        random = new SecureRandom();
        characters = new ArrayList<>();

        char firstLetterBig = 65;
        for (int i = 65; i < 91; i++) {
            characters.add(firstLetterBig);
            firstLetterBig++;
        }

        Collections.shuffle(characters);
        for (int i = 0; i< passLength; i++) {
            digit = characters.get(random.nextInt(26));
            password += digit;
        }
        return password;
    }

    public String createPassOnlySpecialSymbols(int passLength) {

        String password = "";
        random = new SecureRandom();
        characters = new ArrayList<>();

        char firstChars = 33;
        for (int i = 33; i < 48; i++) {
            characters.add(firstChars);
            firstChars++;
        }
        char secondChars = 58;
        for (int i = 58; i < 65; i++) {
            characters.add(secondChars);
            secondChars++;
        }
        Collections.shuffle(characters);
        char thirdChars = 91;
        for (int i = 91; i < 97; i++) {
            characters.add(thirdChars);
            thirdChars++;
        }
        Collections.shuffle(characters);
        char foursChars = 123;
        for (int i = 123; i < 127; i++) {
            characters.add(foursChars);
            foursChars++;
        }
        Collections.shuffle(characters);
        for (int i = 0; i< passLength; i++) {
            digit = characters.get(random.nextInt(32));
            password += digit;
        }
        return password;
    }

    public String createPassOnlyDigits(int passLength) {

        String password = "";
        random = new SecureRandom();
        characters = new ArrayList<>();

        char firstDigit = 48;
        for (int i = 48; i < 58; i++) {
            characters.add(firstDigit);
            firstDigit++;
        }

        Collections.shuffle(characters);
        for (int i = 0; i< passLength; i++) {
            digit = characters.get(random.nextInt(10));
            password += digit;
        }
        return password;
    }

}
