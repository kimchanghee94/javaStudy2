package 타노스_2;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] word = br.readLine().toCharArray();
        int cnt0=0, cnt1=0;
        for(char c : word){
            if(c=='0')  cnt0++;
            else cnt1++;
        }

        StringBuilder sb = new StringBuilder();
        cnt0/=2; cnt1/=2;
        int idx=word.length-1;
        while(cnt0>0){
            if(word[idx]=='0'){
                word[idx]='.';
                cnt0--;
            }
            idx--;
        }

        idx=0;
        while(cnt1>0){
            if(word[idx]=='1'){
                word[idx]='.';
                cnt1--;
            }
            idx++;
        }

        for(char c : word) if(c!='.') sb.append(c);
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}