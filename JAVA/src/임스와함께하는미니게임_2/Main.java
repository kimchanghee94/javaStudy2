package 임스와함께하는미니게임_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);
        Set<String> set = new HashSet<>();
        for(int i=0;i<N;i++) set.add(br.readLine());
        if(game=='Y') bw.write(String.valueOf(set.size()));
        else if(game=='F') bw.write(String.valueOf(set.size()/2));
        else if(game=='O') bw.write(String.valueOf(set.size()/3));
        br.close();
        bw.close();
    }
}