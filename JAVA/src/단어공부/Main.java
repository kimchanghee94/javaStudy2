package 단어공부;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine().toLowerCase();
        int mCnt=0;
        int[] flag = new int[26];

        for(char c : word.toCharArray()){
            flag[c-'a']++;
            mCnt=Math.max(flag[c-'a'], mCnt);
        }
        int cnt=0,ans=0;
        for(int i=0; i<26; i++){
            if(flag[i]==mCnt) {
                ans=i;
                cnt++;
            }
        }

        if(cnt>1) bw.write("?");
        else bw.write('A'+ans);

        br.close();
        bw.close();
    }
}
