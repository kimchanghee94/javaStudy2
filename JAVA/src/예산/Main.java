package 예산;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++) list.add(Integer.parseInt(st.nextToken()));
        list.sort(Comparator.naturalOrder());
        int ans=0;
        for(int i=0;i<N;i++){
            ans = M/(N-i);
            if(ans>=list.get(i)) M-=list.get(i);
            else break;
            if(i==N-1) ans=list.get(i);
        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
