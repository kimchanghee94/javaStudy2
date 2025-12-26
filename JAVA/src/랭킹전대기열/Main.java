package 랭킹전대기열;
import java.io.*;
import java.util.*;

public class Main {
    private static class Node{
        int point;
        String name;
        Node(int point, String name){
            this.point=point;
            this.name=name;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Node>> list = new ArrayList<>();

        for(int i=0;i<p;i++){
            st = new StringTokenizer(br.readLine());
            Node node = new Node(Integer.parseInt(st.nextToken()), st.nextToken());
            int room=-1;
            for(int j=0;j<list.size();j++) {
                int point = list.get(j).get(0).point;
                if(point-10<=node.point && node.point<=point+10 && list.get(j).size()<m) {
                    room=j;
                    break;
                }
            }

            if(room==-1){
                List<Node> tmp = new ArrayList<>();
                tmp.add(node);
                list.add(tmp);
            }else list.get(room).add(node);
        }

        for(int i=0;i<list.size();i++){
            List<Node> tmp = list.get(i);
            if(tmp.size()==m) bw.write("Started!\n");
            else bw.write("Waiting!\n");
            tmp.sort(Comparator.comparing(node->node.name));
            for(Node node : tmp) bw.write(node.point + " " + node.name + "\n");
        }

        br.close();
        bw.close();
    }
}