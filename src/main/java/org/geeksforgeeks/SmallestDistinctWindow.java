package org.geeksforgeeks;

import java.util.*;

public class SmallestDistinctWindow {
    // https://practice.geeksforgeeks.org/problems/smallest-distant-window3132/1#

    public int findSubString(String str) {
        int length = str.length();
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (Character c: str.toCharArray()) {
            set.add(c);
        }

        int distinctCharacterSize = set.size();
        int min = Integer.MAX_VALUE;
        int windowSize = 0;
        int left = 0;
        for (int right = 0; right < length; right++) {
            char rightCharacter = str.charAt(right);
            map.put(rightCharacter, map.getOrDefault(rightCharacter, 0) + 1);
            char leftCharacter = str.charAt(left);
            while(map.get(leftCharacter) > 1) {
                map.put(leftCharacter, map.get(leftCharacter) - 1);
                left++;
                leftCharacter = str.charAt(left);
            }

            if (map.size() == distinctCharacterSize) {
                windowSize = right - left + 1;
                min = Math.min(min, windowSize);
            }
        }

        return min;
    }

    public int findSubString1(String str) {
        int length = str.length();
        int[][] dp = new int[length][52];
        Set<Character> distinctCharacter = new HashSet<>();

        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            distinctCharacter.add(c);

            if (i != 0) {
                dp[i] = dp[i-1].clone();
            }

            if (Character.isUpperCase(c)) {
                dp[i][c - 'A']++;
            }

            if (Character.isLowerCase(c)) {
                dp[i][26 + (c - 'a')]++;
            }
        }

        // System.out.println("Result : " + Arrays.deepToString(dp));
        // System.out.println("str : " + str);
        // System.out.println("distinctCharacter : " + distinctCharacter);
        int minimumWindowSize = distinctCharacter.size();

        int posStart = 0;
        int posEnd = length - 1;
        int min = Integer.MAX_VALUE;
        for (int windowSize = minimumWindowSize - 1; windowSize < length; windowSize++) {
            for (int start = 0; start < length - windowSize; start++) {

                Set<Character> set = new HashSet<>();
                for (int i = 0; i < 26; i++) {
                    if (start == 0 && dp[windowSize][i] != 0) {
                        set.add((char)('A' + i));
                        continue;
                    }

                    if (start != 0 && dp[start + windowSize][i] - dp[start - 1][i] != 0) {
                        set.add((char)('A' + i));
                    }
                }

                for (int i = 26; i < 52; i++) {
                    if (start == 0 && dp[windowSize][i] != 0) {
                        set.add((char)('a' + i - 26));
                        continue;
                    }

                    if (start != 0 && dp[start + windowSize][i] - dp[start - 1][i] != 0) {
                        set.add((char)('a' + i - 26))
                        ;
                    }
                }

                if (set.size() == minimumWindowSize) {
                    min = Math.min(min, windowSize + 1);
                }
                // System.out.println("windowSize : " + windowSize + " start : " + start + " set : " + set + " min : " + min);
            }
        }

        return min;
    }
}
