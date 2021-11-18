package amazon.oa;

import java.util.HashSet;

public class ValidVariable {

    public static void main(String[] args) {
        ValidVariable validVariable = new ValidVariable();
//        System.out.println(validVariable.valid(new String[]{"is", "valid"}, "isValid"));
//        System.out.println(validVariable.valid(new String[]{"is", "valid"}, "IsValid"));
//        System.out.println(validVariable.valid(new String[]{"is", "valid"}, "IsValId"));
//        System.out.println(validVariable.valid(new String[]{"a", "valid"}, "AAAAAAAA"));
        System.out.println(validVariable.isBeautiful("bbbaacdafe"));
        System.out.println(validVariable.isBeautiful("bbbaa"));
        System.out.println(validVariable.isBeautiful("bbc"));
    }

    public boolean valid(String[] words, String variable) {
        HashSet set = new HashSet<String>();
        for(String word : words) {
            set.add(word);
        }
        int left = 0;
        for(int i = 0;i<variable.length();i++) {
            char cur = variable.charAt(i);
            if(cur >= 'A' && cur <= 'Z') {
               if(i > 0) {
                  String word = variable.substring(left, i);
                  word = normalize(word);
                  if(!set.contains(word)) {
                      return false;
                  }
                  left = i;
               }
            }
        }

        if(left < variable.length() - 1) {
           String word = variable.substring(left);
            word = normalize(word);
            if(!set.contains(word)) {
                return false;
            }
        }
        return true;
    }

    public String normalize(String word) {
        char first = word.charAt(0);
        if(first >= 'A' && first <= 'Z') {
            word = (char)('a' + (first - 'A')) + word.substring(1);
        }
        return word;
    }


    public boolean isBeautiful(String str) {
        int[] count = new int[26];
        for(char c : str.toCharArray()) {
            count[c-'a']++;
        }

        for(int i=1;i<26;i++) {
            if(count[i] > count[i-1]) {
                return false;
            }
        }
        return true;
    }


}
