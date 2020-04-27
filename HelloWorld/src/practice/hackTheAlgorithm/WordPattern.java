package practice.hackTheAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    private boolean found;

    public boolean wordPatternMatch(String pattern, String str) {
        // write your code here
        if (pattern == null || pattern.length() == 0 || str == null || str.length() == 0)
            return false;
        found = false;
        dfs(pattern, 0, new HashMap<Character, String>(),
                str, 0, new HashMap<String, Character>());
        return found;
    }

    private void dfs(String pattern, int pIndex, Map<Character, String> pMap,
                     String str, int sIndex, Map<String, Character> sMap) {
        if (found)
            return;
        if (pIndex == pattern.length() && sIndex == str.length()) {
            found = true;
            return;
        }

        if (pIndex >= pattern.length() || sIndex >= str.length())
            return;

        char p = pattern.charAt(pIndex);
        if (pMap.containsKey(p)) {
            String temp = pMap.get(p);
            if (!sMap.containsKey(temp) || !temp.equals(str.substring(sIndex, sIndex + temp.length())))
                return;
            dfs(pattern, pIndex + 1, pMap, str, sIndex + temp.length(), sMap);
        } else {
            for (int i = sIndex; i < str.length(); i++) {
                String temp = str.substring(sIndex, i + 1);
                if (sMap.containsKey(temp))
                    continue;
                pMap.put(p, temp);
                sMap.put(temp, p);
                dfs(pattern, pIndex + 1, pMap, str, sIndex + temp.length(), sMap);
                pMap.remove(p);
                sMap.remove(temp);
            }
        }
    }

    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPatternMatch("styfs", "rpcxw"));
    }
}
