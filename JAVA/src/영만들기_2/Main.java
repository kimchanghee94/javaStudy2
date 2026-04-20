package 영만들기_2;
import java.io.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            backtrack(N,new char[N],1,0,1);
            bw.write(sb.toString());
            sb.setLength(0);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void backtrack(int N, char[] arr, int cnt, int tot, int val){
        if(N==cnt){
            if(tot+val!=0) return;
            sb.append("1");
            for(int i=0;i<N-1;i++) sb.append(arr[i]+String.valueOf(i+2));
            sb.append("\n");
        }else{
            arr[cnt-1]=' ';
            backtrack(N, arr, cnt+1, tot, val>0 ? (val*10)+(cnt+1) : (val*10)-(cnt+1));
            arr[cnt-1]='+';
            backtrack(N, arr, cnt+1,tot+val, cnt+1);
            arr[cnt-1]='-';
            backtrack(N, arr, cnt+1,tot+val, -(cnt+1));
        }
    }
}