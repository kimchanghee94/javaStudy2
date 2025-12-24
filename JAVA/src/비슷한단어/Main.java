package 비슷한단어;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String word = br.readLine();
        char[] wArr = word.toCharArray();
        int ans=0;

        for(int n=0;n<N-1;n++){
            String comp = br.readLine();
            char[] cArr = comp.toCharArray();
            int cnt=0;
            for(int i=0;i<word.length();i++){
                for(int j=0;j<comp.length();j++){
                    if(wArr[i]==cArr[j]){
                        cArr[j]='.';
                        cnt++;
                        break;
                    }
                }
            }
            if(Math.abs(cnt-word.length())<=1 && Math.abs(cnt-comp.length())<=1) ans++;
        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}