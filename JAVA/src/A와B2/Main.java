package A와B2;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder a = new StringBuilder(br.readLine());
        StringBuilder b = new StringBuilder(br.readLine());

        int aCnt1=0, bCnt1=0, aCnt2=0, bCnt2=0;
        for(char c : a.toString().toCharArray()) if(c=='A') aCnt1++;
        bCnt1=a.length()-aCnt1;
        for(char c : b.toString().toCharArray()) if(c=='A') aCnt2++;
        bCnt2=b.length()-aCnt2;
        aCnt2=Math.max(aCnt2-aCnt1, 0);
        bCnt2=Math.max(bCnt2-bCnt1, 0);
        if(backtrack(aCnt2, bCnt2, a, b)) bw.write("1");
        else bw.write("0");

        br.close();
        bw.close();
    }

    private static boolean backtrack(int aCnt, int bCnt, StringBuilder a, StringBuilder b){
        if(a.toString().equals(b.toString())) return true;
        boolean chk=false;
        if(aCnt>0 && b.charAt(b.length()-1)=='A' && !chk){
            chk=backtrack(aCnt-1, bCnt, a, new StringBuilder(b.substring(0,b.length()-1)));
        }
        if(bCnt>0 && b.charAt(0)=='B' && !chk){
            chk=backtrack(aCnt, bCnt-1, a, new StringBuilder(b.reverse().substring(0,b.length()-1)));
        }
        return chk;
    }
}
