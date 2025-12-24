package 타노스;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] arr = br.readLine().toCharArray();
        int zCnt=0, oCnt=0;
        for(char c : arr){
            if(c=='0') zCnt++;
            else oCnt++;
        }
        zCnt/=2; oCnt/=2;
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='1' && oCnt-->0) arr[i]='X';
            if(arr[arr.length-i-1]=='0' && zCnt-->0) arr[arr.length-i-1]='X';
        }
        for(int i=0;i<arr.length;i++) if(arr[i]!='X') bw.write(arr[i]);
        br.close();
        bw.close();
    }
}
