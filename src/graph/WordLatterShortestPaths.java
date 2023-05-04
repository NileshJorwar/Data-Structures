package src.graph;

import java.util.*;

public class WordLatterShortestPaths {
    public static void main(String[] args) {

        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        int res = usingBfsToFindShortestPaths(beginWord, endWord, wordList);
        System.out.println(res);
    }

    private static int usingBfsToFindShortestPaths(String beginWord, String endWord, List<String> wordList) {
        Queue<WordPair> queue = new LinkedList<>();
        queue.add(new WordPair(beginWord, 1));
        Set<String> wordSet = new HashSet<>();
        int len = wordList.size();
        //adding words from word list to set
        for (int i = 0; i < len; i++) {
            wordSet.add(wordList.get(i));
        }

        wordSet.remove(beginWord);

        while (!queue.isEmpty()) {

            WordPair wordPair = queue.poll();
            String word = wordPair.word;
            int steps = wordPair.sequence;
            if (word.equals(endWord))
                return steps;
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char charArr[] = word.toCharArray();
                    charArr[i] = ch;
                    String replaceString = new String(charArr);
                    if (wordSet.contains(replaceString)) {
                        wordSet.remove(replaceString);
                        queue.add(new WordPair(replaceString, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
}

class WordPair {
    String word;
    int sequence;

    public WordPair(String w, int s) {
        this.word = w;
        this.sequence = s;
    }
}
