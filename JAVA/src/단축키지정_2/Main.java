package 단축키지정_2;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        boolean[] flag = new boolean[26];

        for(int i=0;i<N;i++){
            String[] words = br.readLine().split(" ");
            StringBuilder ans = new StringBuilder();
            int fi=-1;

            for(int j=0;j<words.length;j++){
                char c = words[j].charAt(0);
                if(!flag[idx(c)]) {
                    fi=j;
                    flag[idx(c)] = true;
                    break;
                }
            }

            if(fi>=0){
                for(int j=0;j<words.length;j++){
                    if(j==fi) ans.append("["+words[j].substring(0,1)+"]"+words[j].substring(1)+" ");
                    else ans.append(words[j]+" ");
                }

                bw.write(ans+"\n");
            }else{
                int fj=-1;
                for(int j=0;j<words.length;j++){
                    for(int k=0;k<words[j].length();k++){
                        char c = words[j].charAt(k);
                        if(!flag[idx(c)]){
                            fi=j;
                            fj=k;
                            flag[idx(c)]=true;
                            break;
                        }
                    }
                    if(fi>=0) break;
                }

                if(fi>=0){
                    for(int j=0;j<words.length;j++){
                        if(fi==j){
                            for(int k=0;k<words[j].length();k++){
                                if(k==fj) ans.append("["+words[j].charAt(k)+"]");
                                else ans.append(words[j].charAt(k));
                            }
                            ans.append(" ");
                        }else ans.append(words[j]+" ");
                    }

                    bw.write(ans+"\n");
                }else {
                    for(String word : words) bw.write(word + " ");
                    bw.newLine();
                }
            }
        }

        br.close();
        bw.close();
    }

    private static int idx(char c){
        if('a'<=c && c<='z') return c-'a';
        return c-'A';
    }
}