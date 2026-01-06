package 스카이라인쉬운거;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int ans=0;
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            while(!s.empty() && s.peek()>y){
                ans++;
                s.pop();
            }
            if(y==0 || (!s.empty() && s.peek()==y)) continue;
            s.push(y);
        }
        bw.write(String.valueOf(ans+s.size()));
        br.close();
        bw.close();
    }
}
