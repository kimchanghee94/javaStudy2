package 괄호추가하기3;
import java.io.*;
import java.util.*;

public class Main {
    private static Node[][] dp;
    private static List<Integer> num = new ArrayList<>();
    private static List<Character> oper = new ArrayList<>();
    static class Node{
        int max,min;
        Node(int max, int min){
            this.max=max;
            this.min=min;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int dpLen = N/2+1;
        dp = new Node[dpLen][dpLen];

        for(int i=0;i<N;i++){
            if(i%2==0){
                int tmp = arr[i]-'0';
                num.add(tmp);
                int idx = i/2;
                dp[idx][idx] = new Node(tmp,tmp);
            }else oper.add(arr[i]);
        }

        for(int i=1;i<dpLen;i++) for(int j=i-1;j>=0;j--) calc(j,i);

        bw.write(String.valueOf(dp[0][dpLen-1].max));
        br.close();
        bw.close();
    }

    private static void calc(int fi, int fj){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<fj-fi;i++){
            Node n1 = dp[fi+i+1][fj];
            Node n2 = dp[fi][fi+i];
            int idx = fi+i;

            if(oper.get(idx) == '+'){
                max = Math.max(max, n1.max + n2.max);
                min = Math.min(min, n1.min + n2.min);
            }else if(oper.get(idx)=='-'){
                max = Math.max(max, n2.max - n1.min);
                min = Math.min(min, n2.min - n1.max);
            }else{
                int tmp = n1.max*n2.max;
                int tmpMax = tmp;
                int tmpMin = tmp;

                tmp = n1.max*n2.min;
                tmpMax = Math.max(tmp, tmpMax);
                tmpMin = Math.min(tmp, tmpMin);

                tmp = n1.min*n2.max;
                tmpMax = Math.max(tmp, tmpMax);
                tmpMin = Math.min(tmp, tmpMin);

                tmp = n1.min*n2.min;
                tmpMax = Math.max(tmp, tmpMax);
                tmpMin = Math.min(tmp, tmpMin);

                max = Math.max(max, tmpMax);
                min = Math.min(min, tmpMin);
            }
        }
        dp[fi][fj] = new Node(max,min);
    }
}