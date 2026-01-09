package 문자열폭발;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] src = br.readLine().toCharArray();
        char[] dest = br.readLine().toCharArray();
        char[] ans = new char[src.length];
        int aIdx=0;

        for(int i=0;i<src.length;i++){
            ans[aIdx++] = src[i];
            if(aIdx>=dest.length && ans[aIdx-1]==dest[dest.length-1]){
                boolean same=true;
                for(int j=dest.length;j>0;j--){
                    if(ans[aIdx-j]!=dest[dest.length-j]){
                        same=false;
                        break;
                    }
                }
                if(same) aIdx-=dest.length;
            }
        }
        if(aIdx==0) bw.write("FRULA");
        else for(int i=0;i<aIdx;i++) bw.write(ans[i]);

        br.close();
        bw.close();
    }
}
