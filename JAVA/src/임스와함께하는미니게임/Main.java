package 임스와함께하는미니게임;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        char G = st.nextToken().charAt(0);
        int M = (G=='Y' ? 1 : (G=='F' ? 2 : 3));
        int cnt=0, ans=0;
        Set<String> set = new HashSet<>();
        while(N-->0){
            String id = br.readLine();
            if(!set.contains(id)){
                cnt++;
                if(cnt==M){
                    ans++;
                    cnt=0;
                }
                set.add(id);
            }
        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}