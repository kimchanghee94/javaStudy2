package 영단어암기는괴로워;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String,Integer> map = new TreeMap<>();
        for(int i=0;i<N;i++){
            String word = br.readLine();
            if(word.length()<M) continue;
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b)->{
           if(!a.getValue().equals(b.getValue())) return b.getValue()-a.getValue();
           else if(!a.getKey().equals(b.getKey())) return b.getKey().length()-a.getKey().length();
           return a.getKey().compareTo(b.getKey());
        });

        for(Map.Entry<String,Integer> tmp : list) bw.write(tmp.getKey()+"\n");
        br.close();
        bw.close();
    }
}