package 스카이라인쉬운거_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        int ans=0;

        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while(!s.isEmpty() && s.peek()>=y){
                if(s.peek()>y) ans++;
                s.pop();
            }

            if(y!=0) s.push(y);
        }
        ans+=s.size();
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}