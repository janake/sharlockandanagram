package org.prodet;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
//        int anagrams = main.countAnagram("ifailuhkqq");
//        int anagrams = main.countAnagram("qqqq");
        int anagrams = main.countAnagram("cdcd");
        System.out.println(anagrams);
    }

    private int countAnagram(String word) {
        int anagrams = 0;
        int wordLength = word.length();
        int firstWordPos = 0;
        int actualOffset = 1;
        while (firstWordPos + actualOffset <= wordLength) {
            anagrams = getAnagrams(word, anagrams, wordLength, firstWordPos, actualOffset);
            actualOffset ++;
        }
        return anagrams;
    }

    private int getAnagrams(String word, int anagrams, int wordLength, int firstWordPos, int actualOffset) {
        while (firstWordPos + actualOffset <= wordLength) {
            int secondWordPos = firstWordPos + 1;
            anagrams = checkAnagrams(word, anagrams, wordLength, firstWordPos, actualOffset, secondWordPos);
            firstWordPos++;
        }
        return anagrams;
    }

    private int checkAnagrams(String word, int anagrams, int wordLength, int firstWordPos, int actualOffset, int secondWordPos) {
        while (secondWordPos + actualOffset <= wordLength) {
            String firstSub = word.substring(firstWordPos, firstWordPos + actualOffset);
            String secondSub = word.substring(secondWordPos, secondWordPos + actualOffset);
            anagrams += compareSubstrings(firstSub, secondSub);
            secondWordPos++;
        }
        return anagrams;
    }

    private int compareSubstrings(String firstWord, String secondWod) {
        int result = 0;
        char[] first = firstWord.toCharArray();
        char[] second = secondWod.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        if (Arrays.equals(first, second)) {
//            for (char c : first) {
//                System.out.print(c);
//            }
//            System.out.println();
            result = 1;
        }
        return result;
    }
}
