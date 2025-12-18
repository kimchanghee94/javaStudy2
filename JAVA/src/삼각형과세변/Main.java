package 삼각형과세변;
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==0 && b==0 && c==0) break;
            if(a+b<=c || a+c<=b || b+c<=a) bw.write("Invalid");
            else if(a==b && a==c) bw.write("Equilateral");
            else if(a==b || a==c || b==c) bw.write("Isosceles");
            else bw.write("Scalene");
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}