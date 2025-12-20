package 쿠키의신체측정;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] graph = new String[N];
        for(int i=0;i<N;i++) graph[i]=br.readLine();
        boolean chk=false;
        for(int ci=0;ci<N && !chk;ci++){
            for(int cj=0;cj<N && !chk;cj++){
                if(graph[ci].charAt(cj)=='*'){
                    ci++;
                    bw.write((ci+1)+" "+(cj+1));
                    bw.newLine();

                    int tIdx=cj;
                    while(tIdx>=0 && graph[ci].charAt(tIdx)=='*') tIdx--;
                    bw.write(cj-tIdx-1+" ");

                    tIdx=cj;
                    while(tIdx<N && graph[ci].charAt(tIdx)=='*') tIdx++;
                    bw.write(tIdx-cj-1+" ");

                    tIdx=ci;
                    while(graph[tIdx].charAt(cj)=='*') tIdx++;
                    bw.write(tIdx-ci-1+" ");

                    ci=tIdx;
                    while(tIdx<N && graph[tIdx].charAt(cj-1)=='*') tIdx++;
                    bw.write(tIdx-ci+" ");

                    tIdx=ci;
                    while(tIdx<N && graph[tIdx].charAt(cj+1)=='*') tIdx++;
                    bw.write(tIdx-ci+" ");

                    chk=true;
                }
            }
        }

        br.close();
        bw.close();
    }
}