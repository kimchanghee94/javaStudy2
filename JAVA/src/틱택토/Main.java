package 틱택토;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String str = br.readLine();
            if(str.equals("end")) break;
            char[] b = str.toCharArray();
            int xCnt=0,oCnt=0;
            for(char c:b) {
                if(c=='O') oCnt++;
                else if(c=='X') xCnt++;
            }

            if((xCnt!=oCnt && xCnt!=oCnt+1) || (xCnt<3 && oCnt<3)){
                bw.write("invalid\n");
                continue;
            }

            boolean xChk=false;
            if(b[0]==b[1] && b[0]==b[2] && b[0]=='X') xChk=true;
            else if(b[3]==b[4] && b[3]==b[5] && b[3]=='X') xChk=true;
            else if(b[6]==b[7] && b[6]==b[8] && b[6]=='X') xChk=true;
            else if(b[0]==b[3] && b[0]==b[6] && b[0]=='X') xChk=true;
            else if(b[1]==b[4] && b[1]==b[7] && b[1]=='X') xChk=true;
            else if(b[2]==b[5] && b[2]==b[8] && b[2]=='X') xChk=true;
            else if(b[0]==b[4] && b[0]==b[8] && b[0]=='X') xChk=true;
            else if(b[2]==b[4] && b[2]==b[6] && b[2]=='X') xChk=true;

            boolean oChk=false;
            if(b[0]==b[1] && b[0]==b[2] && b[0]=='O') oChk=true;
            else if(b[3]==b[4] && b[3]==b[5] && b[3]=='O') oChk=true;
            else if(b[6]==b[7] && b[6]==b[8] && b[6]=='O') oChk=true;
            else if(b[0]==b[3] && b[0]==b[6] && b[0]=='O') oChk=true;
            else if(b[1]==b[4] && b[1]==b[7] && b[1]=='O') oChk=true;
            else if(b[2]==b[5] && b[2]==b[8] && b[2]=='O') oChk=true;
            else if(b[0]==b[4] && b[0]==b[8] && b[0]=='O') oChk=true;
            else if(b[2]==b[4] && b[2]==b[6] && b[2]=='O') oChk=true;

            if(xCnt>oCnt && oChk) bw.write("invalid\n");
            else if(xCnt==oCnt && xChk) bw.write("invalid\n");
            else if(xCnt+oCnt!=9 && !oChk && !xChk) bw.write("invalid\n");
            else bw.write("valid\n");
        }

        br.close();
        bw.close();
    }
}
