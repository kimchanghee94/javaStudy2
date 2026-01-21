package 보석도둑;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        int[] c = new int[K];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (a,b)->a[0]-b[0]);
        for(int i=0;i<K;i++) c[i]=Integer.parseInt(br.readLine());
        Arrays.sort(c);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        long ans=0;
        int idx=0;
        for(int i=0;i<K;i++){
            while(idx<N && c[i]>=arr[idx][0]) pq.offer(arr[idx++][1]);
            if(!pq.isEmpty()) ans+=pq.poll();
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}