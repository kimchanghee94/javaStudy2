package 비슷한단어_2179;
import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        String word;
        int idx;
        Node(String word, int idx){
            this.word=word;
            this.idx=idx;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        for(int i=0;i<N;i++) list.add(new Node(br.readLine(), i));
        List<Node> cList = new ArrayList<>(list);
        list.sort((a,b)->a.word.compareTo(b.word));
        int minIdx=0;
        int maxLen=0;
        for(int i=0;i<N-1;i++){
            String a = list.get(i).word;
            String b = list.get(i+1).word;
            int len=0;
            while(a.length()>len && b.length()>len && a.charAt(len)==b.charAt(len)) len++;
            if(len==0 || len<maxLen) continue;
            if(len>maxLen) minIdx=Math.min(list.get(i).idx, list.get(i+1).idx);
            else minIdx=Math.min(minIdx, Math.min(list.get(i).idx, list.get(i+1).idx));
            maxLen=Math.max(len,maxLen);
        }
        String S = cList.get(minIdx).word;
        bw.write(S+"\n");
        for(int i=minIdx+1;i<cList.size();i++){
            int len=0;
            String word=cList.get(i).word;
            while(S.length()>len && word.length()>len && S.charAt(len)==word.charAt(len)) len++;
            if(maxLen==len){
                bw.write(word);
                break;
            }
        }
        br.close();
        bw.close();
    }
}