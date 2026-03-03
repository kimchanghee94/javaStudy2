package 비슷한단어_2;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        char[] word = br.readLine().toCharArray();
        int[] src = new int[26];
        int srcLen = word.length;
        for(int i=0;i<srcLen;i++) src[word[i]-'A']++;

        int ans=0;
        for(int i=0;i<N-1;i++){
            word = br.readLine().toCharArray();
            int diff=0;
            int[] dest = new int[26];
            int destLen = word.length;
            for(int j=0;j<destLen;j++) dest[word[j]-'A']++;

            for(int j=0;j<26;j++) diff+=Math.abs(dest[j]-src[j]);
            if(srcLen==destLen && diff<3) ans++;
            else if(srcLen!=destLen && diff<2) ans++;
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}