package 문자열교환;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        int acnt=0, bcnt=0, ans=1000;
        for(char c : word.toCharArray()) if(c=='a') acnt++;
        for(int i=0;i<acnt;i++) if(word.charAt(i)=='b') bcnt++;
        ans=Math.min(bcnt,ans);
        for(int i=acnt;i<word.length()+acnt-1;i++){
            if(word.charAt(i-acnt)=='b') bcnt--;
            if(word.charAt(i%word.length())=='b') bcnt++;
            ans=Math.min(bcnt,ans);
        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}