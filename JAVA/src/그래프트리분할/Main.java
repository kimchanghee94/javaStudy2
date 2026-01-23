package 그래프트리분할;
import java.io.*;
import java.util.*;

public class Main {
    private static int N,M;
    private static boolean[] flag, leaf;
    private static List<int[]>[] graph;
    private static List<Integer>[] node, edge;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];
        node = new ArrayList[N];
        edge = new ArrayList[N];
        flag = new boolean[N];
        leaf = new boolean[N];
        for(int i=0;i<N;i++){
            graph[i] = new ArrayList<>();
            node[i] = new ArrayList<>();
            edge[i] = new ArrayList<>();
        }

        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            graph[u].add(new int[]{v,i});
            graph[v].add(new int[]{u,i});
        }
        int tCnt=0;
        for(int i=0;i<N;i++) if(!flag[i]) dfs(i,tCnt++);

        if(N>1 && tCnt==1){
            int t1=0,t2=0;
            for(int i=0;i<N;i++){
                if(leaf[i]) t2=i;
                else t1=i;
            }
            Arrays.fill(flag,false);
            flag[t2]=true;
            node[0].clear(); edge[0].clear();
            node[1].add(t2);
            dfs(t1,0);
        }

        if(N==1 || tCnt>2 || node[0].size()==node[1].size()) bw.write("-1");
        else{
            bw.write(node[0].size() + " " + node[1].size()); bw.newLine();
            for(int n : node[0]) bw.write((n+1) + " "); bw.newLine();
            for(int e : edge[0]) bw.write(e + " "); bw.newLine();
            for(int n : node[1]) bw.write((n+1) + " "); bw.newLine();
            for(int e : edge[1]) bw.write(e + " ");
        }

        br.close();
        bw.close();
    }

    private static void dfs(int n, int t){
        flag[n]=true;
        node[t].add(n);
        boolean isLeaf = true;
        for(int i=0;i<graph[n].size();i++){
            int nn=graph[n].get(i)[0];
            int e=graph[n].get(i)[1];

            if(!flag[nn]){
                isLeaf = false;
                edge[t].add(e);
                dfs(nn,t);
            }
        }
        if(isLeaf) leaf[n]=true;
    }
}