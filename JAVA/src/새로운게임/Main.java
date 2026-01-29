package 새로운게임;
import java.io.*;
import java.util.*;

public class Main {
    private static final int[] di = {0,0,-1,1};
    private static final int[] dj = {1,-1,0,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N][N];
        int[][] horse = new int[K][4];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) graph[i][j]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            horse[i][0] = Integer.parseInt(st.nextToken())-1;
            horse[i][1] = Integer.parseInt(st.nextToken())-1;
            horse[i][2] = Integer.parseInt(st.nextToken())-1;
        }

        int ans=1;
        boolean fin=false;
        while(ans<=1000){
            for(int i=0;i<K;i++){
                int fi=horse[i][0], fj=horse[i][1];
                int d = horse[i][2];
                int ni=fi+di[d], nj=fj+dj[d];
                int s = horse[i][3];

                if(s!=0) continue;
                List<Integer> same = new ArrayList<>();
                for(int j=0;j<K;j++) {
                    if(horse[j][0]==fi && horse[j][1]==fj) same.add(j);
                }

                if(ni<0 || ni>=N || nj<0 || nj>=N || graph[ni][nj]==2){
                    if(d==0) d=1;
                    else if(d==1) d=0;
                    else if(d==2) d=3;
                    else d=2;
                    horse[i][2]=d;

                    ni=fi+di[d];
                    nj=fj+dj[d];
                    if(ni>=0 && ni<N && nj>=0 && nj<N && graph[ni][nj]!=2){
                        int cnt=0;
                        for(int j=0;j<K;j++) if(horse[j][0]==ni && horse[j][1]==nj) cnt++;

                        for(int j : same){
                            horse[j][0]=ni;
                            horse[j][1]=nj;
                            if(graph[ni][nj]==1) horse[j][3]=same.size()-horse[j][3]-1;
                            horse[j][3]+=cnt;
                            if(horse[j][3]>=3){
                                fin=true;
                                break;
                            }
                        }
                    }
                }else{
                    int cnt=0;
                    for(int j=0;j<K;j++) if(horse[j][0]==ni && horse[j][1]==nj) cnt++;

                    for(int j : same){
                        horse[j][0]=ni;
                        horse[j][1]=nj;
                        if(graph[ni][nj]==1) horse[j][3]=same.size()-horse[j][3]-1;
                        horse[j][3]+=cnt;
                        if(horse[j][3]>=3){
                            fin=true;
                            break;
                        }
                    }
                }
                if(fin) break;
            }
            if(fin) break;
            ans++;
        }

        bw.write(fin ? String.valueOf(ans) : "-1");
        br.close();
        bw.close();
    }
}