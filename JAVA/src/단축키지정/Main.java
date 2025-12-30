package 단축키지정;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        boolean[] flag = new boolean[26];
        while(N-->0){
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            boolean chk = false;

            while(st.hasMoreTokens()){
               StringBuilder word = new StringBuilder(st.nextToken());
               int idx = Character.toLowerCase(word.charAt(0))-'a';
                if(!flag[idx] && !chk){
                   flag[idx]=true;
                   chk=true;
                   word.insert(0, "[");
                   word.insert(2,"]");
               }
               sb.append(word+" ");
            }

            if(!chk){
                for(int i=0;i<sb.length();i++){
                    if(sb.charAt(i)==' ') continue;
                    int idx = Character.toLowerCase(sb.charAt(i))-'a';
                    if(!flag[idx]){
                        flag[idx]=true;
                        sb.insert(i,"[");
                        sb.insert(i+2,"]");
                        break;
                    }
                }
            }
            bw.write(sb+"\n");
        }

        br.close();
        bw.close();
    }
}
