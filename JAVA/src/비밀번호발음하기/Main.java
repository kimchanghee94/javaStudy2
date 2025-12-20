package 비밀번호발음하기;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String word = br.readLine();
            if(word.equals("end")) break;

            int aCnt=0;
            boolean chk1=true;
            boolean chk2=true;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if(chk(c)) aCnt++;
                if(i>0){
                    char bc = word.charAt(i-1);
                    if(c==bc && c!='e' && c!='o') {
                        chk1=false;
                        break;
                    }
                }
                if(i>1){
                    char bc1 = word.charAt(i-2);
                    char bc2 = word.charAt(i-1);
                    if((chk(c) && chk(bc1) && chk(bc2)) || (!chk(c) && !chk(bc1) && !chk(bc2))){
                        chk2=false;
                        break;
                    }
                }
            }
            if(aCnt==0 || !chk1 || !chk2) bw.write("<"+word+"> is not acceptable.");
            else bw.write("<"+word+"> is acceptable.");
            bw.newLine();
        }

        br.close();
        bw.close();
    }
    private static boolean chk(char c){
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') return true;
        return false;
    }
}
