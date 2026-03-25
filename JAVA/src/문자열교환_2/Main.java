package 문자열교환_2;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        int cnt=0;
        for(char c : word.toCharArray()) if(c=='a') cnt++;
        int len = word.length()+cnt-1;
        char[] arr = new char[len];
        for(int i=0;i<len;i++) arr[i]=word.charAt(i%word.length());

        int ans=0;
        for(int i=0;i<cnt;i++) if(arr[i]=='b') ans++;
        int tmp=ans;
        for(int i=cnt;i<len;i++){
            if(arr[i]=='b') tmp++;
            if(arr[i-cnt]=='b') tmp--;
            ans=Math.min(ans, tmp);
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}