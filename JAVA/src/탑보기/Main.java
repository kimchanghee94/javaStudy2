package 탑보기;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[N+1];
        int[] show = new int[N+1];
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> s = new Stack<>();
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            while(!s.empty() && arr[i]>=arr[s.peek()]) s.pop();
            cnt[i]+=s.size();
            if(!s.empty()) show[i]=s.peek();
            s.push(i);
        }
        s.clear();
        for(int i=N;i>=1;i--){
            while(!s.empty() && arr[i]>=arr[s.peek()]) s.pop();
            if(!s.empty()){
                if(show[i]==0) show[i]=s.peek();
                else if(Math.abs(i-show[i]) > Math.abs(i-s.peek())) show[i]=s.peek();
            }
            cnt[i]+=s.size();
            s.push(i);
        }

        for(int i=1;i<=N;i++){
            if(cnt[i]==0) bw.write("0\n");
            else bw.write(cnt[i]+" "+show[i]+"\n");
        }
        br.close();
        bw.close();
    }
}