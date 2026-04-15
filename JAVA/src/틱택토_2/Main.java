package 틱택토_2;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String word = br.readLine();
            if(word.equals("end")) break;

            char[] arr = word.toCharArray();
            int xCnt=0, oCnt=0;
            for(char c : arr){
                if(c=='X') xCnt++;
                else if(c=='O') oCnt++;
            }

            if(xCnt==oCnt){
                if(chk(arr,'X')) bw.write("invalid\n");
                else if(chk(arr,'O')) bw.write("valid\n");
                else bw.write("invalid\n");
            }else if(xCnt==oCnt+1){
                if(chk(arr,'O')) bw.write("invalid\n");
                else if(chk(arr,'X')) bw.write("valid\n");
                else if(xCnt+oCnt==9) bw.write("valid\n");
                else bw.write("invalid\n");
            }else bw.write("invalid\n");
        }

        br.close();
        bw.close();
    }

    private static boolean chk(char[]arr, char c){
        boolean chk = false;
        if(arr[0]==arr[1] && arr[0]==arr[2] && arr[0]==c) chk=true;
        else if(arr[3]==arr[4] && arr[3]==arr[5] && arr[3]==c) chk=true;
        else if(arr[6]==arr[7] && arr[6]==arr[8] && arr[6]==c) chk=true;
        else if(arr[0]==arr[3] && arr[0]==arr[6] && arr[0]==c) chk=true;
        else if(arr[1]==arr[4] && arr[1]==arr[7] && arr[1]==c) chk=true;
        else if(arr[2]==arr[5] && arr[2]==arr[8] && arr[2]==c) chk=true;
        else if(arr[0]==arr[4] && arr[0]==arr[8] && arr[0]==c) chk=true;
        else if(arr[2]==arr[4] && arr[2]==arr[6] && arr[2]==c) chk=true;
        return chk;
    }
}