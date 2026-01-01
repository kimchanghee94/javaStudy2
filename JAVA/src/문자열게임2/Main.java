package 문자열게임2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            Map<Integer, List<Integer>> map = new HashMap<>();
            char[] cArr = br.readLine().toCharArray();
            int K = Integer.parseInt(br.readLine());
            int minAns=10001, maxAns=0;
            for(int i=0;i<cArr.length;i++) map.computeIfAbsent(cArr[i]-'a', k -> new ArrayList<>()).add(i);
            for(int i=0;i<26;i++){
                if(!map.containsKey(i) || map.get(i).size()<K) continue;
                List<Integer> list = map.get(i);
                for(int j=0;j+K-1<list.size();j++){
                    int v=list.get(j+K-1)-list.get(j)+1;
                    minAns=Math.min(minAns,v);
                    maxAns=Math.max(maxAns,v);
                }
            }
            if(minAns==10001) bw.write("-1\n");
            else bw.write(minAns+" "+maxAns+"\n");
        }
        br.close();
        bw.close();
    }
}
