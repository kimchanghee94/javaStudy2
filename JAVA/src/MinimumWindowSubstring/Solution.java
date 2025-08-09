package MinimumWindowSubstring;

public class Solution {
    public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        int strt=0, left=0, cnt=0, tCnt=0;
        int[] map = new int[128];
        int[] window = new int[128];

        for(char c : t.toCharArray()){
            if(map[c] == 0) tCnt++;
            map[c]++;
        }

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(map[c] > 0){
                window[c]++;

                if(map[c] == window[c]){
                    cnt++;
                }
            }

            while(cnt == tCnt){
                if(minLen > i-left+1){
                    minLen = i-left+1;
                    strt = left;
                }

                char dc = s.charAt(left);
                if(map[dc] > 0){
                    if(map[dc] == window[dc]){
                        cnt--;
                    }

                    window[dc]--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(strt, strt+minLen);
    }
}

/*
class Solution {
    public String minWindow(String s, String t) {
        int tLen=t.length(),l=0,strt=0,minLen=Integer.MAX_VALUE;
        int[] map = new int[128];
        for(char c : t.toCharArray()) map[c]++;
        for(int r=0; r<s.length(); r++){
            char cr = s.charAt(r);
            if(map[cr]-->0) tLen--;

            while(tLen==0){
                if(r-l+1<minLen){
                    minLen=r-l+1;
                    strt=l;
                }
                char cl=s.charAt(l);
                if(++map[cl]>0) tLen++;
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(strt, strt+minLen);
    }
}
*/