package 인구이동_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        int[][] tmp = new int[N][N];
        boolean[][] flag = new boolean[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) arr[i][j]=Integer.parseInt(st.nextToken());
        }

        int ans=0;
        int[] di={1,0,-1,0}, dj={0,1,0,-1};

        while(true){
            boolean chk = false;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!flag[i][j]){
                        flag[i][j]=true;
                        Queue<int[]> q = new LinkedList<>();
                        q.offer(new int[]{i,j});
                        int tot=arr[i][j];
                        int cnt=1;
                        List<int[]> pos = new ArrayList<>();
                        pos.add(new int[]{i,j});

                        while(!q.isEmpty()){
                            int[] f = q.poll();
                            int fi=f[0], fj=f[1];

                            for(int d=0;d<4;d++){
                                int ni=fi+di[d], nj=fj+dj[d];
                                if(ni<0 || ni>=N || nj<0 || nj>=N || flag[ni][nj]) continue;
                                int val = Math.abs(arr[fi][fj]-arr[ni][nj]);
                                if(val<L || R<val) continue;
                                flag[ni][nj]=true;
                                tot+=arr[ni][nj];
                                cnt++;
                                q.offer(new int[]{ni,nj});
                                pos.add(new int[]{ni,nj});
                            }
                        }

                        for(int p=0;p<pos.size();p++){
                            int pi=pos.get(p)[0], pj=pos.get(p)[1];
                            tmp[pi][pj]=tot/cnt;
                        }
                        if(pos.size()>1) chk=true;
                    }
                }
            }
            if(!chk) break;

            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++){
                    arr[i][j]=tmp[i][j];
                    flag[i][j]=false;
                }
            }
            ans++;
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}