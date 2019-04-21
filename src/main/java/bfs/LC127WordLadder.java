package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC127WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] visited = new boolean[wordList.size()];
        Queue<String> queue = new LinkedList<>();
        for(int i=0;i<wordList.size();i++) {
            if(isOneLetterDistance(beginWord, wordList.get(i))) {
                visited[i] = true;
                queue.offer(wordList.get(i));
            }
        }

        int step = 1;
        while(!queue.isEmpty()) {
            step++;
            int size = queue.size();
            while(size > 0) {
                String poll = queue.poll();
                if(poll.equals(endWord)) return step;
                for(int i=0;i<wordList.size();i++) {
                    if(!visited[i] && isOneLetterDistance(poll, wordList.get(i))) {
                        queue.offer(wordList.get(i));
                        visited[i] = true;
                    }
                }
                size--;
            }
        }
        return 0;
    }

    public boolean isOneLetterDistance(String str1, String str2) {
        int length = str1.length();
        int diffCount = 0;
        for(int i=0;i<length;i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                diffCount++;
                if(diffCount > 1) {
                    return false;
                }
            }
        }
        return diffCount == 1;
    }

    public static void main(String[] args) {
        System.out.println(new LC127WordLadder().ladderLength("hit", "cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"})));;
    }
}
