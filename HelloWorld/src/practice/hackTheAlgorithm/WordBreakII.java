package practice.hackTheAlgorithm;

import java.util.*;

public class WordBreakII {
//    public List<String> wordBreak(String s, Set<String> wordDict) {
//        // write your code here
//        List<String> res = new ArrayList<>();
//        if (s == null)
//            return res;
//        int maxLen = getMaxLen(wordDict);
//        boolean[] canSeg = new boolean[s.length() + 1];
//        canSeg[0] = true;
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        map.put(0, new ArrayList<Integer>());
//
//        for (int i = 1; i < canSeg.length; i++) {
//            for (int j = 1; j <= maxLen && j <= i; j++) {
//                String temp = s.substring(i - j, i);
//                if (wordDict.contains(temp) && canSeg[i - j]) {
//                    canSeg[i] = true;
//                    if (map.containsKey(i - j)) {
//                        List<Integer> list = map.get(i - j);
//                        list.add(i);
//                    } else {
//                        List<Integer> list = new ArrayList<>();
//                        list.add(i);
//                        map.put(i - j, list);
//                    }
//                }
//            }
//        }
//
//        if (!canSeg[s.length()])
//            return res;
//        if (map.get(0).size() != 0) {
//            List<List<Integer>> intRes = new ArrayList<>();
//            strRes(map.get(0), s.length(), map, new ArrayList<>(), intRes);
//            for (int i = 0; i < intRes.size(); i++) {
//                StringBuilder sb = new StringBuilder();
//                int startIndex = 0;
//                for (int j = 0; j < intRes.get(i).size(); j++) {
//                    int endIdxTemp = intRes.get(i).get(j);
//                    sb.append(s, startIndex, endIdxTemp);
//                    startIndex = endIdxTemp;
//                    if (endIdxTemp != s.length())
//                        sb.append(" ");
//                }
//                String sRes = sb.toString();
//                if (sRes.length() > 0)
//                    res.add(sRes);
//            }
//        }
//        return res;
//    }
//
//    private int getMaxLen(Set<String> dict) {
//        int maxLen = 0;
//        for (String temp : dict) {
//            maxLen = Math.max(maxLen, temp.length());
//        }
//        return maxLen;
//    }
//
//    private void strRes(List<Integer> indices, int end, Map<Integer,
//            List<Integer>> map, List<Integer> subsets, List<List<Integer>> res) {
//        if (indices == null)
//            return;
//        for (int i = 0; i < indices.size(); i++) {
//            int index = indices.get(i);
//            subsets.add(index);
//            if (index == end) {
//                res.add(new ArrayList<Integer>(subsets));
//                subsets.remove(subsets.size() - 1);
//                continue;
//            }
//
//            strRes(map.get(index), end, map, subsets, res);
//            subsets.remove(subsets.size() - 1);
//        }

    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Map<String, ArrayList<String>> memo = new HashMap<String, ArrayList<String>>();
        return wordBreakHelper(s, dict, memo);
    }

    public ArrayList<String> wordBreakHelper(String s,
                                             Set<String> dict,
                                             Map<String, ArrayList<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        ArrayList<String> results = new ArrayList<String>();

        if (s.length() == 0) {
            return results;
        }

        if (dict.contains(s)) {
            results.add(s);
        }

        for (int len = 1; len < s.length(); ++len) {
            String word = s.substring(0, len);
            if (!dict.contains(word)) {
                continue;
            }

            String suffix = s.substring(len);
            ArrayList<String> segmentations = wordBreakHelper(suffix, dict, memo);

            for (String segmentation : segmentations) {
                results.add(word + " " + segmentation);
            }
        }

        memo.put(s, results);
        return results;
    }

    public static void main(String[] args) {
        //"lintcode"
        //["de","ding","co","code","lint"]
        //"cars"
        //["car","ca","rs"]
        WordBreakII w = new WordBreakII();
        Set<String> set = new HashSet<>();
        set.add("de");
        set.add("ding");
        set.add("co");
        set.add("code");
        set.add("lint");
        set.add("lintcode");
//        set.add("car");
//        set.add("ca");
//        set.add("rs");

        String s = "lintcode";
        System.out.println(w.wordBreak(s, set));
    }
}
