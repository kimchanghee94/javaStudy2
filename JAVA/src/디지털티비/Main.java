package 디지털티비;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N=Integer.parseInt(br.readLine());
        int idx1=0,idx2=0;
        for(int i=0;i<N;i++){
            String word=br.readLine();
            if(word.equals("KBS1")) idx1=i;
            else if(word.equals("KBS2")) idx2=i;
        }
        if(idx1>idx2) idx2++;
        for(int i=0;i<idx1;i++) bw.write("1");
        for(int i=0;i<idx1;i++) bw.write("4");
        for(int i=0;i<idx2;i++) bw.write("1");
        for(int i=1;i<idx2;i++) bw.write("4");

        br.close();
        bw.close();
    }
}
