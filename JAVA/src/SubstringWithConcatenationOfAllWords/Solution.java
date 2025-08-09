package SubstringWithConcatenationOfAllWords;

import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> wordsMap = new HashMap<>();

        int wordLen = words[0].length();
        int totCnt = words.length;

        for(String word : words){
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        for(int i=0; i<wordLen; i++){
            int left = i;
            int cnt = 0;
            Map<String, Integer> slide = new HashMap<>();

            for(int j=i; j<=s.length()-wordLen; j+=wordLen){
                String word = s.substring(j, j+wordLen);

                if(wordsMap.containsKey(word)){
                    slide.put(word, slide.getOrDefault(word, 0) + 1);
                    cnt++;

                    while(wordsMap.get(word) < slide.get(word)){
                        String leftWord = s.substring(left, left+wordLen);
                        slide.put(leftWord, slide.get(leftWord) - 1);
                        left += wordLen;
                        cnt--;
                    }

                    if(cnt == totCnt){
                        ans.add(left);
                    }
                }else{
                    slide.clear();
                    cnt=0;
                    left = j+wordLen;
                }
            }
        }

        return ans;
    }
}

/*
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int tLen = words.length, wLen = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        for(int i=0; i<wLen; i++){
            int left=i, cnt=0;
            Map<String, Integer> slide = new HashMap<>();
            for(int j=i; j<=s.length()-wLen; j+=wLen){
                String word = s.substring(j,j+wLen);
                if(map.containsKey(word)){
                    slide.put(word, slide.getOrDefault(word, 0) + 1);
                    cnt++;

                    while(map.get(word) < slide.get(word)){
                        String lWord = s.substring(left, left+wLen);
                        slide.put(lWord, slide.get(lWord)-1);
                        left+=wLen;
                        cnt--;
                    }

                    if(cnt==tLen) ans.add(left);
                }else{
                    slide.clear();
                    left=j+wLen;
                    cnt=0;
                }
            }
        }
        return ans;
    }
}
*/