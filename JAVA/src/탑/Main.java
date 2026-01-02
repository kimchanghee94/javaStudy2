package 탑;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> s = new Stack<>();
        for(int i=0;i<N;i++){
            int val=Integer.parseInt(st.nextToken());
            while(!s.isEmpty() && s.peek()[0]<val) s.pop();
            if(s.isEmpty()) bw.write("0 ");
            else bw.write(s.peek()[1]+1+" ");
            s.push(new int[]{val,i});
        }
        br.close();
        bw.close();
    }
}
