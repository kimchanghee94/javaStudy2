package 랭킹전대기열_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int pos=0;
        int[][] arr = new int[p][2];
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> team = new ArrayList<>();

        while(p-->0){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            map.put(n,l);

            boolean chk = false;
            for(int i=0;i<pos;i++){
                if(arr[i][0]==m) continue;
                if(arr[i][1]-10<=l && l<=arr[i][1]+10){
                    arr[i][0]++;
                    team.get(i).add(n);
                    chk = true;
                    break;
                }
            }

            if(!chk){
                List<String> tmp = new ArrayList<>();
                tmp.add(n);
                team.add(tmp);
                arr[pos][0]++;
                arr[pos][1]=l;
                pos++;
            }
        }

        for(List<String> tmp : team){
            if(tmp.size()==m) bw.write("Started!\n");
            else bw.write("Waiting!\n");
            tmp.sort(Comparator.naturalOrder());
            for(String name : tmp){
                bw.write(map.get(name) + " " + name + "\n");
            }
        }

        br.close();
        bw.close();
    }
}