package 단어공부_2;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] alpha = new int[26];
        String str = br.readLine().toLowerCase();
        int max=0;
        for(char c : str.toCharArray()) max = Math.max(max,++alpha[c-'a']);
        char ans=0;
        int cnt=0;
        for(int i=0;i<26;i++){
            if(alpha[i]==max) {
                ans=(char)(i+'A');
                cnt++;
            }
        }
        if(cnt>=2) bw.write("?");
        else bw.write(ans);
        br.close();
        bw.close();
    }
}