package 비밀번호발음하기_2;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String str = br.readLine();
            if(str.equals("end")) break;

            int acnt=0;
            boolean flag=true;

            if(chk(str.charAt(0))) acnt++;

            for(int i=1;i<str.length() && flag;i++){
                char c = str.charAt(i);
                if(chk(c)) acnt++;
                if(c!='e' && c!='o' && c==str.charAt(i-1)) flag=false;
                if(i>1){
                    if((chk(str.charAt(i-2)) && chk(str.charAt(i-1)) && chk(str.charAt(i))) ||
                    (!chk(str.charAt(i-2)) && !chk(str.charAt(i-1)) && !chk(str.charAt(i)))) flag=false;
                }
            }
            if(acnt==0 || !flag) bw.write("<"+str+"> is not acceptable.\n");
            else bw.write("<"+str+"> is acceptable.\n");
        }

        br.close();
        bw.close();
    }

    private static boolean chk(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') return true;
        return false;
    }
}