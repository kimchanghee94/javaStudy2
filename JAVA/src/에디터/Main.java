package 에디터;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String word = br.readLine();
        List<Character> list = new LinkedList<>();
        for(char c : word.toCharArray()) list.add(c);
        int M = Integer.parseInt(br.readLine());
        ListIterator<Character> it = list.listIterator(list.size());
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            if(c=='L' && it.hasPrevious()) it.previous();
            else if(c=='D' && it.hasNext()) it.next();
            else if(c=='B' && it.hasPrevious()) {
                it.previous();
                it.remove();
            }
            else if(c=='P'){
                char a = st.nextToken().charAt(0);
                it.add(a);
            }
        }
        for(char tmp : list) bw.write(tmp);

        br.close();
        bw.close();
    }
}
