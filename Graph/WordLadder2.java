package Graph;

import java.util.*;

public class WordLadder2 {
    public static ArrayList<ArrayList<String>> findLadders(String startWord, String endWord, String[] wordList){
        Set<String> st= new HashSet<>();
        int len=wordList.length;

        // Push all values of wordList into a set
        // to make deletion from it easier and in less time complexity.
        for(int i=0; i<len; i++){
            st.add(wordList[i]);
        }
        Queue<ArrayList<String>> q= new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(startWord);
        q.add(ls);

        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        int level = 0;

        ArrayList < ArrayList < String >> ans = new ArrayList < > ();
        int cnt = 0;

        while(!q.isEmpty()){
            cnt++;
            ArrayList<String> vec = q.peek();
            q.remove();
            // Now, erase all words that have been
            // used in the previous levels to transform
            if(vec.size()>level){
                level++;
                for(String it: usedOnLevel){
                    st.remove(it);
                }
            }

            String word = vec.get(vec.size() - 1);

             // store the answers if the end word matches with targetWord.
            if (word.equals(endWord)) {
                // the first sequence where we reached the end.
                if (ans.size() == 0) {
                    ans.add(vec);
                } else if (ans.get(0).size() == vec.size()) {
                    ans.add(vec);
                }
            }
            for (int i = 0; i < word.length(); i++) {

                // Now, replace each character of ‘word’ with char
                // from a-z then check if ‘word’ exists in wordList.
                for (char c = 'a'; c <= 'z'; c++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = c;
                    String replacedWord = new String(replacedCharArray);
                    if (st.contains(replacedWord) == true) {
                        vec.add(replacedWord);
                        // Java works by reference, so enter the copy of vec
                        // otherwise if you remove word from vec in next lines, it will 
                        // remove from everywhere 
                        ArrayList < String > temp = new ArrayList < > (vec);
                        q.add(temp);
                        // mark as visited on the level 
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size() - 1);
                    }
                }

            }
        }
        return ans;
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

        ArrayList < ArrayList < String >> ans = findLadders(startWord, targetWord, wordList);
        
        // If no transformation sequence is possible.
        if (ans.size() == 0)
            System.out.println(-1);
        else {

            Collections.sort(ans, new comp());
            for (int i = 0; i < ans.size(); i++) {
                for (int j = 0; j < ans.get(i).size(); j++) {
                    System.out.print(ans.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
    
    public static class comp implements Comparator < ArrayList < String >> {

    public int compare(ArrayList < String > a, ArrayList < String > b) {
        String x = "";
        String y = "";
        for (int i = 0; i < a.size(); i++)
            x += a.get(i);
        for (int i = 0; i < b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}
}
