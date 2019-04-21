package uber;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StringProcess {

    public String process(String[] keys, String word) {
        Arrays.sort(keys, (k1, k2) -> {return k2.length() - k1.length();});

        List<int[]> available = new LinkedList<>();
        List<int[]> occupied = new LinkedList<>();
        available.add(new int[]{0, word.length()-1});
        for(String key : keys) {
            for(int[] span : available) {
                String temp = word.substring(span[0], span[1] + 1);
                int index = temp.indexOf(key);
                if(index != -1) {
                    ((LinkedList<int[]>) available).remove(span);
                }
                while(index != -1) {

                }
            }
        }

        return word;


    }

    public static void main(String[] args) {
        String word = new StringProcess().process(new String[]{"na", "b", "aa", "aaaa", "Z"}, "word");
    }
}
