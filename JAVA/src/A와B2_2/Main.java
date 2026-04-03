package A와B2_2;
import java.io.*;

public class Main {
    private static boolean chk=false;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        String T = br.readLine();
        backtrack(S,T);
        bw.write(chk ? "1" : "0");
        br.close();
        bw.close();
    }
    private static void backtrack(String S, String T){
        if(S.equals(T)) chk=true;
        if(S.length()>=T.length()) return;
        if(T.charAt(0)=='B' && !chk) backtrack(S, new StringBuilder(T.substring(1)).reverse().toString());
        if(T.charAt(T.length()-1)=='A' && !chk) backtrack(S, T.substring(0,T.length()-1));
    }
}