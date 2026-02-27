package 수이어쓰기_2;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        int ans=1, idx=0;
        while(idx<word.length()){
            String strAns=String.valueOf(ans);
            for(int i=0;i<strAns.length();i++){
                if(word.length()>idx && word.charAt(idx)==strAns.charAt(i)) idx++;
            }
            ans++;
        }

        bw.write(String.valueOf(ans-1));
        br.close();
        bw.close();
    }
}