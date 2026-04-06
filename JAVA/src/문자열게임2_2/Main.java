package 문자열게임2_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            char[] word = br.readLine().toCharArray();
            int K = Integer.parseInt(br.readLine());
            Map<Integer, List<Integer>> map = new HashMap<>();
            for(int i=0;i<word.length;i++) map.computeIfAbsent(word[i]-'a', k->new ArrayList<>()).add(i);
            int ans1=Integer.MAX_VALUE;
            int ans2=0;

            for(int i=0;i<26;i++){
                if(!map.containsKey(i) || map.get(i).size()<K) continue;
                List<Integer> list = map.get(i);
                for(int j=0;j+K-1<list.size();j++){
                    int dist=list.get(j+K-1)-list.get(j)+1;
                    ans1=Math.min(ans1,dist);
                    ans2=Math.max(ans2,dist);
                }
            }

            if(ans1!=Integer.MAX_VALUE) bw.write(ans1+" "+ans2+"\n");
            else bw.write("-1\n");
        }

        br.close();
        bw.close();
    }
}