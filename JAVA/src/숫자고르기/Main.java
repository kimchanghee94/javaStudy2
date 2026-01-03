package 숫자고르기;
import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer> ans = new ArrayList<>();
    private static int[] arr, flag;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        flag = new int[N+1];
        for(int i=1;i<=N;i++) arr[i]=Integer.parseInt(br.readLine());
        for(int i=1;i<=N;i++) dfs(i,i);
        bw.write(ans.size()+"\n");
        for(int tmp : ans) bw.write(tmp+"\n");
        br.close();
        bw.close();
    }
    private static void dfs(int s, int e){
        if(flag[e]==1) {
            if (s==e) ans.add(s);
        }
        else{
            flag[e]=1;
            dfs(s,arr[e]);
            flag[e]=0;
        }
    }
}
