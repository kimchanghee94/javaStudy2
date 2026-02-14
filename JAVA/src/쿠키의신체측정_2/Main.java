package 쿠키의신체측정_2;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        char[][] graph = new char[N][N];
        for(int i=0;i<N;i++) graph[i]=br.readLine().toCharArray();

        for(int i=1;i<N-1;i++) for(int j=1;j<N-1;j++)
        if(graph[i][j]=='*' && graph[i][j-1]=='*' && graph[i][j+1]=='*' && graph[i-1][j]=='*' && graph[i+1][j]=='*'){
            int ci=i, cj=j;
            bw.write((ci+1)+" "+(cj+1)+"\n");
            while(cj>=0 && graph[ci][cj]=='*') cj--;
            bw.write(j-cj-1+" "); cj=j;
            while(cj<N && graph[ci][cj]=='*') cj++;
            bw.write(cj-j-1+" "); cj=j;
            while(graph[ci][cj]=='*') ci++;
            bw.write(ci-i-1+" ");
            int tci=ci;
            while(tci<N && graph[tci][cj-1]=='*') tci++;
            bw.write(tci-ci+" "); tci=ci;
            while(tci<N && graph[tci][cj+1]=='*') tci++;
            bw.write(tci-ci+" ");
        }

        br.close();
        bw.close();
    }
}