
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class WordLadder {

    public static void main(String[] args) {
        WordLadder obj = new WordLadder();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot", "dog", "lot", "log", "cog"));

        System.out.println(obj.ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        int length = 1;

        // logic being used here is finding the shortest path in an un weighted graph using the bfs algo
        while (!q.isEmpty()) {
            int levelSize = q.size();

            for (int j = 0; j < levelSize; j++) {
                String word = q.poll();
                if (word.equals(endWord)) {
                    return length;
                }
                // loop over each letter of word and replace with english alphabets
                for (int i = 0; i < word.length(); i++) {
                    for (char idx = 'a'; idx <= 'z'; idx++) {
                        String newWord = word.substring(0, i) + idx + word.substring(i + 1);
                        if (wordSet.contains(newWord)) {
                            q.add(newWord);
                            wordSet.remove(newWord);

                        }
                    }

                }
            }
            length++;

        }

        return 0;
    }
}
