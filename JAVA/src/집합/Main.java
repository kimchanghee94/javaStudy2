package 집합;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M=Integer.parseInt(br.readLine());
        int[] flag = new int[21];
        while(M-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int val=0;
            if(!order.equals("all") && !order.equals("empty")) val=Integer.parseInt(st.nextToken());
            if(order.equals("add")) flag[val]=1;
            else if(order.equals("remove")) flag[val]=0;
            else if(order.equals("toggle")) flag[val]=(flag[val]==1 ? 0 : 1);
            else if(order.equals("all")) for(int i=1;i<21;i++) flag[i]=1;
            else if(order.equals("empty")) for(int i=1;i<21;i++) flag[i]=0;
            else if(order.equals("check")) {
                bw.write(String.valueOf(flag[val]));
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }
}
