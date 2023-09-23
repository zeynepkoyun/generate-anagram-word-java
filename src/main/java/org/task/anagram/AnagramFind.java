package org.task.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class AnagramFind {
    public List<String> generateAnagrams(String kelime) {
        List<String> anagramList = new ArrayList<>();
        Stack<AnagramState> stack = new Stack<>();
        stack.push(new AnagramState("", kelime));

        while (!stack.isEmpty()) {
            AnagramState currentState = stack.pop();
            StringBuilder prefix = new StringBuilder(currentState.prefix);
            String remaining = currentState.remaining;
            if (!anagramList.isEmpty()) {
                break;
            }

            int length = remaining.length();
            if (length == 0) {
                if (!isContains(anagramList, prefix.toString())) {
                    anagramList.add(prefix.toString());
                }
            } else {
                for (int i = 0; i < length; i++) {
                    char currentChar = remaining.charAt(i);
                    String[] words = prefix.toString().split(" ");
                    String lastWord = words[words.length - 1];
                    int indexOfCurrentChar = lastWord.indexOf(currentChar);
                    if (indexOfCurrentChar == -1) {
                        String newPrefix = prefix.toString() + currentChar;
                        String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
                        stack.push(new AnagramState(newPrefix, newRemaining));
                    } else {
                        prefix.append(" ");
                    }

                }
            }
        }
        return anagramList;
    }

    public static boolean isContains(List<String> anagramlar, String prefix) {
        boolean isContainPrefix = false;
        if (anagramlar.contains(prefix)) {
            isContainPrefix = true;
        }
        return isContainPrefix;
    }

    public boolean isAnagram(String requestWord, String responseWord) {
        requestWord = requestWord.replace(" ", "");
        responseWord = responseWord.replace(" ", "");
        if (requestWord.length() != responseWord.length()) {
            return false;
        }
        char[] requestWordCharArray = requestWord.toCharArray();
        char[] responseWordCharArray = responseWord.toCharArray();
        Arrays.sort(requestWordCharArray);
        Arrays.sort(responseWordCharArray);
        return Arrays.equals(requestWordCharArray, responseWordCharArray);
    }
}

