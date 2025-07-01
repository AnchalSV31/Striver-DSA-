package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder1 {
    //TC:O(N * M * 26) SC: O(N)
    static class Pair{
        String first;
        int second;
        Pair(String first, int second){
            this.first=first;
            this.second=second;
        }
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q= new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        Set<String> st= new HashSet<>();
        int len = wordList.size();
        for(int i=0; i<len; i++){
            st.add(wordList.get(i));
        }
        st.remove(beginWord);

        while(!q.isEmpty()){
            String word=q.peek().first;
            int steps=q.peek().second;
            q.remove();

            if(word.equals(endWord)==true){
                return steps;
            }

            for(int i=0; i<word.length(); i++){
                for(char ch='a'; ch<='z'; ch++){
                    char replacedCharArray[]=word.toCharArray();
                    replacedCharArray[i]=ch;
                    String replacedWord=new String(replacedCharArray);

                    if(st.contains(replacedWord)==true){
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps+1));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
            "des",
            "der",
            "dfr",
            "dgt",
            "dfs"
        };
        System.out.println(ladderLength(startWord, targetWord, List.of(wordList)));
    }
}
