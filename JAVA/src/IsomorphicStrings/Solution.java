package IsomorphicStrings;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] sFlag = new char[128];
        char[] tFlag = new char[128];

        for(int i=0; i<s.length(); i++){
            char sc = s.charAt(i), tc = t.charAt(i);
            if(sFlag[sc] == 0) sFlag[sc] = tc;
            else if(sFlag[sc] != tc) return false;

            if(tFlag[tc] == 0) tFlag[tc] = sc;
            else if(tFlag[tc] != sc) return false;
        }

        return true;
    }
}
