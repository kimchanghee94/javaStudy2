package 에디터_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        List<Character> list = new LinkedList<>();
        for(char c : word.toCharArray()) list.add(c);
        int M = Integer.parseInt(br.readLine());
        ListIterator<Character> it = list.listIterator(list.size());
        while(M-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if(order.equals("L") && it.hasPrevious()) it.previous();
            else if(order.equals("D") && it.hasNext()) it.next();
            else if(order.equals("B") && it.hasPrevious()){
                it.previous();
                it.remove();
            }
            else if(order.equals("P")) it.add(st.nextToken().charAt(0));
        }
        for(char c : list) bw.write(c);
        br.close();
        bw.close();
    }
}
