package 영만들기;
import java.io.*;
public class Main {
    private static int N;
    private static char[] op;
    private static char[] ov={' ','+','-'};
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            N = Integer.parseInt(br.readLine());
            op = new char[N];
            backtrack(1,0,1);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void backtrack(int cnt, int tot, int val) throws IOException{
        if(cnt==N){
            if(tot+val!=0) return;
            bw.write("1");
            for(int i=0;i<N-1;i++) bw.write(op[i]+String.valueOf(i+2));
            bw.newLine();
        }else{
            for(int i=0;i<3;i++){
                op[cnt-1]=ov[i];
                if(i==0) backtrack(cnt+1, tot, val>0 ? val*10+(cnt+1) : val*10-(cnt+1));
                else if(i==1) backtrack(cnt+1, tot+val, cnt+1);
                else if(i==2) backtrack(cnt+1, tot+val, -(cnt+1));
            }
        }
    }
}
