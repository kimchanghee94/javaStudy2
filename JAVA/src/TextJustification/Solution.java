package TextJustification;

import java.util.*;;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = null;
        int maxN = 0;
        int cnt = 0;
        int lastIdx = 0;

        for (int i = 0; i < words.length; i++) {
            if (maxN + words[i].length() + cnt > maxWidth) {
                lastIdx = i;

                int space = maxWidth - maxN;
                int spaceN = cnt - 1;
                int minus = maxWidth - maxN;
                int rem = 0;

                if (spaceN != 0) {
                    minus = space / spaceN;
                    rem = space % spaceN;
                }

                sb = new StringBuilder();
                for (int j = i - cnt; j < i; j++) {
                    sb.append(words[j]);
                    for (int k = 0; k < minus; k++) {
                        space--;
                        if (space < 0) break;
                        sb.append(" ");
                    }

                    if (rem > 0) {
                        sb.append(" ");
                        space--;
                        rem--;
                    }
                }

                ans.add(sb.toString());

                cnt = 0;
                maxN = 0;
            }

            cnt++;
            maxN += words[i].length();
        }

        sb = new StringBuilder();
        for (int i = lastIdx; i < words.length; i++) {
            sb.append(words[i]);
            if (i != words.length - 1) {
                sb.append(' ');
            }
        }

        for (int i = sb.length(); i < maxWidth; i++) {
            sb.append(' ');
        }
        ans.add(sb.toString());

        return ans;
    }
}
