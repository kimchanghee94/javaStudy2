package 집합_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        int[] set = new int[21];
        while(M-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int x = 0;
            if(order.equals("add") || order.equals("remove") || order.equals("check") || order.equals("toggle"))
                x = Integer.parseInt(st.nextToken());

            if(order.equals("add")) set[x]=1;
            else if(order.equals("remove")) set[x]=0;
            else if(order.equals("check")) bw.write(set[x]+"\n");
            else if(order.equals("toggle")) set[x]=set[x]==0?1:0;
            else if(order.equals("all")) Arrays.fill(set,1);
            else if(order.equals("empty")) Arrays.fill(set,0);
        }

        br.close();
        bw.close();
    }
}