package 지름길_2;
import java.io.*;
import java.util.*;
public class Main {
    private static final int MAX = 10001;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        List<int[]>[] graph = new ArrayList[MAX];
        for(int i=0;i<MAX;i++) graph[i] = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[s].add(new int[]{e,c});
        }

        int[] arr = new int[MAX];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0]=0;
        for(int i=0;i<=D;i++){
            if(i>0) arr[i]=Math.min(arr[i],arr[i-1]+1);
            for(int j=0;j<graph[i].size();j++){
                int e = graph[i].get(j)[0];
                int c = graph[i].get(j)[1];
                arr[e]=Math.min(arr[e],arr[i]+c);
            }
        }

        bw.write(String.valueOf(arr[D]));
        br.close();
        bw.close();
    }
}